package com.example.tarefa1.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@AllArgsConstructor
//@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "processos")
public class Processo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_processo", nullable = false)
    private Long id;

    private String numero;
    private String conteudo;


    @OneToOne
    @JoinColumn(name = "info_processo_id")
    private InfoProcesso infoProcesso;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Processo processo = (Processo) o;
        return id != null && Objects.equals(id, processo.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
