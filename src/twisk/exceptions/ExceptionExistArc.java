package twisk.exceptions;

public class ExceptionExistArc extends TwiskException {
    /**
     * ecouteur des arc existant
     */
    public ExceptionExistArc(){
        super("Impossible de crée cet arc ,il existe déjà");
    }
}
