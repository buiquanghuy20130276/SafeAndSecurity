package controller;

import bean.User;
import service.UserService;
import tool.DSA;
import tool.MD5;
import tool.SendToMail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.KeyPair;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;


@WebServlet(name = "Register", value = "/register")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String agree = request.getParameter("agree");
        String name = request.getParameter("name");
        String uname = request.getParameter("username");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String pass = request.getParameter("password");
        Random rd = new Random();

        String timeRegister = String.valueOf(LocalDate.now());
        DSA dsa = new DSA();
        KeyPair keyPair = dsa.generateKeyPair();


        String publickey = dsa.encodeToBase64(keyPair.getPublic().getEncoded());
        String privateKey = dsa.encodeToBase64(keyPair.getPrivate().getEncoded());
        User user = new User();
        user.setIdUser("user" + rd.nextInt(1000000) + rd.nextInt(100000));
        user.setName(name);
        user.setUserName(uname);
        user.setEmail(email);
        user.setDay_register(timeRegister);
        user.setPassWord(MD5.getMd5(pass));
        user.setPhone(phone);
        user.setIsAdmin(0);
        user.setPublicKey(publickey);
        user.setStatus(1);

        try {
            if (name.equals("") || uname.equals("") || email.equals("") || pass.equals("")) {
                request.setAttribute("msg", "Vui lòng điền đầy đủ thông tin");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
            if (agree == null) {
                request.setAttribute("msg", "Vui lòng chấp nhận điều khoảng");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
            if (UserService.existUserName(uname)) {
                request.setAttribute("msg", "Tên đăng nhập đã tồn tại");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
            if (UserService.existEmail(email)) {
                request.setAttribute("msg", "Email này đã được đăng ký tài khoảng");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            } else if (UserService.register(user)) {
                String subject = "Đăng ký tài khoản";
                String message = "Đây là khóa bí mật của bạn, Vui lòng không ai biết thông tin về khóa này:\n" +privateKey;
                SendToMail.sendEmail(email, subject, message);
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            } else {
                request.setAttribute("msg", "Tạo tài khoản thất bại.<br> Hãy thử lại!!!");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DSA dsa = new DSA();
        KeyPair keyPair = dsa.generateKeyPair();
//        System.out.println("hhhh");
        System.out.println(dsa.encodeToBase64(keyPair.getPublic().getEncoded()));
        User user =  new User("user10000000", "quahuysuper", "buiquanghuy0029a@gmail.com", "212002", 1, "Bùi Quang Huy", "0981722033", 1, String.valueOf(LocalDate.now()),dsa.encodeToBase64(keyPair.getPublic().getEncoded()));

        UserService.register(user);
    }
}
