//Name: Aryan Singh

import java.util.*; //imported everything from the util class

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

		System.out.printf("%-16s%-18s%-18s%-15s", "PLAYER NAME   |", "HEIGHT (in)   |", "WEIGHT (lb)   |",
				"HOME COUNTRY"); // displaying the categories of the roster using column widths

		System.out.println(); // formatting line

		for (BallerRoster Raptors : BBallRoster) { // created a enhanced for loop where it will run though all 4
													// variables stored in the array

			System.out.printf("%-16s", Raptors.name); // printing the names of the roster and formatting it to 16
														// spaces, left justified
			System.out.printf("%-18s", Raptors.height);// printing the heights of the roster and formatting it to 18
														// spaces, left justified
			System.out.printf("%-18s", Raptors.weight);// printing the weights of the roster and formatting it to 18
														// spaces, left justified
			System.out.printf("%-15s", Raptors.country);// printing the countries of the roster and formatting it to 15
														// spaces, left justified

			System.out.println(); // formatting line

		} // closing enhanced for loop
	} // closing printBaller method

	public static void selectionSort(ArrayList<BallerRoster> BBallRoster) { // created a method called selectionSort which will sort the players alphabetically by name

		int n = BBallRoster.size(); // created an integer variable n where it stores the size of the array

		for (int i = 0; i < n - 1; i++) { // created a for loop that will go through each element in the array except the last one

			int minIndex = i; // created an integer called minIndex and initialized it with i, assuming the current index is the smallest

			for (int j = i + 1; j < n; j++) { // created another for loop starting from the next index to compare values

				if (BBallRoster.get(j).name.compareTo(BBallRoster.get(minIndex).name) < 0) { // comparing the names alphabetically using compareTo and checking if the current name is smaller than the one at minIndex

					minIndex = j; // if a smaller name is found, update minIndex to j
					
				} //closing if statement
				
			} // closing inner for loop

			BallerRoster temp = BBallRoster.get(i); // storing the current player at index i in a temporary variable called temp

			BBallRoster.set(i, BBallRoster.get(minIndex)); // setting the player at index i to the player at minIndex

			BBallRoster.set(minIndex, temp); // setting the player at minIndex to the one stored in temp to complete the swap
			
		} // closing outer for loop
		
	} // closing selectionSort method
	
	
	public static int binarySearch(ArrayList<BallerRoster> BBallRoster, String query) { // created a new method called binarySearch which will search for a player by name

		int lowestPossibleLoc = 0; // created an int variable called lowestPossibleLoc and set it to 0

		int highestPossibleLoc = BBallRoster.size() - 1; // created an int variable called highestPossibleLoc and set it to the last index of the array

		while (highestPossibleLoc >= lowestPossibleLoc) { // running the while loop while the search is valid

			int middle = (lowestPossibleLoc + highestPossibleLoc) / 2; // created an int variable called middle to find the middle index of the array

			if (BBallRoster.get(middle).name.equals(query)) // checking if the name at the middle index matches the query name
				
				return middle; // if found, return the index

			else if (BBallRoster.get(middle).name.compareTo(query) > 0) // if the name at middle is alphabetically greater than query
				
				highestPossibleLoc = middle - 1; // eliminate all indexes greater than or equal to middle

			else // if the name at middle is alphabetically less than query
				
				lowestPossibleLoc = middle + 1; // eliminate all names less than or equal to middle
			
		} // closing while loop

		return -1; // returning -1 if player is not found
		
	} // closing binarySearch method

	public class Baller { // opening main class

		static Scanner s = new Scanner(System.in); // created a static scanner called s where it will ask the users
													// input for the option

		static ArrayList<BallerRoster> BBallRoster = new ArrayList<BallerRoster>(); // created a static ArrayList called
																					// BBallRoster to store the 4
																					// variables of the BallerRoster
																					// class

		public static void main(String[] args) { // opening main method
			// TODO Auto-generated method stub

			boolean keepRepeating = true; // created a boolean variable called keepRepeating where it will allow the
											// while loop to run until it is false.

			while (keepRepeating == true) { // running the while loop was keepRepeating = true

				System.out.println("1 - Add Player"); // stating that number 1 is add player
				System.out.println("2 - Remove Player");// stating that number 2 is remove player
				System.out.println("3 - Count Players");// stating that number 3 is count players
				System.out.println("4 - Print Roster");// stating that number 4 is printing roster
				System.out.println("5 - Search Player");// stating that number 5 is searching the players
				System.out.println("6 - Exit");// stating that number 6 is exiting the application
				System.out.print("Please choose a option: "); // asking the user to choose an option
				System.out.print(""); // formatting line

				int option = s.nextInt(); // creating a new int variable called option and saving users input

				switch (option) { // creating a switch statement which will switch through the option variable

				case 1: // running case if option = 1

					BallerRoster Player = new BallerRoster(); // created a Player object class where it will save all 4
																// variables for the categories of the player

					System.out.print("What player would you like to add: "); // asking the user what player they would
																				// like to add

					Player.name = s.nextLine(); // saving the name to the object class and using nextLine for first name
												// and last name

					Player.name = s.nextLine(); // using nextLine for first name and last name

					System.out.print("Height (in): "); // asking the user for the height of the player

					Player.height = s.nextDouble();// saving the players height to the Player class

					System.out.print("Weight (lbs): "); // asking the user for the weight of the player

					Player.weight = s.nextDouble();// saving the players weight to the Player class

					System.out.print("Country: "); // asking the user for the country of the player

					Player.country = s.next(); // saving the players country to the Player class

					BBallRoster.add(Player); // adding the Player object to the array

					System.out.println("ADDED " + Player.name + " to the ROSTER."); // telling the user the player has
																					// been added to the roster

					System.out.println(); // formatting line

					break; // break out of case

				case 2: // running case if option = 2

					BallerRoster playerRemove = new BallerRoster(); // created a new object called playerRemove which
																	// will run through the name variable to remove a
																	// player out of the array

					System.out.print("What player would you like to remove: "); // asking the user what player they
																				// would like to remove
					playerRemove.name = s.nextLine(); // saving the users input and using nextLine for first name and
														// last name
					playerRemove.name = s.nextLine();// using nextLine for first name and last name

					for (BallerRoster Raptors : BBallRoster) { // running an enhanced for loop to find the player they
																// want to remove

						if (playerRemove.name.equals(Raptors.name)) { // running the if statement if the name typed in
																		// equals to a name stored in the array

							System.out.println("REMOVED " + playerRemove.name + " from the ROSTER."); // telling the
																										// user the the
																										// player was
																										// removed of
																										// the roster,
																										// which is the
																										// array
							System.out.println(); // formatting line
							playerRemove = Raptors; // the playerRemove object the array that was created to print the
													// roster
							BBallRoster.remove(playerRemove); // removing the player off the roster if the player was
																// found

							break; // break out of case
						} // closing if statement

						else { // opening else statement

							System.out.println(); // formatting line
							System.out.println(playerRemove.name + " was not found on the ROSTER."); // telling the user
																										// if the player
																										// was not found
							break; // break out of case

						} // closing else statement
					} // closing enhanced for loop

					break; // break out of case

				case 3: // running case if option = 3

					System.out.println("The number of players on the roster is " + BBallRoster.size() + "."); // printing
																												// the
																												// number
																												// of
																												// players
																												// on
																												// the
																												// roster
																												// in
																												// the
																												// array
																												// using
																												// .size
					System.out.println(); // formatting line
					break; // break out of case

				case 4: // running case if option = 4

					System.out.println(""); // formatting line

					System.out.println("The players on the roster are: "); // printing a line which will tell the user
																			// the players on the roster

					// BubbleSort(BBallRoster);

					selectionSort(BBallRoster);

					BallerRoster.printBaller(BBallRoster); // running the method to print the players on the roster
															// through an array

					System.out.println(); // formatting line

					break;// break out of case
					
				case 5: // running case if option = 5

					System.out.println(); // formatting line
					
					System.out.print("Enter the player name to search: "); // asking the user which player to search for
					
					String searchBaller = s.nextLine(); // taking the first name and last name from the user
					
					searchBaller = s.nextLine(); // nextLine for formatting

					selectionSort(BBallRoster); // making sure the list is sorted before binary search

					int findBaller = binarySearch(BBallRoster, searchBaller); // calling the binarySearch method 

					if (findBaller != -1) { // if the player was found in the roster
						
						BallerRoster foundBaller = BBallRoster.get(findBaller); // getting the player object at the found index
						
						System.out.println(searchBaller + " is on the basketball ROSTER."); // informing the user the player was found
						
						System.out.println(); // formatting line
						
						System.out.printf("%-16s%-18s%-18s%-15s", "PLAYER NAME   |", "HEIGHT (in)   |", "WEIGHT (lb)   |",
								"HOME COUNTRY"); // displaying the categories of the player using column widths
						
						System.out.println(); // formatting line
						
						System.out.printf("%-16s", foundBaller.name); // printing the names of the player and formatting it to 16
						// spaces, left justified
						
						System.out.printf("%-18s", foundBaller.height);// printing the heights of the player and formatting it to 18
						// spaces, left justified
						
						System.out.printf("%-18s", foundBaller.weight);// printing the weights of the player and formatting it to 18
						// spaces, left justified
						
						System.out.printf("%-15s", foundBaller.country);// printing the countries of the player and formatting it to 15
						// spaces, left justified
						
						System.out.println(); // formatting line
						
					} else { // if player not found
						
						System.out.println(searchBaller + " was not found on the basketball ROSTER."); // informing the user the player was not found
						
						System.out.println(); // formatting line
					}
					
					break; // break out of case

				case 6: // running case if option = 6

					keepRepeating = false; // the while loop stops because the user exits the program
					System.out.println("Thank you for using the basketball roster application."); // thanking the user
																									// for using the
																									// code
					break; // break out of case

				default: // if none of the cases are fulfilled, it will resort to the default case
					
					System.out.println("Invalid."); // telling the user the input is invalid

				} // closing switch statement

			} // closing while loop
		} // closing main method
	}
}
// closing Baller class