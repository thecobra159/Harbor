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
    private static String name;
    private static int qtyHarbor, optionLoadDown, optionPerishible;
    private static List<Ship> listShip, newListShip;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        in = new Scanner(System.in);
        listShip = new ArrayList<>();
        System.out.print("Total de navios: ");
        qtyHarbor = in.nextInt();

        for (int i = 0; i < qtyHarbor; i++) {
            Ship ship = new Ship();
            ship.start();

            System.out.print("Nome: ");
            name = in.next();
            ship.setName(name);

            menuLoadDown();
            System.out.print("Fase: ");
            optionLoadDown = in.nextInt();
            if (optionLoadDown == 1) {
                ship.setLoading(true);
            } else {
                ship.setLoading(false);
            }

            menuPershible();
            System.out.print("Tipo: ");
            optionPerishible = in.nextInt();
            if (optionPerishible == 1) {
                ship.setPerishable(true);
            } else {
                ship.setPerishable(false);
            }

            listShip.add(ship);
        }

        newListShip = Singleton.getInstance().isPerishable(listShip);

        newListShip.stream().map((ship) -> {
            return ship;
        }).map((ship) -> {
            if (ship.isPerishable()) {
                System.out.println("Carga perecível!");
            } else {
                System.out.println("Carga não perecível!");
            }
            return ship;
        }).forEachOrdered((ship) -> {
            try {
                if (ship.isLoading()) {
                    if (!ship.goSleep(Constants.SLEEP_LOADING)) {
                        System.out.print("Carregando " + ship.getName());
                        Thread.sleep(1000);
                        System.out.print(" .");
                        Thread.sleep(1000);
                        System.out.print(".");
                        Thread.sleep(1000);
                        System.out.println(".");
                    }
                } else {
                    while (!ship.goSleep(Constants.SLEEP_DOWNLOAD)) {
                        System.out.print("Descarregando " + ship.getName());
                        Thread.sleep(1000);
                        System.out.print(" .");
                        Thread.sleep(1000);
                        System.out.print(".");
                        Thread.sleep(1000);
                        System.out.println(".");
                    }
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });
    }

    public static void menuLoadDown() {
        System.out.println("1 - Carga");
        System.out.println("2 - Descarga");
    }

    public static void menuPershible() {
        System.out.println("1 - Perecível");
        System.out.println("2 - Não Perecível");
    }
}
