/**
 * @author Mohamed Ali
 * @since 25-01-2021
 * @QUID 201912476
 * 
 */

import java.security.SecureRandom;
import java.util.Scanner;

public class River {
	private static int    WIDTH          = 60;
	private static int    HIGHT          = 20;
	private static int    STARTING_FISH  = 25;
	private static int    STARTING_BEAR  = 30;
	private static double CHANCE_TO_MOVE = 0.5;

	private SecureRandom randomObj = new SecureRandom();

	private Animal[][] river;
	private int fishCount = 0;
	private int bearCount = 0;

	public River () {
		river = new Animal[WIDTH][HIGHT];
		while(fishCount<STARTING_FISH) {
			fishCount += addNewAnimal(new Fish() );
		}
		while(bearCount<STARTING_BEAR) {
			bearCount += addNewAnimal(new Bear() ); 
		}
	}
	public void move () {
		for (int y=0; y<HIGHT; y++) {
			for (int x=0; x<WIDTH; x++) {
				if (river[x][y] != null) {
					double chance = randomObj.nextDouble();

					if (chance < CHANCE_TO_MOVE) {
						int xChange = randomObj.nextInt(3) - 1; // -1, 0, 1
						int yChange = randomObj.nextInt(3) - 1; // -1, 0, 1

						int xNew = x + xChange;
						int yNew = y + yChange; 


						boolean xCanMove = false;
						boolean yCanMove = false;

						if ((xChange != 0) && (xNew>=0) && (xNew<WIDTH) ) {
							xCanMove = true;
						}
						if ((yChange != 0) && (yNew>=0) && (yNew<HIGHT) ) {
							yCanMove = true;
						} 
						if ((xCanMove == true ) || (yCanMove == true)) {
							int xFinal = x;
							int yFinal = y;

							if (xCanMove == true ) {xFinal = xNew;} 
							if (yCanMove == true ) {yFinal = yNew;}

							if (river[xFinal][yFinal] == null) {
								river[xFinal][yFinal] = river[x][y];
								river[x][y] = null;

							} else if (river[x][y].getClass() == river[xFinal][yFinal].getClass()) {
								// Producing a baby animal.
								if (river[x][y].getClass().getName().endsWith("Fish") == true) {
									fishCount += addNewAnimal(new Fish() );	
								} if (river[x][y].getClass().getName().endsWith("Bear") == true) {
									bearCount += addNewAnimal(new Bear() );	
								}
							}  else if (river[x][y].getClass() != river[xFinal][yFinal].getClass()) {
								// If bear is moving onto a fish.

								if (river[x][y].getClass().getName().endsWith("Fish") == true) {
									if (fishCount > 0) {
										river[x][y] = null;
										fishCount--;
									}
									//the fish moves onto a bear.
								}
								if (river[xFinal][yFinal].getClass().getName().endsWith("Fish") == true) {
									if (fishCount > 0) {
										river[xFinal][yFinal] = river[x][y];
										fishCount--;
									}
									//the bear moves onto a fish.
								}
							}
						}
					}
				}
			}
		}

	}
	public void moveAndDisplay() {
		System.out.println (this);
		move();
	}



	public int addNewAnimal (Animal animal) {
		int addCount = 0;
		int totalCellsSoFar = fishCount + bearCount;

		if (totalCellsSoFar < WIDTH * HIGHT) {

			while(addCount == 0) {
				int x = randomObj.nextInt(WIDTH); // 0 <= x < WIDTH 
				int y = randomObj.nextInt(HIGHT); // 0 <= y < HIGHT

				if (river[x][y] == null) {
					river[x][y] = animal;
					addCount++;
				}
			}
		}
		return addCount;
	}
	public String toString () {
		String output = "";
		for (int y=0; y<HIGHT; y++)
		{
			for (int x=0; x<WIDTH; x++)
			{
				if (river[x][y] == null)
				{
					output += ".";
				} else if (river[x][y] instanceof Fish)
				{
					output += "F";
				}  else if (river[x][y] instanceof Bear)
				{
					output += "B";
				}
			}
			output += "\n";
		}
		output += "Fish: " + fishCount + "      Bears: " + bearCount;

		return output;
	}
}
