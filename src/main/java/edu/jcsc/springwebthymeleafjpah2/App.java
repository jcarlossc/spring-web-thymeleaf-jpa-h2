package edu.jcsc.springwebthymeleafjpah2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import edu.jcsc.springwebthymeleafjpah2.model.Produto;
import edu.jcsc.springwebthymeleafjpah2.service.ProdutoService;;

@Component
public class App implements CommandLineRunner {

    @Autowired
    private ProdutoService produtoService;

    @Override
    public void run(String... args) throws Exception {

        Produto p1 = new Produto("caneta", 1.54);
        Produto p2 = new Produto("borracha", 1.23);
        Produto p3 = new Produto("papel", 1.45);
        
        produtoService.adicionar(p1);
        produtoService.adicionar(p2);
        produtoService.adicionar(p3);
 
    }
}
