package prac7;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author sifiso
 */
public class Prac7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Prac7Gui prac = new Prac7Gui();
        prac.pack();
        prac.setSize(800, 400);
        prac.setVisible(true);
        prac.setDefaultCloseOperation(EXIT_ON_CLOSE);
        prac.setGui();
    }

}
