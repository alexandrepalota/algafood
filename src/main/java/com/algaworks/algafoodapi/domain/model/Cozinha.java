package com.algaworks.algafoodapi.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@JsonRootName("gastronomia") // aplicável ao xml
@Data // contém Getters, Setters, AllArgsConstructor, ToString, Equals e HashCode
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_cozinha")
public class Cozinha {

    @JsonIgnore
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("titulo")
    @Column(name = "nm_cozinha", nullable = false)
    private String nome;

}
