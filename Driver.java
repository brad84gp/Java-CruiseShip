import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

import java.lang.reflect.Array;


public class Driver {

    // instance variables (add more as needed)
    private static ArrayList<Ship> shipList = new ArrayList<>();
    private static ArrayList<Cruise> cruiseList = new ArrayList<>();
    private static ArrayList<Passenger> passengerList = new ArrayList<>();


    public static void main(String[] args) {
        initializeShipList();       // initial ships
        initializeCruiseList();     // initial cruises
        initializePassengerList();  // initial passengers

        // add loop and code here that accepts and validates user input
        // and takes the appropriate action. include appropriate
        // user feedback and redisplay the menu as needed
        
        //created a boolean that equaled false for the while statement to determine whether to run or not.
        // The display menu function is called to display menu every time the while loop runs.
        // User input is then taken and interpreted. If the input matches any of the if statements
        // below, then the method that follows within that if statement is ran. If the user input matches x
        //then the boolean variable is changed form false to true and the loop exits and the program terminates.
        boolean stop = false;
        while (!stop) {
        	displayMenu();
        	Scanner scnr = new Scanner(System.in);
        	String userInput = scnr.next();
        	if (userInput.equalsIgnoreCase("1")) {
        		addShip();
        	} if (userInput.equalsIgnoreCase("2")) {
        		editShip();
        	} if (userInput.equalsIgnoreCase("3")) {
        		addCruise();
        	} if (userInput.equalsIgnoreCase("4")) {
        		editCruise();
        	} if (userInput.equalsIgnoreCase("5")) {
        		addPassenger();
        	} if (userInput.equalsIgnoreCase("6")) {
        		editPassenger();
        	} if (userInput.equalsIgnoreCase("A")) {
        		printShipList("name");
        	} if (userInput.equalsIgnoreCase("B")) {
        		printShipList("active");
        	} if (userInput.equalsIgnoreCase("C")) {
        		printShipList("full");
        	} if (userInput.equalsIgnoreCase("D")) {
        		printCruiseList("list");
        	} if (userInput.equalsIgnoreCase("E")) {
        		printCruiseList("details");
        	} if (userInput.equalsIgnoreCase("F")) {
        		printPassengerList();
        	} if (userInput.equalsIgnoreCase("x")) {
        		stop = true;
        	}
        }
       
        }

    

    // hardcoded ship data for testing
    // Initialize ship list
    public static void initializeShipList() {
        add("Candy Cane", 20, 40, 10, 60, true);
        add("Peppermint Stick", 10, 20, 5, 40, true);
        add("Bon Bon", 12, 18, 2, 24, false);
        add("Candy Corn", 12, 18, 2, 24, false);
    }

    // hardcoded cruise data for testing
    // Initialize cruise list
    public static void initializeCruiseList() {
        Cruise newCruise = new Cruise("Southern Swirl", "Candy Cane", "Miami", "Cuba", "Miami");
        cruiseList.add(newCruise);
    }

    // hardcoded cruise data for testing
    // Initialize passenger list
    public static void initializePassengerList() {
        Passenger newPassenger1 = new Passenger("Neo Anderson", "Southern Swirl", "STE");
        passengerList.add(newPassenger1);

        Passenger newPassenger2 = new Passenger("Trinity", "Southern Swirl", "STE");
        passengerList.add(newPassenger2);

        Passenger newPassenger3 = new Passenger("Morpheus", "Southern Swirl", "BAL");
        passengerList.add(newPassenger3);
    }

    // custom method to add ships to the shipList ArrayList
    public static void add(String tName, int tBalcony, int tOceanView,
                           int tSuite, int tInterior, boolean tInService) {
        Ship newShip = new Ship(tName, tBalcony, tOceanView, tSuite, tInterior, tInService);
        shipList.add(newShip);
    }


    public static void printShipList(String listType) {
        // printShipList() method prints list of ships from the
        // shipList ArrayList. There are three different outputs
        // based on the listType String parameter:
        // name - prints a list of ship names only
        // active - prints a list of ship names that are "in service"
        // full - prints tabbed data on all ships

        if (shipList.size() < 1) {
            System.out.println("\nThere are no ships to print.");
            return;
        }
        if (listType == "name") {
            System.out.println("\n\nSHIP LIST - Name");
            for (int i = 0; i < shipList.size(); i++) {
                System.out.println(shipList.get(i));
            }
        } else if (listType == "active") {
            System.out.println("\n\nSHIP LIST - Active");
            //this for loop cycles through the ship array list and pulls any ship who's
            // in service status is true. These are considered active ships and each one is printed.
            for (int i = 0; i < shipList.size(); i++) {
            	if (shipList.get(i).getInService()) {
            		System.out.println(shipList.get(i));
            	}
            }
            // complete this code block


        } else if (listType == "full") {
            System.out.println("\n\nSHIP LIST - Full");
            System.out.println("-----------------------------------------------");
            System.out.println("                    Number of Rooms     	In");
            System.out.print("SHIP NAME           Bal OV     Ste      Int     Service");
            System.out.println("\n-----------------------------------------------");
            for (Ship eachShip: shipList)
                eachShip.printShipData();

        } else
            System.out.println("\n\nError: List type not defined.");
    }

    public static void printCruiseList(String listType) {
        if (cruiseList.size() < 1) {
            System.out.println("\nThere are no cruises to print.");
            return;
        }
        if (listType == "list") {
            System.out.println("\n\nCRUISE LIST");
            for (int i=0; i < cruiseList.size(); i++) {
                System.out.println(cruiseList.get(i));
            }
        } else if (listType == "details") {
            System.out.println("\n\nCRUISE LIST - Details");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("                                      |----------------------PORTS-----------------------|");
            System.out.print("CRUISE NAME         SHIP NAME           DEPARTURE           DESTINATION         RETURN");
            System.out.println("\n-----------------------------------------------------------------------------------------");
            for (Cruise eachCruise: cruiseList)
                eachCruise.printCruiseDetails();
        } else
            System.out.println("\n\nError: List type not defined.");
    }

    public static void printPassengerList() {
        if (passengerList.size() < 1) {
            System.out.println("\nThere are no passengers to print.");
            return;
        }
        System.out.println("\n\nPASSENGER LIST");
        System.out.println("-----------------------------------------------------");
        System.out.print("PASSENGER NAME      CRUISE              ROOM TYPE");
        System.out.println("\n-----------------------------------------------------");
        for (Passenger eachPassenger: passengerList)
            eachPassenger.printPassenger();
    }

    // display text-based menu
    public static void displayMenu() {
    	
        System.out.println("\n\n");
        System.out.println("\t\t\tLuxury Ocean Cruise Outings");
        System.out.println("\t\t\t\t\tSystem Menu\n");
        System.out.println("[1] Add Ship            [A] Print Ship Names");
        System.out.println("[2] Edit Ship           [B] Print Ship In Service List");
        System.out.println("[3] Add Cruise          [C] Print Ship Full List");
        System.out.println("[4] Edit Cruise         [D] Print Cruise List");
        System.out.println("[5] Add Passenger       [E] Print Cruise Details");
        System.out.println("[6] Edit Passenger      [F] Print Passenger List");
        System.out.println("[x] Exit System");
        System.out.println("\nEnter a menu selection: ");
    }

    // Add a New Ship
    // this method will add a ship when called. The method start off by requesting for a
    // new ship name to be entered. The for loop cycles through the existing arrarylist for
    // ships. If the name exists, the loop is canceled and a statement is printed. The user 
    // is then redirected back to the main menu. If the name does not match any within the arrarylist
    // then more information is attained from the user and added to the arraylist.
    public static void addShip() {
    	Scanner scnr = new Scanner(System.in);
        Ship newShip = new Ship();
    	System.out.println("Enter ship name: ");
    	newShip.setShipName(scnr.nextLine());
    	boolean nonExist = false;
    	while(!nonExist) {
    		for (int k = 0; k < shipList.size();k++) {
	    		if(shipList.get(k).getShipName().equalsIgnoreCase(newShip.getShipName())) {
	            	System.out.println("Ship already exists, please start over.");
	            	nonExist = true;
	            	break;
	            	
	    		}
	    		else {
	    			nonExist = false;
	    			continue;
	
	    		}
    		}
    	
            if (nonExist == false) {
            	// exception handling using throw and catch to determine if the number is less than zero.
            	// if the number  is less than zero, the exception is thrown and the addship method exits.
            	// if the number is not an integer, the addship method exits. If it is not an integer
            	// the catch is automtically displayed and then the addship method exits.
            	try {
			    	System.out.println("Enter number of balcony rooms: ");
			    	newShip.setRoomBalcony(scnr.nextInt());
			    	if (newShip.getRoomBalcony() < 0) {
			    		throw new Exception("Number needs to be 0 or greater");
			    	}
			    	
			    	
			    	System.out.println("Enter number of oceanview rooms: ");
			    	newShip.setRoomOceanView(scnr.nextInt());
			    	if (newShip.getRoomOceanView() < 0) {
			    		throw new Exception("Number needs to be 0 or greater");
			    	}
			    	
			    	
			    	System.out.println("Enter number of suite rooms: ");
			    	newShip.setRoomSuite(scnr.nextInt());
			    	if (newShip.getRoomSuite() < 0) {
			    		throw new Exception("Number needs to be 0 or greater");
			    	}
			    	
			    	
			    	System.out.println("Enter number of interior rooms: ");
			    	newShip.setRoomInterior(scnr.nextInt());
			    	if (newShip.getRoomInterior() < 0) {
			    		throw new Exception("Number needs to be 0 or greater");
			    	}
			    	
			    	
			    	System.out.println("Enter in service status: ");
			    	newShip.setInService(scnr.nextBoolean());
			    	shipList.add(newShip);
			    	nonExist = true;
            } 
            	catch(Exception excpt1) {
            		System.out.println(excpt1.getMessage());
            		System.out.print("Number needs to be in integer format");
            		System.out.println();
            	}
        }

    }
    }
    

    // Edit an existing ship
    public static void editShip() {
    	Scanner scnr = new Scanner(System.in);
    	System.out.println("Enter the name of the ship you would like to edit: ");
    	String shipName = scnr.nextLine();
    	for (int k = 0 ; k <shipList.size();k++) {
    		if (shipList.get(k).getShipName().equalsIgnoreCase(shipName)) {
    			int BAL = shipList.get(k).getRoomBalcony();
    			int OV = shipList.get(k).getRoomOceanView();
    			int Suite = shipList.get(k).getRoomSuite();
    			int Interior = shipList.get(k).getRoomInterior();
    			boolean serviceStatus = shipList.get(k).getInService();
    			boolean cont = true;
    			while(cont) {
    				System.out.println("What would you like to change?");
    				System.out.println("[1] Ship Name              [2] # of Balcony roooms ");
    				System.out.println("[3] # of OceanView rooms   [4] # of Suite rooms ");
    				System.out.println("[5] # of Interior rooms    [6] Service status");
    				System.out.println("[x] Main Menu");
    				String userAns = scnr.next();
    				if (userAns.equals("1")) {
    					System.out.println("Enter new ship name: ");
    					String newShipName = scnr.nextLine();
    					for(Ship eachShip: shipList) {
    						if(eachShip.getShipName().equals(shipName)) {
    							eachShip.setShipName(newShipName);
    							
    						}
    					}
    				}
    				
    				if(userAns.equals("2")) {
    					System.out.println("Enter new number of balcony rooms: ");
    					int balconyRooms = scnr.nextInt();
    					for(Ship eachShip: shipList) {
    						if(eachShip.getRoomBalcony() == BAL) {
    							eachShip.setRoomBalcony(balconyRooms);
    							
    						}
    					}
    				}
    				
    				if(userAns.equals("3")) {
    					System.out.println("Enter new number of ocean view rooms: ");
    					int oceanView = scnr.nextInt();
    					for(Ship eachShip: shipList) {
    						if(eachShip.getRoomOceanView() == OV) {
    							eachShip.setRoomOceanView(oceanView);
    							
    						}
    					}
    				}
    				
    				if(userAns.equals("4")) {
    					System.out.println("Enter new number of suite rooms: ");
    					int suiteRooms = scnr.nextInt();
    					for(Ship eachShip: shipList) {
    						if(eachShip.getRoomSuite() == Suite) {
    							eachShip.setRoomSuite(suiteRooms);
    							
    						}
    					}
    				}
    				
    				if(userAns.equals("5")) {
    					System.out.println("Enter new number of interior rooms: ");
    					int interiorRooms = scnr.nextInt();
    					for(Ship eachShip: shipList) {
    						if(eachShip.getRoomInterior() == Interior) {
    							eachShip.setRoomInterior(interiorRooms);
    							
    						}
    					}
    				}
    				
    				if(userAns.equals("6")) {
    					System.out.println("Enter new service status: ");
    					boolean inServiceStatus = scnr.nextBoolean();
    					for(int i = 0; i < shipList.size(); i++) {
    						if(shipList.get(i).getShipName().equalsIgnoreCase(shipName)) {
    							shipList.get(i).setInService(inServiceStatus);
    						}
    					}	
    				}
    				
    				if (userAns.equalsIgnoreCase("x")) {
    					printShipList("full");
    					cont = false;
    					return;
    				}
	
    			}
    		}    		
    	}
    	System.out.println("Ship does not exist, Exiting to the main menu....");
    	return;
    }
    	
    	

      
    // this method will add a cruise when called. The method start off by requesting for a
    // new cruise name to be entered. The for loop cycles through the existing arrarylist for
    // cruises. If the name exists, the loop is canceled and a statement is printed. The user 
    // is then redirected back to the main menu. If the name does not match any within the arrarylist
    // then more information is attained from the user and added to the arraylist.
	public static void addCruise() {
    	Scanner scnr = new Scanner(System.in);
        Cruise newCruise = new Cruise();
    	System.out.println("Enter cruise name: ");
	    newCruise.setCruiseName(scnr.nextLine());
	    boolean nonExist = false;
    	while(!nonExist) {
    		for (int k = 0; k < cruiseList.size();k++) {
	    		if(cruiseList.get(k).getCruiseName().equalsIgnoreCase(newCruise.getCruiseName())) {
	            	System.out.println("Cruise already exists, please start over.");
	            	nonExist = true;
	            	return;
	            	
	    		}
	    		else {
	    			nonExist = false;
	    			continue;
	    		}
    		}
    	
            if (nonExist == false){
            	// exception hanlding added to verify string length is over 3. if word length is 2 or shorter
            	//exception is thrown and addcruise method is exited. displaymenu method is called and started again.
            	try {
					System.out.println("Enter cruise ship name: ");
					newCruise.setCruiseShipName(scnr.nextLine());
					if(newCruise.getCruiseShipName().length()<=2) {
						throw new Exception("Invalid word length");
					}
					
					System.out.println("Enter departure port: ");
					newCruise.setDeparturePort(scnr.nextLine());
					if(newCruise.getDeparturePort().length()<=2) {
						throw new Exception("Invalid word length");
					}
					
					System.out.println("Enter destination: ");
					newCruise.setDestination(scnr.nextLine());
					if(newCruise.getDestination().length()<=2) {
						throw new Exception("Invalid word length");
					}
					
					System.out.println("Enter return port: ");
					newCruise.setReturnPort(scnr.nextLine());
					if(newCruise.getReturnPort().length()<=2) {
						throw new Exception("Invalid word length");
					}
					
			        cruiseList.add(newCruise);
			        nonExist = true;
            } catch(Exception excpt1){
            	System.out.println(excpt1.getMessage());
            	System.out.println("Please enter information in word format");        	
            }
        }
        }
	}
		 
	


    
    
    	

	// Edit an existing cruise
    public static void editCruise() {
    	Scanner scnr = new Scanner(System.in);
    	System.out.println("Enter the name of the cruise youd like to edit: ");
    	String cruiseName = scnr.nextLine();
    	for (int k = 0; k < cruiseList.size(); k++) {
    		if(cruiseList.get(k).getCruiseName().equalsIgnoreCase(cruiseName)) {
    			String shipName = cruiseList.get(k).getCruiseShipName();
    			String departPort = cruiseList.get(k).getDeparturePort();
    			String destination = cruiseList.get(k).getDestination();
    			String returnPort = cruiseList.get(k).getReturnPort();
    			boolean cont = true;
    			while(cont) {
    				System.out.println("What would you like to change?");
    				System.out.println("[1] Cruise Name     [2] Cruise Ship Name");
    				System.out.println("[3] Departure Port  [4] Destination");
    				System.out.println("[5] Return Port     [x] Main Menu");
    				String userAns = scnr.nextLine();
    				if (userAns.equals("1")) {
    					System.out.println("Enter new name for cruise: ");
    					String newCruiseName = scnr.nextLine();
    					for (Cruise eachCruise : cruiseList) {
    			    	    if (eachCruise.getCruiseName().equalsIgnoreCase(cruiseName)) {
    			    	        eachCruise.setCruiseName(newCruiseName);
    			    	    }
    					}
    				
    				}
    				if(userAns.equals("2")) {
    					System.out.println("Enter new Cruise Ship Name: ");
    					String newCruiseShipName = scnr.nextLine();
    					for(Cruise eachCruise: cruiseList) {
    						if(eachCruise.getCruiseShipName().equalsIgnoreCase(shipName)) {
    							eachCruise.setCruiseShipName(newCruiseShipName);

    						}
    					}
    				}
    				if (userAns.equals("3")) {
    					System.out.println("Enter new departure port: ");
    					String newDepartPort = scnr.nextLine();
    					for(Cruise eachCruise: cruiseList) {
    						if(eachCruise.getDeparturePort().equalsIgnoreCase(departPort)) {
    							eachCruise.setDeparturePort(newDepartPort);
    						}
    					}
    				}
    				if(userAns.equals("4")) {
    					System.out.println("Enter new destinatin: ");
    					String newDest = scnr.nextLine();
    					for(Cruise eachCruise: cruiseList) {
    						if(eachCruise.getDestination().equalsIgnoreCase(destination)) {
    							eachCruise.setDestination(newDest);
    						}
    					}
    				}
    				if (userAns.equals("5")) {
    					System.out.println("Enter new return port: ");
    					String newReturnPort = scnr.nextLine();
    					for(Cruise eachCruise: cruiseList) {
    						if(eachCruise.getReturnPort().equalsIgnoreCase(returnPort)) {
    							eachCruise.setReturnPort(newReturnPort);
    						}
    					}
    				}
    				if (userAns.equalsIgnoreCase("x")) {
    					printCruiseList("details");
    					cont = false;
    					return;
    				}
    			
    			}
    		}
    	}
    	System.out.println("Cruise does not exist within the system, exiting to main menu....");
    	return;
    }
    
    	
    

    // Add a New Passenger
    @SuppressWarnings("unused")
	public static void addPassenger() {

        Scanner newPassengerInput = new Scanner(System.in);
        System.out.println("Enter the new passenger's name: ");
        String newPassengerName = newPassengerInput.nextLine();

        // ensure new passenger name does not already exist
        for (Passenger eachPassenger: passengerList) {
            if (eachPassenger.getPassengerName().equalsIgnoreCase(newPassengerName)) {
                System.out.println("That passenger is already in the system. Exiting to menu...");
                return; // quits addPassenger() method processing
            }
        }

        // get cruise name for passenger
        System.out.println("Enter cruise name: ");
        String newCruiseName = newPassengerInput.nextLine();

        // ensure cruise exists
        boolean nonExist = false;
    	while(!nonExist) {
    		for (int k = 0; k < cruiseList.size(); k++) {
	    		if(cruiseList.get(k).getCruiseName().equalsIgnoreCase(newCruiseName)) {
			        System.out.println("Enter Room Type (BAL, OV, STE, or INT: ");
			        String room = newPassengerInput.nextLine();
			        // validate room type
			        if ((room.equalsIgnoreCase("BAL")) || (room.equalsIgnoreCase("OV")) ||
			                (room.equalsIgnoreCase("STE")) || (room.equalsIgnoreCase("INT"))) {
			            // validation passed - add passenger
			            Passenger newPassenger = new Passenger(newPassengerName, newCruiseName, room.toUpperCase());
			            passengerList.add(newPassenger);
			            nonExist = false;
			            return;
			        } else {
			            System.out.println("Invalid input. Exiting to menu...");
			            return; // quits addPassenger() method processing
        }
    }
    		}
	    		
	    System.out.println("Cruise does not exist in the system. Exiting to main menu...");
	    return;
	    		}
    		}
	    		

    // Edit an existing passenger
    public static void editPassenger() {
    	Scanner scnr = new Scanner(System.in);
    	System.out.println("Enter the name of the passenger you would like to edit: ");
    	String newName = scnr.nextLine();
    	for(int k = 0; k < passengerList.size(); k++) {
    		if(passengerList.get(k).getPassengerName().equalsIgnoreCase(newName)) {
    			String cruise = passengerList.get(k).getPassengerCruise();
    			String roomType = passengerList.get(k).getPassengerRoomType();
    			boolean cont = true;
    			while (cont) {
	    			System.out.println("What would you like to edit: ");
	    			System.out.println("[1] Passenger Name     [2] Passeneger Cruise");
	    			System.out.println("[3] Passenger Room     [x] Main Menu");
	    			String userAns = scnr.nextLine();
    				if (userAns.equals("1")) {
    					System.out.println("Enter passengers name: ");
    					String passengersName = scnr.nextLine();
    					for(Passenger eachPassenger: passengerList) {
    						if(eachPassenger.getPassengerName().equalsIgnoreCase(newName)) {
    							eachPassenger.setPassengerName(passengersName);
    							continue;
    						}
    					}
    				}
    				
    				if(userAns.equals("2")) {
    					System.out.println("Enter passengers cruise: ");
    					String passengersCruise = scnr.nextLine();
    					for(int i = 0; i < passengerList.size(); i++) {
    						if(passengerList.get(i).getPassengerName().equalsIgnoreCase(newName)) {
    							passengerList.get(i).setPassengerCruise(passengersCruise);
    							break;
    						}
    					}
    					System.out.println("Cruise Does not exist");
    				}
    				
    				if(userAns.equals("3")) {
    					System.out.println("Enter passengers room: ");
    					String passengersRoom = scnr.nextLine();
    					for(int i = 0; i < passengerList.size(); i++) {
    						if(passengerList.get(i).getPassengerName().equalsIgnoreCase(newName)) {
    							passengerList.get(i).setPassengerRoomType(passengersRoom);
    							break;
    						}
    					}
    				}
    				if(userAns.equalsIgnoreCase("x")) {
    					printPassengerList();
    					cont = false;
    					return;
    				}
    						
    			}
    		}
    	}
    	System.out.println("Passenger does not exist in the system, exiting to main menu...");
    	return;
    }


    // Method to check if input is a number
    public static boolean isANumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)) == false)
                return false;
        }
        return true;
    }

}

