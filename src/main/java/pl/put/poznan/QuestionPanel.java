package pl.put.poznan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import pl.put.poznan.Main.Question;

public class QuestionPanel implements ActionListener {

	private JFrame parent;
	private JPanel panel;
	private JButton nextButton;
	private String answer;

	public QuestionPanel(JFrame parent, Question question) {
		this.parent = parent;
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JLabel questionLabel = new JLabel(question.content);
		panel.add(questionLabel);

		ButtonGroup buttons = new ButtonGroup();
		for (String answer : question.possibleAnswers) {
			JRadioButton button = new JRadioButton(answer);
			button.setActionCommand(answer);
			button.addActionListener(this);
			panel.add(button);
			buttons.add(button);
		}

		nextButton = new JButton("Next");
		nextButton.setActionCommand("_next_");
		nextButton.addActionListener(this);
		nextButton.setEnabled(false);
		panel.add(nextButton);
	}

	public void show() {
		parent.setContentPane(panel);
		parent.validate();
		parent.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (action == "_next_") {
			System.out.println(answer);
		}
		else {
			answer = action;
			nextButton.setEnabled(true);
		}
	}
}