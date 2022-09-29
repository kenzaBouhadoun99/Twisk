package twisk.exceptions;

public class ExceptionsArcMemeEtape extends TwiskException {
    /**
     * ecouteur des arc de la meme etape
     *
     */
    public ExceptionsArcMemeEtape(){
        super("Impossible de crée un arc entre deux points de la meme étape ou avec le meme point");
    }
}
