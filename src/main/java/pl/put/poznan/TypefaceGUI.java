package pl.put.poznan;

import javax.swing.*;

import org.kie.api.runtime.KieSession;

public class TypefaceGUI {
	
	private static JFrame frame;
	private static KieSession session;
	
	private static void createAndShowGUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(688, 400);
        frame.setResizable(false);
        
        StartPanel panel = new StartPanel(frame);
        panel.show();
        
        frame.setVisible(true);
    }
	
	public static void startGUI(KieSession session) {
        frame = new JFrame("So you need a typeface");
        TypefaceGUI.session = session;
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
	
	public static JFrame getFrame() {
		return frame;
	}
	
	public static KieSession getSession() {
		return session;
	}
}
