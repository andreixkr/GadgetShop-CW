/**
 * The Gadget class represents a gadget item.
 * Information about the gadget is stored and can be retrieved.
 * This class serves as a superclass for more specific items.
 * 
 * @author Andrei Ionita
 * @version 2.0
 */
public class Gadget 
{
    private double price;
    private int weight;
    private String model;
    private String size;

    /**
     * Initialize the item.
     * @param model The model of this item.
     * @param price The price of this item.
     * @param weight The weight of this item.
     * @param size The size of this item.
     */
    public Gadget(String model, double price, int weight, String size) 
    {
        this.model = model;
        this.price = price;
        this.weight = weight;
        this.size = size;
    }

    /**
     * @return The model for this item.
     */
    public String getModel() 
    {
        return model;
    }

    /**
     * @return The price for this item.
     */
    public double getPrice() 
    {
        return price;
    }

    /**
     * @return The weight for this item.
     */
    public int getWeight() 
    {
        return weight;
    }

    /**
     * @return The size for this item.
     */
    public String getSize() 
    {
        return size;
    }

    /**
     * Print details about this item to the text terminal.
     */
    public void display() 
    {
        System.out.println("Model: " + model);
        System.out.println("Price: £" + price);
        System.out.println("Weight: " + weight + " gram(s)");
        System.out.println("Size: " + size);
    }
}
