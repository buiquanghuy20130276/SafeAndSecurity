package controller;

import bean.Order;
import model.UserSession;
import service.OrderDetailService;
import service.OrderService;
import tool.DSA;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Order", value = "/ListOrder")
public class ListOrder extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserSession u = (UserSession) request.getSession().getAttribute("user");
        DSA dsa = new DSA();
        if (u == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            List<Order> listOrder = OrderService.getAllOrder();
            for (Order o : listOrder) {
                o.setSignature(OrderService.getSignature(o.getOrderID()));
                o.setOrderDetails(OrderDetailService.getDetailOrder(o.getOrderID()));
            }
            for (Order o : listOrder){

                try {
                    if(dsa.verifySignature(o.getDataToSign(),o.getSignature(), dsa.stringToPublicKey(u.getPublickey()))){
                        request.setAttribute(o.getOrderID(),"true");
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            request.setAttribute("listO", listOrder);
            request.getRequestDispatcher("admin/ManageOrder.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
