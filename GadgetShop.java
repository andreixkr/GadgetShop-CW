import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

/**
 * The GadgetShop class provides a facility to store mobile and mp3 
 * objects. A list of all the gadgets can be printed to the terminal.
 * 
 * @author Andrei Ionita
 * @version 2.0
 */
public class GadgetShop implements ActionListener 
{
    private JFrame frame;

    private JLabel modelLabel;
    private JLabel priceLabel;
    private JLabel weightLabel;
    private JLabel sizeLabel;
    private JLabel creditLabel;
    private JLabel memoryLabel;
    private JLabel phoneNumberLabel;
    private JLabel durationLabel;
    private JLabel downloadLabel;
    private JLabel displayNumberLabel;

    private JTextField modelTextField;
    private JTextField priceTextField;
    private JTextField weightTextField;
    private JTextField sizeTextField;
    private JTextField creditTextField;
    private JTextField memoryTextField;
    private JTextField phoneNumberTextField;
    private JTextField durationTextField;
    private JTextField downloadTextField;
    private JTextField displayNumberTextField;

    private Button addMobileButton;
    private Button addMP3Button;
    private Button clearButton;
    private Button displayAllButton;
    private Button makeACallButton;
    private Button downloadMusicButton;

    private ArrayList<Gadget> gadgets = new ArrayList<Gadget>();

    /**
     * The main method allows the program to be run without BlueJ.
     */
    public static void main(String args[]) 
    {
        GadgetShop shop = new GadgetShop();
    }

    /**
     * Create a GadgetShop and show it on screen.
     */
    public GadgetShop() 
    {
        makeFrame();
    }

    /**
     * Create the Swing frame and its content.
     */
    private void makeFrame() 
    {   
        frame = new JFrame("Gadget Shop");
        
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridLayout(7, 4));
        
        modelLabel = new JLabel("Model:");
        contentPane.add(modelLabel);
        
        priceLabel = new JLabel("Price:");
        contentPane.add(priceLabel);
        
        weightLabel = new JLabel("Weight:");
        contentPane.add(weightLabel);
        
        sizeLabel = new JLabel("Size:");
        contentPane.add(sizeLabel);
        
        modelTextField = new JTextField(15);
        contentPane.add(modelTextField);
        
        priceTextField = new JTextField(15);
        contentPane.add(priceTextField);
        
        weightTextField = new JTextField(15);
        contentPane.add(weightTextField);
        
        sizeTextField = new JTextField(15);
        contentPane.add(sizeTextField);
        
        creditLabel = new JLabel("Credit:");
        contentPane.add(creditLabel);
        
        memoryLabel = new JLabel("Memory:");
        contentPane.add(memoryLabel);
        
        addMobileButton = new Button("Add Mobile");
        contentPane.add(addMobileButton);
        addMobileButton.addActionListener(this);
        
        addMP3Button = new Button("Add MP3");
        contentPane.add(addMP3Button);
        addMP3Button.addActionListener(this);

        creditTextField = new JTextField(15); 
        contentPane.add(creditTextField);
        
        memoryTextField = new JTextField(15);
        contentPane.add(memoryTextField);
        
        clearButton = new Button("Clear");
        contentPane.add(clearButton);
        clearButton.addActionListener(this);
        
        displayAllButton = new Button("Display All");
        contentPane.add(displayAllButton);
        displayAllButton.addActionListener(this);
        
        phoneNumberLabel = new JLabel("Phone No:");
        contentPane.add(phoneNumberLabel);
        
        durationLabel = new JLabel("Duration:");
        contentPane.add(durationLabel);
        
        downloadLabel = new JLabel("Download:");
        contentPane.add(downloadLabel);
        
        displayNumberLabel = new JLabel("Display Number:");
        contentPane.add(displayNumberLabel);
        
        phoneNumberTextField = new JTextField(15);
        contentPane.add(phoneNumberTextField);
        
        durationTextField = new JTextField(15);
        contentPane.add(durationTextField);
        
        downloadTextField = new JTextField(15);
        contentPane.add(downloadTextField);
        
        displayNumberTextField = new JTextField(15);
        contentPane.add(displayNumberTextField);
     
        makeACallButton = new Button("Make A Call");
        contentPane.add(makeACallButton);
        makeACallButton.addActionListener(this);
        
        downloadMusicButton = new Button("Download Music");
        contentPane.add(downloadMusicButton);
        downloadMusicButton.addActionListener(this);

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Find which button triggered the event and call the appropriate method.
     */
    public void actionPerformed(ActionEvent event) 
    {
        String command = event.getActionCommand();

        switch (command) {
            case "Add Mobile":
                addMobile();
                break;
            case "Add MP3":
                addMP3();
                break;
            case "Clear":
                clear();
                break;
            case "Display All":
                displayAll();
                break;
            case "Make A Call":
                makeACall();
                break;
            case "Download Music":
                downloadMusic();
                break;

            default:
                JOptionPane.showMessageDialog(frame, "Unknown command");
                break;
        }
    }

    /**
     * Add a mobile to the shop.
     */
    public void addMobile() 
    {
        try {
            Mobile newMobile = new Mobile(getModel(), getPrice(), getWeight(), getSize(), getCredit());
            gadgets.add(newMobile);
            JOptionPane.showMessageDialog(frame, "A new mobile was added.");
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "There was an error adding a new mobile.");
        }
    }

    /**
     * Add a mp3 to the shop.
     */
    public void addMP3() 
    {
        try {
            MP3 newMP3 = new MP3(getModel(), getPrice(), getWeight(), getSize(), getMemory());
            gadgets.add(newMP3);
            JOptionPane.showMessageDialog(frame, "A new MP3 was added.");
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "There was an error adding a new MP3.");
        }
    }

    /**
     * Clear all textfields.
     */
    public void clear() 
    {
        modelTextField.setText("");
        priceTextField.setText("");
        weightTextField.setText("");
        sizeTextField.setText("");
        creditTextField.setText("");
        memoryTextField.setText("");
        phoneNumberTextField.setText("");
        durationTextField.setText("");
        downloadTextField.setText("");
        displayNumberTextField.setText("");
    }

    /**
     * Print a list of all currently stored mobiles and mp3s to the text terminal.
     */
    public void displayAll() 
    {
        for (Gadget gadget : gadgets) {
            System.out.println("Display number: " + gadgets.indexOf(gadget));
            gadget.display();
            System.out.println();
        }
    }

    /**
     * Make a call using the phone number and duration values.
     */
    public void makeACall() 
    {
        int displayNumber = getDisplayNumber();
        if (displayNumber != -1) {
            try {
                Mobile mobile = (Mobile)gadgets.get(displayNumber);
                mobile.makeACall(getPhoneNumber(), getDuration());
            } 
            catch (ClassCastException e) {
                JOptionPane.showMessageDialog(frame, "The given display number is not a mobile.");
            }
        }
    }

    /**
     * Download some music using the download size value.
     */
    public void downloadMusic() 
    {
        int displayNumber = getDisplayNumber();
        if (displayNumber != -1) {
            try {
                MP3 mp3 = (MP3)gadgets.get(displayNumber);
                mp3.downloadMusic(getDownloadSize());
            } 
            catch (ClassCastException e) {
                JOptionPane.showMessageDialog(frame, "The given display number is not an mp3.");
            }
        }
    }

    /**
     * Retrieve the value from the model textfield and return it.
     */
    public String getModel() 
    {
        String model = modelTextField.getText();
        return model;
    }

    /**
     * Retrieve the value from the price textfield and return it as a double.
     */
    public double getPrice() 
    {
        double price = Double.parseDouble(priceTextField.getText());
        return price;
    }

    /**
     * Retrieve the value from the weight textfield and return it as an int.
     */
    public int getWeight() 
    {
        int weight = Integer.parseInt(weightTextField.getText());
        return weight;
    }

    /**
     * Retrieve the value from the size textfield and return it.
     */
    public String getSize() 
    {
        String size = sizeTextField.getText();
        return size;
    }

    /**
     * Retrieve the value from the credit textfield and return it as an int.
     */
    public int getCredit() 
    {
        int credit = Integer.parseInt(creditTextField.getText());
        return credit;
    }

    /**
     * Retrieve the value from the memory textfield and return it as an int.
     */
    public int getMemory() 
    {
        int memory = Integer.parseInt(memoryTextField.getText());
        return memory;
    }

    /**
     * Retrieve the value from the phone number textfield and return it.
     */
    public String getPhoneNumber() 
    {
        String phoneNumber = phoneNumberTextField.getText();
        return phoneNumber;
    }

    /**
     * Retrieve the value from the duration textfield and return it as an int.
     */
    public int getDuration() 
    {
        int duration = Integer.parseInt(durationTextField.getText());
        return duration;
    }

    /**
     * Retrieve the value from the download textfield and return it as an int.
     */
    public int getDownloadSize() 
    {
        int downloadSize = Integer.parseInt(downloadTextField.getText());
        return downloadSize;
    }

    /**
     * Retrieve the value from the display number textfield and return it as an int.
     */
    public int getDisplayNumber() 
    {
        int displayNumber = -1;

        try {
            int inputNumber = Integer.parseInt(displayNumberTextField.getText());
            if (inputNumber >= 0 && inputNumber < gadgets.size()) {
                displayNumber = inputNumber;
            } 
            else {
                JOptionPane.showMessageDialog(frame, "The number is out of the correct range.");
            }
        } 
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
        }

        return displayNumber;
    }
}