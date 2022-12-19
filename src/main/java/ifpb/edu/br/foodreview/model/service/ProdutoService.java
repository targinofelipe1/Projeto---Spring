package ifpb.edu.br.foodreview.model.service;

import ifpb.edu.br.foodreview.model.entity.Produto;
import ifpb.edu.br.foodreview.model.repository.ProdutoIF;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoIF produtoRepository;

    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    @Transactional
    public Produto saveProduto(Produto newProduto){
        return produtoRepository.save(newProduto);
    }

    public Produto consultarProduto(Long id){
        return produtoRepository.findById(id).orElse(null);
    }

    @Transactional
    public Produto updateProduto(Produto produtoParaAtualizar){
        Produto produtoPesquisado = produtoRepository.findById(produtoParaAtualizar.getId()).orElse(null);
        if(produtoPesquisado == null){
            saveProduto(produtoParaAtualizar);
        }
        return produtoRepository.save(produtoParaAtualizar);
    }

    @Transactional
    public void deletarProduto(Produto produtoParaDeletar){
        produtoRepository.deleteById(produtoParaDeletar.getId());
    }

}