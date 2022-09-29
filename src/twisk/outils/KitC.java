package twisk.outils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class KitC {
    /**
     * Constructeur de KitC
     */
    private final FabriqueNumero fab = FabriqueNumero.getInstance();
    private final  int cpt = fab.getnumlib();
    public KitC() {

    }

    /**
     * Fonction qui cree l'environnement de twisk dans /tmp
     */
    public void creerEnvironnement(){
        try {
        // création du répertoire twisk sous /tmp. Ne déclenche pas d’erreur si le répertoire existe déjà
            Path directories = Files.createDirectories(Paths.get("/tmp/twisk"));
        // copie des deux fichiers programmeC.o et def.h depuis le projet sous /tmp/twisk
            String[] liste = {"programmeC.o", "def.h" , "codeNatif.o"};
            for (String nom : liste) {
                InputStream source = getClass().getResource("/codeC/" + nom).openStream() ;
                File destination = new File("/tmp/twisk/" + nom) ;
                copier(source, destination);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        }

    /**
     * Fonction qui copie les fichiers programmeC.o, def.h et codeNatif.o sous /tmp/twisk.
     * @param source
     * @param dest
     * @throws IOException
     */
    private void copier(InputStream source, File dest) throws IOException {
        InputStream sourceFile = source;
        OutputStream destinationFile = new FileOutputStream(dest) ;
// Lecture par segment de 0.5Mo
        byte buffer[] = new byte[512 * 1024];
        int nbLecture;
        while ((nbLecture = sourceFile.read(buffer)) != -1){
            destinationFile.write(buffer, 0, nbLecture);
        }
        destinationFile.close();
        sourceFile.close();
    }

    /**
     * Fonction qui cree la classe client.c dans twisk
     * @param codeC
     */
    public void creerFichier(String codeC) {
        try {
            new File("/tmp/twisk/client.c");
            FileWriter flotFiltre = new FileWriter("/tmp/twisk/client.c");
            flotFiltre.write(codeC);
            flotFiltre.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fonction qui compile le code c automatiquement
     */
    public void compiler(){
        try {

            Runtime runtime = Runtime.getRuntime();
            Process p = runtime.exec("gcc -Wall -fPIC -c /tmp/twisk/client.c -o /tmp/twisk/client.o" );
            // récupération des messages sur la sortie standard et la sortie d’erreur de la commande exécutée
            // à reprendre éventuellement et à adapter à votre code
            BufferedReader output = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader error = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            String ligne ;
            while ((ligne = output.readLine()) != null) {
                System.out.println(ligne);
            }
            while ((ligne = error.readLine()) != null) {
                System.out.println(ligne);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fonction qui cree la librairie libTwisk.so
     */
   public void construireLaLibrairie(){
       try {
           Runtime runtime = Runtime.getRuntime();
           Process p = runtime.exec("gcc -shared /tmp/twisk/programmeC.o /tmp/twisk/codeNatif.o /tmp/twisk/client.o -o /tmp/twisk/libTwisk"+cpt+".so");
           p.waitFor();

           // récupération des messages sur la sortie standard et la sortie d’erreur de la commande exécutée
           // à reprendre éventuellement et à adapter à votre code
           BufferedReader output = new BufferedReader(new InputStreamReader(p.getInputStream()));
           BufferedReader error = new BufferedReader(new InputStreamReader(p.getErrorStream()));
           String ligne ;
           while ((ligne = output.readLine()) != null) {
               System.out.println(ligne);
           }
           while ((ligne = error.readLine()) != null) {
               System.out.println(ligne);
           }
       } catch (IOException  | InterruptedException e) {
           e.printStackTrace();
       }
   }
   public int getNumlib(){
       return cpt;
   }
}
