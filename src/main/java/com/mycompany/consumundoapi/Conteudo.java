package com.mycompany.consumundoapi;

public class Conteudo {

    private String titulo;
    private String urlImagem;

    
    
    public Conteudo(String titulo, String urlImagem) {
        this.titulo = titulo;
        this.urlImagem = urlImagem;
    }

    public Conteudo() {
    }

    
    
    public String getTitulo() {
        return titulo;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }
    
    
    
    

}
