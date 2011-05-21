/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JFrame;
import java.awt.*;

/**
 *
 * @author David
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Wack-a-Mole");
        frame.setSize(400, 400);
        frame.setLocation(100, 50);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Panel());
        frame.setVisible(true);
		Toolkit toolkit = Toolkit.getDefaultToolkit(); 

		Image image = toolkit.getImage("hammer.png"); 


		Point hotSpot = new Point(0,0); 
		Cursor cursor = toolkit.createCustomCursor(image, hotSpot, "Hammer"); 
		frame.setCursor(cursor);
    }

}
