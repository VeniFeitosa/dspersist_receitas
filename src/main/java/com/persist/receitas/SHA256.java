package com.persist.receitas;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {

    // CONVERTE O HASH PARA HEXADECIMAL
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static void printSHA256(String arquivoCsv) throws IOException, NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        try {
            FileInputStream fis = new FileInputStream(arquivoCsv);

            // CALCULA O HASH
            byte[] bytes = new byte[1024];
            int n;
            while ((n = fis.read(bytes)) != -1) {
                md.update(bytes, 0, n);
            }

            // CONVERTE PARA HEXADECIMAL 
            byte[] hash = md.digest();
            String sha256 = bytesToHex(hash);

            fis.close();
            System.out.println(sha256);
            
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}