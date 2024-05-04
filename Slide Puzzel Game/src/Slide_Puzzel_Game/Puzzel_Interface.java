/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Slide_Puzzel_Game;

import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author General
 */
public class Puzzel_Interface extends javax.swing.JFrame {

    private CountDownTime countDownTimer;
    private Clip clip;
    private boolean isMuted = false;
    private static final int GRID_SIZE = 4; 
    private String playerName;
    private JButton[][] tiles;
    
    //-----------------------------------------------------------------------
    //----------------------------------------------------------------------
    
    private HashMap<String, Integer> scores = new HashMap<>(); // Store scores with player names
    private final String SCORES_FILE = "scores.txt"; // File to save scores
    
    //-----------------------------------------------------------------------
    
     private void recordScore(String playerName, int score) {
        scores.put(playerName, score); // Record the player's score
        saveScoresToFile(); // Save the scores to a file
    }
    //------------------------------------------------------------------------
      private void saveScoresToFile() {
        try {
            FileWriter fw = new FileWriter(SCORES_FILE);
            BufferedWriter bw = new BufferedWriter(fw);
            for (String player : scores.keySet()) {
                int score = scores.get(player);
                bw.write(player + "," + score); // Write player name and score to file
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
      
    //-----------------------------------------------------------------------
    
    private int getHighestScore() {
    int highestScore = Integer.MIN_VALUE; // Initialize with the smallest possible integer value
    
    try (Scanner scanner = new Scanner(new File(SCORES_FILE))) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            if (parts.length == 2) {
                int score = Integer.parseInt(parts[1]);
                highestScore = Math.max(highestScore, score); // Update highest score if current score is higher
            }
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    
        return highestScore;
    }

    private void displayHighestScore() {
        int highestScore = getHighestScore();
        HightsScore.setText(String.valueOf(highestScore));
    }

    
    //------------------------------------------------------------------------
    private void playBackgroundMusic() {
        try {
            File audioFile = new File("background_music.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            
            clip = AudioSystem.getClip();
            
            clip.open(audioStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //------------------------------------------------------------------------
    
    private void playClickSound() {
    try {
        File audioFile = new File("click_sound.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

        Clip clickClip = AudioSystem.getClip();

        clickClip.open(audioStream);
        clickClip.start();

    } catch (Exception ex) {
        ex.printStackTrace();
    }
    }


    //-------------------------------------------------------------------------
    public Puzzel_Interface() {
        initComponents();
        initializeTiles();
        playClickSound();
        playBackgroundMusic();
        new CountDownTime().startTimer();
        countDownTimer = new CountDownTime();
        Shuffle();   
    }
    //--------------------------------------------------------------------------
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        No1 = new javax.swing.JButton();
        No2 = new javax.swing.JButton();
        No3 = new javax.swing.JButton();
        No5 = new javax.swing.JButton();
        No4 = new javax.swing.JButton();
        No9 = new javax.swing.JButton();
        No12 = new javax.swing.JButton();
        No11 = new javax.swing.JButton();
        No10 = new javax.swing.JButton();
        No15 = new javax.swing.JButton();
        No14 = new javax.swing.JButton();
        No13 = new javax.swing.JButton();
        No6 = new javax.swing.JButton();
        No7 = new javax.swing.JButton();
        No8 = new javax.swing.JButton();
        EmptyBox = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        CountDownTimer = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Btn_Exit = new javax.swing.JButton();
        Btn_Mute = new javax.swing.JButton();
        Btn_Reset = new javax.swing.JButton();
        Btn_NewGame = new javax.swing.JButton();
        Btn_Solution = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        NumOfClicks_Counte = new javax.swing.JLabel();
        HightsScore = new javax.swing.JLabel();
        Btn_Hint = new javax.swing.JButton();
        BtnAutoSlove = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 2));

        jLabel2.setFont(new java.awt.Font("Sitka Small", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SLIDE PUZZLE ......");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 246, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(33, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(13, 13, 13)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 2));

        No1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        No1.setText("1");
        No1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                No1ActionPerformed(evt);
            }
        });

        No2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        No2.setText("2");
        No2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                No2ActionPerformed(evt);
            }
        });

        No3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        No3.setText("3");
        No3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                No3ActionPerformed(evt);
            }
        });

        No5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        No5.setText("5");
        No5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                No5ActionPerformed(evt);
            }
        });

        No4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        No4.setText("4");
        No4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                No4ActionPerformed(evt);
            }
        });

        No9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        No9.setText("9");
        No9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                No9ActionPerformed(evt);
            }
        });

        No12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        No12.setText("12");
        No12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                No12ActionPerformed(evt);
            }
        });

        No11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        No11.setText("11");
        No11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                No11ActionPerformed(evt);
            }
        });

        No10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        No10.setText("10");
        No10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                No10ActionPerformed(evt);
            }
        });

        No15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        No15.setText("15");
        No15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                No15ActionPerformed(evt);
            }
        });

        No14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        No14.setText("14");
        No14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                No14ActionPerformed(evt);
            }
        });

        No13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        No13.setText("13");
        No13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                No13ActionPerformed(evt);
            }
        });

        No6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        No6.setText("6");
        No6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                No6ActionPerformed(evt);
            }
        });

        No7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        No7.setText("7");
        No7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                No7ActionPerformed(evt);
            }
        });

        No8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        No8.setText("8");
        No8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                No8ActionPerformed(evt);
            }
        });

        EmptyBox.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        EmptyBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmptyBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(No9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(No8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(No1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(No2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(No7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(No10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(EmptyBox, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(No15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(No3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(No6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(No4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(No5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(No11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(No12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(No14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(No13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(No1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(No2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(No3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(No4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(No8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(No7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(No6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(No5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(No10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(No9, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(No11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(No12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(No13, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(No14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(No15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EmptyBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 2));

        CountDownTimer.setBackground(new java.awt.Color(204, 0, 0));
        CountDownTimer.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        CountDownTimer.setForeground(new java.awt.Color(204, 0, 0));
        CountDownTimer.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CountDownTimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Slide_Puzzel_Game/time (1).png"))); // NOI18N
        CountDownTimer.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("No of moves:");

        Btn_Exit.setBackground(new java.awt.Color(255, 0, 153));
        Btn_Exit.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        Btn_Exit.setForeground(new java.awt.Color(204, 0, 0));
        Btn_Exit.setText("Exit");
        Btn_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ExitActionPerformed(evt);
            }
        });

        Btn_Mute.setBackground(new java.awt.Color(255, 255, 255));
        Btn_Mute.setFont(new java.awt.Font("Sitka Banner", 0, 18)); // NOI18N
        Btn_Mute.setForeground(new java.awt.Color(204, 0, 204));
        Btn_Mute.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Slide_Puzzel_Game/mute (3).png"))); // NOI18N
        Btn_Mute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_MuteActionPerformed(evt);
            }
        });

        Btn_Reset.setBackground(new java.awt.Color(102, 0, 102));
        Btn_Reset.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        Btn_Reset.setForeground(new java.awt.Color(0, 204, 204));
        Btn_Reset.setText("Reset");
        Btn_Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ResetActionPerformed(evt);
            }
        });

        Btn_NewGame.setBackground(new java.awt.Color(0, 0, 255));
        Btn_NewGame.setFont(new java.awt.Font("Sitka Banner", 0, 18)); // NOI18N
        Btn_NewGame.setForeground(new java.awt.Color(204, 0, 204));
        Btn_NewGame.setText("New game");
        Btn_NewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_NewGameActionPerformed(evt);
            }
        });

        Btn_Solution.setBackground(new java.awt.Color(0, 0, 255));
        Btn_Solution.setFont(new java.awt.Font("Sitka Banner", 0, 18)); // NOI18N
        Btn_Solution.setForeground(new java.awt.Color(204, 0, 204));
        Btn_Solution.setText("Solution");
        Btn_Solution.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_SolutionActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Count Down:");

        NumOfClicks_Counte.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        NumOfClicks_Counte.setForeground(new java.awt.Color(204, 0, 0));
        NumOfClicks_Counte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Slide_Puzzel_Game/process (1).png"))); // NOI18N

        HightsScore.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HightsScore.setForeground(new java.awt.Color(255, 0, 255));

        Btn_Hint.setBackground(new java.awt.Color(0, 0, 255));
        Btn_Hint.setFont(new java.awt.Font("Sitka Banner", 0, 18)); // NOI18N
        Btn_Hint.setForeground(new java.awt.Color(204, 0, 204));
        Btn_Hint.setText("Hint");
        Btn_Hint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_HintActionPerformed(evt);
            }
        });

        BtnAutoSlove.setBackground(new java.awt.Color(0, 0, 255));
        BtnAutoSlove.setFont(new java.awt.Font("Sitka Banner", 0, 18)); // NOI18N
        BtnAutoSlove.setForeground(new java.awt.Color(204, 0, 204));
        BtnAutoSlove.setText("Auto");
        BtnAutoSlove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAutoSloveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Btn_NewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(CountDownTimer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(NumOfClicks_Counte, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Btn_Solution, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Btn_Hint, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BtnAutoSlove, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Btn_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(Btn_Mute, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(HightsScore, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_Reset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_NewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Btn_Solution, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NumOfClicks_Counte, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnAutoSlove, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Btn_Hint, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CountDownTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(HightsScore, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Btn_Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Btn_Mute))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void No1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_No1ActionPerformed
        // TODO add your handling code here:
        EmptySpotChecker(No1,No2);
        EmptySpotChecker(No1,No8);
        playClickSound();
        SloutionChecker();
    }//GEN-LAST:event_No1ActionPerformed

    private void No2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_No2ActionPerformed
        // TODO add your handling code here:
        EmptySpotChecker(No2,No1);
        EmptySpotChecker(No2,No3);
        EmptySpotChecker(No2,No7);
        playClickSound();
        SloutionChecker();
    }//GEN-LAST:event_No2ActionPerformed

    private void No3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_No3ActionPerformed
        // TODO add your handling code here:
        EmptySpotChecker(No3,No2);
        EmptySpotChecker(No3,No4);
        EmptySpotChecker(No3,No6);
        playClickSound();
        SloutionChecker();
    }//GEN-LAST:event_No3ActionPerformed

    private void No4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_No4ActionPerformed
        // TODO add your handling code here:
        EmptySpotChecker(No4,No3);
        EmptySpotChecker(No4,No5);
        playClickSound();
        SloutionChecker();
        
    }//GEN-LAST:event_No4ActionPerformed

    private void No5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_No5ActionPerformed
        // TODO add your handling code here:
        EmptySpotChecker(No5,No4);
        EmptySpotChecker(No5,No6);
        EmptySpotChecker(No5,No12);
        playClickSound();
        SloutionChecker();
    }//GEN-LAST:event_No5ActionPerformed

    private void No6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_No6ActionPerformed
        // TODO add your handling code here:
        EmptySpotChecker(No6,No3);
        EmptySpotChecker(No6,No7);
        EmptySpotChecker(No6,No5);
        EmptySpotChecker(No6,No11);
        playClickSound();
        SloutionChecker();
    }//GEN-LAST:event_No6ActionPerformed

    private void No7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_No7ActionPerformed
        // TODO add your handling code here:
        EmptySpotChecker(No7,No2);
        EmptySpotChecker(No7,No8);
        EmptySpotChecker(No7,No6);
        EmptySpotChecker(No7,No10);
        playClickSound();
        SloutionChecker();
    }//GEN-LAST:event_No7ActionPerformed

    private void No8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_No8ActionPerformed
        // TODO add your handling code here:
        EmptySpotChecker(No8,No1);
        EmptySpotChecker(No8,No7);
        EmptySpotChecker(No8,No9);
        playClickSound();
        SloutionChecker();
    }//GEN-LAST:event_No8ActionPerformed

    private void No9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_No9ActionPerformed
        // TODO add your handling code here:
        EmptySpotChecker(No9,No8);
        EmptySpotChecker(No9,No10);
        EmptySpotChecker(No9,EmptyBox);
        playClickSound();
        SloutionChecker();
    }//GEN-LAST:event_No9ActionPerformed

    private void No10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_No10ActionPerformed
        // TODO add your handling code here:
        //No10.setText("10");
        EmptySpotChecker(No10,No7);
        EmptySpotChecker(No10,No9);
        EmptySpotChecker(No10,No11);
        EmptySpotChecker(No10,No15);
        playClickSound();
        SloutionChecker();
    }//GEN-LAST:event_No10ActionPerformed

    private void No11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_No11ActionPerformed
        // TODO add your handling code here:
        EmptySpotChecker(No11,No6);
        EmptySpotChecker(No11,No10);
        EmptySpotChecker(No11,No12);
        EmptySpotChecker(No11,No14);
        playClickSound();
        SloutionChecker();
    }//GEN-LAST:event_No11ActionPerformed

    private void No12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_No12ActionPerformed
        // TODO add your handling code here:
        EmptySpotChecker(No12,No5);
        EmptySpotChecker(No12,No11);
        EmptySpotChecker(No12,No13);
        playClickSound();
        SloutionChecker();
    }//GEN-LAST:event_No12ActionPerformed

    private void No13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_No13ActionPerformed
        // TODO add your handling code here:
        EmptySpotChecker(No13,No12);
        EmptySpotChecker(No13,No14);
        playClickSound();
        SloutionChecker();
    }//GEN-LAST:event_No13ActionPerformed

    private void No14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_No14ActionPerformed
        // TODO add your handling code here:
        EmptySpotChecker(No14,No11);
        EmptySpotChecker(No14,No13);
        EmptySpotChecker(No14,No15);
        playClickSound();
        SloutionChecker();
    }//GEN-LAST:event_No14ActionPerformed

    private void No15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_No15ActionPerformed
        // TODO add your handling code here:
        EmptySpotChecker(No15,No11);
        EmptySpotChecker(No15,No14);
        EmptySpotChecker(No15,EmptyBox);
        playClickSound();
        SloutionChecker();
    }//GEN-LAST:event_No15ActionPerformed

    private void EmptyBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmptyBoxActionPerformed
        // TODO add your handling code here:
        EmptySpotChecker(EmptyBox,No9);
        EmptySpotChecker(EmptyBox,No15);
        playClickSound();
        SloutionChecker();
    }//GEN-LAST:event_EmptyBoxActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        Shuffle();
        displayHighestScore();
    }//GEN-LAST:event_formWindowActivated
//-----------------------------------------------------------------------------
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        //Shuffle();
        //This is add by an error don't add any thing to this add to the formWindowActivated ////// 
    }//GEN-LAST:event_formWindowOpened
//------------------------------------------------------------------------------
    private void Btn_SolutionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_SolutionActionPerformed
        // TODO add your handling code here:
        No1.setText("1");
        No2.setText("2");
        No3.setText("3");
        No4.setText("4");
        No5.setText("5");
        No6.setText("6");
        No7.setText("7");
        No8.setText("8");
        No9.setText("9");
        No10.setText("10");
        No11.setText("11");
        No12.setText("12");
        No13.setText("13");
        No14.setText("14");
        No15.setText("15");
        EmptyBox.setText("");
    }//GEN-LAST:event_Btn_SolutionActionPerformed

    private void Btn_ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ResetActionPerformed
        // TODO add your handling code here:
        // Reset the game
        Shuffle();
        Counter = 0;
        NumOfClicks_Counte.setText("0");

        // Reset the timer
        countDownTimer.resetTimer();
        countDownTimer.startTimer();
    }//GEN-LAST:event_Btn_ResetActionPerformed
    
    
    private void Btn_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ExitActionPerformed
        // TODO add your handling code here:
    int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
    
    // Check the user's choice
    if (choice == JOptionPane.YES_OPTION) {
        System.exit(0);
    }
        
    }//GEN-LAST:event_Btn_ExitActionPerformed

    private void Btn_NewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_NewGameActionPerformed
        // TODO add your handling code here:
         String playerName = JOptionPane.showInputDialog(null, "Enter your name:", "Player Name", JOptionPane.QUESTION_MESSAGE);
    if (playerName == null || playerName.trim().isEmpty()) {
        // If the player cancels or enters an empty name, display a default name
        playerName = "Anonymous";
    }

    // Shuffle the numbers
    Shuffle(); 
    Counter = 0; // Reset the counter
    NumOfClicks_Counte.setText("0"); // Update the counter display

    // Record the player's score with their name
    recordScore(playerName, 0);

    // Reset the timer
    countDownTimer.resetTimer();
    countDownTimer.startTimer();
    }//GEN-LAST:event_Btn_NewGameActionPerformed
    
    
    private void Btn_MuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_MuteActionPerformed
        // TODO add your handling code here:
         isMuted = !isMuted;
    
        // If muted, stop the music; otherwise, resume playing
        if (isMuted) {
            clip.stop(); // Stop the music
        } else {
            clip.loop(Clip.LOOP_CONTINUOUSLY); // Resume playing
        }
    }//GEN-LAST:event_Btn_MuteActionPerformed
    //------------------------------------------------------------------------
    private void initializeTiles() {
    tiles = new JButton[4][4];
    tiles[0][0] = No1;
    tiles[0][1] = No2;
    tiles[0][2] = No3;
    tiles[0][3] = No4;
    tiles[1][0] = No5;
    tiles[1][1] = No6;
    tiles[1][2] = No7;
    tiles[1][3] = No8;
    tiles[2][0] = No9;
    tiles[2][1] = No10;
    tiles[2][2] = No11;
    tiles[2][3] = No12;
    tiles[3][0] = No13;
    tiles[3][1] = No14;
    tiles[3][2] = No15;
    tiles[3][3] = EmptyBox;

    // Set the text of EmptyBox to an empty string
    EmptyBox.setText("");
}


    
    private void Btn_HintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_HintActionPerformed
        // TODO add your handling code here
     // Find the empty tile position
    int emptyRow = -1;
    int emptyCol = -1;
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            if (tiles[i][j].getText().isEmpty()) {
                emptyRow = i;
                emptyCol = j;
                break;
            }
        }
    }

    // Randomly select left or right direction
    Random random = new Random();
    boolean moveLeft = random.nextBoolean();

    // Determine the target column for the move
    int targetCol = moveLeft ? emptyCol - 1 : emptyCol + 1;

    // Check if the target column is within bounds
    if (targetCol >= 0 && targetCol < 4) {
        // Move the tile to the empty space
        String temp = tiles[emptyRow][targetCol].getText();
        tiles[emptyRow][targetCol].setText("");
        tiles[emptyRow][emptyCol].setText(temp);
    }
    }//GEN-LAST:event_Btn_HintActionPerformed
    //------------------------------------------------------------------------
    
    private Timer timer;
    private int currentNumber = 1;
    private void BtnAutoSloveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAutoSloveActionPerformed
        // TODO add your handling code here:
        // Create a timer to simulate solving the puzzle step by step
    ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            // Set the numbers in order and clear the empty box step by step
            switch (currentNumber) {
                case 1:
                    No1.setText("1");
                    break;
                case 2:
                    No2.setText("2");
                    break;
                case 3:
                    No3.setText("3");
                    break;
                case 4:
                    No4.setText("4");
                    break;
                case 5:
                    No5.setText("5");
                    break;
                case 6:
                    No6.setText("6");
                    break;
                case 7:
                    No7.setText("7");
                    break;
                case 8:
                    No8.setText("8");
                    break;
                case 9:
                    No9.setText("9");
                    break;
                case 10:
                    No10.setText("10");
                    break;
                case 11:
                    No11.setText("11");
                    break;
                case 12:
                    No12.setText("12");
                    break;
                case 13:
                    No13.setText("13");
                    break;
                case 14:
                    No14.setText("14");
                    break;
                case 15:
                    No15.setText("15");
                    break;
                case 16:
                    EmptyBox.setText("");
                    break;
                default:
                    // Puzzle solved
                    timer.stop();
                    // Send congratulatory message
                    JOptionPane.showMessageDialog(null, "Congratulations! Puzzle solved!");
                    break;
            }

            currentNumber++;
        }
    };

    // Create a timer with a delay of 500 milliseconds between each step
    timer = new Timer(500, listener);
    timer.setInitialDelay(0);
    timer.start();
    }//GEN-LAST:event_BtnAutoSloveActionPerformed
    //------------------------------------------------------------------------

    //------------------------------------------------------------------------
    int Counter;
    
    void EmptySpotChecker(JButton Butt1, JButton Butt2){
        String ShuffleNumber = Butt2.getText();
        
        if (ShuffleNumber == ""){
            Butt2.setText(Butt1.getText());
            Butt1.setText("");
        }
    }
    //-------------------------------------------------------------------------
    public void Shuffle() {
    Integer[] btnNo = new Integer[15];
    
    // Fill the array with numbers from 1 to 15
    for (int i = 0; i < 15; i++) {
        btnNo[i] = i + 1;
    }

    // Shuffle the array using Fisher-Yates algorithm
    Random rand = new Random();
    for (int i = btnNo.length - 1; i > 0; i--) {
        int index = rand.nextInt(i + 1);
        // Swap btnNo[i] and btnNo[index]
        int temp = btnNo[index];
        btnNo[index] = btnNo[i];
        btnNo[i] = temp;
    }

    // Set the shuffled numbers on the buttons
    No1.setText(btnNo[0].toString());
    No2.setText(btnNo[1].toString());
    No3.setText(btnNo[2].toString());
    No4.setText(btnNo[3].toString());
    No5.setText(btnNo[4].toString());
    No6.setText(btnNo[5].toString());
    No7.setText(btnNo[6].toString());
    No8.setText(btnNo[7].toString());
    No9.setText(btnNo[8].toString());
    No10.setText(btnNo[9].toString());
    No11.setText(btnNo[10].toString());
    No12.setText(btnNo[11].toString());
    No13.setText(btnNo[12].toString());
    No14.setText(btnNo[13].toString());
    No15.setText(btnNo[14].toString());
    EmptyBox.setText("");
}

    //-------------------------------------------------------------------------
    
    public void SloutionChecker(){
    
    // Check if the number of clicks has reached the limit (30)
    // add as you want to this to increase your movements
    if (Counter >= 30) {
        JOptionPane.showMessageDialog(null, "You have reached the maximum number of clicks! Starting a new game.", "Limit Exceeded", JOptionPane.WARNING_MESSAGE);
        Shuffle(); // Reset the game by shuffling the numbers
        Counter = 0; // Reset the counter to 0
        NumOfClicks_Counte.setText("0"); // Update the counter display
        return; 
    }
    
    // Check if the puzzle is solved
    String b1 = No1.getText();
    String b2 = No2.getText();
    String b3 = No3.getText();
    String b4 = No4.getText();
    String b5 = No5.getText();
    String b6 = No6.getText();
    String b7 = No7.getText();
    String b8 = No8.getText();
    String b9 = No9.getText();
    String b10 = No10.getText();
    String b11 = No11.getText();
    String b12 = No12.getText();
    String b13 = No13.getText();
    String b14 = No14.getText();
    String b15 = No15.getText();
    
    if (b1.equals("1") && b2.equals("2") && b3.equals("3") && b4.equals("4") &&
        b5.equals("5") && b6.equals("6") && b7.equals("7") && b8.equals("8") &&
        b9.equals("9") && b10.equals("10") && b11.equals("11") && b12.equals("12") &&
        b13.equals("13") && b14.equals("14") && b15.equals("15")) {
        
        JOptionPane.showMessageDialog(null, "Congratulations! You solved the Puzzle game", "Victory", JOptionPane.INFORMATION_MESSAGE);
    }
    
    // Increment the counter only if the game is not solved yet
    Counter++;
    NumOfClicks_Counte.setText(Integer.toString(Counter));
}

    //------------------------------------------------------------------------
    public class CountDownTime {
        private Timer timer;
        //change this to get more time
        private int timeLeftInSeconds = 30 * 60; // 30 minutes**** // to test the code set the timer to 15 seconds***

        public CountDownTime() {
            timer = new Timer(1000, e -> {
                timeLeftInSeconds--;
                updateTimeDisplay();
                if (timeLeftInSeconds == 0) {
                    timer.stop();
                    handleTimeUp();
                }
            });
        }

        private void startTimer() {
            timer.start();
        }
        
         public void stopTimer() {
            timer.stop();
        }
        // use this to how the reset clock timer 
        public void resetTimer() {
            timeLeftInSeconds = 30 * 60; // 30 minutes**** // to test the code set the timer to 15 seconds***
            updateTimeDisplay();
        }

        private void updateTimeDisplay() {
            int minutes = timeLeftInSeconds / 60;
            int seconds = timeLeftInSeconds % 60;
            String timeString = String.format("%02d:%02d", minutes, seconds);
            CountDownTimer.setText(timeString);
        }

        private void handleTimeUp() {
            JOptionPane.showMessageDialog(null, "Time's up! Starting a new game.", "Time Up", JOptionPane.WARNING_MESSAGE);
            Shuffle(); // Reset the game by shuffling the numbers
            Counter = 0; // Reset the counter to 0
            NumOfClicks_Counte.setText("0"); // Update the counter display
        }
    }
    //-------------------------------------------------------------------------
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Puzzel_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Puzzel_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Puzzel_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Puzzel_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Puzzel_Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAutoSlove;
    private javax.swing.JButton Btn_Exit;
    private javax.swing.JButton Btn_Hint;
    private javax.swing.JButton Btn_Mute;
    private javax.swing.JButton Btn_NewGame;
    private javax.swing.JButton Btn_Reset;
    private javax.swing.JButton Btn_Solution;
    private javax.swing.JLabel CountDownTimer;
    private javax.swing.JButton EmptyBox;
    private javax.swing.JLabel HightsScore;
    private javax.swing.JButton No1;
    private javax.swing.JButton No10;
    private javax.swing.JButton No11;
    private javax.swing.JButton No12;
    private javax.swing.JButton No13;
    private javax.swing.JButton No14;
    private javax.swing.JButton No15;
    private javax.swing.JButton No2;
    private javax.swing.JButton No3;
    private javax.swing.JButton No4;
    private javax.swing.JButton No5;
    private javax.swing.JButton No6;
    private javax.swing.JButton No7;
    private javax.swing.JButton No8;
    private javax.swing.JButton No9;
    private javax.swing.JLabel NumOfClicks_Counte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
