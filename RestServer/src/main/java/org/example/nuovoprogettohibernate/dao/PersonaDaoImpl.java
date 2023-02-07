package org.example.nuovoprogettohibernate.dao;


import org.example.nuovoprogettohibernate.myentities.Persona;

import javax.persistence.EntityManager;
import java.util.List;

public class PersonaDaoImpl implements DaoInterface<Persona> {

    private EntityManager manager = null;

    public PersonaDaoImpl() {
        this(null);
    }

    public PersonaDaoImpl(EntityManager m) {
        setManager(m);
    }


    public List<Persona> retrieve() {
        return manager.createQuery("select x from Persona x", Persona.class).getResultList();
    }


    public Persona retrieveForId(int id) {
        return manager.find(Persona.class, id);
    }


    //cancella attraverso l'attributo 'cognome'

    public void deleteByAttribute(String surname) {
        switch (manager.createQuery("delete from Persona x where x.cognome =:c").
                setParameter("c", surname).executeUpdate()) {
            case 0:
                System.out.println("Non ci sono record con attributo 'cognome' = " + surname);
                break;
            case 1:
                System.out.println("Record cancellato con successo");
                break;
            default:
                System.out.println("Record cancellati con successo");
        }
    }

    //Recupera attraverso il nome
    public List<Persona> retrieveByAnAttribute(String name) {
        return manager.createQuery("select x from Persona x where x.nome =:n", Persona.class).setParameter("n", name).
                getResultList();
    }

    public void create(Persona object) {
        manager.persist(object);
    }

    //Fà l'update di due attributi
    public void updateTwoAttributesInId1(String name, String surname) {
        if(manager.createQuery("update Persona x set x.nome =:n, x.cognome =:s where x.id = 1").
                setParameter("n", name).setParameter("s", surname).executeUpdate()==1){
            System.out.println("Record aggiornato con successo");
        }else{
            System.out.println("Impossibile aggiornare la tabella, non vi è un record con id=1");
        }
    }

    //TODO riparare metodo
    public void delete(Persona object) {
        switch (manager.createQuery("delete from Persona x where x.nome =:n").
                setParameter("n", object.getNome()).executeUpdate()) {
            case 0:
                System.out.println("Non vi sono record relativi all'oggetto passato");
                break;
            case 1:
                System.out.println("Record cancellato con successo");
                break;
            default:
                System.out.println("Record cancellati con successo");
        }
    }

    public String aProiectionById(int id) {
        return manager.createQuery("select x.nome from Persona x where x.id =:i",String.class).setParameter("i",id)
                .getSingleResult();
    }

    public EntityManager getManager() {
        return manager;
    }

    public void setManager(EntityManager manager) {
        this.manager = manager;
    }
}
