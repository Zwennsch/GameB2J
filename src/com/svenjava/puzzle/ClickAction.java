package com.svenjava.puzzle;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ClickAction extends AbstractAction {
	
	List<MyButton> btns;
	List<Point> solution;
	JPanel panel;
	
	
	public ClickAction(List<MyButton> btns, JPanel panel, List<Point> solution) {
		this.btns = btns;
		this.panel = panel;
		this.solution = solution;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		checkButton(e);
		checkSolution();
	}

	private void checkSolution() {
		List<Point> current = new ArrayList<>();
		
		for (JComponent btn : btns) {
			current.add((Point) btn.getClientProperty("position"));
		}
		if (Arrays.deepEquals(current.toArray(), solution.toArray())) {
			JOptionPane.showMessageDialog(panel, "Finished", "Congratulation", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void checkButton(ActionEvent e) {
		int lastIndex = 0;
		
		for (MyButton btn : btns) {
			if(btn.isLastButton()) {
				lastIndex = btns.indexOf(btn);
			}
		}
		
		JButton button = (JButton) e.getSource();
		int bIndex = btns.indexOf(button);
		
		if(bIndex +1 == lastIndex || bIndex -1 == lastIndex || bIndex +3 == lastIndex || bIndex -3 == lastIndex) {
			Collections.swap(btns, lastIndex, bIndex);
			updateButtons();
		}
		
	}

	private void updateButtons() {
		panel.removeAll();
		for(JButton button : btns) {
			panel.add(button);
		}
		panel.validate();
	}

}
