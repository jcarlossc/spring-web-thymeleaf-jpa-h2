package edu.jcsc.springwebthymeleafjpah2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jcsc.springwebthymeleafjpah2.model.Produto;
import edu.jcsc.springwebthymeleafjpah2.repository.ProdutoRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProdutoService {
 
    @Autowired
    private ProdutoRepository repo;
     
    public List<Produto> listar() {
        return repo.findAll();
    }
     
    public void adicionar(Produto produto) {
        repo.save(produto);
    }
     
    public Produto editar(Integer id) {
        return repo.findById(id).get();
    }
     
    public void apagar(Integer id) {
        repo.deleteById(id);
    }
}

