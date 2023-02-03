package org.example.nuovoprogettohibernate.test;



import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import org.example.nuovoprogettohibernate.businesslogic.MyBusinessLogic;
import org.example.nuovoprogettohibernate.myentities.Automobile;
import org.example.nuovoprogettohibernate.myentities.Persona;

import java.util.List;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("MioDb");
        EntityManager manager = managerFactory.createEntityManager();
        MyBusinessLogic bLogic= new MyBusinessLogic(manager);
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci una targa (5 caratteri)");
        //bLogic.inserisciPersonaEAuto(new Persona ("Mario","Rossi"), new Automobile("Fiat","Punto",scan.next()));
        List<Persona> listPersona= bLogic.selectAllFromPersona();
        System.out.println("Tuple della tabella 'persona' (solo nome e cognome)'");
        for (Persona p : listPersona){
            System.out.println("nome = "+p.getNome()+" cognome = "+p.getCognome());
        }

        bLogic.aggiornaDueAttributiToAutomobile("Mercedes","classe-A");

    }
}
