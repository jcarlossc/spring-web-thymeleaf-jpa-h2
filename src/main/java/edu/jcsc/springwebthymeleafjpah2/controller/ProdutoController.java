package edu.jcsc.springwebthymeleafjpah2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.jcsc.springwebthymeleafjpah2.model.Produto;
import edu.jcsc.springwebthymeleafjpah2.service.ProdutoService;

@Controller
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Produto> listaProdutos = produtoService.listar();
        model.addAttribute("listarProdutos", listaProdutos);
        
        return "index";
    }

    @RequestMapping("/novo")
    public String novoProduto(Model model) {
        Produto produto = new Produto();
        model.addAttribute("produto", produto);
        
        return "novo_produto";
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public String salvaProduto(@ModelAttribute("produto") Produto produto) {
        produtoService.adicionar(produto);
        
        return "redirect:/";
    }

    @RequestMapping("/editar/{id}")
    public ModelAndView editaProduto(@PathVariable(name = "id") int id) {
        ModelAndView modelView = new ModelAndView("editar_produto");
        Produto produto = produtoService.editar(id);
        modelView.addObject("produto", produto);
        
        return modelView;
    }

    @RequestMapping("/apagar/{id}")
    public String apagaProduto(@PathVariable(name = "id") int id) {
        produtoService.apagar(id);
        return "redirect:/";       
    }
}
