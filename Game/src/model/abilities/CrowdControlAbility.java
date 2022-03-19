package model.abilities;
import model.effects.Effect;


public class CrowdControlAbility extends Ability {
	Effect effect;	
	public CrowdControlAbility(String name, int manaCost, int baseCooldown, int currentCooldown, int castRange,
			int requiredActionPoints, AreaOfEffect castArea) {
		super(name, manaCost, baseCooldown, currentCooldown, castRange, requiredActionPoints, castArea);
}
	public Effect getEffect() {
		return effect;
	}

}
