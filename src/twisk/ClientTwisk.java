package twisk;


import twisk.monde.*;
import twisk.monde.Monde;
import twisk.outils.ClassLoaderPerso;
import twisk.simulation.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class  ClientTwisk {
    public static void main(String[] args) {
        //ClientTwisk client=new ClientTwisk();


        // private static void simulate(){
        Monde m = new Monde();


        Guichet guichet = new Guichet("ticket", 2);
        Activite act1 = new ActiviteRestreinte("toboggan", 2, 1);

        Etape etape1 = new Activite("musee");
        Etape etape2 = new Activite("boutique");

        etape1.ajouterSuccesseur(etape2);
        etape2.ajouterSuccesseur(guichet);
        guichet.ajouterSuccesseur(act1);

        m.ajouter(etape1, etape2);
        m.ajouter(act1);
        m.ajouter(guichet);

        m.aCommeEntree(etape1);
        m.aCommeSortie(act1);
        try {
            ClassLoaderPerso ClassLoader = new ClassLoaderPerso(ClientTwisk.class.getClassLoader());
            Class<?> simul = ClassLoader.loadClass("twisk.simulation.Simulation");
            Object objSimulation = simul.getDeclaredConstructor().newInstance();
            Method setNbClients = simul.getDeclaredMethod("setNbClients", int.class);
            Method sim = simul.getDeclaredMethod("simuler", Monde.class);
            setNbClients.invoke(objSimulation, 4);
            sim.invoke(objSimulation, m);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("\n************* FIN *************\n\n");

        Monde monde = new Monde();
        Guichet guichett = new Guichet("file", 2);
        Activite act1t = new ActiviteRestreinte("piscine", 2, 1);

        Etape etape1t = new Activite("plage");
        Etape etape2t = new Activite("balance");

        etape1t.ajouterSuccesseur(etape2t);
        etape2t.ajouterSuccesseur(guichett);
        guichett.ajouterSuccesseur(act1t);

        monde.ajouter(etape1t, etape2t);
        monde.ajouter(act1t);
        monde.ajouter(guichett);

        monde.aCommeEntree(etape1t);
        monde.aCommeSortie(act1t);
        try {
            ClassLoaderPerso ClassLoader2 = new ClassLoaderPerso(ClientTwisk.class.getClassLoader());
            Class<?> simul2 = ClassLoader2.loadClass("twisk.simulation.Simulation");
            Object objSimulation2 = simul2.getDeclaredConstructor().newInstance();
            Method setNbClients2 = simul2.getDeclaredMethod("setNbClients", int.class);
            Method sim2 = simul2.getDeclaredMethod("simuler", Monde.class);
            setNbClients2.invoke(objSimulation2, 4);
            sim2.invoke(objSimulation2, monde);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }}

