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

    @Column(name="professione")
    private String mansione;

    @OneToMany
    private List<Automobile> listaAuto=null;

    public Persona() {
    }

    public Persona(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public Persona(String nome, String cognome, Integer eta, String mansione) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.mansione = mansione;
    }

    public Persona(String nome, String cognome, Integer eta, String mansione, List<Automobile> listaAuto) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.mansione = mansione;
        this.listaAuto = listaAuto;
    }

    public Integer getId() {
        return id;
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

    public String getMansione() {
        return mansione;
    }

    public void setMansione(String mansione) {
        this.mansione = mansione;
    }

    public List<Automobile> getListaAuto() {
        return listaAuto;
    }

    public void setListaAuto(List<Automobile> listaAuto) {
        this.listaAuto = listaAuto;
    }
}
