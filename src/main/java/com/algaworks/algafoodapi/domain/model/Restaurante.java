package com.algaworks.algafoodapi.domain.model;

import com.algaworks.algafoodapi.core.validation.Groups;
import com.algaworks.algafoodapi.core.validation.TaxaFrete;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data // contém Getters, Setters, AllArgsConstructor, ToString, Equals e HashCode
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_restaurante")
public class Restaurante {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String nome;

    @NotNull
//    @PositiveOrZero(message = "{TaxaFrete.invalida}")
    @TaxaFrete
    @Column(nullable = false)
    private BigDecimal taxaFrete;

    @Valid
    @ConvertGroup(from = Default.class, to = Groups.CozinhaId.class)
    @NotNull
    @ManyToOne
    @JoinColumn(name = "cozinha_id", nullable = false)
    private Cozinha cozinha;

    @JsonIgnore
    @Embedded
    private Endereco endereco;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "tb_restaurante_forma_pagamento",
            joinColumns = @JoinColumn(name = "restaurante_id"),
            inverseJoinColumns = @JoinColumn(name = "forma_pagamento_id"))
    private List<FormaPagamento> formasPagamento = new ArrayList<>();

    @JsonIgnore
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime dataCadastro;

    @JsonIgnore
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime dataAtualizacao;

    @JsonIgnore
    @OneToMany(mappedBy = "restaurante")
    private List<Produto> produtos;

}
