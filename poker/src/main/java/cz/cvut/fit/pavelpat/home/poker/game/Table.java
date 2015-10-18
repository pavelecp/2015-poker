package cz.cvut.fit.pavelpat.home.poker.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cz.cvut.fit.pavelpat.home.poker.cards.Deck;
import cz.cvut.fit.pavelpat.home.poker.exception.PokerException;

public class Table {

	private final static Logger logger = LoggerFactory.getLogger(Table.class);

	private List<Player> players;
	private Deck deck;

	private int smallBlind;
	private int bigBlind;
	private Player dealer;
	private int startingBalance;

	private boolean gameInProgress;
	private Random random;

	public Table() {
		players = new ArrayList<>();
		deck = new Deck();
		smallBlind = 10;
		bigBlind = smallBlind * 2;
		startingBalance = 1000;
		random = new Random();
	}

	public void AddPlayer(Player player) throws PokerException {
		if (players.size() >= 8) {
			throw new PokerException("Already 8 players at the table. Cannot add " + player);
		}
		if (gameInProgress) {
			throw new PokerException("Cannot add player during the game.");
		}
		players.add(player);
	}

	public void startGame() throws PokerException {
		logger.info("Starting game.");
		if (gameInProgress) {
			throw new PokerException("Cannot start a game,which is already in progress.");
		}
		prepareForGame();
		gameInProgress = true;
		playGame();
		gameInProgress = false;
	}

	private void playGame() throws PokerException {
		playRound();
	}

	private void playRound() throws PokerException {
		logger.info("Starting new round.");
		dealCardsToPlayers();
	}

	private void dealCardsToPlayers() throws PokerException {
		int dealerIndex = players.indexOf(dealer);
		for (int v = 0; v < 2; v++) {
			for (int i = (dealerIndex == players.size() - 1) ? players.size() : dealerIndex + 1; i < players
					.size(); i++) {
				players.get(i).addCard(deck.takeCard());
			}
			for (int i = 0; i <= dealerIndex; i++) {
				players.get(i).addCard(deck.takeCard());
			}
		}
	}

	private void prepareForGame() throws PokerException {
		if (players.size() < 2) {
			throw new PokerException("Cannot play with less than 2 players.");
		}
		for (Player player : players) {
			player.setBalance(startingBalance);
		}
		int dealerIndex = random.nextInt(players.size());
		dealer = players.get(dealerIndex);
		logger.info("Table was successfully prepared.");
	}

	private void doubleBlinds() {
		smallBlind *= 2;
		bigBlind *= 2;
	}
}
