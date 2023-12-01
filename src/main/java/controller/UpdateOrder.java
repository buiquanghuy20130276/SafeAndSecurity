package controller;

import bean.Order;
import bean.OrderDetail;
import bean.Product;
import service.OrderDetailService;
import service.OrderService;
import service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

@WebServlet(name = "UpdateOrder", value = "/UpdateOrder")
public class UpdateOrder extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        String id = request.getParameter("id");
        if (action != null) {
            if (action.equals("delete")) {
                OrderDetailService.deleteOrderDetail(id);
                OrderService.deleteOrder(id);
                response.sendRedirect("ListOrder");
            }
            if (action.equals("update")) {
                OrderDetailService.updateStatus(id);
                response.sendRedirect("ListOrder");
            }
            if (action.equals("cancel")) {
                OrderDetailService.cancelOrder(id);
                UserSession u = (UserSession) request.getSession().getAttribute("user");
                String subject = "Thông báo đặt hàng";
                String content = "Cảm ơn bạn đã đặt hàng \n" +
                        "Tôi rất tiếc khi phải thông báo rằng đơn hàng của bạn đã bị người khác chỉnh sửa thông tin, bạn có thể đặt hàng lại nhé! \n" +
                        "cảm ơn bạn đã tin dùng sản phẩm của chúng tôi";
                SendToMail.sendEmail(u.getEmail(), subject, content);
                response.sendRedirect("ListOrder");
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
