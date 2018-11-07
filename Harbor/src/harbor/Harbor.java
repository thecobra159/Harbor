/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harbor;

import controller.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Ship;
import util.Constants;

/**
 *
 * @author thecobra
 */
public class Harbor {

    private static Scanner in;
    private static int qtyHarbor, optionLoadDown, optionPerishible;
    private static List<Ship> listShip, newListShip;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        listShip = new ArrayList<Ship>();
        System.out.println("Total de navios: ");
        qtyHarbor = in.nextInt();

        for (int i = 0; i < qtyHarbor; i++) {
            Ship ship = new Ship();

            menuLoadDown();
            optionLoadDown = in.nextInt();
            if (optionLoadDown == 1) {
                ship.setLoading(true);
            } else {
                ship.setLoading(false);
            }

            menuPershible();
            optionPerishible = in.nextInt();
            if (optionPerishible == 1) {
                ship.setPerishable(true);
            } else {
                ship.setPerishable(false);
            }

            listShip.add(ship);
        }

        newListShip = Singleton.getInstance().isPerishable(listShip);

        for (Ship ship : newListShip) {
            ship.start();
            if (ship.isPerishable()) {
                System.out.println("Carga perecível!");
            } else {
                System.out.println("Carga não perecível!");
            }
            if (ship.isLoading()) {
                while (ship.sleep(Constants.SLEEP_LOADING)) {                   //fix this
                    System.out.println("Carregando");
                    System.out.print(" .");
                    System.out.print(".");
                    System.out.print(".");
                }
            } else {
                while (ship.sleep(Constants.SLEEP_DOWNLOAD)) {                  //fix this
                    System.out.println("Descarregando");
                    System.out.print(" .");
                    System.out.print(".");
                    System.out.print(".");
                }
            }
        }
    }

    public static void menuLoadDown() {
        System.out.println("1 - Carga");
        System.out.println("2 - Descarga");
    }

    public static void menuPershible() {
        System.out.println("1 - Perecível");
        System.out.println("1 - Não Perecível");
    }
}
