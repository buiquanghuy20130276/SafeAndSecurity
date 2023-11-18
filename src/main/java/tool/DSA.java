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
            System.out.println(dsa.stringToPrivateKey("MIIBSwIBADCCASwGByqGSM44BAEwggEfAoGBAP1/U4EddRIpUt9KnC7s5Of2EbdSPO9EAMMeP4C2USZpRV1AIlH7WT2NWPq/xfW6MPbLm1Vs14E7gB00b/JmYLdrmVClpJ+f6AR7ECLCT7up1/63xhv4O1fnxqimFQ8E+4P208UewwI1VBNaFpEy9nXzrith1yrv8iIDGZ3RSAHHAhUAl2BQjxUjC8yykrmCouuEC/BYHPUCgYEA9+GghdabPd7LvKtcNrhXuXmUr7v6OuqC+VdMCz0HgmdRWVeOutRZT+ZxBxCBgLRJFnEj6EwoFhO3zwkyjMim4TwWeotUfI0o4KOuHiuzpnWRbqN/C/ohNWLx+2J6ASQ7zKTxvqhRkImog9/hWuWfBpKLZl6Ae1UlZAFMO/7PSSoEFgIUaGeUn1XFE6j8Fqc8tjog/7LgXZc="));

            // Dữ liệu cần ký
//            String dataToSign = "Hello, DSA!";
//
//            // Ký và xác minh chữ ký
//            byte[] signature = dsa.signData(dataToSign, privateKey);
//            String base64Signature = dsa.encodeToBase64(signature);
//            boolean isVerified = dsa.verifySignature(dataToSign, dsa.decodeFromBase64(base64Signature), publicKey);
//
//            System.out.println("Data: " + dataToSign);
//            System.out.println("Signature: " + base64Signature);
//            System.out.println("Signature verified: " + isVerified);

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

    public  byte[] signData(String data, PrivateKey privateKey) throws Exception {
        // Băm dữ liệu sử dụng SHA-256
        byte[] hashedData = hashData(data);

        // Ký chữ ký cho dữ liệu đã băm
        Signature signature = Signature.getInstance("SHA256withDSA");
        signature.initSign(privateKey);
        signature.update(hashedData);
        return signature.sign();
    }
    public boolean verifySignature(String data, byte[] signature, PublicKey publicKey) throws Exception {
        // Băm dữ liệu sử dụng SHA-256
        byte[] hashedData = hashData(data);

        // Xác minh chữ ký với dữ liệu đã băm
        Signature verifier = Signature.getInstance("SHA256withDSA");
        verifier.initVerify(publicKey);
        verifier.update(hashedData);
        return verifier.verify(signature);
    }

    private  byte[] hashData(String data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(data.getBytes());
    }

    public String encodeToBase64(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    public byte[] decodeFromBase64(String base64) {
        return Base64.getDecoder().decode(base64);
    }
    public  PublicKey stringToPublicKey(String keyString) throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode(keyString);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("DSA");
        return keyFactory.generatePublic(keySpec);
    }

    public  PrivateKey stringToPrivateKey(String keyString) throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode(keyString);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("DSA");
        return keyFactory.generatePrivate(keySpec);
    }


}
