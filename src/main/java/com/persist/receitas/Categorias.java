package com.persist.receitas;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "ListaCategorias")
public class Categorias {
    List<Categoria> categorias = new ArrayList<Categoria>();
    
    public Categorias(List<Categoria> categorias){
        this.categorias = categorias;
    }

    @JacksonXmlElementWrapper(localName = "Categorias")
    @JacksonXmlProperty(localName = "Categoria")
    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    @Override
    public String toString(){
        return this.categorias.toString();
    }
}
