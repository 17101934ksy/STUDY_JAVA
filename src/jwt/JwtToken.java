package jwt;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class JwtToken {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        KeyPairGenerator rsaKeyPairGenerator = KeyPairGenerator.getInstance("RSA");
        rsaKeyPairGenerator.initialize(2048);

        KeyPair keyPair = rsaKeyPairGenerator.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

        System.out.println(publicKey);
        System.out.println(privateKey);

        byte[] encoded = publicKey.getEncoded();
        String a = "test";

        byte[] bytes = a.getBytes();
        


    }
}
