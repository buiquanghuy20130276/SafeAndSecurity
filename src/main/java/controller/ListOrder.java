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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        UserSession u = UserSession.getUS(session);
        DSA dsa = new DSA();
        if (u == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            List<Order> listOrder = OrderService.getAllOrder();
            for (Order o : listOrder) {
                o.setOrderDetails(OrderDetailService.getDetailOrder(o.getOrderID()));
            }
//            System.out.println(u.getPublickey());
            for (Order o : listOrder){

                    if(dsa.verifySignature(o.getDataToSign(),dsa.decodeFromBase64(o.getSignature()), dsa.stringToPublicKey(u.getPublickey()))){
                        request.setAttribute(o.getOrderID(),"true");
                    }

            }
            request.setAttribute("listO", listOrder);
            request.getRequestDispatcher("admin/ManageOrder.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public static void main(String[] args) throws Exception {
        DSA dsa = new DSA();
        List<Order> listOrder = OrderService.getAllOrder();
        for (Order o : listOrder) {

        o.setOrderDetails(OrderDetailService.getDetailOrder(o.getOrderID()));
            System.out.println(o.toString());
        }
        for (Order o : listOrder) {
            if (dsa.verifySignature(o.getDataToSign(), dsa.decodeFromBase64(o.getSignature()), dsa.stringToPublicKey("MIIBtzCCASwGByqGSM44BAEwggEfAoGBAP1/U4EddRIpUt9KnC7s5Of2EbdSPO9EAMMeP4C2USZpRV1AIlH7WT2NWPq/xfW6MPbLm1Vs14E7gB00b/JmYLdrmVClpJ+f6AR7ECLCT7up1/63xhv4O1fnxqimFQ8E+4P208UewwI1VBNaFpEy9nXzrith1yrv8iIDGZ3RSAHHAhUAl2BQjxUjC8yykrmCouuEC/BYHPUCgYEA9+GghdabPd7LvKtcNrhXuXmUr7v6OuqC+VdMCz0HgmdRWVeOutRZT+ZxBxCBgLRJFnEj6EwoFhO3zwkyjMim4TwWeotUfI0o4KOuHiuzpnWRbqN/C/ohNWLx+2J6ASQ7zKTxvqhRkImog9/hWuWfBpKLZl6Ae1UlZAFMO/7PSSoDgYQAAoGAYxmSOXXEqObHMQUpIIy0kVzgl+f4cS921BC6qG2Q9Y2x5pztHcBw58NL3qaxPoqBITZsLg+4DD1msxcTy27KaS6wLaM7kqnczl5x2vY1GZMs6r+2V8JGYwFWgSLPoNWOlN9nmYrmlxNCrPWtITFtPvKQJaL/MDTu422QnaVM7V4="))) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
//            System.out.println(o.getDataToSign());
        }
    }
}
