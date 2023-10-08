
public class Enemy {
	
	// atributos
	private int positionX;
	private int positionY;
	private int health;
	private int attack;
	private int defense;
	
	// constructor 
	public Enemy(int health, int attack, int defense) {
		this.positionX = 4;
		this.positionY = 5;
		this.health = health;
		this.attack = attack;
		this.defense = defense;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}
	
	public void moveLeft() {
		positionY -= 1;
	}
	
	public void moveUp() {
		positionX -= 1;
	}
	
	public void moveRight() {
		positionY += 1;
	}
	
	public void moveDown() {
		positionX += 1;
	}
	
	
}
