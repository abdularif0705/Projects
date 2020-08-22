public class Person{

  private String name;
  private int age;
  private boolean hungry;
  private double totalDistance;
  private double walkingCapacity;
  private boolean tired;
  private boolean sleeping;
  private Person friend;

//Constructor
  //Initializes value for this person to have, including a few input values

  public Person(String Name, int Age){
    this.name = Name;
    this.age = Age;
    this.hungry = true; // starts hungry
    this.totalDistance = 0;
    this.walkingCapacity = 4; 
    this.tired = false; // not tired 
    this.sleeping = false;  // awake
    this.friend = null; 
    System.out.println(name + " was posessed");
  }
//Methods
  //tests if person is old enough to speak
    public void talk(String speak){
    if (age >= 2)
      System.out.println(name +" says \""+speak+"\"");
    else
      System.out.println(name + " started crying");
  }

  //tests if person can eat or is full
  public void eat(){
    if(hungry) { 
      System.out.println(name + " ate some grub.");
      hungry = false; 
    }
    else{
      System.out.println(name + " is full!");
    }
  }

  //Makes person hungry if they aren't already
  public void needFood(){
    if(!hungry) { 
      System.out.println(name + " is hungry and needs food.");
      hungry = true;
    }
    else{
      System.out.println(name + " is already hungry, and needs food.");
    }
  }

  //Person travels allowable input distance (dependent on capacity), and gets tired if capacity is reached
  public void walk(double partDistance){
    if (tired){
      System.out.println(name + " is tired, and needs to rest before they can walk again.");
    }
    else if (sleeping){
      System.out.println(name + " is sleeping...");
    }
    else if (partDistance + totalDistance > walkingCapacity){
      System.out.println(name + " can't walk that far.");
    }
    else{
      System.out.println(name + " walked for " + partDistance + " km.");
      this.totalDistance += partDistance;
      if(totalDistance >= walkingCapacity) {
        this.tired = true; 
        System.out.println(name + " is now tired!");
      }
    }
  }

  //Puts person to sleep unless already sleeping, and resets tired and daily distance values
  public void sleep() {
    if(sleeping) { 
      System.out.println(name + " is already sleeping...");
    }
    else {
      sleeping = true;
      System.out.println(name + " went to sleep.");
      this.tired = false; 
      this.totalDistance = 0; 
    }
  }

  //Makes person wake up if sleeping
  public void awake() {
    if(sleeping) { 
      System.out.println(name + " has woken up.");
      sleeping = false; 
    }
    else {
      System.out.println(name + " is already awake.");
    }
  }

//  Ages person by one year
  public void grow() {
    this.age += 1; 
    System.out.println(name + " is now " + age + " years old.");
    if(age >= 55) { //when person turns 55 they lose half of their ability to walk.
      if(age % 5 == 0) {
        walkingCapacity /= 2;//They lose half of their ability to walk every 5 years after 55
        System.out.println(name + "'s walking capacity is now: " + walkingCapacity + " kms.");
      }
      if (age == 69)
        System.out.println(name + " made it to "+age+ "\n\"Nice.\"");
    }
  }

  //Person befriends someone if they are able to.
  public void getFriend(Person newFriend){
    if(friend != null) {
      System.out.println(name + " can't have anymore friends.");
    }
    else {
      this.friend = newFriend;
      System.out.println(name + " and " + friend.name + " became friends.");
    }
  }

  //Person replaces current friend with someone else
  public void changeFriend(Person newFriend){
    if(friend == null) {
      System.out.println(name + " can't change friends when they dont even have any...");
    }
    else {
      System.out.println(name + " cut off " + friend.name + ".");
      this.friend = newFriend;
      System.out.println(name + " is now friends with " + friend.name + ".");
    }
  }
}
