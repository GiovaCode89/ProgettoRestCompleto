package org.example.nuovoprogettohibernate.dao;


import org.example.nuovoprogettohibernate.myentities.Persona;

import javax.persistence.EntityManager;
import java.util.List;

public class PersonaDaoImpl implements DaoInterface <Persona> {

    private EntityManager manager=null;

    public PersonaDaoImpl(){
        this(null);
    }

    public PersonaDaoImpl(EntityManager m){
        setManager(m);
    }

    public List<Persona> retrieve(){
        return manager.createQuery("select x from Persona x",Persona.class).getResultList();
    }


    public Persona retrieveForId(int id){
        return manager.find(Persona.class,id);
    }

    //cancella attraverso l'attributo 'professione'
    @Override
    public void deleteByAttribute(String job) {
        manager.createQuery("delete from Persona x where x.professione =:j").
                setParameter("j",job).executeUpdate();
    }

    //Recupera attraverso il nome
    public List<Persona> retrieveByAnAttribute(String name){
        return manager.createQuery("select x from Persona x where x.nome =:n",Persona.class).setParameter("n",name).
                getResultList();
    }

    public void create(Persona object){
        manager.persist(object);
    }

    //Fà l'update di due attributi
    public void updateTwoAttributesInId1(String name, String surname){
        manager.createQuery("update Persona x set x.nome =:n, x.cognome =:s where x.id = 1").
                setParameter("n",name).setParameter("s",surname).executeUpdate();
    }

    public void delete(Persona object){
        manager.remove(object);
    }

    public EntityManager getManager() {
        return manager;
    }

    public void setManager(EntityManager manager) {
        this.manager = manager;
    }
}
