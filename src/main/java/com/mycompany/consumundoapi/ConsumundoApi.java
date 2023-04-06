package com.mycompany.consumundoapi;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class ConsumundoApi {

    public static void main(String[] args) throws IOException, InterruptedException {

        //puxa os dados
        //String url = "https://imdb-api.com/en/API/Top250Movies/ + SUA-API-KEY";
        String urlIMDB = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        String urlNasa = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
        String urlPropria ="http://localhost:8080/linguagens";
        //URI endereco = URI.create(url);
        //HttpClient cliente = HttpClient.newHttpClient();
        //HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        //HttpResponse<String> response = cliente.send(request, BodyHandlers.ofString());
        //String body = response.body();
        
        ClienteHttp http = new ClienteHttp();
        String json = http.buscaDados(urlPropria);
        
        //extrair só os dados que interessam
        //var parser = new JsonParser();
        //List<Map<String,String>> listaDeConteudos = parser.parse(json);
        
        
        
       //ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();
       //List<Conteudo> conteudos = extrator.extraiConteudos(json);
       
       ExtratorDeConteudo extrator1 = new ExtratorDeConteudoDoIMDB();
       List<Conteudo> conteudos1 = extrator1.extraiConteudos(json); 
       
        //exibir e manipular dados
        GeradorDeFigurinhas geradora = new GeradorDeFigurinhas();
        for(int i =0; i<3;i++){
            
            Conteudo conteudo = conteudos1.get(i);
            
            
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            
            String nomeArquivo = conteudo.getTitulo() +".png";
            
            
            geradora.cria(inputStream, nomeArquivo);
            
            System.out.println(conteudo.getTitulo());
            //System.out.println(filme.get("image"));
            //System.out.println(filme.get("imDbRating"));
            System.out.println();
        }

    }
}
