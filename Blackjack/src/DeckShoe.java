// Name: Steven Qian
// Computing ID: uen9ke
// Homework Name: HW4-Blackjack
// Resources used: None


import java.util.Arrays;

/**
 * A stack of more than one deck of cards used in a casino game
 *
 */
public class DeckShoe {

    //An array of decks of cards that comprise this multi-deck.
    private Deck[] decks;

    // you may need other instance variables here

    //record number of cards and decks used

    int currentDeck = 0; //first deck is 0, same as array index in the decks array

    //Constructor: instantiates the number of decks specified and
    //adds them to the list of decks
    public DeckShoe(int numDecks) {

        if (numDecks > 0) {

            decks = new Deck[numDecks]; // instantiates

            for (int i = 0; i < numDecks; i++) { // add decks

                decks[i] = new Deck();

            }
        }
    }


    //Deals the top card from the stack of decks and returns that Card.
    //You can implement this several ways, as long as it correctly
    //deals a card from one of the decks.
    //Important: if you've dealt the last card in all the decks, you'll want
    //to reshuffle all the decks and start over again
    public Card dealTopCard() {
        //System.out.println("##################################### Cardleft:   "+cardsLeft()); For test

        // increase currentDeck when the current deck is empty and not over end of the array
        if (decks[currentDeck].cardsLeft() == 0 && currentDeck < decks.length) {
            currentDeck++;
        }




        // deal the top card in the current deck
        if (currentDeck < decks.length) {
            return decks[currentDeck].dealTopCard();
        }



        // restore decks and reset currentDeck count when current Deck is out of array range
        else {
            restoreDecks();
            currentDeck = 0;
            return decks[currentDeck].dealTopCard();
        }


    }


    //Reshuffles all the decks.
    protected void restoreDecks() {
        for (int i = 0; i < decks.length; i++) {
            decks[i].shuffle();
        }
    }


    //returns the number of cards left to be dealt in the entire stack of cards.
    public int cardsLeft() {


            int numCards = decks[currentDeck].cardsLeft();
            numCards += ((decks.length - currentDeck) - 1) * 52;
            return numCards;

    }


}
