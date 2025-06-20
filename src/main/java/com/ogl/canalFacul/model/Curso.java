package com.ogl.canalFacul.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Modalidade modalidade;
    private String turma;
    private String descricao;
    private String codigoCadastro;
    @ManyToOne
    private Users usuarioAdmin;
}
