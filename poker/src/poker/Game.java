package poker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if (args.length == 0) {
			System.out.print("No game file specified");
			return;
		}

		int p1=0,p2=0;
		try {
			File myObj = new File(args[0]);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {

				String[] arg = myReader.nextLine().split(" ");
				for (int i=0;i<args.length;i+=10) {

					Player a1 = new Player(arg[0],arg[1],arg[2],arg[3],arg[4]);
					Player a2 = new Player(arg[5],arg[6],arg[7],arg[8],arg[9]);

					if(a1.greaterThan(a2)) 
						p1++;
					else 
						p2++;
				}

			}
			myReader.close();



		} catch (Exception e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		System.out.print("Player 1: ");
		System.out.print(p1);
		System.out.print("\nPlayer 2: ");
		System.out.print(p2);
	}


}
