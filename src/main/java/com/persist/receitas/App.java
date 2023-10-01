package com.persist.receitas;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

public class App 
{
    public static void main( String[] args )
    {
        
        salvarCSV.salvar();
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
