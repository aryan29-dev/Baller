import java.util.*; // imported everything from the util class

class BallerRoster { // created a new class called BallerRoster where it will store all the variables
						// and print them through a method called printBaller

	String name; // created a string variable called name where it will store the players names.
	double height; // created a double variable called height where it will store the players
					// heights.
	double weight; // created a double variable called weight where it will store the players
					// weights.
	String country; // created a string variable called country where it will store the players
					// countries.

	public static void printBaller(ArrayList<BallerRoster> BBallRoster) { // created a new method called printBaller
																			// where it will print the roster with all
																			// the 4 variables
		System.out.println(); // formatting line

		System.out.printf("%-16s%-18s%-18s%-15s%n",
				"PLAYER NAME", "HEIGHT (in)", "WEIGHT (lb)", "HOME COUNTRY"); // displaying the categories

		System.out.println(); // formatting line

		for (BallerRoster Raptors : BBallRoster) { // created an enhanced for loop

			System.out.printf("%-16s", Raptors.name); // printing name
			System.out.printf("%-18s", Raptors.height); // printing height
			System.out.printf("%-18s", Raptors.weight); // printing weight
			System.out.printf("%-15s", Raptors.country); // printing country

			System.out.println(); // formatting line
		}
	}

	public static void selectionSort(ArrayList<BallerRoster> BBallRoster) { // created a method called selectionSort

		int n = BBallRoster.size(); // created an integer variable n where it stores the size of the array

		for (int i = 0; i < n - 1; i++) { // created a for loop

			int minIndex = i; // created an integer called minIndex

			for (int j = i + 1; j < n; j++) { // created another for loop

				if (BBallRoster.get(j).name.compareTo(BBallRoster.get(minIndex).name) < 0) {
					minIndex = j; // update minIndex
				}
			}

			BallerRoster temp = BBallRoster.get(i); // temporary variable
			BBallRoster.set(i, BBallRoster.get(minIndex)); // swap
			BBallRoster.set(minIndex, temp); // swap
		}
	}

	public static int binarySearch(ArrayList<BallerRoster> BBallRoster, String query) { // created binarySearch method

		int lowestPossibleLoc = 0;
		int highestPossibleLoc = BBallRoster.size() - 1;

		while (highestPossibleLoc >= lowestPossibleLoc) {

			int middle = (lowestPossibleLoc + highestPossibleLoc) / 2;

			if (BBallRoster.get(middle).name.equals(query))
				return middle;

			else if (BBallRoster.get(middle).name.compareTo(query) > 0)
				highestPossibleLoc = middle - 1;

			else
				lowestPossibleLoc = middle + 1;
		}

		return -1; // returning -1 if player is not found
	}
}

public class Baller { // opening main class

	static Scanner s = new Scanner(System.in); // created a static scanner called s

	static ArrayList<BallerRoster> BBallRoster = new ArrayList<>(); // created a static ArrayList

	public static void main(String[] args) { // opening main method

		boolean keepRepeating = true; // created a boolean variable called keepRepeating

		while (keepRepeating == true) { // running the while loop

			System.out.println("1 - Add Player");
			System.out.println("2 - Remove Player");
			System.out.println("3 - Count Players");
			System.out.println("4 - Print Roster");
			System.out.println("5 - Search Player");
			System.out.println("6 - Exit");
			System.out.print("Please choose a option: ");

			int option = s.nextInt();
			s.nextLine();

			switch (option) {

				case 1 -> {
					BallerRoster Player = new BallerRoster();

					System.out.print("What player would you like to add: ");
					Player.name = s.nextLine();

					System.out.print("Height (in): ");
					Player.height = s.nextDouble();
					s.nextLine();

					System.out.print("Weight (lbs): ");
					Player.weight = s.nextDouble();
					s.nextLine();

					System.out.print("Country: ");
					Player.country = s.nextLine();

					BBallRoster.add(Player);

					System.out.println("ADDED " + Player.name + " to the ROSTER.\n");
				}

				case 2 -> {
					System.out.print("What player would you like to remove: ");
					String removeName = s.nextLine();

					boolean removed = false;

					for (int i = 0; i < BBallRoster.size(); i++) {
						if (BBallRoster.get(i).name.equals(removeName)) {
							BBallRoster.remove(i);
							removed = true;
							System.out.println("REMOVED " + removeName + " from the ROSTER.\n");
							break;
						}
					}

					if (!removed) {
						System.out.println(removeName + " was not found on the ROSTER.\n");
					}
				}

				case 3 -> System.out.println("The number of players on the roster is " + BBallRoster.size() + ".\n");

				case 4 -> {
					BallerRoster.selectionSort(BBallRoster);
					BallerRoster.printBaller(BBallRoster);

					System.out.println(); // spacing line
					System.out.println(); // spacing line
				}

				case 5 -> {
					System.out.print("Enter the player name to search: ");
					String searchBaller = s.nextLine();

					BallerRoster.selectionSort(BBallRoster);
					int findBaller = BallerRoster.binarySearch(BBallRoster, searchBaller);

					if (findBaller != -1) {
						BallerRoster found = BBallRoster.get(findBaller);
						System.out.println(searchBaller + " is on the basketball ROSTER.\n");

						System.out.printf("%-16s%-18s%-18s%-15s%n",
								"PLAYER NAME", "HEIGHT (in)", "WEIGHT (lb)", "HOME COUNTRY");
						System.out.println();

						System.out.printf("%-16s%-18s%-18s%-15s%n",
								found.name, found.height, found.weight, found.country);
					} else {
						System.out.println(searchBaller + " was not found on the basketball ROSTER.\n");
					}
				}

				case 6 -> {
					keepRepeating = false;
					System.out.println("Thank you for using the basketball roster application.");
				}

				default -> System.out.println("Invalid.");
			}
		}
	}
}
