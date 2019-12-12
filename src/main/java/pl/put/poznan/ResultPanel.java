package pl.put.poznan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ResultPanel extends PanelBase implements ActionListener {

	public ResultPanel(JFrame parent, String result) {
		super(parent);

		JLabel resultLabel = new JLabel("Perfect typeface for you is " + result + ".");
		panel.add(resultLabel);

		JButton okButton = new JButton("OK");
		okButton.setActionCommand("ok");
		okButton.addActionListener(this);
		panel.add(okButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (action == "ok") {
			close();
		}
	}
}