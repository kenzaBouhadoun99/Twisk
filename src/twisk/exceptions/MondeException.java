package twisk.exceptions;

public class MondeException extends TwiskException {
    /**
     * ecouteur de l'exception de la simulation ou le monde dois avoir au moin une entree et une sortie
     */
    public MondeException() {
        super("Attention !! votre monde doit avoir au moin une sortie , une entrée et une Activité . ");
    }
}
