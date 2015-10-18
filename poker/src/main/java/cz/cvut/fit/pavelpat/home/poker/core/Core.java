package cz.cvut.fit.pavelpat.home.poker.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cz.cvut.fit.pavelpat.home.poker.game.Player;
import cz.cvut.fit.pavelpat.home.poker.game.Table;

public class Core {

	private final static Logger logger = LoggerFactory.getLogger(Core.class.getSimpleName());

	public static void main(String[] args) throws Exception {
		logger.info("Starting the Core.");
		Table table = new Table();
		table.AddPlayer(new Player("Patrik"));
		table.AddPlayer(new Player("Jan"));
		table.AddPlayer(new Player("Dave"));
		table.AddPlayer(new Player("Milly"));
		table.AddPlayer(new Player("Krk krkovec"));
		table.startGame();
		
	}
}
