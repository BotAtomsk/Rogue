import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		
		// input usuario
		Scanner sc = new Scanner(System.in);
		System.out.println("Indica el alto de la habitación");
		int height = sc.nextInt();
		System.out.println("Indica el ancho de la habitación");
		int width = sc.nextInt();
		
		Scene scene = new Scene(width, height);
		Player player = new Player(30, 6, 4);
		Enemy enemy = new Enemy(22, 4, 1);
		scene.setPlayer(player);
		scene.setEnemy(enemy);
		
		// bucle movimiento
		int opcion = 0;
		scene.print();
		while(opcion != 999) {
			if (player.getHealth() <= 0) {
				System.out.println("Has perdido toda tu salud, fin de la partida...");
				break;
			}
			System.out.println("Indica qué quieres hacer:\n\t1) Mover izquierda\n\t2) Mover arriba\n\t3) Mover derecha\n\t4) Mover abajo\n\t999) Salir");
			opcion = sc.nextInt();
			switch(opcion) {
				case 1:
					if (player.getPositionY() == 1) {
						System.out.println("Imposible mover a la izquierda.");
						scene.print();
						break;
					} 
					scene.updateOldPos();
					player.moveLeft();
					scene.print();
					break;
				case 2:
					if (player.getPositionX() == 1) {
						System.out.println("Imposible mover hacia arriba.");
						scene.print();
						break;
					} 
					scene.updateOldPos();
					player.moveUp();
					scene.print();
					break;
				case 3:
					if (player.getPositionY() == scene.getWidth() - 2) {
						System.out.println("Imposible mover a la derecha.");
						scene.print();
						break;
					} 
					scene.updateOldPos();
					player.moveRight();
					scene.print();
					break;
				case 4:
					if (player.getPositionX() == scene.getHeight() - 2) {
						System.out.println("Imposible mover hacia abajo.");
						scene.print();
						break;
					} 
					scene.updateOldPos();
					player.moveDown();
					scene.print();
					break;
				case 999:
					System.out.println("Has elegido dejar de jugar, adiós.");
					break;
				default:
					System.out.println("No has elegido correctamente.");
					break;
			}
		}	
		
		sc.close();
	}

}
