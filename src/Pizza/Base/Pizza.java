package Pizza.Base;
import java.util.*;
public class Pizza {
    private String name;
    private double price;
    private List<Topping> toppings = new ArrayList<>();

    public static final String PEPPERONI_NAME = "Pepperoni";
    public static final String HAWAIIAN_NAME = "Hawaiiana";
    public static final String VEGETARIAN_NAME = "Vegetariana";
    public static final String SUPREME_NAME = "Suprema";
    public static final String WHITE_NAME = "Blanca";

    // Precios preestablecidos como double
    public static final double PEPPERONI_PRICE = 40;
    public static final double HAWAIIAN_PRICE = 55;
    public static final double VEGETARIAN_PRICE = 50;
    public static final double SUPREME_PRICE = 70;
    public static final double WHITE_PRICE = 35;

    //    los tres puntos (...) en el parámetro Topping... toppings del constructor de la clase Pizza tienen
//    un significado especial en Java.
//    Estos three dots se llaman "spread operator" (operador de dispersión) y permiten pasar un
//    conjunto de argumentos variádicos a un método. En este caso, el constructor de la clase Pizza
//    espera una lista de objetos Topping, pero en lugar de especificar explícitamente la lista de
//    objetos, se utiliza el operador de dispersión para pasar todos los argumentos restantes como una
//    lista de objetos Topping.
    public Pizza(String name, double price, Topping... toppings) {
        this.name = name;
        this.price = price;
        for (Topping topping : toppings) {
            this.toppings.add(topping);
        }
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    public void removeTopping(int index) {
        this.toppings.remove(index);
    }

    public List<Topping> getToppings() {

        return Collections.unmodifiableList(new ArrayList<>(toppings));
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Pizza{" + "name='" + name + '\'' + ", price=" + price + ", toppings=" + toppings + '}';
    }

    public void prepare() {
        System.out.println("Preparing..... " + name);
        System.out.println("Adding toppings:");
        for (Topping topping : toppings) {
            System.out.println("- " + topping.getNombre());
            //put 1 second delay
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("The Pizza is ready!");
    }
}
