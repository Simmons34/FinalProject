package JavaSolitaire;

import java.util.Arrays;

public class JavaSolitaire {

    static void printStacks(Deck[] myStacks) {
        System.out.printf("%-11s\t%-11s\n", "Talon Deck", "Main Deck");
        if (myStacks[0].getNumCards() > 0) {
            myStacks[0].printCardAtIndex(myStacks[0].getNumCards() - 1);
        } else {
            System.out.print("          ");
        }
        System.out.print("\t");

        if (myStacks[1].getNumCards() > 0) {
            myStacks[1].printCardAtIndex(myStacks[1].getNumCards() - 1);
        }
        System.out.print("\n");

        System.out.printf("%-11s\t%-11s\t%-11s\t%-11s\t%-11s\t%-11s\t%-11s\n",
                "Stack 1", "Stack 2", "Stack 3", "Stack 4", "Stack 5", "Stack 6", "Stack 7");

        Deck[] activeDecks = Arrays.copyOfRange(myStacks, 2, myStacks.length);

        int largestPile = 0;
        for (Deck aDeck : activeDecks) {
            if (aDeck.getNumCards() > largestPile) {
                largestPile = aDeck.getNumCards();
            }
        }

        for (int x = 2; x < myStacks.length; x++) {
            for (int i = largestPile - 1; i >= 0; i--) {
                if (myStacks[myStacks.length - x + 1].hasCardAtIndex(i)) {
                    myStacks[myStacks.length - x + 1].printCardAtIndex(i);
                } else {
                    System.out.print("           ");
                }
                System.out.print("\t");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        String[] suites = { "hearts", "clubs", "diamonds", "spades" };

        Deck talonDeck = new Deck();
        Deck mainDeck = new Deck(suites);
        Deck stack1 = new Deck();
        Deck stack2 = new Deck();
        Deck stack3 = new Deck();
        Deck stack4 = new Deck();
        Deck stack5 = new Deck();
        Deck stack6 = new Deck();
        Deck stack7 = new Deck();
        Deck[] myStacks = { talonDeck, mainDeck, stack1, stack2, stack3, stack4, stack5, stack6, stack7 };

        mainDeck.shuffleDeck();

        mainDeck.DealCards(stack1, 1);
        mainDeck.DealCards(stack2, 2);
        mainDeck.DealCards(stack3, 3);
        mainDeck.DealCards(stack4, 4);
        mainDeck.DealCards(stack5, 5);
        mainDeck.DealCards(stack6, 6);
        mainDeck.DealCards(stack7, 7);

        mainDeck.DealCards(talonDeck, 1);
        
        printStacks(myStacks);
    }
}
