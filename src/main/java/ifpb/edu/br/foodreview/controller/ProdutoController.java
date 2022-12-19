package ifpb.edu.br.foodreview.controller;

import ifpb.edu.br.foodreview.model.entity.Produto;
import ifpb.edu.br.foodreview.model.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<Produto>> getAllProdutos(){
        return new ResponseEntity<>(produtoService.listarProdutos(), HttpStatus.OK) ;
    }

    @PostMapping
    public Produto saveProduto(@RequestBody Produto newProduto){
        return this.produtoService.saveProduto(newProduto) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> consultaProduto(@PathVariable("id") Long id){
        return ResponseEntity.ok(produtoService.consultarProduto(id)) ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable("id") Long id,
                                                 @RequestBody Produto produtoParaAtualizar)
    {
        produtoParaAtualizar.setId(id);
        return ResponseEntity.ok(produtoService.updateProduto(produtoParaAtualizar));
    }

    @DeleteMapping
    public  ResponseEntity<Void> deletarProduto(@RequestBody Produto produtoParaDeletar){
        produtoService.deletarProduto(produtoParaDeletar);
        return ResponseEntity.noContent().build();
    }
}
