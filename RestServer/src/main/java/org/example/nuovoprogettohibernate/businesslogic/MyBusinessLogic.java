package org.example.nuovoprogettohibernate.businesslogic;


import javax.persistence.EntityManager;
import org.example.nuovoprogettohibernate.dao.AutomobileDaoImpl;
import org.example.nuovoprogettohibernate.dao.PersonaDaoImpl;
import org.example.nuovoprogettohibernate.myentities.Automobile;
import org.example.nuovoprogettohibernate.myentities.Persona;

import java.util.List;

public class MyBusinessLogic {
    private EntityManager manager =null;
    private AutomobileDaoImpl automobileDao = null;
    private PersonaDaoImpl personaDao = null;

    public MyBusinessLogic(EntityManager manager) {
        this.manager = manager;
        this.automobileDao= new AutomobileDaoImpl(manager);
        this.personaDao= new PersonaDaoImpl(manager);
    }

    public void inserisciUnAutomobile (Automobile auto){
        manager.getTransaction().begin();
        try{
            automobileDao.create(auto);
            manager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void inserisciUnaPersona (Persona persona){
        manager.getTransaction().begin();
        try{
            personaDao.create(persona);
            manager.getTransaction().commit();
       }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void inserisciPersonaEAuto(Persona pers, Automobile auto){
        manager.getTransaction().begin();
        try{
            auto.setPersona(pers);
            automobileDao.create(auto);
            personaDao.create(pers);
            manager.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public List<Persona> selectAllFromPersona (){
        return personaDao.retrieve();
    }

    public void aggiornaDueAttributiToAutomobile (String marca, String modello){
        manager.getTransaction().begin();
        automobileDao.updateTwoAttributesInId1(marca,modello);
        manager.getTransaction().commit();
    }


}
