package Pizza.Base;
import java.util.Scanner;


public class Main {
    public static void main(String[] args){
        Pizza pizza = new Pizza( "Pizza Margherita", 10.99, new Topping("queso", 10.00));
        Scanner scanner = new Scanner(System.in);

        // Mostrar el menú de pizzas disponibles
        System.out.println("Menú de Pizzas Disponibles:");
        System.out.println("1. Pepperoni - Precio: Q" + Pizza.PEPPERONI_PRICE);
        System.out.println("2. Hawaiiana - Precio: Q" + Pizza.HAWAIIAN_PRICE);
        System.out.println("3. Vegetariana - Precio: Q" + Pizza.VEGETARIAN_PRICE);
        System.out.println("4. Suprema - Precio: Q" + Pizza.SUPREME_PRICE);
        System.out.println("5. Blanca - Precio: Q" + Pizza.WHITE_PRICE);

        System.out.print("Seleccione una pizza (1-5): ");
        int pizzaChoice = scanner.nextInt();

        Pizza selectedPizza = null;

        switch (pizzaChoice) {
            case 1:
                selectedPizza = new Pizza(Pizza.PEPPERONI_NAME, Pizza.PEPPERONI_PRICE);
                break;
            case 2:
                selectedPizza = new Pizza(Pizza.HAWAIIAN_NAME, Pizza.HAWAIIAN_PRICE);
                break;
            case 3:
                selectedPizza = new Pizza(Pizza.VEGETARIAN_NAME, Pizza.VEGETARIAN_PRICE);
                break;
            case 4:
                selectedPizza = new Pizza(Pizza.SUPREME_NAME, Pizza.SUPREME_PRICE);
                break;
            case 5:
                selectedPizza = new Pizza(Pizza.WHITE_NAME, Pizza.WHITE_PRICE);
                break;
            default:
                System.out.println("Selección no válida. Saliendo del programa.");
                return;
        }

        // Permitir al usuario agregar toppings extras
        boolean agregarToppings = true;
        while (agregarToppings) {
            System.out.println("Ingredientes extras disponibles:");
            System.out.println("1. Pepperoni - Precio adicional: Q" + Topping.PEPPERONI_PRICE);
            System.out.println("2. Piña - Precio adicional: Q" + Topping.PINEAPPLE_PRICE);
            System.out.println("3. Chile Dulce - Precio adicional: Q" + Topping.SWEET_PEPPER_PRICE);
            System.out.println("4. Cebolla - Precio adicional: Q" + Topping.ONION_PRICE);
            System.out.println("5. Queso - Precio adicional: Q" + Topping.CHEESE_PRICE);
            System.out.println("6. Champiñones - Precio adicional: Q" + Topping.MUSHROOMS_PRICE);
            System.out.println("7. Finalizar y cocinar la pizza");

            System.out.print("Seleccione un ingrediente extra (1-7): ");
            int toppingChoice = scanner.nextInt();

            if (toppingChoice < 1 || toppingChoice > 7) {
                System.out.println("Selección no válida. Saliendo de la selección de ingredientes.");
                break;
            }

            switch (toppingChoice) {
                case 1:
                    selectedPizza.addTopping(new Topping(Topping.PEPPERONI_NAME, Topping.PEPPERONI_PRICE));
                    break;
                case 2:
                    selectedPizza.addTopping(new Topping(Topping.PINEAPPLE_NAME, Topping.PINEAPPLE_PRICE));
                    break;
                case 3:
                    selectedPizza.addTopping(new Topping(Topping.SWEET_PEPPER_NAME, Topping.SWEET_PEPPER_PRICE));
                    break;
                case 4:
                    selectedPizza.addTopping(new Topping(Topping.ONION_NAME, Topping.ONION_PRICE));
                    break;
                case 5:
                    selectedPizza.addTopping(new Topping(Topping.CHEESE_NAME, Topping.CHEESE_PRICE));
                    break;
                case 6:
                    selectedPizza.addTopping(new Topping(Topping.MUSHROOMS_NAME, Topping.MUSHROOMS_PRICE));
                    break;
                case 7:
                    agregarToppings = false;
                    break;
            }
        }

        // Imprimir que la pizza se está cocinando
        System.out.println("Cocinando la pizza...");

        // Calcular el precio total de la pizza
        double totalPizzaPrice = selectedPizza.getPrice();
        for (Topping topping : selectedPizza.getToppings()) {
            totalPizzaPrice += topping.getPrice();
        }

        // Imprimir el total de la pizza y que la pizza está lista
        System.out.println("¡La pizza está lista!");
        System.out.println("El precio total de la pizza es: Q" + totalPizzaPrice);

        
        pizza.prepare();

        scanner.close();
    }
}
