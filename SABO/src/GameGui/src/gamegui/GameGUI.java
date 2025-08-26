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
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.text.Text;

public class GameGUI extends Application {

    private Game mafiaGame;
    private Label statusLabel;
    private Button startButton;
    private Button guessButton;
    private TextArea gameLog;
    private TextField playerNameField;
    private TextField guessField;
    private int attempts = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        mafiaGame = new Game(); // Inisialisasi game

        // Layout untuk GUI
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new javafx.geometry.Insets(20));

        // Label Status
        statusLabel = new Label("Masukkan nama pemain.");
        statusLabel.setStyle("-fx-font-size: 16px;");

        // Game Log (Menampilkan tindakan)
        gameLog = new TextArea();
        gameLog.setEditable(false);
        gameLog.setPrefHeight(200);
        gameLog.setWrapText(true);

        // Input nama pemain
        playerNameField = new TextField();
        playerNameField.setPromptText("Masukkan nama pemain");

        // Tombol untuk menambahkan pemain
        Button addPlayerButton = new Button("Tambah Pemain");
        addPlayerButton.setOnAction(e -> addPlayer());

        // Tombol untuk memulai permainan
        startButton = new Button("Mulai Permainan");
        startButton.setOnAction(e -> startGame());
        startButton.setDisable(true); // Disable until players are added

        // Input untuk menebak Mafia
        guessField = new TextField();
        guessField.setPromptText("Tebak nama Mafia");

        // Tombol untuk menebak Mafia
        guessButton = new Button("Tebak");
        guessButton.setDisable(true); // Disable until game starts
        guessButton.setOnAction(e -> guessMafia());

        // Menambahkan komponen ke layout
        root.getChildren().addAll(statusLabel, playerNameField, addPlayerButton, gameLog, startButton, guessField, guessButton);

        // Scene dan Stage
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Game Mafia");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Menambahkan pemain
    private void addPlayer() {
        String playerName = playerNameField.getText();

        if (playerName != null && !playerName.isEmpty()) {
            if (mafiaGame.getPlayersCount() < 4) {
                mafiaGame.addPlayer(playerName);

                // Menambahkan log dan membersihkan input
                gameLog.appendText(playerName + " telah ditambahkan.\n");
                playerNameField.clear();

                // Jika sudah ada 4 pemain, aktifkan tombol mulai permainan
                if (mafiaGame.getPlayersCount() == 4) {
                    startButton.setDisable(false);
                }
            } else {
                gameLog.appendText("Jumlah pemain sudah mencapai 4. Tidak bisa menambah pemain lagi.\n");
            }
        } else {
            gameLog.appendText("Tolong masukkan nama pemain.\n");
        }
    }

    // Mulai permainan
    private void startGame() {
        mafiaGame.startGame();
        updateStatus("Permainan dimulai! Tebak siapa Mafia.");
        startButton.setDisable(true); // Disable start button after the game starts
        guessButton.setDisable(false); // Enable guess button
    }

    // Menebak Mafia
    private void guessMafia() {
        String guess = guessField.getText();

        if (guess != null && !guess.isEmpty()) {
            if (mafiaGame.checkGuess(guess)) {
                updateStatus("Selamat, Anda berhasil menangkap Mafia!");
                gameLog.appendText("Tebakan Anda benar! Mafia adalah " + guess + ".\n");
                guessButton.setDisable(true); // Disable guess button after correct guess
            } else {
                attempts++;
                if (attempts >= 2) {
                    updateStatus("Anda kalah! Kesempatan Anda habis.");
                    gameLog.appendText("Tebakan Anda salah! Anda telah kehabisan kesempatan.\n");
                    guessButton.setDisable(true); // Disable guess button after losing
                } else {
                    updateStatus("Tebakan salah! Coba lagi.");
                    gameLog.appendText("Tebakan Anda salah. Kesempatan tersisa: " + (2 - attempts) + "\n");
                }
            }
            guessField.clear();
        }
    }

    // Update status permainan
    private void updateStatus(String message) {
        statusLabel.setText(message);
    }
}
