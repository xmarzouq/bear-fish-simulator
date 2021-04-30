/**
 * @author Mohamed Ali
 * @since 25-01-2021
 * @QUID 201912476
 * 
 */

import java.util.Scanner;
import javax.swing.Timer;

public class RiverTest {
	public static void main(String[] args) {
		River rObj = new River();
		Scanner input = new Scanner(System.in);
		//displaying the move and display method every half a second.
		Timer timer = new Timer(500, event -> rObj.moveAndDisplay());
		timer.start();
		input.nextLine();
	}
}
