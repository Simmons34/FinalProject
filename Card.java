package JavaSolitaire;

public class Card implements Comparable<Card> {
    private int cardNum;
    private Suites suit;
    private boolean visible = false;

    enum Suites {
        HEARTS,
        CLUBS,
        DIAMONDS,
        SPADES
    }

    Card() {
        
    }

    Card(int newNum, Suites newSuit) {
        cardNum = newNum;
        suit = newSuit;
    }

    Card(int newNum, String newSuit) {
        cardNum = newNum;
        switch (newSuit.toLowerCase()) {
            case "hearts":
                suit = Suites.HEARTS;
                break;
            case "clubs":
                suit = Suites.CLUBS;
                break;
            case "diamonds":
                suit = Suites.DIAMONDS;
                break;
            case "spades":
                suit = Suites.SPADES;
                break;
            default:
                suit = Suites.HEARTS;
        }
    }

    String EnumToString() {
        switch (this.suit) {
            case HEARTS:
                return "Hearts";
            case CLUBS:
                return "Clubs";
            case DIAMONDS:
                return "Diamonds";
            case SPADES:
                return "Spades";
            default:
                return "INVALID";
        }
    }

    void changeVisibility() {
        if (visible) {
            visible = false;
        } else {
            visible = true;
        }
    }

    boolean getVisibility() {
        return visible;
    }

    boolean hasCard() {
        if (suit != null) {
            return true;
        } else {
            return false;
        }
    }

    void printCard() {
        if (hasCard()) {
            if (visible) {
                System.out.printf("%-1d %-9s", cardNum, EnumToString());
            } else {
                System.out.print("-----------");
            }
        } else {
            System.out.print("           ");
        }
    }

    @Override
    public int compareTo(Card aCard) {
        if (this.suit.compareTo(aCard.suit) != 0) {
            return this.suit.compareTo(aCard.suit);
        } else {
            return this.cardNum - aCard.cardNum;
        }
    }
}
