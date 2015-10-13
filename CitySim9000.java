// Michael Stoltz
// mas482

import java.util.Random;
import java.util.ArrayList;

public class CitySim9000 {
  public static void main(String[] args){

    // check to see if no arguments were provided
    if(args.length == 0){
      System.out.println("You must provide a seed argument!");
      System.exit(0);
    }

    // check to see if too many arguments were provided
    if(args.length > 1){
      System.out.println("Too many arguments!");
      System.exit(0);
    }

    // init seed variable
    int seed = 0;

    // try to parse integer from seed argument
    // in order to make sure it is a valid int
    try {
      seed = Integer.parseInt(args[0]);
    } catch (NumberFormatException e) {
      System.out.println("Argument must be an int!");
      System.exit(0);
    }

    // seed random generator
    Random rand = new Random(seed);
    // create array to hold all possible start locations
    ArrayList<Location> possibleLocations = new ArrayList<Location>();

    // create all location variables
    Location outsideCity = new Location("Outside City");
    Location mall = new Location("Mall");
    Location bookstore = new Location("Bookstore");
    Location university = new Location("University");
    Location coffee = new Location("Coffee");

    // set all connections between locations
    outsideCity.setEast(mall, "Fourth Ave.");
    mall.setEast(bookstore, "Fourth Ave.");
    mall.setSouth(coffee, "Meow St.");
    bookstore.setEast(outsideCity, "Fourth Ave.");
    bookstore.setSouth(university, "Chirp St.");

    outsideCity.setWest(university, "Fifth Ave.");
    university.setNorth(bookstore, "Chirp St.");
    university.setWest(coffee, "Fifth Ave.");
    coffee.setNorth(mall, "Meow St.");
    coffee.setWest(outsideCity, "Fifth Ave.");

    // add all possible starting locations to starting locations array
    possibleLocations.add(outsideCity);
    possibleLocations.add(mall);
    possibleLocations.add(bookstore);
    possibleLocations.add(university);
    possibleLocations.add(coffee);


    // cycle through each driver going through the city
    for(int driver = 0; driver < 5; driver++){
      // get a random index for a start location
      int startLocationIndex = rand.nextInt(possibleLocations.size());
      // get the start location from the array
      Location currentLocation = possibleLocations.get(startLocationIndex);

      // move the driver from the start location to the next random location
      currentLocation = currentLocation.moveDriver(driver, rand);

      // while the driver is not outside the city, continue moving to the next random location
      while(!currentLocation.outsideCity()){
        currentLocation = currentLocation.moveDriver(driver, rand);
      }

      // since the driver is now outside the city, inform the user and move to the next driver
      System.out.println("Driver " + driver + " has left the city!");
      System.out.println("-----");
    }
  }
}