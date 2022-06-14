package com.cloudpayments.payments.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.SigningKeyResolverAdapter;

import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class CustomSigningKeyResolver extends SigningKeyResolverAdapter {

    private String publicKey;

    public CustomSigningKeyResolver(String publicK) {
        this.publicKey = publicK;
    }

    @Override
    public Key resolveSigningKey(JwsHeader jwsHeader, Claims claims) {


        // Base64 decode the data

        byte[] encodedPublicKey = Base64.getDecoder().decode(publicKey);

        X509EncodedKeySpec spec = new X509EncodedKeySpec(encodedPublicKey);
        KeyFactory kf;
        try {
            kf = KeyFactory.getInstance("RSA");
            System.out.println(kf.generatePublic(spec));
            return kf.generatePublic(spec);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}