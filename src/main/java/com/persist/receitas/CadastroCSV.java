package com.persist.receitas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CadastroCSV {
    public static void cadastrar(String arquivoCsv) throws IOException {
        Scanner sc = new Scanner(System.in);
    
        System.out.print("Digite nome da categoria: ");
        String nome = sc.nextLine();
        System.out.print("Digite a descricao da categoria: ");
        String descricao = sc.nextLine();
       
        StringBuilder sb = new StringBuilder();
        
        System.out.print("Digite uma receita da categoria da categoria: ");
        String receita = sc.nextLine();
        sb.append(receita);
        boolean repetir = true;
        
        while(repetir) {
            System.out.print("Deseja adicionar mais uma receita?(S/N): ");
            String resposta = sc.nextLine();
            if (resposta.equals("S") || resposta.equals("s")) {
                System.out.print("Digite o nome da receita nova: ");
                String novaReceita = sc.nextLine();
                sb.append(",");
                sb.append(novaReceita);
            } else {
                repetir = false;
            }
        }

        receita = sb.toString();
    
        System.out.print("Digite o nivel de dificuldade da categoria(1-5): ");
        int dificuldade = sc.nextInt();

        while(dificuldade < 1 || dificuldade > 5) {
            System.out.print("Digite um nivel de dificuldade valido: ");
            dificuldade = sc.nextInt();
            sc.nextLine();
        }

        int id = 1;
        if (QtdCategorias.qtd_categorias(arquivoCsv) != -1) {

            FileReader fr = new FileReader(arquivoCsv);
            BufferedReader br = new BufferedReader(fr);

            int qtdLinhas = QtdCategorias.qtd_categorias(arquivoCsv);

            String linha = br.readLine();
            for (int i = 0; i < qtdLinhas; i++) {
                linha = br.readLine();
            }

            String[] ultimaLinha = linha.split(";");
            String primeiroElemento = ultimaLinha[0];
            id += Integer.parseInt(primeiroElemento);
            br.close();
        }

        Categoria categoria = new Categoria(id, nome, descricao, receita, dificuldade);
        BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoCsv, true));
        
        if (QtdCategorias.qtd_categorias(arquivoCsv) <= 0) {
            writer.write("Id;Nome;Descrição;Receitas;Dificuldade\n");
        }
        writer.write(categoria.getId() + ";" + categoria.getNome() + ";" 
                    + categoria.getDescricao() + ";" + categoria.getReceitas() 
                    + ";" + categoria.getDificuldade() + "\n");

        writer.close();

        //sc.close();
    }
}
