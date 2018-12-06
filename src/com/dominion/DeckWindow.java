package com.dominion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class DeckWindow extends JPanel implements ActionListener{
    // Declaration of checkboxes
    private JCheckBox dominionCbx, intrigueCbx, seasideCbx, alchemyCbx, promoCbx, prosperityCbx, cornucopiaCbx,
            hinterlandsCbx, darkAgesCbx, guildsCbx, empiresCbx, adventuresCbx, nocturneCbx, renaissanceCbx;
    // Declaration of the "imageList" array, an array of the image paths
    private ArrayList<String> imageList;
    // Declaration of the "checkboxArray", and array to hold checkbox references
    private ArrayList<JCheckBox> checkboxArray = new ArrayList<>();
    // Declaration of the constraints variable for the "GridBagLayout":
    private GridBagConstraints c = new GridBagConstraints();

    // Constructs the window and the objects within the window:
    DeckWindow(ArrayList imageList) {
        // Handles the incoming ArrayList "imageList":
        this.imageList = imageList;
        // Instantiates the GridBagLayout
        setLayout(new GridBagLayout());
        // Sets the insets for the the constraints:
        c.insets = new Insets(5, 5, 5, 5);

        // Calls the "buildLabel" method:
        buildLabel();

        // Calls the "buildDominionCbx" method:
        buildDominionCbx();

        // Calls the "buildIntrigueCbx" method:
        buildIntrigueCbx();

        // Calls the "buildSeasideCbx" method:
        buildSeasideCbx();

        // Calls the "buildAlchemyCbx" method:
        buildAlchemyCbx();

        // Calls the "buildPromoCbx" method:
        buildPromoCbx();

        // Calls the "buildProsperityCbx" method:
        buildProsperityCbx();

        // Calls the "buildCornucopiaCbx" method:
        buildCornucopiaCbx();

        // Calls the "buildHinterlandsCbx" method:
        buildHinterlandsCbx();

        // Calls the "buildDarkAgesCbx" method:
        buildDarkAgesCbx();

        // Calls the "buildGuildsCbx" method:
        buildGuildsCbx();

        // Calls the "buildEmpiresCbx" method:
        buildEmpiresCbx();

        // Calls the "buildAdventuresCbx" method:
        buildAdventuresCbx();

        // Calls the "" method:
        buildNocturneCbx();

        // Calls the "buildRenaissanceCbx" method:
        buildRenaissanceCbx();

        // Calls the "buildShuffleBtn" method:
        buildShuffleBtn();

        // Calls the "displayLogic" method:
        displayLogic();
    }

    //  The "buildLabel" method sets the label text, GridBagLayout constraints, position, alignment, color, and font:
    private void buildLabel() {
        JLabel label1;

        label1 = new JLabel("Select checkboxes to include decks:");
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.weightx = 0.7;
        add(label1, c);
        label1.setBackground(Color.lightGray);
        label1.setHorizontalAlignment(0);
        label1.setFont(new Font("Serif", Font.BOLD, 24));
    }

    //  The "buildDominionCbx" method sets the checkbox label text, GridBagLayout constraints, position, and color:
    private void buildDominionCbx() {
        dominionCbx = new JCheckBox("Dominion Base Deck");
        c.gridx = 0;
        c.gridy = 2;
        add(dominionCbx, c);
        dominionCbx.setBackground(Color.lightGray);
    }

    //  The "buildIntrigueCbx" method sets the checkbox label text, GridBagLayout constraints, position, and color:
    private void buildIntrigueCbx() {
        intrigueCbx = new JCheckBox("Intrigue Deck");
        c.gridx = 0;
        c.gridy = 3;
        add(intrigueCbx, c);
        intrigueCbx.setBackground(Color.lightGray);
    }

    //  The "buildSeasideCbx" method sets the checkbox label text, GridBagLayout constraints, position, and color:
    private void buildSeasideCbx() {
        seasideCbx = new JCheckBox("Seaside Deck");
        c.gridx = 0;
        c.gridy = 4;
        add(seasideCbx, c);
        seasideCbx.setBackground(Color.lightGray);
    }

    //  The "buildAlchemyCbx" method sets the checkbox label text, GridBagLayout constraints, position, and color:
    private void buildAlchemyCbx() {
        alchemyCbx = new JCheckBox("Alchemy Deck");
        c.gridx = 0;
        c.gridy = 5;
        add(alchemyCbx, c);
        alchemyCbx.setBackground(Color.lightGray);
    }

    //  The "buildPromoCbx" method sets the checkbox label text, GridBagLayout constraints, position, and color:
    private void buildPromoCbx() {
        promoCbx = new JCheckBox("Promo Cards");
        c.gridx = 0;
        c.gridy = 6;
        add(promoCbx, c);
        promoCbx.setBackground(Color.lightGray);
    }

    //  The "buildProsperityCbx" method sets the checkbox label text, GridBagLayout constraints, position, and color:
    private void buildProsperityCbx() {
        prosperityCbx = new JCheckBox("Prosperity Deck");
        c.gridx = 0;
        c.gridy = 7;
        add(prosperityCbx, c);
        prosperityCbx.setBackground(Color.lightGray);
    }

    //  The "buildCornucopiaCbx" method sets the checkbox label text, GridBagLayout constraints, position, and color:
    private void buildCornucopiaCbx() {
        cornucopiaCbx = new JCheckBox("Cornucopia Deck");
        c.gridx = 0;
        c.gridy = 8;
        add(cornucopiaCbx, c);
        cornucopiaCbx.setBackground(Color.lightGray);
    }

    //  The "buildHinterlandsCbx" method sets the checkbox label text, GridBagLayout constraints, position, and color:
    private void buildHinterlandsCbx() {
        hinterlandsCbx = new JCheckBox("Hinterlands Deck");
        c.gridx = 0;
        c.gridy = 9;
        add(hinterlandsCbx, c);
        hinterlandsCbx.setBackground(Color.lightGray);
    }

    //  The "buildDarkAgesCbx" method sets the checkbox label text, GridBagLayout constraints, position, and color:
    private void buildDarkAgesCbx() {
        darkAgesCbx = new JCheckBox("Dark Ages Deck");
        c.gridx = 0;
        c.gridy = 10;
        add(darkAgesCbx, c);
        darkAgesCbx.setBackground(Color.lightGray);
        darkAgesCbx.setSelected(false);
    }

    //  The "buildGuildsCbx" method sets the checkbox label text, GridBagLayout constraints, position, and color:
    private void buildGuildsCbx() {
        guildsCbx = new JCheckBox("Guilds Deck");
        c.gridx = 0;
        c.gridy = 11;
        add(guildsCbx, c);
        guildsCbx.setBackground(Color.lightGray);
    }

    //  The "buildEmpiresCbx" method sets the checkbox label text, GridBagLayout constraints, position, and color:
    private void buildEmpiresCbx() {
        empiresCbx = new JCheckBox("Empires Deck");
        c.gridx = 0;
        c.gridy = 12;
        add(empiresCbx, c);
        empiresCbx.setBackground(Color.lightGray);
    }

    //  The "buildAdventuresCbx" method sets the checkbox label text, GridBagLayout constraints, position, and color:
    private void buildAdventuresCbx() {
        adventuresCbx = new JCheckBox("Adventures Deck");
        c.gridx = 0;
        c.gridy = 13;
        add(adventuresCbx, c);
        adventuresCbx.setBackground(Color.lightGray);
    }

    //  The "buildNocturneCbx" method sets the checkbox label text, GridBagLayout constraints, position, and color:
    private void buildNocturneCbx() {
        nocturneCbx = new JCheckBox("Nocturne Deck");
        c.gridx = 0;
        c.gridy = 14;
        add(nocturneCbx, c);
        nocturneCbx.setBackground(Color.lightGray);
    }

    //  The "buildRenaissanceCbx" method sets the checkbox label text, GridBagLayout constraints, position, and color:
    private void buildRenaissanceCbx() {
        renaissanceCbx = new JCheckBox("Renaissance Deck");
        c.gridx = 0;
        c.gridy = 15;
        add(renaissanceCbx, c);
        renaissanceCbx.setBackground(Color.lightGray);
    }

    //  The "buildShuffleBtn" method sets the button label text, layout constraints, position, color, and a listener:
    private void buildShuffleBtn() {
        JButton shuffleBtn;

        shuffleBtn = new JButton("Shuffle Decks");
        c.gridx = 0;
        c.gridy = 17;
        add(shuffleBtn, c);
        shuffleBtn.setBackground(Color.GRAY);
        // Action listener for clicking the "shuffleBtn":
        shuffleBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ArrayList<String> initialDeck = new ArrayList<>();
                ArrayList<String> codedValues = new ArrayList<>();

                checkboxArray.addAll(Arrays.asList(dominionCbx, intrigueCbx, seasideCbx, alchemyCbx, promoCbx,
                        prosperityCbx, cornucopiaCbx, hinterlandsCbx, darkAgesCbx, guildsCbx, empiresCbx, adventuresCbx,
                        nocturneCbx, renaissanceCbx));

                // For loop checking that populates the "codedVales" ArrayList based on the selected checkboxes
                for (int count = 0; count < checkboxArray.size(); count++) {

                    // Prompt user for input about what deck(s) to include:
                    if ((checkboxArray.get(count).isSelected())) {
                        codedValues.add("y");
                    }
                    else codedValues.add("n");
                }

                // Create a new "Deck" object called "kingdom"
                Deck kingdom = new Deck();

                // Pass the ArrayList "initialDeck" to the "Deck" Class
                kingdom.setDeckListOfCards(initialDeck);
                kingdom.setCodes(codedValues);
            }
        });
    }

    /*  The "displayLogic" method sets the image of each card to the default, then after the decks are selected and the
    "shuffleBtn" is selected, the imageList array (containing the file paths for each card's image) is read to determine
    the cards appearance based on the cards dealt in the shuffle.  */
    private void displayLogic() {
        JLabel c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;
        ImageIcon card1, card2, card3, card4, card5, card6, card7, card8, card9, card10;
        String defaultImage = "/home/xpanxion/IdeaProjects/Dominion/src/com/dominion/DominionProject/Randomizer/backside_blue.jpg";

        // Conditional logic to display the "back" of the card if the imageList array is null:
        if (imageList == null) card1 = new ImageIcon(defaultImage);
        // Else, show the image generated from the path from the first element of the imageList array:
        else card1 = new ImageIcon(imageList.get(0));
        c1 = new JLabel(card1);
        c.gridx = 1;
        c.gridy = 3;
        c.weightx = 2.9;
        c.weighty = 0.9;
        c.gridheight = 18;
        add(c1, c);

        if (imageList == null) card2 = new ImageIcon(defaultImage);
        else card2 = new ImageIcon(imageList.get(1));
        c2 = new JLabel(card2);
        c.gridx = 2;
        c.gridy = 3;
        add(c2, c);

        if (imageList == null) card3 = new ImageIcon(defaultImage);
        else card3 = new ImageIcon(imageList.get(2).toString());
        c3 = new JLabel(card3);
        c.gridx = 3;
        c.gridy = 3;
        add(c3, c);

        if (imageList == null) card4 = new ImageIcon(defaultImage);
        else card4 = new ImageIcon(imageList.get(3).toString());
        c4 = new JLabel(card4);
        c.gridx = 4;
        c.gridy = 3;
        add(c4, c);

        if (imageList == null) card5 = new ImageIcon(defaultImage);
        else card5 = new ImageIcon(imageList.get(4).toString());
        c5 = new JLabel(card5);
        c.gridx = 5;
        c.gridy = 3;
        add(c5, c);

        if (imageList == null) card6 = new ImageIcon(defaultImage);
        else card6 = new ImageIcon(imageList.get(5).toString());
        c6 = new JLabel(card6);
        c.gridx = 1;
        c.gridy = 15;
        add(c6, c);

        if (imageList == null) card7 = new ImageIcon(defaultImage);
        else card7 = new ImageIcon(imageList.get(6).toString());
        c7 = new JLabel(card7);
        c.gridx = 2;
        c.gridy = 15;
        add(c7, c);

        if (imageList == null) card8 = new ImageIcon(defaultImage);
        else card8 = new ImageIcon(imageList.get(7).toString());
        c8 = new JLabel(card8);
        c.gridx = 3;
        c.gridy = 15;
        add(c8, c);

        if (imageList == null) card9 = new ImageIcon(defaultImage);
        else card9 = new ImageIcon(imageList.get(8).toString());
        c9 = new JLabel(card9);
        c.gridx = 4;
        c.gridy = 15;
        add(c9, c);

        if (imageList == null) card10 = new ImageIcon(defaultImage);
        else card10 = new ImageIcon(imageList.get(9).toString());
        c10 = new JLabel(card10);
        c.gridx = 5;
        c.gridy = 15;
        add(c10, c);
    }

    void buildWindow() {
        DeckWindow d = new DeckWindow(imageList);
        d.setBackground(Color.lightGray);

        JFrame jf = new JFrame();

        jf.setTitle("Kingdom Deck");
        jf.setSize(1920, 1080);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setBackground(Color.lightGray);
        jf.setVisible(true);
        jf.add(d);
    }

    public void actionPerformed(ActionEvent shuffle) {
        ArrayList<String> initialDeck = new ArrayList<>();
        ArrayList<String> codedValues = null;

        checkboxArray.addAll(Arrays.asList(dominionCbx, intrigueCbx, seasideCbx, alchemyCbx, promoCbx,
                prosperityCbx, cornucopiaCbx, hinterlandsCbx, darkAgesCbx, guildsCbx, empiresCbx, adventuresCbx,
                nocturneCbx, renaissanceCbx));

        // For loop checking that populates the "codedVales" ArrayList based on the selected checkboxes
        for (int count = 0; count < checkboxArray.size(); count++) {

            // Prompt user for input about what deck(s) to include:
            //
            if ((checkboxArray.get(count).isSelected())) {
                codedValues.add("y");
            } else codedValues.add("n");
        }

        // Create a new "Deck" object called "kingdom"
        Deck kingdom = new Deck();

        // Pass the ArrayList "initialDeck" to the Class
        kingdom.setDeckListOfCards(initialDeck);
        kingdom.setCodes(codedValues);
    }
}
