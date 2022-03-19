package model.abilities;

public class HealingAbility extends Ability {
	private int healAmount;
	public HealingAbility(String name, int manaCost, int baseCooldown, int currentCooldown, int castRange,
			int requiredActionPoints, AreaOfEffect castArea) {
		super(name, manaCost, baseCooldown, currentCooldown, castRange, requiredActionPoints, castArea);
	}
	
	public int getHealAmount() {
		return healAmount;
	}
	
	public void setHealAmount(int healAmount) {
		this.healAmount = healAmount;
	}


}
