package com.persist.receitas;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.util.List;

public class ConverterCSV {
    public static void converter(int linguagem, String arquivoCsv) throws Exception {
        
        String[] nomeArquivo = arquivoCsv.split("\\.");
        List<Categoria> lista = lerCSV.CSVList(arquivoCsv);
        Categorias c = new Categorias(lista);
        if (linguagem == 1){
            // Cria um objeto ObjectMapper.
            ObjectMapper mapper = new ObjectMapper();
        
            File f = new File(nomeArquivo[0] + ".json");
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(f, c);
            System.out.println("Arquivo JSON gerado com sucesso.");

        } else {
            // Cria um objeto XMLMapper.
            XmlMapper xm = new XmlMapper();

            File f = new File(nomeArquivo[0] + ".xml");
            xm.enable(SerializationFeature.INDENT_OUTPUT);
            xm.writeValue(f, c);
            System.out.println("Arquivo XML gerado com sucesso.");
        }
    }
}
