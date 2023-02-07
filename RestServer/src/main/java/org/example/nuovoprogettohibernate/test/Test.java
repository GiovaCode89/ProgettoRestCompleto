package org.example.nuovoprogettohibernate.test;



import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import org.example.nuovoprogettohibernate.businesslogic.MyBusinessLogic;
import org.example.nuovoprogettohibernate.myentities.Automobile;
import org.example.nuovoprogettohibernate.myentities.Impresa;
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
        try {
            for (Persona p : listPersona) {
                System.out.println("nome = " + p.getNome() + " cognome = " + p.getCognome());
            }
        }catch (NullPointerException e){
            System.out.println("Errore, 'listPersona' è pari a 'null'");
        }

        bLogic.aggiornaDueAttributiToAutomobile("Mercedes","classe-A");

        //Dovrebbe far partire la stampa di errore
        //bLogic.cancellaUnImpresa(new Impresa("Microsoft","Informatica"));

        String i = manager.createQuery("select x.tipoImpresa from Impresa x where x.id = 2",String.class).getSingleResult();
        System.out.println(i);
    }
}
