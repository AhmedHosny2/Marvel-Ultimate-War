//the date is  Mar 19, 2022

package engine;

import java.awt.Point;
import java.io.*;
import java.util.ArrayList;

import exceptions.UnallowedMovementException;
import model.abilities.*;

import model.effects.*;

import model.world.*;

public class Game {
	private Player firstPlayer, secondPlayer;
	private boolean firstLeaderAbilityUsed, secondLeaderAbilityUsed;
	final private static int BOARDHEIGHT = 5;
	final private static int BOARDWIDTH = 5;
	private Object[][] board = new Object[BOARDHEIGHT][BOARDWIDTH];
	private static ArrayList<Champion> availableChampions;
	private static ArrayList<Ability> availableAbilities;
	private PriorityQueue turnOrder;

	public Game(Player firstPlayer, Player secondPlayer) {
		super();
		availableChampions = new ArrayList<Champion>();
		availableAbilities = new ArrayList<Ability>();
		this.firstPlayer = firstPlayer;
		this.secondPlayer = secondPlayer;
		turnOrder = new PriorityQueue(6);
		placeChampions();
		placeCovers();

	}

	public Player getFirstPlayer() {
		return firstPlayer;
	}

	public static int getBoardheight() {
		return BOARDHEIGHT;
	}

	public Player getSecondPlayer() {
		return secondPlayer;
	}

	public static int getBOARDHEIGHT() {
		return BOARDHEIGHT;
	}

	public static int getBOARDWIDTH() {
		return BOARDWIDTH;
	}

	public Object[][] getBoard() {
		return board;
	}

	public static ArrayList<Champion> getAvailableChampions() {
		return availableChampions;
	}

	public static ArrayList<Ability> getAvailableAbilities() {
		return availableAbilities;
	}

	public PriorityQueue getTurnOrder() {
		return turnOrder;
	}

	public static int getBoardwidth() {
		return BOARDWIDTH;
	}

	public boolean isFirstLeaderAbilityUsed() {
		return firstLeaderAbilityUsed;
	}

	public boolean isSecondLeaderAbilityUsed() {
		return secondLeaderAbilityUsed;
	}

//here we are placing the champion on the board with avoiding the corners 
	private void placeChampions() {

		if (firstPlayer.getTeam().size() != 3 || secondPlayer.getTeam().size() != 3)
			return;

		for (int i = 1; i < 4; i++) {

			board[4][i] = secondPlayer.getTeam().get(i - 1);
			secondPlayer.getTeam().get(i - 1).setLocation(new Point(4, i));
			board[0][i] = firstPlayer.getTeam().get(i - 1);
			firstPlayer.getTeam().get(i - 1).setLocation(new Point(0, i));
		}

	}

//here we are placing the covers in random empty places 
	private void placeCovers() {

		int available_covers = 5;

		while (available_covers > 0) {
			int x = (int) (Math.random() * 3) + 1;
			int y = (int) (Math.random() * 5);
			if (board[x][y] == null) {
				board[x][y] = new Cover(x, y);
				available_covers--;
			}

		}
	}

//here we take load the ability from csv file 
	public static void loadAbilities(String filePath) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		String currentLine = br.readLine();
		AreaOfEffect AOE = null; // this is an enum

		while (currentLine != null) {
			Effect effect = null;
			Ability ability;
			String[] arrayOfAbilities = currentLine.split(",");
			AOE = AOE.valueOf(arrayOfAbilities[5]);

			if (arrayOfAbilities[0].equals("CC")) {
				if (arrayOfAbilities[7].equals("Disarm")) {
					effect = new Disarm(Integer.parseInt(arrayOfAbilities[8]));
				} else if (arrayOfAbilities[7].equals("PowerUp")) {
					effect = new PowerUp(Integer.parseInt(arrayOfAbilities[8]));
				} else if (arrayOfAbilities[7].equals("Shield")) {
					effect = new Shield(Integer.parseInt(arrayOfAbilities[8]));
				} else if (arrayOfAbilities[7].equals("Silence")) {
					effect = new Silence(Integer.parseInt(arrayOfAbilities[8]));
				} else if (arrayOfAbilities[7].equals("SpeedUp")) {
					effect = new SpeedUp(Integer.parseInt(arrayOfAbilities[8]));
				} else if (arrayOfAbilities[7].equals("Embrace")) {
					effect = new Embrace(Integer.parseInt(arrayOfAbilities[8]));
				} else if (arrayOfAbilities[7].equals("Root")) {
					effect = new Root(Integer.parseInt(arrayOfAbilities[8]));
				} else if (arrayOfAbilities[7].equals("Shock")) {
					effect = new Shock(Integer.parseInt(arrayOfAbilities[8]));
				} else if (arrayOfAbilities[7].equals("Dodge")) {
					effect = new Dodge(Integer.parseInt(arrayOfAbilities[8]));
				} else if (arrayOfAbilities[7].equals("Stun")) {
					effect = new Stun(Integer.parseInt(arrayOfAbilities[8]));
				}

				ability = new CrowdControlAbility(arrayOfAbilities[1], Integer.parseInt(arrayOfAbilities[2]),
						Integer.parseInt(arrayOfAbilities[4]), Integer.parseInt(arrayOfAbilities[3]), AOE,
						Integer.parseInt(arrayOfAbilities[6]), effect);

			} else if (arrayOfAbilities[0].equals("HEL")) {
				ability = new HealingAbility(arrayOfAbilities[1], Integer.parseInt(arrayOfAbilities[2]),
						Integer.parseInt(arrayOfAbilities[4]), Integer.parseInt(arrayOfAbilities[3]), AOE,
						Integer.parseInt(arrayOfAbilities[6]), Integer.parseInt(arrayOfAbilities[7]));

			} else {
				ability = new DamagingAbility(arrayOfAbilities[1], Integer.parseInt(arrayOfAbilities[2]),
						Integer.parseInt(arrayOfAbilities[4]), Integer.parseInt(arrayOfAbilities[3]), AOE,
						Integer.parseInt(arrayOfAbilities[6]), Integer.parseInt(arrayOfAbilities[7]));

			}

			availableAbilities.add(ability);

			currentLine = br.readLine();
		}

	}

	public static void loadChampions(String filePath)
			throws UnallowedMovementException, NumberFormatException, IOException {

		String currentLine = "";
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		while ((currentLine = br.readLine()) != null) {
			Champion ch;
			String[] loadChampion = currentLine.split(",");
			if (loadChampion.length < 11)
				continue;

			if (loadChampion[0].equals("A")) {

				ch = new AntiHero(loadChampion[1], Integer.parseInt(loadChampion[2]), Integer.parseInt(loadChampion[3]),
						Integer.parseInt(loadChampion[4]), Integer.parseInt(loadChampion[5]),
						Integer.parseInt(loadChampion[6]), Integer.parseInt(loadChampion[7]));
			} else if (loadChampion[0].equals("H")) {
				ch = new Hero(loadChampion[1], Integer.parseInt(loadChampion[2]), Integer.parseInt(loadChampion[3]),
						Integer.parseInt(loadChampion[4]), Integer.parseInt(loadChampion[5]),
						Integer.parseInt(loadChampion[6]), Integer.parseInt(loadChampion[7]));
			} else {
				ch = new Villain(loadChampion[1], Integer.parseInt(loadChampion[2]), Integer.parseInt(loadChampion[3]),
						Integer.parseInt(loadChampion[4]), Integer.parseInt(loadChampion[5]),
						Integer.parseInt(loadChampion[6]), Integer.parseInt(loadChampion[7]));
			}

			for (int i = 8; i < 11; i++) {
				for (int z = 0; z < availableAbilities.size(); z++) {
					if (availableAbilities.get(z).getName().equals(loadChampion[i])) {
						ch.addAbility(availableAbilities.get(z));

					}
				}

			}

			availableChampions.add(ch);

		}

	}

}
