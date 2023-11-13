package edu.jcsc.springwebthymeleafjpah2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.jcsc.springwebthymeleafjpah2.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    
}
