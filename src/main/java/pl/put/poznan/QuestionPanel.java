package pl.put.poznan;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import pl.put.poznan.Main.Question;
import pl.put.poznan.Main.Answer;

public class QuestionPanel implements ActionListener {

	private JFrame parent;
	private JPanel panel;
	private JButton nextButton;
	private Question question;
	private String answer;

	public QuestionPanel(JFrame parent, Question question) {
		this.question = question;
		this.parent = parent;
		panel = new JPanel();
        GroupLayout groupLayout = new GroupLayout(panel);
		panel.setLayout(groupLayout);
		groupLayout.setAutoCreateGaps(true);
		groupLayout.setAutoCreateContainerGaps(true);
        GroupLayout.ParallelGroup parallel = groupLayout.createParallelGroup();
		GroupLayout.SequentialGroup sequential = groupLayout.createSequentialGroup();
        groupLayout.setHorizontalGroup(parallel);
		groupLayout.setVerticalGroup(sequential);


		JLabel questionLabel = new JLabel(question.content);
		parallel.addComponent(questionLabel);
		sequential.addComponent(questionLabel);
//		panel.add(questionLabel);

		ButtonGroup buttons = new ButtonGroup();
		for (String answer : question.possibleAnswers) {
			JRadioButton button = new JRadioButton(answer);
			button.setActionCommand(answer);
			button.addActionListener(this);
			parallel.addGroup(groupLayout.createSequentialGroup().addComponent(button));
//			panel.add(button);
			parallel.addComponent(button);
			sequential.addComponent(button);
			buttons.add(button);
		}

		nextButton = new JButton("Next");
		nextButton.setActionCommand("_next_");
		nextButton.addActionListener(this);
		nextButton.setEnabled(false);
		parallel.addComponent(nextButton);
		sequential.addComponent(nextButton);
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
			TypefaceGUI.getSession().insert(new Answer(question.getSubject(), answer));
			TypefaceGUI.getSession().fireAllRules();
		}
		else {
			answer = action;
			nextButton.setEnabled(true);
		}
	}
}