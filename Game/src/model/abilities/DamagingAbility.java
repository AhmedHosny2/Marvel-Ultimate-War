package model.abilities;

public class DamagingAbility extends Ability {
	private int damageAmount;
	public DamagingAbility(String name, int manaCost, int baseCooldown, int currentCooldown, int castRange,
			int requiredActionPoints, AreaOfEffect castArea) {
		super(name, manaCost, baseCooldown, currentCooldown, castRange, requiredActionPoints, castArea);
	}
	public int getDamageAmount() {
		return damageAmount;
	}
	public void setDamageAmount(int damageAmount) {
		this.damageAmount = damageAmount;
	}

}
