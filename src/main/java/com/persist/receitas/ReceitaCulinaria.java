package com.persist.receitas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Ingrediente implements Serializable {
    private String nome;
    private String quantidade;
    private String unidadeMedida;

    // Construtores, getters e setters aqui
    public Ingrediente(String nome, String quantidade, String unidadeMedida) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.unidadeMedida = unidadeMedida;
    }

    @Override
    public String toString() {
        return nome + " (" + quantidade + " " + unidadeMedida + ")";
    }

}

public class ReceitaCulinaria implements Serializable {
    private int id;
    private String nome;
    private String categoria;
    private List<Ingrediente> ingredientes;
    private String instrucoes;

    // Construtores, getters e setters aqui
     public ReceitaCulinaria(int id, String nome, String categoria) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
    }

    public void adicionarIngrediente(Ingrediente ingrediente) {
        if (ingredientes == null) {
            ingredientes = new ArrayList<>();
        }
        ingredientes.add(ingrediente);
    }

    public void adicionarIngrediente(List<Ingrediente> ingredientes) {
        if (this.ingredientes == null) {
            this.ingredientes = new ArrayList<>();
        }
        for (Ingrediente ingrediente : ingredientes) {
            this.ingredientes.add(ingrediente);
        }
    }

    public String listarIngredientes(){
        String res = "[";
        for (Ingrediente ingrediente : this.ingredientes) {
            // System.out.println(ingrediente);
            res += String.format("%s;", ingrediente);
        }
        res += "]";
        // System.out.println(res);
        return res;
    }

    public void adicionarInstrucoes(){
        Scanner scanner = new Scanner(System.in, "UTF-8");
        String str = "";
        String entrada = scanner.nextLine();
        while (!entrada.equals("FIM")) {
            str+= entrada + "\n";
            entrada = scanner.nextLine();
        }
        // System.out.println(str);
        this.instrucoes = str;
    }

    @Override
    public String toString() {
        return "ReceitaCulinaria [id = " + id + ", nome = " + nome + ", categoria = " + categoria + "]";
    }
}