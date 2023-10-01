package com.persist.receitas;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class lerCSV {
    public static List<Categoria> CSVList(String arquivoCsv){
        List<Categoria> lista = new ArrayList<Categoria>();
        try {
            InputStream is = new FileInputStream(arquivoCsv);
            Scanner entrada = new Scanner(is);
            entrada.nextLine();
            while (entrada.hasNextLine()) {
                String[] linha = entrada.nextLine().split("\\;");
                int id = Integer.parseInt(linha[0]);
                String nome = linha[1];
                String desc = linha[2];
                String receitas = linha[3];
                int dif = Integer.parseInt(linha[4]);
                lista.add(new Categoria(id, nome, desc, receitas, dif));
            }
            entrada.close();
        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo CSV: " + e.getMessage());
        }
        return lista;
    }
}
