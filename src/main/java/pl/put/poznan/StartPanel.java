package pl.put.poznan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class StartPanel extends PanelBase implements ActionListener {

	public StartPanel(JFrame parent) {
		super(parent);

		BufferedImage image;
		try {
			image = ImageIO.read(new File("src/main/resources/start.jpg"));
			ImageIcon imageIcon = new ImageIcon(image);
			JLabel imgLabel = new JLabel(imageIcon);
			panel.add(imgLabel);
		} catch (IOException e) {
			System.out.println("Image not found.");
		}

		JButton startButton = new JButton("Start");
		startButton.setActionCommand("start");
		startButton.addActionListener(this);
		panel.add(startButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (action == "start") {
			TypefaceGUI.getSession().fireAllRules();
		}
	}
}
