package com.dominion;

import java.util.*;

class Deck {
    // Fields of the class "Deck":
    String deckType;
    ArrayList<String> deckListOfCards;

    Deck() { }

    // Constructor
    void setDeck(String deckType) {
        deckListOfCards = new ArrayList<>();

        switch(deckType) {
            case "Dominion" :
                deckListOfCards.addAll(Arrays.asList("Adventurer", "Bureaucrat", "Cellar", "Chancellor", "Chapel",
                        "Council Room", "Feast", "Festival", "Gardens", "Laboratory", "Library", "Market", "Militia",
                        "Mine", "Moat", "Moneylender", "Remodel", "Smithy", "Spy", "Thief", "Throne Room", "Village",
                        "Witch", "Woodcutter", "Workshop"));
                break;

            case "DominionEd2" :
                deckListOfCards.addAll(Arrays.asList("Artisan", "Bandit", "Bureaucrat", "Cellar", "Chapel",
                        "Council Room", "Festival", "Gardens", "Harbinger", "Laboratory", "Library", "Market",
                        "Merchant", "Militia", "Mine", "Moat", "Moneylender", "Poacher", "Remodel", "Sentry", "Smithy",
                        "Throne Room", "Vassal", "Village", "Witch", "Workshop"));
                break;

            case "Intrigue" :
                deckListOfCards.addAll(Arrays.asList("Baron", "Bridge", "Conspirator", "Coppersmith", "Courtyard",
                        "Duke", "Great Hall", "Harem", "Ironworks", "Masquerade", "Mining Village", "Minion", "Nobles",
                        "Pawn", "Saboteur", "Scout", "Secret Chamber", "Shanty Town", "Steward", "Swindler", "Torturer",
                        "Trading Post", "Tribute", "Upgrade", "Wishing Well"));
                break;

            case "IntrigueEd2" :
                deckListOfCards.addAll(Arrays.asList("Baron", "Bridge", "Conspirator", "Courtier", "Courtyard",
                        "Diplomat", "Duke", "Harem", "Ironworks", "Lurker", "Masquerade", "Mill", "Mining Village",
                        "Minion", "Nobles", "Patrol", "Pawn", "Replace", "Secret Passage", "Shanty Town", "Steward",
                        "Swindler", "Torturer", "Trading Post", "Upgrade", "Wishing Well"));
                break;

            case "Seaside" :
                deckListOfCards.addAll(Arrays.asList("Ambassador", "Bazaar", "Caravan", "Cutpurse", "Embargo",
                        "Explorer", "Fishing Village", "Ghost Ship", "Haven", "Island", "Lighthouse", "Lookout",
                        "Merchant Ship", "Native Village", "Navigator", "Outpost", "Pearl Diver", "Pirate Ship",
                        "Salvager", "Sea Hag", "Smugglers", "Tactician", "Treasure Map", "Treasury", "Warehouse",
                        "Wharf"));
                break;

            case "Alchemy" :
                deckListOfCards.addAll(Arrays.asList("Alchemist", "Apothecary", "Apprentice", "Familiar", "Golem",
                        "Herbalist", "Philosopher's Stone", "Possession", "Scrying Pool", "Transmute", "University",
                        "Vineyard"));
                break;

            case "Promo Cards" :
                deckListOfCards.addAll(Arrays.asList("Avanto", "Black Market", "Dismantle", "Envoy", "Governor",
                        "Prince", "Sauna", "Stash", "Walled Village"));
                break;

            case "Prosperity" :
                deckListOfCards.addAll(Arrays.asList("Bank", "Bishop", "City", "Contraband", "Counting House", "Expand",
                        "Forge", "Goons", "Grand Market", "Hoard", "King's Court", "Loan", "Mint", "Monument",
                        "Mountebank", "Peddler", "Quarry", "Rabble", "Royal Seal", "Talisman", "Trade Route", "Vault",
                        "Vault", "Venture", "Watchtower", "Worker's Village"));
                break;
            case "Cornucopia" :
                deckListOfCards.addAll(Arrays.asList("Fairgrounds", "Farming Village", "Fortune Teller", "Hamlet",
                        "Harvest", "Horn of Plenty", "Horse Traders", "Hunting Party", "Jester", "Menagerie", "Remake",
                        "Tournament", "Young Witch"));
                break;

            case "Hinterlands" :
                deckListOfCards.addAll(Arrays.asList("Border Village", "Cache", "Cartographer", "Crossroads", "Develop",
                        "Duchess", "Embassy", "Farmland", "Fool's Gold", "Haggler", "Highway", "Ill-Gotten Gains",
                        "Inn", "Jack of All Trades", "Mandarin", "Margrave", "Noble Brigand", "Nomad Camp", "Oasis",
                        "Oracle", "Scheme", "Silk Road", "Spice Merchant", "Stables", "Trader", "Tunnel"));
                break;

            case "Dark Ages" :
                deckListOfCards.addAll(Arrays.asList("Altar", "Armory", "Band of Misfits", "Bandit Camp", "Beggar",
                        "Catacombs", "Count", "Counterfeit", "Cultist", "Death Cart", "Feodum", "Forager", "Fortress",
                        "Graverobber", "Hermit", "Hunting Grounds", "Ironmonger", "Junk Dealer", "Knights", "Marauder",
                        "Market Square", "Mystic", "Pillage", "Poor House", "Procession", "Rats", "Rebuild", "Rogue",
                        "Sage", "Scavenger", "Squire", "Storeroom", "Urchin", "Vagrant", "Wandering Minstrel"));
                break;

            case "Guilds" :
                deckListOfCards.addAll(Arrays.asList("Advisor", "Baker", "Butcher", "Candlestick Maker", "Doctor",
                        "Herald", "Journeyman", "Masterpiece", "Merchant Guild", "Plaza", "Soothsayer", "Stonemason",
                        "Taxman"));
                break;

            case "Empires" :
                deckListOfCards.addAll(Arrays.asList("Archive", "Bustling Village", "Capital", "Castles", "Catapult",
                        "Chariot Race", "Charm", "City Quarter", "Crown", "Emporium", "Encampment", "Enchantress",
                        "Engineer", "Farmer's Market", "Fortune", "Forum", "Gladiator", "Groundskeeper", "Legionary",
                        "Patrician", "Plunder", "Rocks", "Royal Blacksmith", "Sacrifice", "Settlers", "Temple", "Villa",
                        "Wild Hunt"));
                break;

            case "Adventures" :
                deckListOfCards.addAll(Arrays.asList("Amulet", "Artificer", "Bridge Troll", "Coin of the Realm",
                        "Distant Lands", "Dungeon", "Duplicate", "Gear", "Guide", "Haunted Woods", "Hireling",
                        "Lost City", "Magpie", "Messenger", "Miser", "Page", "Peasant", "Port", "Ranger", "Ratcatcher",
                        "Raze", "Relic", "Royal Carriage", "Storyteller", "Swamp Hag", "Transmogrify", "Treasure Trove",
                        "Wine Merchant"));
                break;

            case "Nocturne" :
                deckListOfCards.addAll(Arrays.asList("Bard", "Blessed Village", "Cemetery", "Changeling", "Cobbler",
                        "Conclave", "Crypt", "Cursed Village", "Den of Sin", "Devil's Workshop", "Druid", "Exorcist",
                        "Faithful Hound", "Fool", "Guardian", "Ghost Town", "Idol", "Leprechaun", "Monastery",
                        "Necromancer", "Night Watchman", "Pixie", "Pooka", "Raider", "Sacred Grove", "Secret Cave",
                        "Shepherd", "Skulk", "Tormentor", "Tracker", "Tragic Hero", "Vampire", "Werewolf"));
                break;

            case "Renaissance" :
                deckListOfCards.addAll(Arrays.asList("Acting Troupe", "Border Guard", "Cargo Ship", "Ducat",
                        "Experiment", "Flag Bearer", "Hideout", "Improve", "Inventor", "Lackeys", "Mountain Village",
                        "Old Witch", "Patron", "Priest", "Recruiter", "Research", "Scepter", "Scholar", "Seer",
                        "Silk Merchant", "Spices", "Swashbuckler", "Treasurer", "Villain"));
                break;

            case "Other" :
                deckListOfCards.addAll(Arrays.asList("other", "other", "other", "other", "other", "other", "other",
                        "other", "other", "other"));
                break;

            default :
                deckListOfCards.addAll(Arrays.asList("other", "other", "other", "other", "other", "other", "other",
                        "other", "other", "other"));
                break;
        }
    }
}