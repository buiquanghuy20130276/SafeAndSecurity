package tool;

import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class DSA {

    public static void main(String[] args) {
        try {
            DSA dsa = new DSA();
            // Tạo cặp khóa
            KeyPair keyPair = dsa.generateKeyPair();

            // Lấy khóa công khai và khóa riêng tư từ cặp khóa
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();

            // Dữ liệu cần ký
            String dataToSign = "Hello, DSA!";

            // Ký và xác minh chữ ký
            byte[] signature = dsa.signData(dataToSign, privateKey);
            String base64Signature = dsa.encodeToBase64(signature);
            boolean isVerified = dsa.verifySignature(dataToSign, dsa.decodeFromBase64(base64Signature), publicKey);

            System.out.println("Data: " + dataToSign);
            System.out.println("Signature: " + base64Signature);
            System.out.println("Signature verified: " + isVerified);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public KeyPair generateKeyPair()  {
        KeyPairGenerator keyPairGenerator = null;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("DSA");
            SecureRandom secureRandom = new SecureRandom();
            keyPairGenerator.initialize(1024, secureRandom);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        return keyPairGenerator.generateKeyPair();
    }

    public byte[] signData(String data, PrivateKey privateKey) throws Exception {
        Signature signature = Signature.getInstance("SHA1withDSA");
        signature.initSign(privateKey);
        signature.update(data.getBytes());
        return signature.sign();
    }

    public boolean verifySignature(String data, byte[] signature, PublicKey publicKey) throws Exception {
        Signature sig = Signature.getInstance("SHA1withDSA");
        sig.initVerify(publicKey);
        sig.update(data.getBytes());
        return sig.verify(signature);
    }

    public String encodeToBase64(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    public byte[] decodeFromBase64(String base64) {
        return Base64.getDecoder().decode(base64);
    }

}
