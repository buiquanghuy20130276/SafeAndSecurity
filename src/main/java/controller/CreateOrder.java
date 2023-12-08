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
import tool.Template;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@WebServlet(name = "CreateOrder", value = "/CreateOrder")
public class CreateOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String fullname = request.getParameter("fullname");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String privateKey = request.getParameter("private");
        UserSession u = (UserSession) request.getSession().getAttribute("user");
        if (u == null) {
            request.setAttribute("err", "Vui lòng đăng nhập trước khi đặt hàng *");
            request.getRequestDispatcher("Payment").forward(request, response);
        } else {
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
                Order order = new Order(idOrder, idUser, fullname, (int) c.total(), address, phone, email,0, String.valueOf( LocalDate.now()),String.valueOf(LocalDate.now()));
                OrderService.insertOrder(order);
                //insert order detail
                OrderDetailService.insertOrderDetail(pro, order.getOrderID());
                //xu ly chu ky
                order.setOrderDetails(OrderDetailService.getDetailOrder(order.getOrderID()));
                DSA dsa = new DSA();
                System.out.println(order.getDataToSign());
                String signature = dsa.encodeToBase64(dsa.signData(order.getDataToSign(), dsa.stringToPrivateKey(privateKey)));
                try {
                    OrderService.updateSignature(order.getOrderID(),signature);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
//                System.out.println(dsa.verifySignature(order.getDataToSign(), dsa.decodeFromBase64(signature),dsa.stringToPublicKey("MIIBtzCCASwGByqGSM44BAEwggEfAoGBAP1/U4EddRIpUt9KnC7s5Of2EbdSPO9EAMMeP4C2USZpRV1AIlH7WT2NWPq/xfW6MPbLm1Vs14E7gB00b/JmYLdrmVClpJ+f6AR7ECLCT7up1/63xhv4O1fnxqimFQ8E+4P208UewwI1VBNaFpEy9nXzrith1yrv8iIDGZ3RSAHHAhUAl2BQjxUjC8yykrmCouuEC/BYHPUCgYEA9+GghdabPd7LvKtcNrhXuXmUr7v6OuqC+VdMCz0HgmdRWVeOutRZT+ZxBxCBgLRJFnEj6EwoFhO3zwkyjMim4TwWeotUfI0o4KOuHiuzpnWRbqN/C/ohNWLx+2J6ASQ7zKTxvqhRkImog9/hWuWfBpKLZl6Ae1UlZAFMO/7PSSoDgYQAAoGAYxmSOXXEqObHMQUpIIy0kVzgl+f4cS921BC6qG2Q9Y2x5pztHcBw58NL3qaxPoqBITZsLg+4DD1msxcTy27KaS6wLaM7kqnczl5x2vY1GZMs6r+2V8JGYwFWgSLPoNWOlN9nmYrmlxNCrPWtITFtPvKQJaL/MDTu422QnaVM7V4=") ));
                //send mail
                SendToMail mail = new SendToMail();
                mail.sendEmail(email, "TrueMart-Order", Template.getOrderHtml());
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
