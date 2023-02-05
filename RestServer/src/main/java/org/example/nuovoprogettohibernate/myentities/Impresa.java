package org.example.nuovoprogettohibernate.myentities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="impresa")
public class Impresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @Column(name="tipo_impresa")
    private String tipoImpresa;

    @ManyToMany
    @JoinTable(name = "impieghi",joinColumns = @JoinColumn(name="impresa_id"),
            inverseJoinColumns = @JoinColumn(name="persona_id"))
    private List<Persona> persone = null;


    public Impresa() {
    }

    public Impresa(String nome, String tipoImpresa) {
        this.nome = nome;
        this.tipoImpresa = tipoImpresa;
    }

    public Integer getId() {
        return id;
    }

    public List<Persona> getPersone() {
        return persone;
    }

    public void setPersone(List<Persona> persone) {
        this.persone = persone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoImpresa() {
        return tipoImpresa;
    }

    public void setTipoImpresa(String tipoImpresa) {
        this.tipoImpresa = tipoImpresa;
    }
}
