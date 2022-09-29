package twisk.exceptions;

public class ExceptionGuichet  extends TwiskException{

    /**
     * ecouteur de l'exception de si il existe un arc entre deux guichet
     */

    public ExceptionGuichet() {
        super("Attention !! Vous ne pouvez pas relier deux guichets ");
    }
}

