package cz.cvut.fit.pavelpat.home.poker.game;

import java.util.ArrayList;
import java.util.List;

import cz.cvut.fit.pavelpat.home.poker.cards.Card;
import cz.cvut.fit.pavelpat.home.poker.exception.PokerException;

public class Player {

	private final String name;
	private int balance;
	private int currentBet;
	private List<Card> cards;

	public Player(String name) {
		this.name = name;
		this.balance = 0;
		this.currentBet = 0;
		this.cards = new ArrayList<>();
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getCurrentBet() {
		return currentBet;
	}

	public void setCurrentBet(int currentBet) {
		this.currentBet = currentBet;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void addCard(Card card) throws PokerException {
		if (cards.size() >= 2) {
			throw new PokerException("Cannot have more than 2 cards");
		}
		cards.add(card);
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}	
