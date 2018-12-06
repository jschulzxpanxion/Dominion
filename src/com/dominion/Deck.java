package com.dominion;

import java.util.*;

class Deck {
    // Fields of the class "Deck":
    private String deckType;
    private ArrayList<String> deckListOfCards;
    private ArrayList<String> cumulativeDeck = new ArrayList<>();
    private ArrayList<String> pathList = new ArrayList<>();
    private int includeDominionBaseDeck, includeIntrigueDeck, includeSeasideDeck, includeAlchemyDeck, includePromoDeck,
            includeProsperityDeck, includeCornucopiaDeck, includeHinterlandsDeck, includeDarkAgesDeck,
            includeGuildsDeck, includeAdventuresDeck, includeEmpiresDeck, includeNocturneDeck,
            includeRenaissanceDeck;

    // Constructor
    Deck() {
        deckType = null;
        deckListOfCards = null;
    }

    // Mutator method setting the Deck Type
    private void setDeckType(String deckType) {
        this.deckType = deckType;
    }

    // Mutator setting the Codes
    void setCodes(ArrayList codes) {
        // create an Array to store ArrayList values
        String[] codeArray = new String[codes.size()];
        // convert the ArrayList to an Array
        codes.toArray(codeArray);
        deckListOfCards.addAll(Arrays.asList(codeArray));

        generateCodeArray();

        // Call the "accumulateDeck" method
        accumulateDeck();

        // Call the "shuffleDeck" method to shuffle the
        shuffleDeck();

        // Call the "dealDeck" method to deal the first 10 cards
        dealDeck();

        // Call the "generateWindow method to build the Deck Window
        generateWindow();
    }

    private void generateCodeArray() {
        // Logic used to code the deck based on the values in the "codeArray" passed in from user input:
        if (deckListOfCards.get(0).equalsIgnoreCase("y")) includeDominionBaseDeck = 2;
        else if (deckListOfCards.get(0).equalsIgnoreCase("n")) includeDominionBaseDeck = 1;
        else includeDominionBaseDeck = 0;

        if (deckListOfCards.get(1).equalsIgnoreCase("y")) includeIntrigueDeck = 2;
        else if (deckListOfCards.get(1).equalsIgnoreCase("n")) includeIntrigueDeck = 1;
        else includeIntrigueDeck = 0;

        if (deckListOfCards.get(2).equalsIgnoreCase("y")) includeSeasideDeck = 2;
        else if (deckListOfCards.get(2).equalsIgnoreCase("n")) includeSeasideDeck = 1;
        else includeSeasideDeck = 0;

        if (deckListOfCards.get(3).equalsIgnoreCase("y")) includeAlchemyDeck = 2;
        else if (deckListOfCards.get(3).equalsIgnoreCase("n")) includeAlchemyDeck = 1;
        else includeAlchemyDeck = 0;

        if (deckListOfCards.get(4).equalsIgnoreCase("y")) includePromoDeck = 2;
        else if (deckListOfCards.get(4).equalsIgnoreCase("n")) includePromoDeck = 1;
        else includePromoDeck = 0;

        if (deckListOfCards.get(5).equalsIgnoreCase("y")) includeProsperityDeck = 2;
        else if (deckListOfCards.get(5).equalsIgnoreCase("n")) includeProsperityDeck = 1;
        else includeProsperityDeck = 0;

        if (deckListOfCards.get(6).equalsIgnoreCase("y")) includeCornucopiaDeck = 2;
        else if (deckListOfCards.get(6).equalsIgnoreCase("n")) includeCornucopiaDeck = 1;
        else includeCornucopiaDeck = 0;

        if (deckListOfCards.get(7).equalsIgnoreCase("y")) includeHinterlandsDeck = 2;
        else if (deckListOfCards.get(7).equalsIgnoreCase("n")) includeHinterlandsDeck = 1;
        else includeHinterlandsDeck = 0;

        if (deckListOfCards.get(8).equalsIgnoreCase("y")) includeDarkAgesDeck = 2;
        else if (deckListOfCards.get(8).equalsIgnoreCase("n")) includeDarkAgesDeck = 1;
        else includeDarkAgesDeck = 0;

        if (deckListOfCards.get(9).equalsIgnoreCase("y")) includeGuildsDeck = 2;
        else if (deckListOfCards.get(9).equalsIgnoreCase("n")) includeGuildsDeck = 1;
        else includeGuildsDeck = 0;

        if (deckListOfCards.get(10).equalsIgnoreCase("y")) includeEmpiresDeck = 2;
        else if (deckListOfCards.get(10).equalsIgnoreCase("n")) includeEmpiresDeck = 1;
        else includeEmpiresDeck = 0;

        if (deckListOfCards.get(11).equalsIgnoreCase("y")) includeAdventuresDeck = 2;
        else if (deckListOfCards.get(11).equalsIgnoreCase("n")) includeAdventuresDeck = 1;
        else includeAdventuresDeck = 0;

        if (deckListOfCards.get(12).equalsIgnoreCase("y")) includeNocturneDeck = 2;
        else if (deckListOfCards.get(12).equalsIgnoreCase("n")) includeNocturneDeck = 1;
        else includeNocturneDeck = 0;

        if (deckListOfCards.get(13).equalsIgnoreCase("y")) includeRenaissanceDeck = 2;
        else if (deckListOfCards.get(13).equalsIgnoreCase("n")) includeRenaissanceDeck = 1;
        else includeRenaissanceDeck = 0;
    }

    private void accumulateDeck() {
        if (includeDominionBaseDeck == 2) {
            setDeckType("Dominion");
            ArrayList<String> dominionList = new ArrayList<>();
            dominionList.addAll(Arrays.asList("Adventurer", "Bureaucrat", "Cellar", "Chancellor", "Chapel",
                    "Council Room", "Feast", "Festival", "Gardens", "Laboratory", "Library", "Market", "Militia",
                    "Mine", "Moat", "Moneylender", "Remodel", "Smithy", "Spy", "Thief", "Throne Room", "Village",
                    "Witch", "Woodcutter", "Workshop"));
            cumulativeDeck.addAll(dominionList);
        }

        if (includeIntrigueDeck == 2) {
            setDeckType("Intrigue");
            ArrayList<String> intrigueList = new ArrayList<>();
            intrigueList.addAll(Arrays.asList("Baron", "Bridge", "Conspirator", "Coppersmith", "Courtyard",
                    "Duke", "Great Hall", "Harem", "Ironworks", "Masquerade", "Mining Village", "Minion", "Nobles",
                    "Pawn", "Saboteur", "Scout", "Secret Chamber", "Shanty Town", "Steward", "Swindler", "Torturer",
                    "Trading Post", "Tribute", "Upgrade", "Wishing Well"));
            cumulativeDeck.addAll(intrigueList);
        }

        if (includeSeasideDeck == 2) {
            setDeckType("Seaside");
            ArrayList<String> seasideList = new ArrayList<>();
            seasideList.addAll(Arrays.asList("Ambassador", "Bazaar", "Caravan", "Cutpurse", "Embargo", "Explorer",
                    "Fishing Village", "Ghost Ship", "Haven", "Island", "Lighthouse", "Lookout", "Merchant Ship",
                    "Native Village", "Navigator", "Outpost", "Pearl Diver", "Pirate Ship", "Salvager", "Sea Hag",
                    "Smugglers", "Tactician", "Treasure Map", "Treasury", "Warehouse", "Wharf"));
            cumulativeDeck.addAll(seasideList);
        }

        if (includeAlchemyDeck == 2) {
            setDeckType("Alchemy");
            ArrayList<String> alchemyList = new ArrayList<>();
            alchemyList.addAll(Arrays.asList("Alchemist", "Apothecary", "Apprentice", "Familiar", "Golem",
                    "Herbalist", "Philosopher's Stone", "Possession", "Scrying Pool", "Transmute", "University",
                    "Vineyard"));
            cumulativeDeck.addAll(alchemyList);
        }

        if (includePromoDeck == 2) {
            setDeckType("Promo Cards");
            ArrayList<String> promoList = new ArrayList<>();
            promoList.addAll(Arrays.asList("Avanto", "Black Market", "Dismantle", "Envoy", "Governor",
                    "Prince", "Sauna", "Stash", "Walled Village"));
            cumulativeDeck.addAll(promoList);
        }

        if (includeProsperityDeck == 2) {
            setDeckType("Prosperity");
            ArrayList<String> prosperityList = new ArrayList<>();
            prosperityList.addAll(Arrays.asList("Bank", "Bishop", "City", "Contraband", "Counting House", "Expand",
                    "Forge", "Goons", "Grand Market", "Hoard", "King's Court", "Loan", "Mint", "Monument", "Mountebank",
                    "Peddler", "Quarry", "Rabble", "Royal Seal", "Talisman", "Trade Route", "Vault", "Vault", "Venture",
                    "Watchtower", "Worker's Village"));
            cumulativeDeck.addAll(prosperityList);
        }

        if (includeCornucopiaDeck == 2) {
            setDeckType("Cornucopia");
            ArrayList<String> cornucopiaList = new ArrayList<>();
            cornucopiaList.addAll(Arrays.asList("Fairgrounds", "Farming Village", "Fortune Teller", "Hamlet",
                    "Harvest", "Horn of Plenty", "Horse Traders", "Hunting Party", "Jester", "Menagerie", "Remake",
                    "Tournament", "Young Witch"));
            cumulativeDeck.addAll(cornucopiaList);
        }

        if (includeHinterlandsDeck == 2) {
            setDeckType("Hinterlands");
            ArrayList<String> hinterlandsList = new ArrayList<>();
            hinterlandsList.addAll(Arrays.asList("Border Village", "Cache", "Cartographer", "Crossroads", "Develop",
                    "Duchess", "Embassy", "Farmland", "Fool's Gold", "Haggler", "Highway", "Ill-Gotten Gains", "Inn",
                    "Jack of All Trades", "Mandarin", "Margrave", "Noble Brigand", "Nomad Camp", "Oasis", "Oracle",
                    "Scheme", "Silk Road", "Spice Merchant", "Stables", "Trader", "Tunnel"));
            cumulativeDeck.addAll(hinterlandsList);
        }

        if (includeDarkAgesDeck == 2) {
            setDeckType("Dark Ages");
            ArrayList<String> darkAgesList = new ArrayList<>();
            darkAgesList.addAll(Arrays.asList("Altar", "Armory", "Band of Misfits", "Bandit Camp", "Beggar",
                    "Catacombs", "Count", "Counterfeit", "Cultist", "Death Cart", "Feodum", "Forager", "Fortress",
                    "Graverobber", "Hermit", "Hunting Grounds", "Ironmonger", "Junk Dealer", "Knights", "Marauder",
                    "Market Square", "Mystic", "Pillage", "Poor House", "Procession", "Rats", "Rebuild", "Rogue",
                    "Sage", "Scavenger", "Squire", "Storeroom", "Urchin", "Vagrant", "Wandering Minstrel"));
            cumulativeDeck.addAll(darkAgesList);
        }

        if (includeGuildsDeck == 2) {
            setDeckType("Guilds");
            ArrayList<String> guildsList = new ArrayList<>();
            guildsList.addAll(Arrays.asList("Advisor", "Baker", "Butcher", "Candlestick Maker", "Doctor",
                    "Herald", "Journeyman", "Masterpiece", "Merchant Guild", "Plaza", "Soothsayer", "Stonemason",
                    "Taxman"));
            cumulativeDeck.addAll(guildsList);
        }

        if (includeEmpiresDeck == 2) {
            setDeckType("Empires");
            ArrayList<String> empiresList = new ArrayList<>();
            empiresList.addAll(Arrays.asList("Archive", "Bustling Village", "Capital", "Castles", "Catapult",
                    "Chariot Race", "Charm", "City Quarter", "Crown", "Emporium", "Encampment", "Enchantress",
                    "Engineer", "Farmer's Market", "Fortune", "Forum", "Gladiator", "Groundskeeper", "Legionary",
                    "Patrician", "Plunder", "Rocks", "Royal Blacksmith", "Sacrifice", "Settlers", "Temple", "Villa",
                    "Wild Hunt"));
            cumulativeDeck.addAll(empiresList);
        }

        if (includeAdventuresDeck == 2) {
            setDeckType("Adventures");
            ArrayList<String> adventuresList = new ArrayList<>();
            adventuresList.addAll(Arrays.asList("Amulet", "Artificer", "Bridge Troll", "Coin of the Realm",
                    "Distant Lands", "Dungeon", "Duplicate", "Gear", "Guide", "Haunted Woods", "Hireling", "Lost City",
                    "Magpie", "Messenger", "Miser", "Page", "Peasant", "Port", "Ranger", "Ratcatcher", "Raze", "Relic",
                    "Royal Carriage", "Storyteller", "Swamp Hag", "Transmogrify", "Treasure Trove", "Wine Merchant"));
            cumulativeDeck.addAll(adventuresList);
        }

        if (includeNocturneDeck == 2) {
            setDeckType("Nocturne");
            ArrayList<String> nocturneList = new ArrayList<>();
            nocturneList.addAll(Arrays.asList("Bard", "Blessed Village", "Cemetery", "Changeling", "Cobbler",
                    "Conclave", "Crypt", "Cursed Village", "Den of Sin", "Devil's Workshop", "Druid", "Exorcist",
                    "Faithful Hound", "Fool", "Guardian", "Ghost Town", "Idol", "Leprechaun", "Monastery",
                    "Necromancer", "Night Watchman", "Pixie", "Pooka", "Raider", "Sacred Grove", "Secret Cave",
                    "Shepherd", "Skulk", "Tormentor", "Tracker", "Tragic Hero", "Vampire", "Werewolf"));
            cumulativeDeck.addAll(nocturneList);
        }

        if (includeRenaissanceDeck == 2) {
            setDeckType("Renaissance");
            ArrayList<String> renaissanceList = new ArrayList<>();
            renaissanceList.addAll(Arrays.asList("Acting Troupe", "Border Guard", "Cargo Ship", "Ducat", "Experiment",
                    "Flag Bearer", "Hideout", "Improve", "Inventor", "Lackeys", "Mountain Village", "Old Witch",
                    "Patron", "Priest", "Recruiter", "Research", "Scepter", "Scholar", "Seer", "Silk Merchant",
                    "Spices", "Swashbuckler", "Treasurer", "Villain"));
            cumulativeDeck.addAll(renaissanceList);
        }
    }

    // Mutator method setting the ArrayList of cards:
    void setDeckListOfCards(ArrayList deckListOfCards) {
        this.deckListOfCards = deckListOfCards;
    }

    // Method that shuffles the entire "cumulativeDeck" array:
    private void shuffleDeck() {
        Collections.shuffle(cumulativeDeck);
    }

    // Method that deals the first ten elements of the "cumulativeDeck" array, displays console output and builds the
    // "pathList" Array
    private void dealDeck() {

        Card card;

        if (cumulativeDeck == null) {
            printNoDecksMessage();
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

    // Method that passes the "pathList" Array to the window and then builds the window
    private void generateWindow() {
        DeckWindow deckWindow;

        // Passes the "pathList" ArrayList to the DeckWindow constructor
        deckWindow = new DeckWindow(pathList);
        deckWindow.buildWindow();
    }

    private void printNoDecksMessage() {
        System.out.println("No decks have been selected.  Try again");
    }
}