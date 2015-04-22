/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.model;

import com.finco.framework.model.Mediator;

/**
 *
 * @author MdRuzdi
 */
public class MyMediator extends Mediator{
    
    private static MyMediator instance;
    
    public static MyMediator getInstance() {
        if (instance == null) {
            instance = new MyMediator();
        }
        return instance;
    }
}
