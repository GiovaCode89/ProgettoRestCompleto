package org.example.nuovoprogettohibernate.dao;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

import org.example.nuovoprogettohibernate.myentities.Automobile;


public class AutomobileDaoImpl implements DaoInterface<Automobile> {

    private EntityManager manager = null;

    public AutomobileDaoImpl(EntityManager manager) {
        setManager(manager);
    }

    public List<Automobile> retrieve() {
        return manager.createQuery("select x from Automobile x", Automobile.class).getResultList();
    }

    public void create(Automobile object) {
        manager.persist(object);
    }

    //Fà l'update sugli attributi "marca" e "modello"

    public void updateTwoAttributesInId1(String marca, String modello) {
        if (manager.createQuery("update Automobile x set x.marca =:m, x.modello=:n where x.id = 4")
                .setParameter("m", marca).setParameter("n", modello).
                executeUpdate() == 1){
            System.out.println("Record aggiornato con successo");
        }else{
            System.out.println("Impossibile fare aggiornamento, non c'è record con id = 4!");
        }
    }

    //Fà la select attraverso l'attributo 'marca'

    public List<Automobile> retrieveByAnAttribute(String marca) {
        return manager.createQuery("select x from Automobile x where x.marca =:m", Automobile.class).
                setParameter("m", marca).getResultList();
    }


    public Automobile retrieveForId(int id) {
        return manager.find(Automobile.class, id);
    }

    //Cancella attraverso l'attributo 'targa'

    public void deleteByAttribute(String targa) {
        if (manager.createQuery("delete from Automobile x where x.targa =:t").
                setParameter("t", targa).executeUpdate()==1){
            System.out.println ("Record cancellato con successo!");
        }else{
            System.out.println ("Impossibile cancellare, non vi è un record con 'targa' = "+targa);
        }
    }

    //Restituisce proiezione su 'marca'
    public String aProiectionById(int id) {
        return manager.createQuery("select x.marca from Automobile x where x.id =:i", String.class)
                .setParameter("i",id).getSingleResult();
    }

    //TODO risolvere metodo
    public void delete(Automobile object) {
        manager.remove(object);
    }



    public EntityManager getManager() {
        return manager;
    }

    public void setManager(EntityManager manager) {
        this.manager = manager;
    }
}
