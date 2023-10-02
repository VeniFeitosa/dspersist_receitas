package com.persist.receitas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CompactarCSV {
    public static void compactar(String arquivoCsv) {
        try {
            // Cria um novo arquivo ZipOutputStream
            String[] nomeArquivo = arquivoCsv.split("\\.");
            FileOutputStream out = new FileOutputStream(nomeArquivo[0] + ".zip");
            ZipOutputStream zos = new ZipOutputStream(out);

            // Adiciona o arquivo "arquivo.csv" ao arquivo zip
            File file = new File(arquivoCsv);
            ZipEntry entrada = new ZipEntry(file.getName());
            zos.putNextEntry(entrada);

            // Lê os dados do arquivo CSV e os escreve no arquivo zip
            BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line;
            while ((line = bfr.readLine()) != null) {
                zos.write((line + "\n").getBytes());
            }

            // Fecha o arquivo zip
            zos.close();
            bfr.close();
            System.out.println("Arquivo CSV compactado com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao compactar.");
        }
        
    }
}
