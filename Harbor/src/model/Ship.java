/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author thecobra
 */
public class Ship extends Thread {
    private boolean perishable = false;
    private boolean loading = false;

    public boolean isPerishable() {
        return perishable;
    }

    public void setPerishable(boolean perishable) {
        this.perishable = perishable;
    }

    public boolean isLoading() {
        return loading;
    }

    public void setLoading(boolean loading) {
        this.loading = loading;
    }
    
    /**
     * Method to sleep the ship and return true when it's finished
     * @param millis
     * @return true
     * @throws InterruptedException
     */
    public boolean goSleep(long millis) throws InterruptedException {
        Ship.sleep(millis);
        System.out.println("ACORDOU");
        return true;
    }
}
