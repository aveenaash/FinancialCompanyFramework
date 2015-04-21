/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.finco.controller;

import java.awt.event.ActionEvent;

/**
 *
 * @author abinash
 */
public class ExitController implements Controller {

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.exit(0);
    }

}
