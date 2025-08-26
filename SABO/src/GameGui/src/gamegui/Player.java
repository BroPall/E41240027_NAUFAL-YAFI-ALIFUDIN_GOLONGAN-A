/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamegui;

/**
 *
 * @author Arvita Agus K
 */
public class Player {
    private String name;
    private String role; // "Mafia" atau "Non-Mafia"
    private boolean isAlive;

    public Player(String name, String role) {
        this.name = name;
        this.role = role;
        this.isAlive = true;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void kill() {
        isAlive = false;
        System.out.println(name + " has been killed!");
    }

    void displayInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void attack() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

