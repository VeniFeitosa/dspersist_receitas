package com.persist.receitas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// RETORNA O NUMERO DE LINHAS DO ARQUIVO CSV DE CATEGORIAS
public class QtdCategorias {
    public static int qtd_categorias(String arquivoCsv) throws IOException {
        try {
            FileReader fr = new FileReader(arquivoCsv);
            BufferedReader br = new BufferedReader(fr);
            int contador = 0;
            // ENQUANTO TIVER LINHA SOMA O CONTADOR 
            while (br.readLine() != null) {
                contador++;
            }

            br.close();
            return contador - 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
}