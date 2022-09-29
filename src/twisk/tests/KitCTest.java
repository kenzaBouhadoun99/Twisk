package twisk.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import twisk.outils.KitC;

import static org.junit.jupiter.api.Assertions.*;

class KitCTest {
    KitC kit ;
    @BeforeEach
    void setUp() {
        kit = new KitC();
    }

    @Test
    public void TestcreerEnvironnement() {
        kit.creerEnvironnement();

    }

    @Test
    public void TestcreerFichier() {
        kit.creerFichier("codeC");
    }

    @Test
    public void Testcompiler() {
        kit.compiler();
    }

    @Test
   public  void TestconstruireLaLibrairie() {
        kit.construireLaLibrairie();
    }
}