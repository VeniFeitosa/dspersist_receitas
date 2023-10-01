package com.persist.receitas;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

// import ReceitaCulinaria;
class salvarCSV{
    public static void salvar(){
        try {
            Scanner scanner = new Scanner(System.in, "UTF-8");
            PrintStream pStream = new PrintStream("dados.csv");
            pStream.println("Id,Nome,Categoria,Ingredientes,Instrucoes");

            System.out.println("=================================");
            System.out.println("Digite o id da receita: ");
            String id = scanner.nextLine();
            System.out.println("Digite o nome da receita: ");
            String nome = scanner.nextLine();
            System.out.println("Digite a categoria da recceita: ");
            String categoria = scanner.nextLine();
            System.out.println("---------------------------------");
            System.out.println("SEÇÃO DE INGREDIENTES");
            System.out.println("---------------------------------");
            String listaIngredientes = "[";
            String entrada = "S";

            while ((entrada.equals("S") || entrada.equals("s"))) {
                System.out.println("Digite o nome do ingrediente: ");
                String nomeIngrediente = scanner.nextLine();
                System.out.println("Digite a quantidade: ");
                String quantidade = scanner.nextLine();
                System.out.println("Digite a unidade de medida: ");
                String medida = scanner.nextLine();
                listaIngredientes += String.format("%s (%s %s);", nomeIngrediente, quantidade, medida);
                System.out.println("Quer adicionar mais algum ingrediente?");
                System.out.print("Digite S para sim: ");
                entrada = scanner.nextLine();
            }

            listaIngredientes += "]";
            System.out.println("Digite as instruções da receita: ");

            String instrucoes = scanner.nextLine();
            // System.out.println(instrucoes);
            pStream.println(String.format("%s,%s,%s,%s,%s", id, nome, categoria, listaIngredientes, instrucoes));
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}

class qtdEntidades{
    public static int qtd(){
        try {
            InputStream is = new FileInputStream("dados.csv");
            Scanner entrada = new Scanner(is);
            int count = 0;
            while (entrada.hasNextLine()) {
                // System.out.println(entrada.nextLine());
                count++;
                entrada.nextLine();
            }
            is.close();
            return count - 1;
        } catch (Exception e) {
            // TODO: handle exception
            return -1;
        }
        
    }
}

class compactarCSV{
    public static void compactar(String fileName) {
        try {
            // Cria um novo arquivo ZipOutputStream
            FileOutputStream out = new FileOutputStream("arquivo.zip");
            ZipOutputStream zipOutputStream = new ZipOutputStream(out);

            // Adiciona o arquivo "arquivo.csv" ao arquivo zip
            File file = new File(fileName);
            ZipEntry entry = new ZipEntry(file.getName());
            zipOutputStream.putNextEntry(entry);

            // Lê os dados do arquivo CSV e os escreve no arquivo zip
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line;
            while ((line = reader.readLine()) != null) {
                zipOutputStream.write((line + "\n").getBytes());
            }

            // Fecha o arquivo zip
            zipOutputStream.close();
            System.out.println("Arquivo CSV compactado com sucesso.");
        } catch (Exception e) {
            // e.printStackTrace();
        }
    }
}

public class App 
{
    public static void main( String[] args )
    {
        
        // salvarCSV.salvar();
        // System.out.println(qtdEntidades.qtd());
        compactarCSV.compactar("dados.csv");
        // ReceitaCulinaria r1 = new ReceitaCulinaria(1, "Mousse de Limão", "Sobremesa");
        // List<Ingrediente> ingredientes;
        // ingredientes = new ArrayList<>();
        // ingredientes.add(new Ingrediente("Suco de Limão", "2", "Colheres"));
        // ingredientes.add(new Ingrediente("Leite Condensado", "1", "Caixa"));
        // r1.adicionarIngrediente(ingredientes);
        // System.out.println(r1);
        // r1.listarIngredientes();
        // r1.adicionarInstrucoes();
        
    }
}
