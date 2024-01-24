// Name: Steven Qian
// Computing ID: uen9ke
// Homework Name: HW4-Blackjack
// Resources used: None



/*
 * Define a blackjack player by inheriting from the superclass BlackjackPlayer
 *   and implementing the 3 abstract methods.
 */
public class MyBlackjackPlayer extends BlackjackPlayer{

	@Override
	public int getBet() {
		return 10; //always bet 10
	}

	@Override
	public Move getMove() {

		int playerScore = this.handScore();
		Card dealerUpcard = dealer.getVisibleCard();

		if (playerScore <= 8) {
			return Move.HIT; // Always hit on 8 or lower.


		} else if (playerScore == 9) {

			
			// Double if the dealer's upcard is 3, 4, 5, or 6, otherwise hit
			if (dealerUpcard.getRank() >= 3 && dealerUpcard.getRank() <= 6) {
				return Move.DOUBLE;
			} else {
				return Move.HIT;
			}


		} else if (playerScore == 10) {


			// Double down if the dealer's upcard is 2 to 9, otherwise hit
			if (dealerUpcard.getRank() >= 2 && dealerUpcard.getRank() <= 9) {
				return Move.DOUBLE;
			} else {
				return Move.HIT;
			}

		} else if (playerScore == 11) {


			// Double down if the dealer's upcard is 2 to 10, otherwise hit
			if (dealerUpcard.getRank() >= 2 && dealerUpcard.getRank() <= 10) {
				return Move.DOUBLE;
			} else {
				return Move.HIT;
			}
		} else if (playerScore <= 16) {


			// Stand on 12 to 16 if the dealer's upcard is 2 to 6, otherwise hit
			if (dealerUpcard.getRank() >= 2 && dealerUpcard.getRank() <= 6) {
				return Move.STAY;
			} else {
				return Move.HIT;
			}


		} else {
			return Move.STAY; // Stand on 17 or higher.

		}

	}


	@Override
	public void handOver(Card[] dealerHand) {
		/**
		 * If you care about looking at the dealer's hand once
		 * the hand is over, then you can do it here. This method
		 * is called automatically after every hand and a copy of the dealer's
		 * final hand is given to you to process. The dealer's hand will be
		 * found in the array of Cards that you pass when the method returns.
		 */
		
	}

	
}
