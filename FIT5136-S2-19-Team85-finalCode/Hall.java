import java.util.*;
import java.io.*;
/**
 * Write a description of class Hall here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Hall
{
    private int id;
    private String owner;
    private String name;
    private String description;
    private String address;
    private String contactPhone;
    private String contactEmail;
    private boolean catering;
    private String event;
    private double discount;
    private int capacity;
    private String photo;
    private ArrayList<Quotation> quotation;
    private double priceByHour;

    public Hall()
    {
        id = 0;
        owner = "";
        name = "";
        description = "";
        address = "";
        contactPhone = "";
        contactEmail = "";
        catering = false;
        event = "";
        discount = 0;
        capacity = 0;
        photo = "";
        quotation = new ArrayList<Quotation>();
        priceByHour = 0;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getOwner()
    {
        return owner;
    }

    public void setOwner(String owner)
    {
        this.owner = owner;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getContactPhone()
    {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone)
    {
        this.contactPhone = contactPhone;
    }

    public String getContactEmail()
    {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail)
    {
        this.contactEmail = contactEmail;
    }

    public boolean getCatering()
    {
        return catering;
    }

    public void setCatering(boolean catering)
    {
        this.catering = catering;
    }

    public String getEvent()
    {
        return event;
    }

    public void setEvent(String event)
    {
        this.event = event;
    }

    public double getDiscount()
    {
        return discount;
    }

    public void setDiscount(double discount)
    {
        this.discount = discount;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public void setCapacity(int capacity)
    {   
        this.capacity = capacity;
    }

    public double getPriceByHour()
    {
        return priceByHour;
    }

    public String getPhoto()
    {
        return photo;
    }

    public void setPhoto(String photo)
    {
        this.photo = photo;
    }

    public void setPriceByHour(double priceByHour)
    {
        this.priceByHour = priceByHour;
    }

    public ArrayList<Quotation> getQuotation()
    {
        return quotation;
    }

    public void setQuotation(ArrayList<Quotation> quotation)
    {
        this.quotation = quotation;
    }

    /**
     * Method provideQuotation
     * Quotation status changed by boolean
     *
     */
    public void provideQuotation(String email)
    {
        ArrayList<String> nonAccepted = new ArrayList<String>();
        ArrayList<String> all = new ArrayList<String>();
        String[] seperates;
        setOwner(email);
        int index = -1;

        try
        {               
            Scanner parser = new Scanner(new File("quotation.txt"));
            while (parser.hasNextLine())
            {
                String line = parser.nextLine();
                all.add(line);
                seperates = line.split(",");
                if(seperates[4].equals("false") && email.equalsIgnoreCase(seperates[2])) 
                {
                    nonAccepted.add(line);
                }
            }
            parser.close();
        }
        catch (Exception e)
        {
            System.out.println("Error!");
        }

        if(nonAccepted.size() == 0)
            System.out.println("Sorry, you don't have requested quotations :(");
        else
        {
            System.out.println("There are following requested quotations available: ");
            for(int i = 0; i < nonAccepted.size(); i++)
                System.out.println(i + 1 + ". " + nonAccepted.get(i));

            Scanner scan = new Scanner(System.in);
            boolean intCheck = false;
            do{
                System.out.println("Please select the following requested quotations: ");    
                try
                {
                    String enter = scan.nextLine().trim();
                    if(Integer.parseInt(enter) > 0 && Integer.parseInt(enter) <= nonAccepted.size())
                    {
                        index = Integer.parseInt(enter);
                        System.out.println("Please confirm to accept the quotation (y/n): ");
                        enter = scan.nextLine().trim();
                        while (!(enter.equalsIgnoreCase("y") || enter.equalsIgnoreCase("n")))
                        {
                            System.out.println("Invalid input");
                            System.out.println("Pleae enter Y/N to confirm (y/n): ");
                            enter = scan.nextLine().trim();
                        }

                        if (enter.equalsIgnoreCase("y"))
                        {
                            System.out.println("Congratulations! Your quotation is successfully accepted!");                       
                            System.out.println("============================================="); 
                        }
                        else
                        {
                            System.out.println("Provide quotation cancelled");
                            index = -1;
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

        if(index > 0)
        { 
            String confirm = nonAccepted.get(index - 1);

            for (int n = 0; n < all.size(); n++)
                if (all.get(n).equals(confirm))
                    all.remove(confirm);

            String[] sets = confirm.split(",");
            sets[4] = "true";
            confirm = sets[0];
            for (int i = 1; i < sets.length; i++)
                confirm = confirm + "," + sets[i];                
            all.add(confirm);

            try
            {
                PrintWriter output = new PrintWriter("quotation.txt");
                for(int i = 0; i < all.size(); i++)
                    output.println(all.get(i));
                output.close();
            }
            catch(IOException e)
            {
            }
        }

        System.out.println("Press enter to return to menu...");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }
}
