package com.finco.framework.view;

import java.awt.event.ActionEvent;

import com.finco.framework.controller.Controller;

public class ExitController implements Controller {

	@Override
	public void actionPerformed(ActionEvent ae) {
		System.exit(0);
		
	}

}
