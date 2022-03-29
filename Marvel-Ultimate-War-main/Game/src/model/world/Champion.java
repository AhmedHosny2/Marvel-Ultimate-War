//the date is  Mar 19, 2022

package model.world;

import java.awt.*;
import java.util.*;
import model.abilities.*;
import model.effects.*;

public class Champion {
	private String name;
	private int maxHP, currentHP, mana, maxActionPointsPerTurn, currentActionPoints, attackRange, attackDamage, speed;
	private ArrayList<Ability> abilities;
	private ArrayList<Effect> appliedEffects;
	private Condition condition;
	private Point location;

	public Champion(String name, int maxHP, int mana, int maxActionPointsPerTurn, int speed, int attackRange,
			int attackDamage) {
		super();
		this.name = name;
		this.maxHP = maxHP;
		this.currentHP = maxHP;

		this.mana = mana;
		this.maxActionPointsPerTurn = maxActionPointsPerTurn;
		this.currentActionPoints = maxActionPointsPerTurn;
		this.speed = speed;

		this.attackRange = attackRange;
		this.attackDamage = attackDamage;
		abilities = new ArrayList<Ability>();
		appliedEffects = new ArrayList<Effect>();
		condition = Condition.ACTIVE;
	}

	public String getName() {
		return name;
	}

	public int getMaxHP() {
		return maxHP;
	}

	public int getCurrentHP() {
		return currentHP;
	}

	public Point getLocation() {
		return location;
	}

	public int getMana() {
		return mana;
	}

	public int getMaxActionPointsPerTurn() {
		return maxActionPointsPerTurn;
	}

	public int getCurrentActionPoints() {
		return currentActionPoints;
	}

	public int getAttackRange() {
		return attackRange;
	}

	public int getAttackDamage() {
		return attackDamage;
	}

	public int getSpeed() {
		return speed;
	}

	public ArrayList<Ability> getAbilities() {
		return abilities;
	}

	public ArrayList<Effect> getAppliedEffects() {
		return appliedEffects;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCurrentHP(int currentHP) {
		if (this.maxHP >= currentHP)
			this.currentHP = Math.max(currentHP, 0);
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public void setMaxActionPointsPerTurn(int maxActionPointsPerTurn) {
		this.maxActionPointsPerTurn = maxActionPointsPerTurn;
	}

	public void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public void addAbility(Ability a) {
		abilities.add(a);
	}

}
