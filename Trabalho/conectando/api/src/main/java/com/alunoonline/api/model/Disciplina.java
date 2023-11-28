package com.alunoonline.api.model;

import jakarta.persistence.*;

import javax.net.ssl.HandshakeCompletedEvent;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Disciplina implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nome;
    private String descricao;
    private Integer cargaHoraria;

  //  @ManyToOne
   // @JoinColumn(name = "curso_id")
  //  private Curso curso;

    public Disciplina(String nome, String descricao, Integer cargaHoraria) {
        this.nome = nome;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
      //  this.curso = curso;
    }


    public void setId(Long id) {
        this.id= id;
    }
}
