package twisk.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import twisk.monde.*;
import twisk.monde.Monde;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MondeTest {
    Monde monde;
    SasEntree entree ;
    SasSortie sortie;
    Etape file_tob;
    Etape file_balancoire;
    Etape file_wc;
    Etape toboggan;
    Etape Balancoir;
    Etape plage;
    Etape toillete;

    @BeforeEach
    void setUp() {
        monde = new Monde();
        entree = new SasEntree();
        sortie = new SasSortie();
        file_tob = new Guichet("File tob",3);
        file_balancoire =new Guichet("File bal",2);
        file_wc=new Guichet("File wc",5);
        toboggan =new Activite("tobogan");
        Balancoir=new Activite("Balancoir");
        plage=new Activite("Plage");
        toillete=new Activite("Toillete");

    }


    @Test
    void ajouter() {
        monde.ajouter(entree);
        monde.ajouter(sortie);
        monde.ajouter(file_balancoire,Balancoir,toillete);
        assertEquals(5,monde.nbEtapes());
    }

    @Test
    void nbEtapes() {
        monde.nbEtapes();
        monde.ajouter(toboggan);
        monde.nbEtapes();
        assert(monde.nbEtapes() !=2):"bug dans le nombre d'etapes";
    }

    @Test
    void nbGuichet() {
        monde.ajouter(file_wc);
        assert(monde.nbGuichet() !=2 ):"bug dans le nombre de guichet";
        monde.ajouter(plage);
        monde.ajouter(file_tob);
        assert(monde.nbGuichet() !=3 ):"bug dans le nombre de guichet";

    }


  /*  @Test
=======
    @Test
>>>>>>> main
    void iterator() {
        Iterator<Etape> iterart = monde.iterator();
        iterart.next();
        Etape etape1 = iterart.next();
        assertEquals(etape1,entree);
        Etape etape2 = iterart.next();
        assertEquals(etape2,file_balancoire);
        Etape etape3 = iterart.next();
        assertEquals(etape3,file_tob);
        Etape etape4 = iterart.next();
        assertEquals(etape4,toboggan);
        Etape etape5 = iterart.next();
        assertEquals(etape5,Balancoir);
        Etape etape6 = iterart.next();
        assertEquals(etape6,plage);
        Etape etape7 = iterart.next();
        assertEquals(etape7,file_wc);
        Etape etape8 = iterart.next();
        assertEquals(etape8,toillete);
        Etape etape9 = iterart.next();
        assertEquals(etape9,sortie);
<<<<<<< HEAD
    }*/





}
