// Michael Stoltz
// mas482

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

    City city = new City(seed);

    // cycle through each driver going through the city and traverse their path
    for(int driver = 0; driver < 5; driver++){
      city.traverseCity(driver);
    }
  }
}