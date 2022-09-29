package twisk.mondeIG;


public class PointDeControleIG {
    private EtapeIG et;
    private int posX;
    private int posY;
    private String identifiant;

    /**
     * Constructeur de Point de controles
     * @param etape
     * @param posX
     * @param posY
     * @param idf
     */
    public PointDeControleIG(EtapeIG etape, int posX, int  posY, String idf){
         this.et=etape;
         this.posX=posX;
         this.posY=posY;
         this.identifiant=idf;
    }

    /**
     * Getter des etapes
     * @return
     */
     public EtapeIG getetape(){
        return et;
     }

    /**
     * Getter des position x
     * @return
     */
     public int getPosX() {
        return posX;
    }
    /**
     * Getter des position y
     * @return
     */
    public int getPosY() {
        return posY;
    }
}