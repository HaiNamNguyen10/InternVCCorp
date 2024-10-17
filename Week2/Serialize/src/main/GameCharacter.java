package main;
import java.io.*;

public class GameCharacter implements Serializable {
	private String name;
	private transient int health;
	private String weapon;
	
	public GameCharacter(String name, int health, String weapon) {
		this.name = name;
		this.health = health;
		this.weapon = weapon;
	}
	
	public String toString() {
		String info = "";
		info += this.name;
		info += " - " + this.health;
		info += " - " + this.weapon;
		return info;
		
	}
}
