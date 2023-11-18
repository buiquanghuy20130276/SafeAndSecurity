package controller;

import bean.Order;
import bean.OrderDetail;
import bean.Product;
import bean.User;
import model.Cart;
import model.UserSession;
import service.OrderDetailService;
import service.OrderService;
import tool.DSA;
import tool.SendToMail;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@WebServlet(name = "CreateOrder", value = "/CreateOrder")
public class CreateOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullname = request.getParameter("fullname");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String privateKey = request.getParameter("privatekey");

        UserSession u = (UserSession) request.getSession().getAttribute("user");
        if (u == null) {
            request.setAttribute("err", "Vui lòng đăng nhập trước khi đặt hàng *");
            request.getRequestDispatcher("Payment").forward(request, response);
        } else {
            Collection<User> user = u.getUser();
            String idUser = u.getUserId();
            if (fullname.equals("") || address.equals("") || email.equals("") || phone.equals("")||privateKey.equals("")) {
                request.setAttribute("err", "Vui lòng điền đầy đủ vào những mục có đánh *");
                request.getRequestDispatcher("Payment").forward(request, response);

            } else {
                HttpSession session = request.getSession();
                session.getAttribute("cart");
                Cart c = Cart.getCart(session);
                Collection<Product> products = c.getData();
                List<Product> pro = new ArrayList<Product>(products);
                Random rd = new Random();
                String idOrder = "order" + rd.nextInt(1000000000) + rd.nextInt(1000000);
                //insert order
                Order order = new Order(idOrder, idUser, fullname, (int) c.total(), address, phone, email);
                OrderService.insertOrder(order);
                //insert order detail
                OrderDetailService.insertOrderDetail(pro, idOrder);
                //xu ly chu ky
                List<OrderDetail>list = OrderDetailService.getDetailOrder(idOrder);
                order.setOrderDetails(list);
                DSA dsa = new DSA();
                PrivateKey privatekey =null;
                try {
                    privatekey = dsa.stringToPrivateKey(privateKey);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                try {
                    OrderService.updateSignature(idOrder, dsa.signData(order.getDataToSign(),privatekey));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                //send mail
                SendToMail mail = new SendToMail();
                mail.sendEmail(email, "TrueMart-Order", "TrueMart gach men cao cấp đã nhận được đơn đặt hàng của bạn");
                request.setAttribute("msg", "Bạn đã đặt hàng thành công");
                response.sendRedirect("ProductLists");
                Cart newCart = new Cart();
                newCart.commit(session);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
