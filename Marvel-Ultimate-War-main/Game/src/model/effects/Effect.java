package model.effects;

public class Effect {
	// effect name
	private String name;
	// number of turns the effect remains on the target
	private int duration;
	private EffectType type;

	public Effect(String name, int duration, EffectType type) {

		this.name = name;
		this.duration = duration;
		this.type = type;

	}

	public String getName() {
		return name;
	}

	public int getDuration() {
		return duration;
	}

	public EffectType getType() {
		return type;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

}
