package com.finco.framework.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface Controller extends ActionListener {
	@Override
    public void actionPerformed(ActionEvent ae);
	

}
