public class Main {
    public static void main(String[] args){
        Pizza pizza = new Pizza( "Pizza Margherita", 10.99);
        pizza.addTopping(new Topping("Tomato"));
        pizza.addTopping(new Topping("Tomato"));
        pizza.addTopping(new Topping("Tomato"));
        pizza.prepare();

    }
}