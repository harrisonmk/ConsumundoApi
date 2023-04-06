package com.mycompany.consumundoapi;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class GeradorDeFigurinhas {

    //acesso pasta local do seu projeto
    public static final String USER_DIR = System.getProperty("user.dir");
    //separador de arquivos '\' ou '/' dependendo do Sistema Operacional
    public static final String SEPARATOR = System.getProperty("file.separator");

    public void cria(InputStream inputStream,String nomeArquivo) throws IOException {

        //leitura da imagem
        //InputStream inputStream = new FileInputStream(new File("img/filme.jpg"));
        //final String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_1.jpg";
        //InputStream inputStream = new URL(url).openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        //cria uma nova imagem em memoria com transparencia
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        //copiar a imagem original para nova imagem (em memoria)  
        Graphics2D graficos = (Graphics2D) novaImagem.getGraphics();
        graficos.drawImage(imagemOriginal, 0, 0, null);

        
        //Configurar a fonte
       var fonte = new Font(Font.SANS_SERIF,Font.BOLD,64);
       graficos.setColor(Color.YELLOW);
       graficos.setFont(fonte);
        
        // escrever uma frase na nova imagem    
        graficos.drawString("TOPZERA",100,novaAltura-100);
        
        
        //cria uma pasta com o nome saida e escrever a nova imagem em um arquivo   
        createLocalFolder("saida");
        ImageIO.write(novaImagem, "png", new File("saida/"+nomeArquivo));

    }

    /**
     * Cria um diretorio dentro do seu projeto no workspace.
     *
     * workpace/meu_projeto/folderName
     *
     * @param folderName
     */
    public static void createLocalFolder(String folderName) {
        File file = new File(USER_DIR + SEPARATOR + folderName);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

}
