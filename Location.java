// Michael Stoltz
// mas482

import java.util.Random;
import java.util.ArrayList;

public class Location {
  String name;
  Location northLocation;
  String northStreet;
  Location southLocation;
  String southStreet;
  Location eastLocation;
  String eastStreet;
  Location westLocation;
  String westStreet;
  ArrayList<String> directionsArray;

  // constructor, sets location name string and initializes everything else to null
  public Location(String name){
    this.name = name;
    this.northLocation = null;
    this.northStreet = null;
    this.southLocation = null;
    this.southStreet = null;
    this.eastLocation = null;
    this.eastStreet = null;
    this.westLocation = null;
    this.westStreet = null;

    this.directionsArray = new ArrayList<String>();
  }

  // move the driver from current location to a random next location
  // return the next location aka new current location
  public Location moveDriver(int driver, Random rand){
    // get the number of possible locations to move to from the current location
    int optionCount = this.directionsArray.size();

    // generate a random index based on the count
    int directionIndex = rand.nextInt(optionCount);

    // get the direction to move to
    String direction = this.directionsArray.get(directionIndex);

    Location nextLocation = null;
    String street = null;

    // get the actual location and street to travel on for the next location
    // based on the direction returned

    if(direction.equals("north")){
      nextLocation = this.northLocation;
      street = this.northStreet;
    } else if(direction.equals("south")){
      nextLocation = this.southLocation;
      street = this.southStreet;
    } else if(direction.equals("east")){
      nextLocation = this.eastLocation;
      street = this.eastStreet;
    } else if(direction.equals("west")){
      nextLocation = this.westLocation;
      street = this.westStreet;
    }

    // print driver's travel route
    System.out.println("Driver " + driver + " heading from " + this.name + " to " + nextLocation.name + " via " + street);
    // retuen new current location
    return nextLocation;
  }

  // test to see if the driver's current location is outside the city
  public boolean outsideCity(){
    return this.name.equals("Outside City");
  }

  // set the northern adjacent location to the current location and street to travel there on
  public void setNorth(Location loc, String street){
    this.northLocation = loc;
    this.northStreet = street;
    this.directionsArray.add("north");
  }

  // set the southern adjacent location to the current location and street to travel there on
  public void setSouth(Location loc, String street){
    this.southLocation = loc;
    this.southStreet = street;
    this.directionsArray.add("south");
  }

  // set the eastern adjacent location to the current location and street to travel there on
  public void setEast(Location loc, String street){
    this.eastLocation = loc;
    this.eastStreet = street;
    this.directionsArray.add("east");
  }

  // set the western adjacent location to the current location and street to travel there on
  public void setWest(Location loc, String street){
    this.westLocation = loc;
    this.westStreet = street;
    this.directionsArray.add("west");
  }
}
