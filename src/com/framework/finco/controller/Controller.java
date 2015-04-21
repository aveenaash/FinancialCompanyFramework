/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.finco.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author abinash
 */
public interface Controller extends ActionListener {

    @Override
    public void actionPerformed(ActionEvent ae);

}
