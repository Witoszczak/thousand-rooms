package com.witoszczak;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TRGame {

    // elements of title screen
    JFrame window;
    Container con;
    JPanel gameTitlePanel, gameStartButtonPanel;
    JLabel gameTitleLabel;
    JButton gameStartButton;

    // elements of game screen (after "start")
    JPanel gameNarrationPanel, choiceButtonsPanel, playerPanel;
    JTextArea gameNarrationText;
    JButton choice1, choice2, choice3, choice4;
    JLabel hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;

    // custom fonts
    Font gameTitleFont = new Font("Times New Roman", Font.PLAIN, 54);
    Font gameStartButtonFont = new Font("Times New Roman", Font.PLAIN, 22);

    // setup variables (HP, Items...)
    int playerHP;
    String playerWeapon;

    // help variables
    String position;

    // objects of the "click" handlers used to attach to the buttons
    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();

    public static void main(String[] args) {

        new TRGame();

    }

    public TRGame(){

        // setting the main window
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        con = window.getContentPane();

        // setting the panel for the tittle
        gameTitlePanel = new JPanel();
        gameTitlePanel.setBounds(100,100,600,150);
        gameTitlePanel.setBackground(Color.black);

        // setting the label with the title
        gameTitleLabel = new JLabel("Thousand Rooms Game");
        gameTitleLabel.setForeground(Color.white);
        gameTitleLabel.setFont(gameTitleFont);

        // setting the panel for the start button
        gameStartButtonPanel = new JPanel();
        gameStartButtonPanel.setBounds(300, 400, 200, 100);
        gameStartButtonPanel.setBackground(Color.black);

        // setting the start button
        gameStartButton = new JButton("START");
        gameStartButton.setBackground(Color.black);
        gameStartButton.setForeground(Color.white);
        gameStartButton.setFont(gameStartButtonFont);
        gameStartButton.addActionListener(tsHandler);
        gameStartButton.setFocusPainted(false);

        // adding label and button to its panels
        gameTitlePanel.add(gameTitleLabel);
        gameStartButtonPanel.add(gameStartButton);

        // adding panels to container
        con.add(gameTitlePanel);
        con.add(gameStartButtonPanel);

        window.setVisible(true);

    }

    // method that displays the actual game screen
    // after we click start (first screen of the game)
    public void createGameScreen() {

        //clearing panels from starting window
        gameTitlePanel.setVisible(false);
        gameStartButtonPanel.setVisible(false);

        // setting the panel for the narration
        gameNarrationPanel = new JPanel();
        gameNarrationPanel.setBounds(100, 100,600,250);
        gameNarrationPanel.setBackground(Color.black);
        con.add(gameNarrationPanel);

        // setting the text field for the narration
        gameNarrationText = new JTextArea();
        gameNarrationText.setBounds(100,100,600,250);
        gameNarrationText.setBackground(Color.black);
        gameNarrationText.setForeground(Color.white);
        gameNarrationText.setFont(gameStartButtonFont);
        gameNarrationText.setLineWrap(true);
        gameNarrationPanel.add(gameNarrationText);

        // setting the panel for the choice buttons
        choiceButtonsPanel = new JPanel();
        choiceButtonsPanel.setBounds(250, 350, 300, 150);
        choiceButtonsPanel.setBackground(Color.black);
        choiceButtonsPanel.setForeground(Color.white);
        choiceButtonsPanel.setLayout(new GridLayout(4,1));
        con.add(choiceButtonsPanel);

        // setting the choice1 button
        choice1 = new JButton("Choice number 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(gameStartButtonFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");//to get the difference which was clicked
        choiceButtonsPanel.add(choice1);

        // setting the choice2 button
        choice2 = new JButton("Choice number 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(gameStartButtonFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");//to get the difference which was clicked
        choiceButtonsPanel.add(choice2);

        // setting the choice3 button
        choice3 = new JButton("Choice number 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(gameStartButtonFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");//to get the difference which was clicked
        choiceButtonsPanel.add(choice3);

        // setting the choice4 button
        choice4 = new JButton("Choice number 4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(gameStartButtonFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");//to get the difference which was clicked
        choiceButtonsPanel.add(choice4);

        // setting the player panel
        playerPanel = new JPanel();
        playerPanel.setBounds(100,15,600,50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1,4));
        con.add(playerPanel);

        // setting the HP label
        hpLabel = new JLabel("HP: ");
        hpLabel.setFont(gameStartButtonFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);

        // setting the HP value label
        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(gameStartButtonFont);
        hpLabelNumber.setForeground(Color.white);
        playerPanel.add(hpLabelNumber);

        // setting the weapon label
        weaponLabel = new JLabel("Weapon: ");
        weaponLabel.setFont(gameStartButtonFont);
        weaponLabel.setForeground(Color.white);
        playerPanel.add(weaponLabel);

        //setting the weapon name label
        weaponLabelName = new JLabel();
        weaponLabelName.setFont(gameStartButtonFont);
        weaponLabelName.setForeground(Color.white);
        playerPanel.add(weaponLabelName);

        //setting the player setup (hp, items...) and first game screen
        playerSetup();



    }

    // method to display some basic stats at the top of the game screen
    public void playerSetup(){

        playerHP = 20;
        playerWeapon = "Laser Rifle";

        hpLabelNumber.setText("" + playerHP);
        weaponLabelName.setText(playerWeapon);

        startingRoom();

    }

    // method to display main narrative for the game screen
    public void startingRoom(){

        // where are we?
        position = "startingRoom";

        gameNarrationText.setText("You are in the CRYO-CHAMBER room.\nYou can see a broken door and a massive, locked chest.\n\nWhat do you do?");

        choice1.setText("try open the chest (lockpick)");
        choice2.setText("shoot laser beam to the chest");
        choice3.setText("leave through the door");
        choice4.setText("");

    }

    // method that will handle first choice of starting room (try open chest...)
    public void openChest(){

        // where are we?
        position = "openingChest";

        gameNarrationText.setText("You kneel and examine the chest. Lock is electronic and it's intact. You cannot open it");

        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }

    // method that will handle second choice of starting room (shooting into the chest...)
    public void shootChest(){

        // where are we?
        position = "shootingChest";

        gameNarrationText.setText("You aimed riffle at chest from a distance and pull the trigger...\n\nLaser beam deflects at you!\n (3 damage recieved) ");

        playerHP -= 3;
        hpLabelNumber.setText("" + playerHP);
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    // method that will handle third choice of starting room (leaving through the door)
    public void mainCorridorOne(){

        //where are we?
        position = "mainCorridorOne";

        gameNarrationText.setText("You are in a MAIN CORRIDOR area.\nLight panels are all broken except one, so it's a little bit dark.\nTo the left you can see a door with ENGINE ROOM sign on it.\nThere is an elevator in front of you.\nDoor to cryo-chamber are behind you.");

        choice1.setText("get into elevator");
        choice2.setText("go to ENGINE ROOM");
        choice3.setText("");
        choice4.setText("go back to cryo-chamber");
    }

    public void elevatorRoom(){

        //where are we?
        position = "elevatorRoom";

        gameNarrationText.setText("You are inside a large, cargo elevator.\nBlue panel on the front wall have UP and DOWN, buttons.\nNext to the panel, there is a Inter-com device with the numeric keyboard.");

        choice1.setText("Turn on the Inter-com");
        choice2.setText("Go UP");
        choice3.setText("Go DOWN");
        choice4.setText("Leave the elevator");
    }

    public void engineRoom(){

        position = "engineRoom";

        gameNarrationText.setText("You are in the ENGINE ROOM.\nYou found an electronic lock-pick device\n\n(lock-pick obtained)");

        playerWeapon = "Lock-pick";
        weaponLabelName.setText(playerWeapon);

        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("Go back");
    }





    // event handler class for the start button to get the action from it (go to next screen on click)
    public class TitleScreenHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){
            createGameScreen();
        }

    }

    // event handler class for the choice buttons
    public class ChoiceHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent event) {

            // This string will hold the identifier for the which button was clicked (c1,c2...)
            String yourChoice = event.getActionCommand();

            switch (position){
                case "startingRoom":
                    switch (yourChoice) {
                        case "c1": openChest(); break; // button "try open the chest (lockpick)"
                        case "c2": shootChest(); break; // button "shoot laser beam to the chest"
                        case "c3": mainCorridorOne(); break; // button "leave through the door"
                        case "c4": break;
                    }
                    break;
                case "openingChest":
                    switch (yourChoice) {
                        case "c1": startingRoom(); break;
                        case "c2": break;
                        case "c3": break;
                        case "c4": break;
                    }
                    break;
                case "shootingChest":
                    switch (yourChoice) {
                        case "c1": startingRoom(); break;
                        case "c2": break;
                        case "c3": break;
                        case "c4": break;
                    }
                    break;
                case "mainCorridorOne":
                    switch (yourChoice){
                        case "c1": elevatorRoom(); break;
                        case "c2": engineRoom(); break;
                        case "c3": break;
                        case "c4": startingRoom(); break;
                    }
                    break;
                case "elevatorRoom":
                    switch (yourChoice){
                        case "c1": break;
                        case "c2": break;
                        case "c3": break;
                        case "c4": mainCorridorOne();break;
                    }
                    break;
                case "engineRoom":
                    switch (yourChoice){
                        case "c1": break;
                        case "c2": break;
                        case "c3": break;
                        case "c4": mainCorridorOne(); break;
                    }


            }


        }
    }


}
