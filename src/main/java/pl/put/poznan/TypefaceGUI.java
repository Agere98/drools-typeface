package pl.put.poznan;

import javax.swing.*;

public class TypefaceGUI {
	
	private static JFrame frame;
	
	private static void createAndShowGUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
	
	public static void startGUI() {
        frame = new JFrame("So you need a typeface");
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
	
	public static JFrame getFrame() {
		return frame;
	}
}
