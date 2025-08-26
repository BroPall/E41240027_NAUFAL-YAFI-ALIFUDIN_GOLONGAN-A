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

import java.util.ArrayList;
import java.util.Random;

public class Game {
    private ArrayList<String> players;
    private String mafia;
    private int totalPlayers = 0;

    public Game() {
        players = new ArrayList<>();
    }

    // Menambahkan pemain ke dalam permainan
    public void addPlayer(String playerName) {
        players.add(playerName);
        totalPlayers++;
    }

    // Mendapatkan jumlah pemain
    public int getPlayersCount() {
        return players.size();
    }

    // Memulai permainan
    public void startGame() {
        selectMafia();
    }

    // Memilih mafia secara acak
    private void selectMafia() {
        Random rand = new Random();
        int mafiaIndex = rand.nextInt(players.size());
        mafia = players.get(mafiaIndex);
    }

    // Memeriksa tebakan pemain
    public boolean checkGuess(String guess) {
        return mafia.equalsIgnoreCase(guess);
    }

    // Mendapatkan nama mafia
    public String getMafia() {
        return mafia;
    }
}
