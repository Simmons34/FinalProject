package JavaSolitaire;

import java.util.*;

public class Deck extends Card {
    private ArrayList<Card> cards;

    // used to create an empty deck
    Deck() {
        cards = new ArrayList<Card>();
    }

    // used to create the default/standard deck of 52 cards
    Deck(String[] suites) {
        cards = new ArrayList<Card>();
        for (String suit : suites) {
            for (int i = 1; i <= 13; i++) {
                // successfully creates new card object
                // Card newCard = new Card(i, suit);
                // newCard.printCard();
                addCard(new Card(i, suit));
            }
        }
    }

    // used to create a deck with x copies for each String in suites
    Deck(String[] suites, int x) {
        cards = new ArrayList<Card>();
        for (int copy = 0; copy < x; copy++) {
            for (String suit : suites) {
                for (int i = 1; i <= 13; i++) {
                    cards.add(new Card(i, suit));
                    System.out.println(cards.size());
                }
            }
        }
    }

    int getNumCards() {
        return cards.size();
    }

    void addCard(Card newCard) {
        cards.add(newCard);
    }

    void DealCards(Deck dealTo, int numToDeal) {
        if (getNumCards() != 0) {
            for (int i = 0; i < numToDeal; i++) {
                dealTo.addCard(cards.get(getNumCards() - 1));
                removeCard();
            }
            dealTo.changeVis();
        } else {
            System.out.println("Cannot deal from empty Deck");
        }
    }

    boolean isEmpty() {
        if (getNumCards() != 0) {
            return false;
        } else {
            return true;
        }
    }

    Card getCard() {
        return cards.get(getNumCards() - 1);
    }

    void printVisible() {
        for (Card topCard : cards) {
            if (topCard.getVisibility() == true) {
                topCard.printCard();
            }
        }
    }

    void removeCard() {
        cards.remove(getNumCards() - 1);
    }

    void changeVis() {
        if (getNumCards() != 0) {
            Card myCard = cards.get(getNumCards() - 1);
            myCard.changeVisibility();
        }
    }

    void shuffleDeck() {
        Collections.shuffle(cards);
    }

    void printDeck() {
        for (Card topCard : cards) {
            topCard.printCard();
        }
    }

    boolean hasCardAtIndex(int index) {
        if (index <= getNumCards() - 1) {
            return true;
        } else {
            return false;
        }
    }

    void printCardAtIndex(int index) {
        if (hasCardAtIndex(index)) {
            Card cardAtIndex = cards.get(index);
            cardAtIndex.printCard();
        }
    }
}
