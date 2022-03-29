//the date is  Mar 19, 2022

package engine;

import java.util.*;

import model.world.Champion;

public class Player {
	private String name;
	private Champion leader;
	private ArrayList<Champion> team;

	public Player(String name) {
		super();
		team = new ArrayList<Champion>();
		this.name = name;

	}

	public String getName() {
		return name;
	}

	public ArrayList<Champion> getTeam() {
		return team;
	}

	public Champion getLeader() {
		return leader;
	}

	public void setLeader(Champion leader) {
		this.leader = leader;

	}
}
