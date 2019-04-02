package com.svenjava.puzzle;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.AbstractAction;

public class ClickAction extends AbstractAction {
	
	List<MyButton> btns;
	
	public ClickAction(List<MyButton> btns) {
		this.btns = btns;
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
		
	}

}
