package model.world;
import java.awt.*;

public class Cover {
	int currentHP;
	Point location;
	public Cover(int x, int y) {
	this.currentHP = (int) (Math.random()* (1000-100)) + 100;
	
	}
}
