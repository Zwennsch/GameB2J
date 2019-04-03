package com.svenjava.puzzle;

import java.awt.event.ActionEvent;
import java.util.Collections;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ClickAction extends AbstractAction {
	
	List<MyButton> btns;
	JPanel panel;
	
	public ClickAction(List<MyButton> btns, JPanel panel) {
		this.btns = btns;
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		checkButton(e);
		System.out.println("clicked");
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
