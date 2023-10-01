package com.persist.receitas;


import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {

  public static void printSHA256(String arquivoCsv) throws IOException, NoSuchAlgorithmException {
        // Cria um objeto MessageDigest.
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // Abre um fluxo de entrada para o arquivo CSV.
        FileInputStream fis = new FileInputStream(arquivoCsv);

        // Calcula o hash.
        byte[] bytes = new byte[1024];
        int n;
        while ((n = fis.read(bytes)) != -1) {
            md.update(bytes, 0, n);
        }

        // Converte o hash em uma string hexadecimal.
        byte[] hash = md.digest();
        String sha256 = bytesToHex(hash);

        // Imprime o hash.
        fis.close();
        System.out.println(sha256);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}

