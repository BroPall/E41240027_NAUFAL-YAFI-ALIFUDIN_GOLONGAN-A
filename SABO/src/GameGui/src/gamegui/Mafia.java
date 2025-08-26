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
public class Mafia extends Player {
    public Mafia(String name) {
        super(name, "Mafia");
    }

    public void kill(Player player) {
        if (player.isAlive()) {
            player.kill();
        } else {
            System.out.println(player.getName() + " is already dead.");
        }
    }
}

