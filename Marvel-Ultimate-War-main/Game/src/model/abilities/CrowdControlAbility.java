package model.abilities;

import model.effects.Effect;

public class CrowdControlAbility extends Ability {
	Effect effect;

	public CrowdControlAbility(String name, int cost, int baseCooldown, int castRange, AreaOfEffect castArea,
			int required, Effect effect)

	{
		super(name, cost, baseCooldown, castRange, castArea, required);
		this.effect = effect;
	}

	public Effect getEffect() {
		return effect;
	}

}
