/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hartakarungame;

/**
 *
 * @author Arvita Agus K
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HartaKarunGame {

    private JFrame frame;
    private JPanel panel;
    private JTextArea questionArea;
    private JButton[] answerButtons;
    private JLabel scoreLabel;
    private int currentStage;
    private int score;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                HartaKarunGame window = new HartaKarunGame();
                window.frame.setVisible(true); // Make sure the frame is visible after initialization
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public HartaKarunGame() {
        currentStage = 1;
        score = 0; // Initial score
        initialize();
    }

    private void initialize() {
        // Initialize Frame
        frame = new JFrame("Game Harta Karun");
        frame.setBounds(100, 100, 800, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));
        
        questionArea = new JTextArea();
        questionArea.setEditable(false);
        questionArea.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(questionArea, BorderLayout.CENTER);
        
        // Panel for answer buttons
        JPanel buttonPanel = new JPanel();
        panel.add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.setLayout(new GridLayout(2, 2));
        
        // Initialize answer buttons
        answerButtons = new JButton[4];
        for (int i = 0; i < 4; i++) {
            answerButtons[i] = new JButton("Jawaban " + (i + 1));
            answerButtons[i].addActionListener(new AnswerButtonListener());
            buttonPanel.add(answerButtons[i]);
        }

        // Panel to display score
        JPanel topPanel = new JPanel();
        panel.add(topPanel, BorderLayout.NORTH);
        topPanel.setLayout(new FlowLayout());

        scoreLabel = new JLabel("Skor: " + score);  // Label for score
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        topPanel.add(scoreLabel);

        loadQuestion();
    }

    private void loadQuestion() {
        // Question loading logic based on the current stage
        switch (currentStage) {
            case 1:
                questionArea.setText("Tahap 1: Library mana yang digunakan untuk bekerja dengan koleksi data di Java?");
                answerButtons[0].setText("java.util");
                answerButtons[1].setText("java.lang");
                answerButtons[2].setText("java.io");
                answerButtons[3].setText("javax.swing");
                break;
            case 2:
                questionArea.setText("Tahap 2: Library eksternal apa yang digunakan untuk menghubungkan aplikasi Java dengan database MySQL?");
                answerButtons[0].setText("mysql-connector-java");
                answerButtons[1].setText("java.util");
                answerButtons[2].setText("javax.swing");
                answerButtons[3].setText("java.lang");
                break;
            case 3:
                questionArea.setText("Tahap 3: Apa nama library bawaan yang digunakan untuk manipulasi string di Java?");
                answerButtons[0].setText("java.util");
                answerButtons[1].setText("java.lang");
                answerButtons[2].setText("java.io");
                answerButtons[3].setText("javax.swing");
                break;
            default:
                // When game is over, show final score
                if (score < 0) {
                    questionArea.setText("Anda Gagal mendapatkan Harta Karun! Skor akhir: " + score);
                } else {
                    questionArea.setText("Selamat! Anda telah menemukan harta karun! Skor akhir: " + score);
                }
                for (JButton btn : answerButtons) {
                    btn.setEnabled(false);  // Disable buttons after game ends
                }
                break;
        }
    }

    private class AnswerButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            boolean correct = false;
            
            // Check answer and modify score accordingly
            switch (currentStage) {
                case 1:
                    correct = source.getText().equals("java.util");
                    break;
                case 2:
                    correct = source.getText().equals("mysql-connector-java");
                    break;
                case 3:
                    correct = source.getText().equals("java.lang");
                    break;
            }

            if (correct) {
                score += 10; // Correct answer, add 10 points
            } else {
                score -= 10; // Incorrect answer, subtract 10 points
            }

            // Update score label
            scoreLabel.setText("Skor: " + score);

            // Proceed to next question regardless of the answer
            currentStage++;
            if (currentStage > 3) {
                loadQuestion(); // Game ends, show final score
            } else {
                loadQuestion(); // Load next question
            }
        }
    }
}