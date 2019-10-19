import java.util.*;
import java.io.*;
/**
 * Write a description of class Customer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Customer extends User
{
    // instance variables - replace the example below with your own
    private String type;
    private int id;
    private ArrayList<Quotation> quotations;

    /**
     * Constructor for objects of class Customer
     */
    public Customer()
    {
        // initialise instance variables
        type = "";
        id = 0;
        quotations = new ArrayList<Quotation>();
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setQuotations(ArrayList<Quotation> quotations)
    {
        this.quotations = quotations;
    }

    public String getType()
    {
        return type;
    }

    public int getId()
    {
        return id;
    }

    public ArrayList<Quotation> getQuotations()
    {
        return quotations;
    }

    /**
     * Method searchHall
     * Customer seach the hall
     *
     */
    public void searchHall()
    {
        System.out.println("\u000C");
        Scanner scan = new Scanner(System.in);

        Hall hall = new Hall();
        ArrayList<String> halls = new ArrayList<String>();
        try
        {               
            Scanner parser = new Scanner(new File("hall.txt"));
            while (parser.hasNextLine())
            {
                halls.add(parser.nextLine());
            }
            parser.close();
        }
        catch (Exception e)
        {
            System.out.println("Error!");
        }

        System.out.println("Please choose the following opitions to search:");
        System.out.println("1. Address");
        System.out.println("2. Price");
        System.out.println("3. Capacity of Hall");
        String input = scan.nextLine();
        ArrayList<String> search = new ArrayList<String>();
        while(!(input.equals("1")||input.equals("2")||input.equals("3")))
        {
            System.out.println("Please select the correct opition: ");
            input = scan.nextLine();
        }
        switch(input)
        {            
            case "1":
            System.out.println("Please enter the address: ");
            input = scan.nextLine();           
            for (int i = 0; i < halls.size(); i++)
            {
                String[] parts = halls.get(i).split(",");
                if (parts[4].contains(input))
                {           
                    search.add(halls.get(i));
                }
            }
            break;
            case "2":            
            boolean doubleCheck = false;
            String[] inputs;
            do{
                System.out.println("Please enter the price range by space: ");
                inputs = scan.nextLine().split(" ");
                if(inputs.length == 2)
                {   
                    try
                    {
                        Double.parseDouble(inputs[0]);
                        Double.parseDouble(inputs[1]);
                        doubleCheck = true;
                    }
                    catch (Exception e)
                    {
                        System.out.println("Sorry, your enter is invalid.");
                    }
                }
                else
                    System.out.println("Please enter 2 numbers seperate by space: ");
            }while(!doubleCheck);
            for (int i = 0; i < halls.size(); i++)
            {
                String[] parts = halls.get(i).split(",");
                if((Double.parseDouble(parts[12]) - Double.parseDouble(inputs[0])) * (Double.parseDouble(parts[12]) - Double.parseDouble(inputs[1])) <= 0)
                {           
                    search.add(halls.get(i));
                }
            }
            break;
            case "3":
            boolean intCheck = false;
            String[] inputs2;
            do{
                System.out.println("Please enter the price range by space: ");
                inputs2 = scan.nextLine().split(" ");
                if(inputs2.length == 2)
                {   
                    try
                    {
                        Integer.parseInt(inputs2[0]);
                        Integer.parseInt(inputs2[1]);
                        intCheck = true;
                    }
                    catch (Exception e)
                    {
                        System.out.println("Sorry, your enter is invalid.");
                    }
                }
                else
                    System.out.println("Please enter 2 numbers seperate by space: ");
            }while(!intCheck);
            for (int i = 0; i < halls.size(); i++)
            {
                String[] parts = halls.get(i).split(",");
                if((Integer.parseInt(parts[12]) - Integer.parseInt(inputs2[0])) * (Integer.parseInt(parts[12]) - Integer.parseInt(inputs2[1])) <= 0)
                {           
                    search.add(halls.get(i));
                }
            }
            break;
            default:
            System.out.println("...");
            break;
        }
        for(int i = 0; i < search.size(); i++)
            System.out.println(search.get(i));
    }

    public void addQuotation(Quotation quotation)
    {

    }

    public void requestQuotation()
    {

    }

    /**
     * Method bookHall
     * Customer book the hall
     *
     */
    public void bookHall(String str)
    {
        ArrayList<String> accepted = new ArrayList<String>();
        String[] seperates;
        String booking;
        setEmail(str);
        int index = -1;

        try
        {               
            Scanner parser = new Scanner(new File("quotation.txt"));

            while (parser.hasNext())
            {
                String line = parser.nextLine();
                seperates = line.split(",");
                if(seperates[4].equals("true") && str.equalsIgnoreCase(seperates[2])) 
                {
                    accepted.add(line);
                }
            }
            parser.close();
        }
        catch (Exception e)
        {
            System.out.println("Error!");
        }

        if(accepted.size() == 0)
            System.out.println("Sorry, you don't have bookings available :(");
        else
        {
            System.out.println("There are following bookings available: ");
            for(int i = 0; i < accepted.size(); i++)
            {
                System.out.println(i + 1 + ". " + accepted.get(i));
            }

            Scanner scan = new Scanner(System.in);
            boolean intCheck = false;
            do{
                System.out.println("Please select the following for booking: ");    
                try
                {
                    String enter = scan.nextLine().trim();
                    //Integer.parseInt(enter);
                    if(Integer.parseInt(enter) > 0 && Integer.parseInt(enter) <= accepted.size())
                    {
                        index = Integer.parseInt(enter);
                        System.out.println("Please confirm to pay the diposite (y/n): ");
                        Scanner sc = new Scanner(System.in);
                        String x = sc.nextLine().trim();
                        while (!(x.equalsIgnoreCase("y") || x.equalsIgnoreCase("n")))
                        {
                            System.out.println("Invalid input");
                            System.out.println("Pleae enter Y/N to confirm (y/n): ");
                            x = sc.nextLine().trim();
                        }

                        if (x.equalsIgnoreCase("y"))
                        {
                            System.out.println("Booking confirmed");
                        }
                        else
                        {
                            System.out.println("Booking cancelled");
                        }
                        intCheck = true;
                    }
                    else
                        System.out.println("Please select one in range.");
                }
                catch (Exception e)
                {
                    System.out.println("Sorry, your enter is invalid.");
                }
            }while(!intCheck);
        }

        booking = accepted.get(index - 1) + "," + (accepted.size() + 1);
        try
        {
            File outputFile = new File("booking.txt");
            try
            {
                BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, true));
                bw.append( booking + "\r\n");
                //bw.newLine();
                bw.close();
            }
            catch (Exception e)
            {
                System.out.println("...");
            }
        }
        catch (Exception e)
        {
            System.out.println("Error! Write wrong!");
        }
        System.out.println("Congratulations! Your booking successfully!");                       
        System.out.println("============================================="); 
        System.out.println("Press enter to return to menu...");
        Scanner cl = new Scanner(System.in);
        cl.nextLine();
    }
}
