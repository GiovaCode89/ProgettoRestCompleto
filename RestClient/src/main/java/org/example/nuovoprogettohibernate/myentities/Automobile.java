package org.example.nuovoprogettohibernate.myentities;


import javax.persistence.*;

@Entity
@Table(name="automobile")
public class Automobile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String marca;
    private String modello;
    private String targa;

    @ManyToOne
    @JoinColumn(name="id_persona")
    private Persona persona=null;

    public Automobile(){
    }

    public Automobile(String marca, String modello, String targa) {
        this.marca = marca;
        this.modello = modello;
        this.targa = targa;
    }

    public Automobile(String marca, String modello, String targa, Persona persona) {
        this.marca = marca;
        this.modello = modello;
        this.targa = targa;
        this.persona = persona;
    }

    public Integer getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
