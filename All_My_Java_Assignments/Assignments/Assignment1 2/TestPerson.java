public class TestPerson{

  public static void main(String[] args){
    Person person1 = new Person("Ichigo Kurosaki", 1);
    Person person2 = new Person("Selena Gomez", 27);
    Person person3 = new Person("Tupac Shakur", 54); //
    person2.talk("Was good fam");
    person1.talk("Yee");
    person3.eat();
    person3.eat();
    person3.needFood();
    person3.eat();
    person2.walk(7);
    person2.walk(4);
    person2.sleep();
    person2.sleep();
    person1.awake();
    person2.awake();
    person1.walk(2.5);
    person1.walk(3);
    person1.walk(1.5);
    person1.grow();
    person1.talk("Nyeahhh ehhh!");
    person3.grow();
    person3.grow();
    person3.walk(2);
    person3.sleep();
    person3.grow();
    person3.grow();
    person3.grow();
    person3.grow();
    person3.grow();
    person3.grow();
    person3.grow();
    person3.grow();
    person3.grow();
    person3.grow();
    person3.grow();
    person3.grow();
    person3.grow();
    person3.awake();
    person3.walk(0.5);
    person3.walk(0.5);
    person2.getFriend(person1);
    person2.getFriend(person3);
    person2.changeFriend(person3);
    person3.getFriend(person2);
  }
}
