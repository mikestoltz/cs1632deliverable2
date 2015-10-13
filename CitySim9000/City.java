// Michael Stoltz
// mas482

import java.util.Random;
import java.util.ArrayList;

public class City {
  Location outsideCity;
  Location mall;
  Location bookstore;
  Location university;
  Location coffee;

  Random rand;
  ArrayList<Location> possibleLocations;

  public City(int seed){
    // seed random generator
    this.rand = new Random(seed);
    // create array to hold all possible start locations
    this.possibleLocations = new ArrayList<Location>();

    // instantiate all location variables
    this.outsideCity = new Location("Outside City");
    this.mall = new Location("Mall");
    this.bookstore = new Location("Bookstore");
    this.university = new Location("University");
    this.coffee = new Location("Coffee");

    // set all connections between locations
    this.outsideCity.setEast(mall, "Fourth Ave.");
    this.mall.setEast(bookstore, "Fourth Ave.");
    this.mall.setSouth(coffee, "Meow St.");
    this.bookstore.setEast(outsideCity, "Fourth Ave.");
    this.bookstore.setSouth(university, "Chirp St.");
    this.outsideCity.setWest(university, "Fifth Ave.");
    this.university.setNorth(bookstore, "Chirp St.");
    this.university.setWest(coffee, "Fifth Ave.");
    this.coffee.setNorth(mall, "Meow St.");
    this.coffee.setWest(outsideCity, "Fifth Ave.");

    // add all possible starting locations to starting locations array
    this.possibleLocations.add(outsideCity);
    this.possibleLocations.add(mall);
    this.possibleLocations.add(bookstore);
    this.possibleLocations.add(university);
    this.possibleLocations.add(coffee);
  }

  public void traverseCity (int driver){
    // get the starting location for the driver
    Location currentLocation = getStartLocation();

    // move the driver from the start location to the next random location
    currentLocation = currentLocation.moveDriver(driver, rand);

    // while the driver is not outside the city, continue moving to the next random location
    while(!currentLocation.outsideCity()){
      currentLocation = currentLocation.moveDriver(driver, rand);
    }

    // since the driver is now outside the city, inform the user
    System.out.println("Driver " + driver + " has left the city!");
    System.out.println("-----");
  }

  public Location getStartLocation(){
    // get a random index for a start location
    int startLocationIndex = rand.nextInt(possibleLocations.size());
    // get the start location from the array
    return possibleLocations.get(startLocationIndex);
  }
}