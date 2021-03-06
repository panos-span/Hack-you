package game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * <p>Αντικείμενο coin στο παιχνίδι.</p>
 *
 * @author Team Hack-You
 * @version 1.0
 * @see SuperObject
 */
public class OBJ_Coin extends SuperObject {

    private int spriteCounter = 0;
    private int spriteNum = 1;

    /**
     * <p>Constructor for OBJ_Coin.</p>
     */
    public OBJ_Coin() {
        super("Coin", false);
    }

    /**
     * <p>playSE.</p>
     */
    public void playSE() {
        se.setFile(2);
        se.play();
    }

    /** {@inheritDoc} */
    @Override
    public void draw(Graphics2D g2, GamePanel gp) {
        BufferedImage image = Entity.coin[spriteNum - 1];
        super.setValues(g2, gp, image);
        spriteCounter++;
        if (spriteCounter > 7) {
            if (spriteNum < 9) {
                spriteNum++;
            } else {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }

    }

}
