package Activity;

public class FoodTester{
    public static void main(String[] args){
        Fish swimBoy = new Fish();
        Apple app = new Apple();
        Banana monke = new Banana();
        System.out.println(swimBoy.howToEat());
        System.out.println(app.howToEat());
        System.out.println(monke.howToEat());
    }
}