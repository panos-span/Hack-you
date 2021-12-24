package game;

import java.awt.*;
import java.awt.image.BufferedImage;
/**
 * Αντικείμενο spikes στο παιχνίδι το οποίο απενεργοποιείται με το trigger μιας ερώτησης
 *
 * @author Team Hack-You
 * @version 1.0
 */
public class OBJ_Spikes extends SuperObject {
    private int spriteNum = 2;
    //Η θέση της συσχετιζόμενης ερώτησης στον πίνακα obj του gamepanel
    private final int question_index;

    /**
     * <p>Constructor for OBJ_Spikes.</p>
     *
     * @param question_index a int
     */
    public OBJ_Spikes(int question_index) {
        super();
        name = "Spikes";
        this.question_index = question_index;
    }

    /** {@inheritDoc} */
    @Override
    public void playSE() {}

    /** {@inheritDoc} */
    @Override
    public void draw(Graphics2D g2, GamePanel gp) {
        BufferedImage image = Entity.spikes[spriteNum - 1];
        collision = spriteNum == 2;
        super.setValues(g2, gp, image);
        //OBJ_Question question = (OBJ_Question) gp.obj.get(question_index);
        //Απενεργοποίηση του spike μετά το trigger της ερώτησης
        if (gp.obj.get(question_index) == null)
            spriteNum = 1;
    }

}