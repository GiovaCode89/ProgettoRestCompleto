package org.example.nuovoprogettohibernate.myentities;



import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String cognome;
    private Integer eta;



    //TODO correggere 'mappedBy
    @ManyToMany(mappedBy = "persone")
    private List <Impresa> imprese = null;

    @OneToMany
    private List<Automobile> listaAuto=null;

    public Persona() {
    }

    public Persona(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public Persona(String nome, String cognome, Integer eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
    }

    public Persona(String nome, String cognome, Integer eta, List<Automobile> listaAuto) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.listaAuto = listaAuto;
    }

    public Integer getId() {
        return id;
    }

    public List<Impresa> getImprese() {
        return imprese;
    }

    public void setImprese(List<Impresa> imprese) {
        this.imprese = imprese;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Integer getEta() {
        return eta;
    }

    public void setEta(Integer eta) {
        this.eta = eta;
    }

    public List<Automobile> getListaAuto() {
        return listaAuto;
    }

    public void setListaAuto(List<Automobile> listaAuto) {
        this.listaAuto = listaAuto;
    }
}
