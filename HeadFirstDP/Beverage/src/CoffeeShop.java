import java.util.ArrayList;

abstract class Condiment
{   
    abstract public double getCost();
}

abstract class Beverage
{
    protected ArrayList<Condiment> listOfCondiments;
    String description;
    protected int basicCost;
    abstract public String getDescription();
    public double getCost() {

        double cost = 0.0;
        for (Condiment condiment : listOfCondiments) {
            cost += condiment.getCost();
        }

        return cost + this.basicCost;
    }
}

class Tea extends Beverage
{   
    @Override
    public String getDescription() {
        
        return "None";
    }

    private class Leaf extends Condiment
    {
        private double cost;

        public double getCost() {

            return this.cost;
        }
    }
}



public class CoffeeShop {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        
    }
}
