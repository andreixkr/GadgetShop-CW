/**
 * The MP3 class represents a mp3 object. 
 * Information about the mp3 is stored and can be retrieved.
 * 
 * @author Andrei Ionita
 * @version 2.0
 */
public class MP3 extends Gadget 
{
    private int memory;

    /**
     * Initialize the mp3.
     * @param model The model of the mp3.
     * @param price The price of the mp3.
     * @param weight The weight of the mp3.
     * @param size The size of the mp3.
     * @param memory The available memory of the mp3.
     */
    public MP3(String model, double price, int weight, String size, int memory) 
    {
        super(model, price, weight, size);
        this.memory = memory;
    }

    /**
     * @return The remaining memory for this mp3.
     */
    public int getMemory() 
    {
        return memory;
    }

    /**
     * Download music to the mp3. If there is sufficient available memory on the 
     * MP3 player, decrease the available memory by that amount. 
     * Otherwise, an error message is displayed.
     * @param amount The amount of memory to be entered.
     */
    public void downloadMusic(int amount) 
    {
        if (amount <= memory) {
            memory = memory - amount;
        } 
        else {
            System.out.println("Insufficient available memory on the MP3 player to download the music.");
        }
    }

    /**
     * Delete music from the mp3. Increase the available memory accordingly.
     * @param amount The amount of memory to be entered.
     */
    public void deleteMusic(int amount) 
    {
        memory = memory + amount;
    }

    /**
     * Print details about this mp3.
     */
    public void display() 
    {
        super.display();
        System.out.println("Available memory: " + memory);
    }
}
