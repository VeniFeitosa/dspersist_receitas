package com.persist.receitas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CadastroCSV {
    public static void cadastrar(String arquivoCsv) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o id da categoria: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Digite nome da categoria: ");
        String nome = sc.nextLine();
        System.out.println(nome);
        System.out.print("Digite a descricao da categoria: ");
        String descricao = sc.nextLine();
        // EU NAO QUERIA USAR ARRAYLIST, ENTAO USEI UMA STRINGBUILDER PRA
        // PODER IR "SOMANDO" AS STRINGS E DEPOIS SO ATRIBUIR AO ATRIBUTO
        // RECEITAS
        StringBuilder sb = new StringBuilder();
        // OBRIGATORIAMENTE UMA RECEITA PRECISA SER CADASTRADA
        System.out.print("Digite uma receita da categoria da categoria: ");
        String receita = sc.nextLine();
        sb.append(receita);
        boolean repetir = true;
        // ENQUANTO HOUVER RECEITAS PRA ADD, O LACO SE REPETE
        while(repetir) {
            System.out.print("Deseja adicionar mais uma receita?(S/N): ");
            String resposta = sc.nextLine();
            if (resposta.equals("S") || resposta.equals("s")) {
                System.out.print("Digite o nome da receita nova: ");
                String novaReceita = sc.nextLine();
                sb.append(",");
                sb.append(novaReceita);
            } else {
                //System.out.println("entrou no else");
                repetir = false;
            }
        }

        // RECEITA RECEBE O QUE TINHA NA STRINGBUILDER
        receita = sb.toString();
    
        System.out.print("Digite o nivel de dificuldade da categoria(1-5): ");
        int dificuldade = sc.nextInt();

        while(dificuldade < 1 || dificuldade > 5) {
            System.out.print("Digite um nivel de dificuldade valido: ");
            dificuldade = sc.nextInt();
            sc.nextLine();
        }
        // INSTANCIA UMA NOVA CATEGORIA E ADICIONA NO ARQUIVO CSV
        Categoria categoria = new Categoria(id, nome, descricao, receita, dificuldade);
        BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoCsv, true));
        if (QtdCategorias.qtd_categorias(arquivoCsv) <= 0) {
            //SIGNIFICA QUE O ARQUIVO ESTÁ VAZIO
            writer.write("Id;Nome;Descrição;Receitas;Dificuldade\n");
        }
        writer.write(categoria.getId() + ";" + categoria.getNome() + ";" 
                    + categoria.getDescricao() + ";" + categoria.getReceitas() 
                    + ";" + categoria.getDificuldade() + "\n");

        writer.close();
        // sc.close();
    }
}
