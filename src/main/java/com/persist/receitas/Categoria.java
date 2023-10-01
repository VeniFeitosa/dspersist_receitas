package com.persist.receitas;

public class Categoria {
    private int id;
    private String nome;
    private String descricao;
    private String receitas;
    private int dificuldade;

    //CONSTRUTOR DA CLASSE
    public Categoria(int id, String nome, String descricao, String receita, int dificuldade) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dificuldade = dificuldade;
        this.receitas = receita;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getReceitas() {
        return this.receitas;
    }

    public void setReceitas(String receitas) {
        this.receitas = receitas;
    }

    public int getDificuldade() {
        return this.dificuldade;
    }

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }

}
