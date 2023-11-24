package tool;

import java.security.*;
import java.util.Base64;

public class Test {

    public static KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");
        keyPairGenerator.initialize(2048); // Độ dài của key, bạn có thể điều chỉnh theo nhu cầu
        return keyPairGenerator.generateKeyPair();
    }
    public static byte[] signData(String data, PrivateKey privateKey) throws Exception {
        // Băm dữ liệu sử dụng SHA-256
        byte[] hashedData = hashData(data);

        // Ký chữ ký cho dữ liệu đã băm
        Signature signature = Signature.getInstance("SHA256withDSA");
        signature.initSign(privateKey);
        signature.update(hashedData);
        return signature.sign();
    }
    public static boolean verifySignature(String data, byte[] signature, PublicKey publicKey) throws Exception {
        // Băm dữ liệu sử dụng SHA-256
        byte[] hashedData = hashData(data);

        // Xác minh chữ ký với dữ liệu đã băm
        Signature verifier = Signature.getInstance("SHA256withDSA");
        verifier.initVerify(publicKey);
        verifier.update(hashedData);
        return verifier.verify(signature);
    }

    private static byte[] hashData(String data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(data.getBytes());
    }

    public static void main(String[] args) throws Exception {
        // Tạo cặp khóa
        KeyPair keyPair = Test.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        // Dữ liệu cần ký
        String dataToSign = "Dữ liệu cần ký";

        // Ký chữ ký
        byte[] signature = signData(dataToSign, privateKey);

        // Xác minh chữ ký
        boolean isSignatureValid = verifySignature("Dữ liệu cần ký", signature, publicKey);

        System.out.println("Chữ ký hợp lệ: " + isSignatureValid);
    }
}

