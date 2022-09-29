package twisk.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import twisk.monde.Activite;
import twisk.monde.GestionnaireEtapes;

import static org.junit.jupiter.api.Assertions.*;

class GestionnaireEtapesTest {
    GestionnaireEtapes gest1;
    GestionnaireEtapes gest2;
    GestionnaireEtapes gest3;
    GestionnaireEtapes gest4;
    @BeforeEach
    void setUp() {
        gest1 = new GestionnaireEtapes();
        gest2 = new GestionnaireEtapes();
        gest3 = new GestionnaireEtapes();
        gest4 = new GestionnaireEtapes();
        gest2.ajouter(new Activite(("etape ajoutée")), new Activite(("etape ajoutée")));
        gest3.ajouter(new Activite("etape ajoutée"), new Activite("etape ajoutée"), new Activite("etape ajoutée"));
        gest4.ajouter(new Activite("etape ajoutée"), new Activite("etape ajoutée"), new Activite("etape ajoutée"), new Activite("etape ajoutée"));
    }
        @Test
        void ajouter(){
            gest1.ajouter(new Activite("une etape"),new Activite("une etape"));
            assertEquals(gest1.nbEtapes(),2);
            gest2.ajouter(new Activite("une etape"));
            assertEquals(gest2.nbEtapes(), 3);
            gest3.ajouter(new Activite("une etape"));
            assertEquals(gest3.nbEtapes(), 4);
            gest4.ajouter(new Activite("une etape"),new Activite("une etape"));
            assertEquals(gest4.nbEtapes(),6);
        }

        @Test
        void nbEtapes() {
            assertEquals(gest1.nbEtapes(), 0);
            assertEquals(gest2.nbEtapes(), 2);
            assertEquals(gest3.nbEtapes(), 3);
            assertEquals(gest4.nbEtapes(),4);
        }
}