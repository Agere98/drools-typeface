package pl.put.poznan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class ResultPanel implements ActionListener {

	private JFrame parent;
	private JPanel panel;

	public ResultPanel(JFrame parent, String result) {
		this.parent = parent;
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JLabel resultLabel = new JLabel("Perfect typeface for you is " + result + ".");
		panel.add(resultLabel);

		JButton okButton = new JButton("OK");
		okButton.setActionCommand("ok");
		okButton.addActionListener(this);
		panel.add(okButton);
	}

	public void show() {
		parent.setContentPane(panel);
		parent.validate();
		parent.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (action == "ok") {
			parent.dispatchEvent(new WindowEvent(parent, WindowEvent.WINDOW_CLOSING));
		}
	}
}