/**
 * The Mobile class represents a mobile object. 
 * Information about the mobile is stored and can be retrieved.
 * 
 * @author Andrei Ionita
 * @version 2.0
 */
public class Mobile extends Gadget 
{
    private int credit;

    /**
     * Initialize the mobile.
     * @param model The model of this mobile.
     * @param price The price of this mobile.
     * @param weight The weight of this mobile.
     * @param size The size of this mobile.
     * @param credit The number of minutes of calling credit of this mobile.
     */
    public Mobile(String model, double price, int weight, String size, int credit) 
    {
        super(model, price, weight, size);
        this.credit = credit;
    }


    /**
     * @return The calling credit for this mobile.
     */
    public int getCredit() 
    {
        return credit;
    }

    /**
     * Add calling credit to the mobile. If the amount of credit provided 
     * is greater than zero, then it's added to the existing amount. 
     * Otherwise, an error message is displayed.
     * @param amount The amount to be entered.
     */
    public void addCredit(int amount) 
    {
        if (amount > 0) {
            credit = credit + amount;
        } 
        else {
            System.out.println("Please enter a positive amount.");
        }
    }

    /**
     * Make a call from the mobile. If there is enough credit, then a message giving the 
     * phone number and duration is displayed, and the remaining calling credit is reduced.
     * Otherwise, an error message is displayed.
     * @param phoneNumber The phone number to be entered.
     * @param duration The duration to be entered.
     */
    public void makeACall(String phoneNumber, int duration) 
    {
        if (credit >= duration) {
            System.out.println("Phone number: " + phoneNumber);
            System.out.println("Duration: " + duration + " minute(s)");
            credit = credit - duration;
        } 
        else {
            System.out.println("Insufficient credit amount to call.");
        }
    }

    /**
     * Print details about this mobile.
     */
    public void display() 
    {
        super.display();
        System.out.println("Calling Credit: " + credit + " minute(s)");
    }
}
