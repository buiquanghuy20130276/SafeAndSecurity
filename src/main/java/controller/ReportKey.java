package controller;

import bean.User;
import service.HistoryKeyService;
import service.UserService;
import tool.DSA;
import tool.SendToMail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.KeyPair;

@WebServlet(name = "ReportKey", value = "/ReportKey")
public class ReportKey extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String userId = req.getParameter("userId");
        String userEmail = req.getParameter("userEmail");
        DSA dsa = new DSA();
        User user = new User();
        user.setIdUser(userId);
        KeyPair keyPair = dsa.generateKeyPair();
        String publicKey = dsa.encodeToBase64(keyPair.getPublic().getEncoded());
        String privateKey = dsa.encodeToBase64(keyPair.getPrivate().getEncoded());
        //  gửi privateKey về email , email  này là của người dung
        if (UserService.existEmail(userEmail)) {
            user.setPublicKey(publicKey);
            // lưu lại public key cũ sao đó cập nhật public key mơi
            HistoryKeyService.insertKey(userId, UserService.getPublicKey(userId));
            UserService.updatePublicKey(userId, publicKey);
            SendToMail.sendEmail(userEmail, "PrivateKey mới", privateKey);
            req.setAttribute("existEmail",true);
        } else
            req.setAttribute("existEmail",false);
        req.getRequestDispatcher("/personalUser").forward(req, resp);
    }
}
