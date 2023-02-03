package org.example.nuovoprogettohibernate.dao;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import org.example.nuovoprogettohibernate.myentities.Automobile;


public class AutomobileDaoImpl implements DaoInterface<Automobile> {

    private EntityManager manager=null;

    public AutomobileDaoImpl(EntityManager manager) {
        setManager(manager);
    }

    @Override
    public List<Automobile> retrieve() {
        return manager.createQuery("select x from Automobile x",Automobile.class).getResultList();
    }

    @Override
    public void create(Automobile object) {
        manager.persist(object);
    }

    //Fà l'update sugli attributi "marca" e "modello"
    @Override
    public void updateTwoAttributesInId1(String marca, String modello) {
         manager.createQuery("update Automobile x set x.marca =:m, x.modello=:n where x.id = 4")
                                  .setParameter("m",marca).setParameter("n",modello).
                                executeUpdate();
    }

    //Fà la select attraverso l'attributo 'marca'
    @Override
    public List<Automobile> retrieveByAnAttribute(String marca) {
        return manager.createQuery("select x from Automobile x where x.marca =:m",Automobile.class).
                setParameter("m",marca).getResultList();
    }

    @Override
    public Automobile retrieveForId(int id) {
        return manager.find(Automobile.class,id);
    }

    //Cancella attraverso l'attributo 'targa'
    @Override
    public void deleteByAttribute(String targa) {
        manager.createQuery("delete from Automobile x where x.targa =:t").
                setParameter("t",targa).executeUpdate();
    }

    @Override
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
