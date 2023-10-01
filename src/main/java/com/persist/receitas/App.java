package com.persist.receitas;

import java.util.Scanner;

class App{
    public static void main (String[] args) throws Exception{
        String arquivoCsv = "categorias.csv";
        Scanner sc = new Scanner(System.in);
        
        int opc = 0;
        do {
            System.out.println("----------------------------------**----------------------------------");
            System.out.println("Digite a opcao que deseja realizar:");
            System.out.println("1. Cadastrar categoria;");
            System.out.println("2. Mostrar quantidade de categorias;");
            System.out.println("3. Converter arquivo CSV em JSON ou XML;");
            System.out.println("4. Compactar arquivo CSV em .zip;");
            System.out.println("5. Obter hash256;");
            System.out.println("0. Sair;");
            System.out.print("Opcao -> ");
            opc = sc.nextInt();
            System.out.println("----------------------------------**----------------------------------");

            switch(opc) {
                case 1:
                    CadastroCSV.cadastrar(arquivoCsv);
                    break;
                case 2:
                    System.out.println(QtdCategorias.qtd_categorias(arquivoCsv));
                    break;
                case 3:
                    System.out.println("Para qual linguagem deseja converter o arquivo CSV?");
                    System.out.println("1. JSON");
                    System.out.println("2. XML");
                    System.out.print("Opcao -> ");
                    int linguagem = sc.nextInt();
                    while(linguagem < 1 || linguagem > 2) {
                        System.out.print("Digite uma opcao valida: ");
                        linguagem = sc.nextInt();
                    }
                    ConverterCSV.converter(linguagem, arquivoCsv);
                    break;
                case 4:
                    CompactarCSV.compactar(arquivoCsv);
                    break;
                case 5:
                    SHA256.printSHA256(arquivoCsv);
                    break;
                default:
                    if (opc != 0) {
                        System.out.println("Digite uma opção válida.");
                    }
                    break;
            }
        } while (opc != 0);
        
        sc.close();
    }
}