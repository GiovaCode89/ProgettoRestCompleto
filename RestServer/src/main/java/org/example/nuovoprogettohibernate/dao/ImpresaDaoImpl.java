package org.example.nuovoprogettohibernate.dao;

import org.example.nuovoprogettohibernate.myentities.Impresa;

import javax.persistence.EntityManager;
import java.util.List;

public class ImpresaDaoImpl implements DaoInterface <Impresa>{

    private EntityManager manager = null;
    public ImpresaDaoImpl() {
    }

    public ImpresaDaoImpl(EntityManager manager) {
        setManager(manager);
    }

    public void setManager(EntityManager manager) {
        this.manager = manager;
    }

    public List<Impresa> retrieve() {
        return manager.createQuery("select x from impresa x", Impresa.class).getResultList();
    }

    public void create(Impresa object) {
        manager.persist(object);
    }

    public void delete(Impresa object) {
        if (manager.createQuery("delete x from impresa x where x.id =:i").setParameter("i",object.getId()).
                executeUpdate() == 0){
            System.out.println("Non c'è un record che abbia quel attributo nome!");
        }else{
            System.out.println("Record cancellati con successo");
        }
    }

    //aggiorna gli attributi nome e tipo_impresa del record con id=1
    public void updateTwoAttributesInId1(String nome, String tipo) {
        if (manager.createQuery("update impresa x set x.nome =:n, x.tipoImpresa=:t where x.id = 1").
                setParameter("n",nome).setParameter("t",tipo).executeUpdate() ==0){
            System.out.println("Non c'è un record che abbia id = 1!");
        }else{
            System.out.println("Record cancellati con successo");
        }
    }

    //recupera attraverso l'attributo "nome"
    public List<Impresa> retrieveByAnAttribute(String nome) {
        return manager.createQuery("select x from impresa x where x.nome =:n",Impresa.class).setParameter("n",nome)
                .getResultList();
    }

    public Impresa retrieveForId(int id) {
        return  manager.createQuery("select x from impresa x where x.id =:i",Impresa.class).setParameter("i",id)
                .getSingleResult();
    }


    //cancella considerando l'attributo "nome"
    public void deleteByAttribute(String nome) {
        if (manager.createQuery("delete x from impresa x where x.nome =:n").setParameter("n",nome).executeUpdate() ==0){
            System.out.println("Non c'è un record che abbia quel attributo nome!");
        }else{
            System.out.println("Record cancellati con successo");
        }
    }
}
