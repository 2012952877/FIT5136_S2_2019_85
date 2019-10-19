import java.util.*;
import java.io.*;
/**
 * Write a description of class Owner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Owner extends User
{
    private ArrayList<Hall> hall;
    private int Id;

    /**
     * Constructor for objects of class Owner
     */
    public Owner()
    {
        hall = new ArrayList<Hall>();
        Id = 0;
    }

    public ArrayList<Hall> getHall()
    {
        return hall;
    }

    public int getId()
    {
        return Id;
    }

    public void setHall(ArrayList<Hall> hall)
    {
        this.hall = hall;
    }

    public void setId(int Id)
    {
        this.Id = Id;
    }

    public void createHall(String owner)
    {
        Hall newHall = new Hall();
        Scanner scan = new Scanner(System.in);
        String typeInput;

        ArrayList<String> str = new ArrayList<String>();
        try
        {               
            Scanner parser = new Scanner(new File("hall.txt"));
            while (parser.hasNextLine())
            {
                str.add(parser.nextLine());
            }
            newHall.setId(str.size()+1);
            parser.close();
        }
        catch (Exception e)
        {
            System.out.println("Error!");
        }

        newHall.setOwner(owner);

        System.out.println("Please enter your hall name");
        typeInput = scan.nextLine().trim();
        while(typeInput.equals(""))
        {
            System.out.println("Please re-enter the hall name");
            typeInput = scan.nextLine().trim();
        }
        newHall.setName(typeInput);

        System.out.println("Please enter the hall description");
        typeInput = scan.nextLine().trim();
        newHall.setDescription(typeInput);

        System.out.println("Please enter the hall address");
        typeInput = scan.nextLine().trim();
        newHall.setAddress(typeInput);

        boolean phoneCheck = false;
        do{
            System.out.println("Please enter the contact phone: ");  
            try
            {
                typeInput = scan.nextLine().trim();
                Long.parseLong(typeInput);
                if (typeInput.length()==10)
                {
                    newHall.setContactPhone(typeInput);
                    phoneCheck = true;
                }
                else
                {
                    System.out.println("Sorry, your shold enter 10 digit.");
                }
            }
            catch (Exception e)
            {
                System.out.println("Sorry, your enter should be numeric.");
            }
        }while(!phoneCheck);

        System.out.println("Please enter your contact email: ");
        typeInput = scan.nextLine();
        while(typeInput.equals("")||typeInput.contains(" "))
        {
            System.out.println("Email should be a series");
            System.out.println("Please re-enter email");
            typeInput = scan.nextLine().trim();
        }
        newHall.setContactEmail(typeInput.toLowerCase()+"@hall.primeevent.com.au");

        System.out.println("Pleae enter hall catering availability (y/n): ");
        typeInput = scan.nextLine().trim();
        while (!(typeInput.equalsIgnoreCase("y") || typeInput.equalsIgnoreCase("n")))
        {
            System.out.println("Invalid input");
            System.out.println("Pleae enter hall catering availability (y/n): ");
            Scanner hallCatering = new Scanner(System.in);
            typeInput = scan.nextLine().trim();
        }
        if (typeInput.equalsIgnoreCase("y"))
        {
            newHall.setCatering(true);
        }
        else
        {
            newHall.setCatering(false);
        }

        System.out.println("Please enter the hall events");
        typeInput = scan.nextLine().trim();
        newHall.setEvent(typeInput);

        boolean doubleCheck = false;
        while(!doubleCheck)
        {
            System.out.println("Please enter the discount: ");
            try
            {
                typeInput = scan.nextLine().trim();
                if(Double.parseDouble(typeInput) <= 1 && Double.parseDouble(typeInput) >= 0)
                {
                    newHall.setDiscount(Double.parseDouble(typeInput));
                    doubleCheck = true;
                }
                else
                    System.out.println("Discount should be between 0 - 1.");
            }
            catch (Exception e)
            {
                System.out.println("Sorry, your enter is invalid.");
            }
        }

        boolean intCheck = false;
        do{
            System.out.println("Please enter hall capacity: ");    
            try
            {
                typeInput = scan.nextLine().trim();
                newHall.setCapacity(Integer.parseInt(typeInput));
                intCheck = true;
            }
            catch (Exception e)
            {
                System.out.println("Sorry, your enter is invalid.");
            }
        }while(!intCheck);

        System.out.println("Please upload photos");
        typeInput = scan.nextLine().trim();
        newHall.setPhoto(typeInput);

        doubleCheck = false;
        while(!doubleCheck)
        {
            System.out.println("Please enter the price hourly: ");
            try
            {
                typeInput = scan.nextLine().trim();
                newHall.setPriceByHour(Double.parseDouble(typeInput));
                doubleCheck = true;

            }
            catch (Exception e)
            {
                System.out.println("Sorry, your enter is invalid.");
            }
        }

        String recode = newHall.getId()
            + "," + newHall.getOwner()
            + "," + newHall.getName()
            + "," + newHall.getDescription()
            + "," + newHall.getAddress()
            + "," + newHall.getContactPhone()
            + "," + newHall.getContactEmail()
            + "," + newHall.getCatering()
            + "," + newHall.getEvent()
            + "," + newHall.getDiscount()
            + "," + newHall.getCapacity()
            + "," + newHall.getPhoto()
            + "," + newHall.getPriceByHour();
        hall.add(newHall);
        System.out.println(recode);

        try
        {
            File outputFile = new File("hall.txt");
            try
            {
                BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, true));

                bw.append(recode + "\r\n");
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

        System.out.println("Congratulations! Your hall creating successfully!");                       
        System.out.println("=============================================");                  
        System.out.println("Press enter to return to menu...");
        scan.nextLine();
    }

    public void addHall(Hall hall)
    {

    }

    public void removeHall(Hall hall)
    {

    }

    public void viewHall(String email)
    {
        Hall h = new Hall();
        h.provideQuotation(email);
    }

}
