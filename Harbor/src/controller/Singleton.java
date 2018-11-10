/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Ship;
import util.Constants;

/**
 *
 * @author thecobra
 */
public class Singleton {

    private static Singleton INSTANCE = null;

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }

    public List<Ship> isPerishable(List<Ship> listShip) {
        List<Ship> returnListShip = new ArrayList<>();
        for (Ship ship : listShip) {
            if (ship.isPerishable()) {
                ship.setPriority(Constants.ISPERISHABLE);
                returnListShip.set(0, ship);
            } else {
                ship.setPriority(Constants.NOTPERISHABLE);
                returnListShip.add(ship);
            }
        }
        return returnListShip;
    }
}
