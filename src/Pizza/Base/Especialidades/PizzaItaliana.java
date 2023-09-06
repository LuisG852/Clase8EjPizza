package Pizza.Base.Especialidades;

import Pizza.Base.Pizza;
import Pizza.Base.*;

public class PizzaItaliana extends Pizza {
    private String salsa;
    public PizzaItaliana(String name, double price, String Salsa, Topping... toppings){
        super(name, price, toppings);
        this.salsa = salsa;
    }

    public String getSalsa() {
        return salsa;
    }

    public void setSalsa(String salsa) {
        this.salsa = salsa;
    }
}
