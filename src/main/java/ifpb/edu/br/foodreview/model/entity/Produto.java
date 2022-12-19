package ifpb.edu.br.foodreview.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "tb_produto")
@Data
@EqualsAndHashCode
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="logo")
    private String logo;
    @Column(name="nome")
    private String nome;
    @Column(name="localizacao")
    private String localizacao;
    @Column(name="avaliacao")
    private double avaliacao;
    @Column(name="contato")
    private String contato;
}

