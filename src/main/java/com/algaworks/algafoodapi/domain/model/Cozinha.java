package com.algaworks.algafoodapi.domain.model;

import lombok.Data;

import javax.persistence.*;

@Data // contém Getters, Setters, AllArgsConstructor, ToString, Equals e HashCode
@Entity
@Table(name = "tb_cozinha")
public class Cozinha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nm_cozinha")
    private String nome;

}
