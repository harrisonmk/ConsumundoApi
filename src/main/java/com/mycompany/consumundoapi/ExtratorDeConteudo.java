
package com.mycompany.consumundoapi;

import java.util.List;


public interface ExtratorDeConteudo {
    
    List<Conteudo> extraiConteudos(String json);
    
}
