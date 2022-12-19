package ifpb.edu.br.foodreview.model.repository;

import ifpb.edu.br.foodreview.model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoIF extends JpaRepository<Produto,Long> {

}