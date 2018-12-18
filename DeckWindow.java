package com.dominion;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

class DeckWindow extends JPanel {
    // Declaration of the DeckWindow:
    private DeckWindow gui;
    // Declaration of the panels used within the window:
    private Panel leftPanel = new Panel();
    private Panel windowPanel = new Panel();
    private Panel cardPanel = new Panel();
    private Panel dealPanel = new Panel();
    private Panel dEd1Panel = new Panel();
    private Panel dEd2Panel = new Panel();
    private Panel iEd1Panel = new Panel();
    private Panel iEd2Panel = new Panel();
    private Panel buttonPanel = new Panel();
    // Declaration of labels for the selection of editions of Dominion and Intrigue:
    private JLabel dominionLabel = new JLabel();
    private JLabel intrigueLabel = new JLabel();
    private JLabel indentLabel;
    // Declaration of radio buttons for the editions of Dominion and Intrigue:
    private JRadioButton dominionRadBtn;
    private JRadioButton dominionEd2RadBtn;
    private JRadioButton intrigueRadBtn;
    private JRadioButton intrigueEd2RadBtn;
    // Declaration of checkboxes in the "leftPanel"
    private JCheckBox dominionCbx, intrigueCbx, seasideCbx, alchemyCbx, promoCbx, prosperityCbx, cornucopiaCbx,
            hinterlandsCbx, darkAgesCbx, guildsCbx, empiresCbx, adventuresCbx, nocturneCbx, renaissanceCbx;
    // Declaration of the ImageIcons used in the "cardPanel"
    private ImageIcon card1, card2, card3, card4, card5, card6, card7, card8, card9, card10;
    private JLabel c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, label3;
    // Declaration of the "cumulativeDeck" ArrayList, holding the "included" decks in the ArrayList:
    private ArrayList<String> cumulativeDeck = new ArrayList<>();
    // Declaration of the "pathList" ArrayList, holding the image paths needed for the cards:
    private ArrayList<String> pathList;
    // Declaration of the "shuffleBtn", the button used to kick off the shuffle:
    private JButton shuffleBtn = new JButton("Shuffle Decks");

    // Constructs the initial set up of the window and the objects within the window:
    DeckWindow() {
        // Calls the "windowSettings" method to build the panels and layouts:
        windowSettings();
        // Calls the "cardPanelSettings" method to build the card panel to the right of the buttons and checkboxes:
        cardPanelSettings();
        // Calls the "buildLabel" method to Build the first label text displayed in the window:
        buildLabel();
        // Calls the methods to build the checkboxes, radio buttons, and space in the left Panel:
        buildDominionCbx();
        buildDominionRadBtn();
        buildDominionEd2RadBtn();
        buildDominionLabel();
        buildIntrigueCbx();
        buildIntrigueRadBtn();
        buildIntrigueEd2RadBtn();
        buildIntrigueLabel();
        buildSeasideCbx();
        buildNullLabel();
        buildAlchemyCbx();
        buildNullLabel();
        buildPromoCbx();
        buildNullLabel();
        buildProsperityCbx();
        buildNullLabel();
        buildCornucopiaCbx();
        buildNullLabel();
        buildHinterlandsCbx();
        buildNullLabel();
        buildDarkAgesCbx();
        buildNullLabel();
        buildGuildsCbx();
        buildNullLabel();
        buildEmpiresCbx();
        buildNullLabel();
        buildAdventuresCbx();
        buildNullLabel();
        buildNocturneCbx();
        buildNullLabel();
        buildRenaissanceCbx();
        // Calls the method to build the initial cardPanel, showing 10 cards, "face down":
        buildCardPanel();
        // Calls the method to build a generic error message above the buttons, set invisible until triggered:
        buildErrorMessage();
        // Calls the method to build the shuffleBtn:
        buildShuffleBtn(gui);
        // Calls the method to build the resetBtn:
        buildResetBtn(gui);
    }

    // Constructs the dealPanel, leftPanel, buttonPanel GridLayouts and nests them within windowPanel FlowLayout:
    private void windowSettings() {
        dealPanel.setLayout(new GridLayout(2, 5, 50, 50));
        leftPanel.setLayout(new GridLayout(37,1, 0, 0));
        buttonPanel.setLayout(new GridLayout(1, 1, 20, 0));
        windowPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 60, 40));
        windowPanel.add(leftPanel);
        windowPanel.add(dealPanel);
        //  Sets the FlowLayout for the panels to indent the radio buttons:
        dEd1Panel.setLayout(new FlowLayout(FlowLayout.LEFT,1,1));
        dEd2Panel.setLayout(new FlowLayout(FlowLayout.LEFT,1,1));
        iEd1Panel.setLayout(new FlowLayout(FlowLayout.LEFT,1,1));
        iEd2Panel.setLayout(new FlowLayout(FlowLayout.LEFT,1,1));
    }

    // Constructs the cardPanel, that holds the images of 10 cards, "face down":
    private void cardPanelSettings() {
        windowPanel.add(cardPanel);
        cardPanel.setLayout(new GridLayout(2, 5, 50, 50));
        cardPanel.setVisible(true);
    }

    //  The "buildLabel" method sets the label text, position, alignment, color, and font:
    private void buildLabel() {
        // Declaration of the label (first line)
        JLabel label1;
        // Sets the label text, font size and style, and add the text to the panel.
        label1 = new JLabel("Select checkboxes to include decks:");
        leftPanel.add(label1);
        label1.setFont(new Font("Dialog", Font.BOLD, 20));
    }

    //  The "buildDominionCbx" method sets the checkbox label text, position, and color:
    private void buildDominionCbx() {
        // Declaration of the dominion checkbox, setting the text:
        dominionCbx = new JCheckBox("Dominion Base Deck");
        // Adds the Checkbox to the panel and sets the background color:
        leftPanel.add(dominionCbx);
        dominionCbx.setBackground(Color.lightGray);
        // Sets an action listener which will call the "activatePromo" method, enables text and radio buttons
        dominionCbx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // Calls "activatePromo" method when checkbox is selected
                activatePromo();
                // If checkbox is selected, enable text and radio buttons, selects the "Dominion 2nd Edition" by default
                if (gui.dominionCbx.isSelected()) {
                    dominionRadBtn.setEnabled(true);
                    dominionEd2RadBtn.setEnabled(true);
                    dominionEd2RadBtn.setSelected(true);
                    dominionLabel.setVisible(true);
                }
                // If checkbox is not selected after click, disable the text, radio buttons, and clear and selections
                else {
                    dominionRadBtn.setEnabled(false);
                    dominionRadBtn.setSelected(false);
                    dominionEd2RadBtn.setSelected(false);
                    dominionEd2RadBtn.setEnabled(false);
                    dominionLabel.setVisible(false);
                }
            }
        });
    }

    // The "buildDominionRadBtn" method builds a radio button for the selection of Dominion Edition 1:
    private void buildDominionRadBtn() {
        // Declaration of the label for the radio button for the dominion first edition deck
        dominionRadBtn = new JRadioButton("Dominion Edition 1");
        //  Indents the radio button eight spaces
        indentLabel = new JLabel("        ");
        //  Adds the indentLabel to the dEd1Panel:
        dEd1Panel.add(indentLabel);
        //  Adds the "Dominion Edition 1" radio button to the dEd1Panel:
        dEd1Panel.add(dominionRadBtn);
        //  Adds the "dEd1Panel" to the "leftPanel":
        leftPanel.add(dEd1Panel);
        //  Sets the background color and the default enabled state (disabled by default) of the radio button:
        dominionRadBtn.setBackground(Color.lightGray);
        dominionRadBtn.setEnabled(false);

        // Action listener; when the "Dominion Edition 1" button is selected, the "Dominion Edition 2" button can't be:
        dominionRadBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dominionEd2RadBtn.setSelected(false);
            }
        });
    }

    // The "buildDominionEd2RadBtn" method builds a radio button for the selection of Dominion Edition 2:
    private void buildDominionEd2RadBtn() {
        // Declaration of the label for the radio button for the dominion second edition deck
        dominionEd2RadBtn = new JRadioButton("Dominion Edition 2");
        //  Indents the radio button eight spaces
        indentLabel = new JLabel("        ");
        //  Adds the indentLabel to the dEd2Panel:
        dEd2Panel.add(indentLabel);
        //  Adds the "Dominion Edition 1" radio button to the dEd2Panel:
        dEd2Panel.add(dominionEd2RadBtn);
        //  Adds the "dEd2Panel" to the "leftPanel"
        leftPanel.add(dEd2Panel);
        //  Sets the background color and the default enabled state (disabled by default) of the radio button:
        dominionEd2RadBtn.setBackground(Color.lightGray);
        dominionEd2RadBtn.setEnabled(false);

        // Action listener; when the "Dominion Edition 2" button is selected, the "Dominion Edition 1" button can't be
        dominionEd2RadBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dominionRadBtn.setSelected(false);
            }
        });
    }

    // The "buildDominionLabel" method displays a label in blue text after the "Dominion" checkbox is selected:
    private void buildDominionLabel() {
        // Declares a label instructing the user to select the edition
        dominionLabel = new JLabel("Select the edition of Dominion, if necessary.");
        // Adds label to the "leftPanel":
        leftPanel.add(dominionLabel);
        // Sets background color, font, foreground color, and default visibility (not visible) of the "dominionLabel"
        dominionLabel.setBackground(Color.lightGray);
        dominionLabel.setFont(new Font("Dialog", Font.BOLD, 10));
        dominionLabel.setForeground(Color.BLUE);
        dominionLabel.setVisible(false);
    }

    //  The "buildIntrigueCbx" method sets the checkbox label text, position, and color:
    private void buildIntrigueCbx() {
        // Declaration of the intrigue checkbox, setting the text:
        intrigueCbx = new JCheckBox("Intrigue Deck");
        // Adds the Checkbox to the panel and sets the background color:
        leftPanel.add(intrigueCbx);
        intrigueCbx.setBackground(Color.lightGray);
        // Sets an action listener which will call the "activatePromo" method, enables text and radio buttons
        intrigueCbx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // Calls "activatePromo" method when checkbox is selected
                activatePromo();
                // If checkbox is selected, enable text and radio buttons, selects the "Intrigue 2nd Edition" by default
                if (gui.intrigueCbx.isSelected()) {
                    intrigueRadBtn.setEnabled(true);
                    intrigueEd2RadBtn.setEnabled(true);
                    intrigueEd2RadBtn.setSelected(true);
                    intrigueLabel.setVisible(true);
                }
                // If checkbox is not selected after click, disable the text, radio buttons, and clear and selections
                else {
                    intrigueRadBtn.setEnabled(false);
                    intrigueRadBtn.setSelected(false);
                    intrigueEd2RadBtn.setSelected(false);
                    intrigueEd2RadBtn.setEnabled(false);
                    intrigueLabel.setVisible(false);
                }
            }
        });
    }

    // The "buildIntrigueRadBtn" method builds a radio button for the selection of Intrigue Edition 1:
    private void buildIntrigueRadBtn() {
        // Declaration of the label for the radio button for the Intrigue first edition deck
        intrigueRadBtn = new JRadioButton("Intrigue Edition 1");
        //  Indents the radio button eight spaces
        indentLabel = new JLabel("        ");
        //  Adds the indentLabel to the iEd1Panel:
        iEd1Panel.add(indentLabel);
        //  Adds the "Intrigue Edition 1" radio button to the iEd1Panel:
        iEd1Panel.add(intrigueRadBtn);
        //  Adds the "iEd1Panel" to the "leftPanel":
        leftPanel.add(iEd1Panel);
        //  Sets the background color and the default enabled state (disabled by default) of the radio button:
        intrigueRadBtn.setBackground(Color.lightGray);
        intrigueRadBtn.setEnabled(false);

        // Action listener; when the "Intrigue Edition 2" button is selected, the "Intrigue Edition 1" button can't be:
        intrigueRadBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                intrigueEd2RadBtn.setSelected(false);
            }
        });
    }

    // The "buildIntrigueEd2RadBtn" method builds a radio button for the selection of Intrigue Edition 2:
    private void buildIntrigueEd2RadBtn() {
        // Declaration of the label for the radio button for the Intrigue second edition deck
        intrigueEd2RadBtn = new JRadioButton("Intrigue Edition 2");
        //  Indents the radio button eight spaces
        indentLabel = new JLabel("        ");
        //  Adds the indentLabel to the iEd2Panel:
        iEd2Panel.add(indentLabel);
        //  Adds the "Intrigue Edition 2" radio button to the iEd1Panel:
        iEd2Panel.add(intrigueEd2RadBtn);
        //  Adds the "iEd2Panel" to the "leftPanel":
        leftPanel.add(iEd2Panel);
        //  Sets the background color and the default enabled state (disabled by default) of the radio button:
        intrigueEd2RadBtn.setBackground(Color.lightGray);
        intrigueEd2RadBtn.setEnabled(false);

        // Action listener; when the "Intrigue Edition 1" button is selected, the "Intrigue Edition 2" button can't be:
        intrigueEd2RadBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                intrigueRadBtn.setSelected(false);
            }
        });
    }

    private void buildIntrigueLabel() {
        // Declares a label instructing the user to select the edition
        intrigueLabel = new JLabel("Select the edition of Intrigue, if necessary.");
        // Adds label to the "leftPanel":
        leftPanel.add(intrigueLabel);
        // Sets background color, font, foreground color, and default visibility (not visible) of the "intrigueLabel"
        intrigueLabel.setBackground(Color.lightGray);
        intrigueLabel.setFont(new Font("Dialog", Font.BOLD, 10));
        intrigueLabel.setForeground(Color.BLUE);
        intrigueLabel.setVisible(false);
    }

    //  The "buildSeasideCbx" method sets the checkbox label text, position, and color:
    private void buildSeasideCbx() {
        seasideCbx = new JCheckBox("Seaside Deck");
        leftPanel.add(seasideCbx);
        seasideCbx.setBackground(Color.lightGray);

        seasideCbx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                activatePromo();
            }
        });
    }

    //  The "buildNullLabel" method builds and empty label with spaces:
    private void buildNullLabel() {
        //  Declares a label of spaces:
        JLabel nullLabel = new JLabel("   ");
        //  Adds the label to the "leftPanel".
        leftPanel.add(nullLabel);
    }

    //  The "buildAlchemyCbx" method sets the checkbox label text, position, and color:
    private void buildAlchemyCbx() {
        alchemyCbx = new JCheckBox("Alchemy Deck");
        leftPanel.add(alchemyCbx);
        alchemyCbx.setBackground(Color.lightGray);

        // Action listener disables/enables the Promo cards if the deck checkbox is the only box deselected/selected:
        alchemyCbx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                activatePromo();
            }
        });
    }

    //  The "buildPromoCbx" method sets the checkbox label text, position, and color, disabled by default:
    private void buildPromoCbx() {
        promoCbx = new JCheckBox("Promo Cards");
        leftPanel.add(promoCbx);
        promoCbx.setBackground(Color.lightGray);
        //  Promo checkbox is disabled by default.  Requires at least one other deck to be selected:
        promoCbx.setEnabled(false);
    }

    //  The "buildProsperityCbx" method sets the checkbox label text, position, and color:
    private void buildProsperityCbx() {
        prosperityCbx = new JCheckBox("Prosperity Deck");
        leftPanel.add(prosperityCbx);
        prosperityCbx.setBackground(Color.lightGray);

        // Action listener disables/enables the Promo cards if the deck checkbox is the only box deselected/selected:
        prosperityCbx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                activatePromo();
            }
        });
    }

    //  The "buildCornucopiaCbx" method sets the checkbox label text, position, and color:
    private void buildCornucopiaCbx() {
        cornucopiaCbx = new JCheckBox("Cornucopia Deck");
        leftPanel.add(cornucopiaCbx);
        cornucopiaCbx.setBackground(Color.lightGray);

        // Action listener disables/enables the Promo cards if the deck checkbox is the only box deselected/selected:
        cornucopiaCbx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                activatePromo();
            }
        });
    }

    //  The "buildHinterlandsCbx" method sets the checkbox label text, position, and color:
    private void buildHinterlandsCbx() {
        hinterlandsCbx = new JCheckBox("Hinterlands Deck");
        leftPanel.add(hinterlandsCbx);
        hinterlandsCbx.setBackground(Color.lightGray);

        // Action listener disables/enables the Promo cards if the deck checkbox is the only box deselected/selected:
        hinterlandsCbx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                activatePromo();
            }
        });
    }

    //  The "buildDarkAgesCbx" method sets the checkbox label text, position, and color:
    private void buildDarkAgesCbx() {
        darkAgesCbx = new JCheckBox("Dark Ages Deck");
        leftPanel.add(darkAgesCbx);
        darkAgesCbx.setBackground(Color.lightGray);

        // Action listener disables/enables the Promo cards if the deck checkbox is the only box deselected/selected:
        darkAgesCbx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                activatePromo();
            }
        });
    }

    //  The "buildGuildsCbx" method sets the checkbox label text, position, and color:
    private void buildGuildsCbx() {
        guildsCbx = new JCheckBox("Guilds Deck");
        leftPanel.add(guildsCbx);
        guildsCbx.setBackground(Color.lightGray);

        // Action listener disables/enables the Promo cards if the deck checkbox is the only box deselected/selected:
        guildsCbx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                activatePromo();
            }
        });
    }

    //  The "buildEmpiresCbx" method sets the checkbox label text, position, and color:
    private void buildEmpiresCbx() {
        empiresCbx = new JCheckBox("Empires Deck");
        leftPanel.add(empiresCbx);
        empiresCbx.setBackground(Color.lightGray);

        // Action listener disables/enables the Promo cards if the deck checkbox is the only box deselected/selected:
        empiresCbx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                activatePromo();
            }
        });
    }

    //  The "buildAdventuresCbx" method sets the checkbox label text, position, and color:
    private void buildAdventuresCbx() {
        adventuresCbx = new JCheckBox("Adventures Deck");
        leftPanel.add(adventuresCbx);
        adventuresCbx.setBackground(Color.lightGray);

        // Action listener disables/enables the Promo cards if the deck checkbox is the only box deselected/selected:
        adventuresCbx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                activatePromo();
            }
        });
    }

    //  The "buildNocturneCbx" method sets the checkbox label text, position, and color:
    private void buildNocturneCbx() {
        nocturneCbx = new JCheckBox("Nocturne Deck");
        leftPanel.add(nocturneCbx);
        nocturneCbx.setBackground(Color.lightGray);

        // Action listener disables/enables the Promo cards if the deck checkbox is the only box deselected/selected:
        nocturneCbx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                activatePromo();
            }
        });
    }

    //  The "buildRenaissanceCbx" method sets the checkbox label text, position, and color:
    private void buildRenaissanceCbx() {
        renaissanceCbx = new JCheckBox("Renaissance Deck");
        leftPanel.add(renaissanceCbx);
        renaissanceCbx.setBackground(Color.lightGray);

        // Action listener disables/enables the Promo cards if the deck checkbox is the only box deselected/selected:
        renaissanceCbx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                activatePromo();
            }
        });
    }

    /* The "activatePromo" method activates both the "Promo Cards" checkbox and the "Shuffle" button when at least one
    other checkbox is selected:*/
    private void activatePromo() {
        if (dominionCbx.isSelected() | intrigueCbx.isSelected() | seasideCbx.isSelected() | alchemyCbx.isSelected() |
                prosperityCbx.isSelected() | cornucopiaCbx.isSelected() | hinterlandsCbx.isSelected() |
                darkAgesCbx.isSelected() | guildsCbx.isSelected() | empiresCbx.isSelected() | adventuresCbx.isSelected()
                | nocturneCbx.isSelected() | renaissanceCbx.isSelected()) {
            promoCbx.setEnabled(true);
            shuffleBtn.setEnabled(true);
        }
        else {
            promoCbx.setEnabled(false);
            shuffleBtn.setEnabled(false);
        }
    }

    // Builds the card panel to display the backs of the cards initially:
    private void buildCardPanel() {
        String defaultImage = "/home/xpanxion/IdeaProjects/Dominion/src/com/dominion/DominionProject/Randomizer/backside_blue.jpg";

        card1 = new ImageIcon(defaultImage);
        c1 = new JLabel(card1);
        cardPanel.add(c1);

        card2 = new ImageIcon(defaultImage);
        c2 = new JLabel(card2);
        cardPanel.add(c2);

        card3 = new ImageIcon(defaultImage);
        c3 = new JLabel(card3);
        cardPanel.add(c3);

        card4 = new ImageIcon(defaultImage);
        c4 = new JLabel(card4);
        cardPanel.add(c4);

        card5 = new ImageIcon(defaultImage);
        c5 = new JLabel(card5);
        cardPanel.add(c5);

        card6 = new ImageIcon(defaultImage);
        c6 = new JLabel(card6);
        cardPanel.add(c6);

        card7 = new ImageIcon(defaultImage);
        c7 = new JLabel(card7);
        cardPanel.add(c7);

        card8 = new ImageIcon(defaultImage);
        c8 = new JLabel(card8);
        cardPanel.add(c8);

        card9 = new ImageIcon(defaultImage);
        c9 = new JLabel(card9);
        cardPanel.add(c9);

        card10 = new ImageIcon(defaultImage);
        c10 = new JLabel(card10);
        cardPanel.add(c10);
    }

    // Adds a space with a generic error message that displays above the buttons if something crashes:
    private void buildErrorMessage() {
        String errorMessage = "Something unexpected happened.  Try Again.";

        label3 = new JLabel(errorMessage);
        label3.setVerticalAlignment(1);
        label3.setForeground(Color.red);
        label3.setVisible(false);
        leftPanel.add(label3);
    }

    //  The "buildShuffleBtn" method sets the button label text, position, color, and a listener:
    private void buildShuffleBtn(DeckWindow gui) {
        // Reference to the active window:
        this.gui = gui;

        shuffleBtn.setBackground(Color.GRAY);
        shuffleBtn.setSize(20, 100);
        shuffleBtn.setEnabled(false);
        buttonPanel.add(shuffleBtn);
        leftPanel.add(buttonPanel);

        // Action listener for clicking the "shuffleBtn":
        shuffleBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //  If no decks are selected, display an error message, remove panels, call clearCheckboxes, method
                if (!dominionCbx.isSelected() & !intrigueCbx.isSelected() & !seasideCbx.isSelected() &
                        !alchemyCbx.isSelected() & !promoCbx.isSelected() & !prosperityCbx.isSelected() &
                        !cornucopiaCbx.isSelected() & !hinterlandsCbx.isSelected() & !darkAgesCbx.isSelected() &
                        !guildsCbx.isSelected() & !empiresCbx.isSelected() & !adventuresCbx.isSelected() &
                        !nocturneCbx.isSelected() & !renaissanceCbx.isSelected()) {
                    label3.setVisible(true);
                    windowPanel.removeAll();
                    windowPanel.add(leftPanel);
                    windowPanel.add(cardPanel);
                    clearCheckboxes();
                    validate();
                    repaint();
                }

                else {
                    //Call "accumulateDeck" method; do not display error message, or enable Promo box or Shuffle btn:
                    label3.setVisible(false);
                    promoCbx.setEnabled(false);
                    shuffleBtn.setEnabled(false);
                    accumulateDeck();
                    // Call the "shuffleDeck" method to shuffle the "cumulativeDeck":
                    shuffleDeck();
                    // Call the "dealDeck" method to deal the first 10 cards:
                    dealDeck();
                    // Call the "removeCardPanel" method to clear the previous cards from the card panel:
                    removeCardPanel();
                    // Call the "buildDealPanel" method to display the cards resulting from the "dealDeck" method:
                    buildDealPanel();
                    // Call the "windowSettings" method to add the panels to the layouts in the correct sequence:
                    windowSettings();
                    // Call "clearCheckboxes" method to clear checkboxes and radio buttons; restore defaults:
                    clearCheckboxes();
                    // Call the "clearArrayLists" method to generate subsequent decks with new information:
                    clearArrayLists();
                    // Call "validate()" to apply the changes to the active gui window:
                    validate();
                    // Call "repaint()" to re-draw the active gui window:
                    repaint();
                }
            }
        });
    }

    //  The "buildResetBtn" method sets the button label text, position, color, and a listener:
    private void buildResetBtn(DeckWindow gui) {
        // Reference to the active window:
        this.gui = gui;
        // Declaration of the "Reset" button variable:
        JButton resetBtn;

        // Sets an instance of the "Reset" button and corresponding label text, background color, and size:
        resetBtn = new JButton("Reset");
        resetBtn.setBackground(Color.GRAY);
        resetBtn.setSize(20, 100);
        // Adds the "Reset" button to the "buttonPanel":
        buttonPanel.add(resetBtn);
        // Adds the "buttonPanel" to the "leftPanel":
        leftPanel.add(buttonPanel);
        // Action listener for clicking the "resetBtn":
        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //  Set the error label to invisible, disable "Promo" box and "Shuffle" button:
                label3.setVisible(false);
                promoCbx.setEnabled(false);
                shuffleBtn.setEnabled(false);
                // Call the "removeCardPanel" method to clear the previous cards from the card panel:
                removeCardPanel();
                // Call the "windowSettings" method to add the panels to the layouts in the correct sequence:
                windowSettings();
                // Call the "cardPanelSettings" method to add the card panel in the correct sequence:
                cardPanelSettings();
                // Call the "buildCardPanel" method to restore the default "face down" cards:
                buildCardPanel();
                // Call "clearCheckboxes" method to clear checkboxes and radio buttons; restore defaults:
                clearCheckboxes();
                // Call "validate()" to apply the changes to the active gui window:
                validate();
                // Call "repaint()" to re-draw the active gui window:
                repaint();
            }
        });
    }

    // Deselects all of the checkboxes and radio buttons, sets certain text to invisible:
    private void clearCheckboxes() {
        dominionCbx.setSelected(false);
        dominionLabel.setVisible(false);
        dominionRadBtn.setSelected(false);
        dominionRadBtn.setEnabled(false);
        dominionRadBtn.setSelected(false);
        dominionEd2RadBtn.setSelected(false);
        dominionEd2RadBtn.setEnabled(false);
        intrigueLabel.setVisible(false);
        intrigueRadBtn.setEnabled(false);
        intrigueEd2RadBtn.setSelected(false);
        intrigueRadBtn.setSelected(false);
        intrigueEd2RadBtn.setEnabled(false);
        intrigueCbx.setSelected(false);
        seasideCbx.setSelected(false);
        alchemyCbx.setSelected(false);
        promoCbx.setSelected(false);
        prosperityCbx.setSelected(false);
        cornucopiaCbx.setSelected(false);
        hinterlandsCbx.setSelected(false);
        darkAgesCbx.setSelected(false);
        guildsCbx.setSelected(false);
        empiresCbx.setSelected(false);
        adventuresCbx.setSelected(false);
        nocturneCbx.setSelected(false);
        renaissanceCbx.setSelected(false);
    }

    // Generates the "cumulativeDeck" ArrayList based on which checkboxes/radio buttons were selected:
    private void accumulateDeck() {
        // Sets the "deck" variable:
        Deck deck;

        // If the "Dominion Edition 1" radio button is selected, it is added to the "cumulativeDeck":
        if (gui.dominionRadBtn.isSelected()) {
            deck = new Deck();
            deck.setDeck("Dominion");
            cumulativeDeck.addAll(deck.deckListOfCards);
        }
        // If the "Dominion Edition 2" radio button is selected, it is added to the "cumulativeDeck":
        if (gui.dominionEd2RadBtn.isSelected()) {
            deck = new Deck();
            deck.setDeck("DominionEd2");
            cumulativeDeck.addAll(deck.deckListOfCards);
        }
        // If the "Intrigue Edition 1" radio button is selected, it is added to the "cumulativeDeck":
        if (gui.intrigueRadBtn.isSelected()) {
            deck = new Deck();
            deck.setDeck("Intrigue");
            cumulativeDeck.addAll(deck.deckListOfCards);
        }
        // If the "Intrigue Edition 2" radio button is selected, it is added to the "cumulativeDeck":
        if (gui.intrigueEd2RadBtn.isSelected()) {
            deck = new Deck();
            deck.setDeck("IntrigueEd2");
            cumulativeDeck.addAll(deck.deckListOfCards);
        }
        // If the "Seaside Deck" checkbox is selected, it is added to the "cumulativeDeck":
        if (gui.seasideCbx.isSelected()) {
            deck = new Deck();
            deck.setDeck("Seaside");
            cumulativeDeck.addAll(deck.deckListOfCards);
        }
        // If the "Alchemy Deck" checkbox is selected, it is added to the "cumulativeDeck":
        if (gui.alchemyCbx.isSelected()) {
            deck = new Deck();
            deck.setDeck("Alchemy");
            cumulativeDeck.addAll(deck.deckListOfCards);
        }
        // If the "Promo Cards" checkbox is selected, it is added to the "cumulativeDeck":
        if (gui.promoCbx.isSelected()) {
            deck = new Deck();
            deck.setDeck("Promo Cards");
            cumulativeDeck.addAll(deck.deckListOfCards);
        }
        // If the "Prosperity Deck" checkbox is selected, it is added to the "cumulativeDeck":
        if (gui.prosperityCbx.isSelected()) {
            deck = new Deck();
            deck.setDeck("Prosperity");
            cumulativeDeck.addAll(deck.deckListOfCards);
        }
        // If the "Cornucopia Deck" checkbox is selected, it is added to the "cumulativeDeck":
        if (gui.cornucopiaCbx.isSelected()) {
            deck = new Deck();
            deck.setDeck("Cornucopia");
            cumulativeDeck.addAll(deck.deckListOfCards);
        }
        // If the "Hinterlands Deck" checkbox is selected, it is added to the "cumulativeDeck":
        if (gui.hinterlandsCbx.isSelected()) {
            deck = new Deck();
            deck.setDeck("Hinterlands");
            cumulativeDeck.addAll(deck.deckListOfCards);
        }
        // If the "Dark Ages Deck" checkbox is selected, it is added to the "cumulativeDeck":
        if (gui.darkAgesCbx.isSelected()) {
            deck = new Deck();
            deck.setDeck("Dark Ages");
            cumulativeDeck.addAll(deck.deckListOfCards);
        }
        // If the "Guilds Deck" checkbox is selected, it is added to the "cumulativeDeck":
        if (gui.guildsCbx.isSelected()) {
            deck = new Deck();
            deck.setDeck("Guilds");
            cumulativeDeck.addAll(deck.deckListOfCards);
        }
        // If the "Empires Deck" checkbox is selected, it is added to the "cumulativeDeck":
        if (gui.empiresCbx.isSelected()) {
            deck = new Deck();
            deck.setDeck("Empires");
            cumulativeDeck.addAll(deck.deckListOfCards);
        }
        // If the "Adventures Deck" checkbox is selected, it is added to the "cumulativeDeck":
        if (gui.adventuresCbx.isSelected()) {
            deck = new Deck();
            deck.setDeck("Adventures");
            cumulativeDeck.addAll(deck.deckListOfCards);
        }
        // If the "Nocturne Deck" checkbox is selected, it is added to the "cumulativeDeck":
        if (gui.nocturneCbx.isSelected()) {
            deck = new Deck();
            deck.setDeck("Nocturne");
            cumulativeDeck.addAll(deck.deckListOfCards);
        }
        // If the "Renaissance Deck" checkbox is selected, it is added to the "cumulativeDeck":
        if (gui.renaissanceCbx.isSelected()) {
            deck = new Deck();
            deck.setDeck("Renaissance");
            cumulativeDeck.addAll(deck.deckListOfCards);
        }
    }

    // Method that shuffles the entire "cumulativeDeck" array:
    private void shuffleDeck() {
        Collections.shuffle(cumulativeDeck);
    }

    /* Method that deals the first ten elements of the "cumulativeDeck" array, displays console output and builds the
    "pathList" Array*/
    private void dealDeck() {

        // Declare a "card" variable
        Card card;
        // Create a new instance of the "pathList" ArrayList:
        pathList = new ArrayList();

        // If the cumulative deck is null, display the "face down" default image for each card:
        if (cumulativeDeck == null) {
            String defaultImage = "/home/xpanxion/IdeaProjects/Dominion/src/com/dominion/DominionProject/Randomizer/backside_blue.jpg";
            // For loop displaying the first 10 cards:
            for (int cardNumber = 0; cardNumber < 10; cardNumber++) {
                System.out.println(defaultImage);
                pathList.add(defaultImage);
            }
        }
        else {
            // For loop displaying the first 10 cards:
            for (int cardNumber = 0; cardNumber < 10; cardNumber++) {
                System.out.println(cumulativeDeck.get(cardNumber));
                card = new Card();
                card.name = cumulativeDeck.get(cardNumber);
                card.setCard();
                // Populates the "pathList" ArrayList with each image path
                pathList.add(card.image);
            }
        }
    }

    // Method that removes the card Panel:
    private void removeCardPanel() {
        //  Sets the "cardPanel" panel invisible, and removes all from the "cardPanel" and the "dealPanel":
        cardPanel.setVisible(false);
        cardPanel.removeAll();
        dealPanel.removeAll();
    }

    // Method that replaces the "face down" cards with the images from the "pathList" ArrayList:
    private void buildDealPanel() {
        //  Sets the image for "card1" as the first element in the filepath ArrayList:
        card1 = new ImageIcon(pathList.get(0));
        c1 = new JLabel(card1);
        dealPanel.add(c1);
        //  Sets the image for "card2" as the second element in the filepath ArrayList:
        card2 = new ImageIcon(pathList.get(1));
        c2 = new JLabel(card2);
        dealPanel.add(c2);
        //  Sets the image for "card3" as the third element in the filepath ArrayList:
        card3 = new ImageIcon(pathList.get(2));
        c3 = new JLabel(card3);
        dealPanel.add(c3);
        //  Sets the image for "card4" as the fourth element in the filepath ArrayList:
        card4 = new ImageIcon(pathList.get(3));
        c4 = new JLabel(card4);
        dealPanel.add(c4);
        //  Sets the image for "card5" as the fifth element in the filepath ArrayList:
        card5 = new ImageIcon(pathList.get(4));
        c5 = new JLabel(card5);
        dealPanel.add(c5);
        //  Sets the image for "card6" as the sixth element in the filepath ArrayList:
        card6 = new ImageIcon(pathList.get(5));
        c6 = new JLabel(card6);
        dealPanel.add(c6);
        //  Sets the image for "card7" as the seventh element in the filepath ArrayList:
        card7 = new ImageIcon(pathList.get(6));
        c7 = new JLabel(card7);
        dealPanel.add(c7);
        //  Sets the image for "card8" as the eighth element in the filepath ArrayList:
        card8 = new ImageIcon(pathList.get(7));
        c8 = new JLabel(card8);
        dealPanel.add(c8);
        //  Sets the image for "card9" as the ninth element in the filepath ArrayList:
        card9 = new ImageIcon(pathList.get(8));
        c9 = new JLabel(card9);
        dealPanel.add(c9);
        //  Sets the image for "card10" as the tenth element in the filepath ArrayList:
        card10 = new ImageIcon(pathList.get(9));
        c10 = new JLabel(card10);
        dealPanel.add(c10);
    }

    // Method that clears the ArrayLists "cumulativeDeck" and "pathList" for subsequent shuffles:
    private void clearArrayLists() {
        cumulativeDeck.clear();
        pathList.clear();
    }

    // Method that builds the window:
    void buildWindow(DeckWindow gui) {
        this.gui = gui;
        // DeckWindow gui = new DeckWindow();
        gui.setBackground(Color.lightGray);
        gui.add(windowPanel);

        JFrame jf = new JFrame();

        jf.setTitle("Kingdom Deck");
        jf.setSize(1920, 1080);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setBackground(Color.lightGray);
        jf.setVisible(true);
        jf.add(gui);
    }
}