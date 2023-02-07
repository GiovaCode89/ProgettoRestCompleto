package org.example.nuovoprogettohibernate.dao;

import org.example.nuovoprogettohibernate.myentities.Impresa;

import javax.persistence.EntityManager;
import java.util.List;

public class ImpresaDaoImpl implements DaoInterface<Impresa> {

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
        return manager.createQuery("select x from Impresa x", Impresa.class).getResultList();
    }

    public void create(Impresa object) {
        manager.persist(object);
    }


    //TODO riparare metodo
    public void delete(Impresa object) {
        switch (manager.createQuery("delete from Impresa x where x.nome like :n").setParameter("n", object.getNome())
                .executeUpdate()) {
            case 0:
                System.out.println("Non c'è un record che abbia quel attributo nome!");
                break;
            case 1:
                System.out.println("Record cancellato con successo");
                break;
            default:
                System.out.println("Record cancellati con successo");
        }
    }

    //aggiorna gli attributi nome e tipo_impresa del record con id=1
    public void updateTwoAttributesInId1(String nome, String tipo) {
        if (manager.createQuery("update Impresa x set x.nome =:n, x.tipoImpresa=:t where x.id = 1").
                setParameter("n", nome).setParameter("t", tipo).executeUpdate()==1){
            System.out.println("Record aggiornato con successo");
        }else{
            System.out.println("Non c'è un record che abbia id = 1!");
        }
    }

    //recupera attraverso l'attributo "nome"
    public List<Impresa> retrieveByAnAttribute(String nome) {
        return manager.createQuery("select x from Impresa x where x.nome =:n", Impresa.class).setParameter("n", nome)
                .getResultList();
    }

    public Impresa retrieveForId(int id) {
        return manager.createQuery("select x from Impresa x where x.id =:i", Impresa.class).setParameter("i", id)
                .getSingleResult();
    }


    //cancella considerando l'attributo "nome"
    public void deleteByAttribute(String nome) {
        switch (manager.createQuery("delete x from Impresa x where x.nome =:n").setParameter("n", nome)
                .executeUpdate()) {
            case 0:
                System.out.println("Non vi sono record che hanno quello specifico 'nome'");
                break;
            case 1:
                System.out.println("Record cancellato con successo");
                break;
            default:
                System.out.println("Record cancellati con successo");
        }
    }

    //proiezione sull'attributo 'tipo_impresa'
    public String aProiectionById(int id) {
        return manager.createQuery("select x.tipoImpresa from Impresa x where x.id =:i", String.class)
                .setParameter("i", id).getSingleResult();

    }
}
