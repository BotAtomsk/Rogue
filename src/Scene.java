
public class Scene {

	// atributos
	private String[][] layout;
	private int width;
	private int height;
	private Player player;
	private Enemy enemy;

	
	// constructor 
	public Scene(int width, int height) {
		this.width = width;
		this.height = height;
		layout = fillLayout();
		createExit();
	}
	
	public Enemy getEnemy() {
		return enemy;
	}

	public void setEnemy(Enemy enemy) {
		this.enemy = enemy;
	}

	// método dibujo
	public String[][] fillLayout() {
			String[][] layout = new String[height][width];
			// relleno automático primera fila
			for (int y = 0; y < width; y++) {
				layout[0][y] = "-";
			}
			// relleno del medio
			for (int i = 1; i < layout.length - 1; i++)
				for (int j = 0; j < layout[i].length; j++) {
					if (j == 0 || j == width-1)
						layout[i][j] = "|";
					else
						layout[i][j] = ".";
				}
			// relleno automático última fila
			for (int y = 0; y < width; y++) {
				layout[height-1][y] = "-";
			}
			
			return layout;
		}
	


	public String[][] getLayout() {
		return layout;
	}

	public void setLayout(String[][] layout) {
		this.layout = layout;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public void createExit() {
		int random = (int) (Math.random() * (height - 2)) + 1;
		layout[random][width-2] = "E";
	}
	
	public void updateOldPos() {
		layout[player.getPositionX()][player.getPositionY()] = ".";
		layout[enemy.getPositionX()][enemy.getPositionY()] = ".";
		moveRandomEnemy();
	}
	
	public void updateNewPos() {
		checkExit();
		layout[player.getPositionX()][player.getPositionY()] = "O";
		layout[enemy.getPositionX()][enemy.getPositionY()] = "X";
		if (player.getPositionX() == enemy.getPositionX() && player.getPositionY() == enemy.getPositionY()) {
			layout[enemy.getPositionX()][enemy.getPositionY()] = "@";
			System.out.println("The monster got you! You lost some health...");
			player.setHealth(player.getHealth() - 5);
			System.out.println("Your current health is " + player.getHealth());
		}
	}
	
	public void checkExit() {
		if (this.layout[player.getPositionX()][player.getPositionY()].equalsIgnoreCase("E")) {
			System.out.println("You found the exit! Congrats!");
			System.exit(1);
		}
	}
	
	public void print() {
		updateNewPos();
		for (int x = 0; x < layout.length; x++) {
			for (int y = 0; y < layout[x].length; y++) {
				System.out.print(layout[x][y]);
			}
			System.out.println();
		}
	}
	
	public void moveRandomEnemy() {
		int random = (int) (Math.random() * 4) + 1;
		switch(random) {
		case 1: 
			if (enemy.getPositionX() == 1) {
				layout[enemy.getPositionX()][enemy.getPositionY()] = "X";
				break;
			}
			enemy.moveUp();
			break;
		case 2: 
			if (enemy.getPositionY() == width - 2) {
				layout[enemy.getPositionX()][enemy.getPositionY()] = "X";
				break;
			}
			enemy.moveRight();
			break;
		case 3: 
			if (enemy.getPositionX() == height - 2) {
				layout[enemy.getPositionX()][enemy.getPositionY()] = "X";
				break;
			}
			enemy.moveDown();
			break;
		case 4: 
			if (enemy.getPositionY() == 1) {
				layout[enemy.getPositionX()][enemy.getPositionY()] = "X";
				break;
			}
			enemy.moveLeft();
			break;
		default:
			break;
		}
	}
	
}
