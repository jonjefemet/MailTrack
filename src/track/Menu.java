package track;

import java.util.Scanner;

import services.TrackingDispatcher;

public class Menu {

	private static String showOptions() {

		String menu = "*************** Menu ***************  \n" + "1. Number Tracking. \n" + "5. Exit the program. \n"
				+ "****************************** ******************* \n";
		return menu;
	}

	public static void excuteOptions(int opction) {
		switch (opction) {
		case 1:
			new TrackingDispatcher().dispatcher();
			break;
		case 5:
			System.out.println("Bye, bye");

			break;
		default:
			System.out.println("Unexpected value: " + opction);
			break;
		}

	}

	public void startMenu() {

		int opction = 0;
		Boolean isvalid = false;

		Scanner sc = new Scanner(System.in);
		System.out.println(Menu.showOptions());
		do {
			System.out.println("Please select one of the above options:");

			while (!isvalid) {
				try {
					opction = sc.nextInt();
					isvalid = true;
				} catch (Exception e) {
					System.out.println("\nWrong value, please select one of the above options:");
					sc = new Scanner(System.in);
				}
			}
			isvalid = false;
			try {
				excuteOptions(opction);	
			} catch (Exception e) {
				System.out.println(e);
			}
			
			
		} while (opction != 5);

		sc.close();

	}
}
