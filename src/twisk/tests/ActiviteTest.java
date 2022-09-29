package twisk.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import twisk.monde.Activite;

import static org.junit.jupiter.api.Assertions.*;

class ActiviteTest {
    Activite act ;
    @BeforeEach
    void setUp() {
        act= new Activite("activite");
    }

    @Test
    void estUneActivite() {
        act.estUneActivite();
    }

    @Test
    void getTemps() {
        act.getTemps();
    }

    @Test
    void getEcartTemps() {
        act.getEcartTemps();
    }

    @Test
    void estUnGuichet() {
        act.estUnGuichet();
    }

}