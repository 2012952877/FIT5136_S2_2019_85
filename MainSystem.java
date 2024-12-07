import java.util.*;
import java.io.*;
/**
 * Write a description of class Controller here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MainSystem
{
    UI ui;
    User user;
    PrimeEvents primeEvents;
    
    public MainSystem()
    {
        ui = new UI();
        user = new User();
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User currentUser)
    {
        this.user = user;
    }

    public void register()
    {
        ui = new UI();
        ui.displayRegisterUserType();
        user = new User();
        Scanner scan = new Scanner(System.in);
        String typeInput = scan.nextLine().trim();

        while(!(typeInput.equals("1") || typeInput.equals("2") || typeInput.equals("3")))
        {
            ui.displayRegisterUserType();
            System.out.println("Sorry, please enter value between 1, 2, 3");
            typeInput = scan.nextLine().trim();
        }

        if(typeInput.equals("1"))
        {
            user.setType("Customer");
            System.out.println("Your registration type is customer");
        }
        else if(typeInput.equals("2"))
        {
            user.setType("Owner");
            System.out.println("Your registration type is owner");
        }
        else
        {
            ui.displayBeforeLoginMenu();
        }

        boolean alreadyRegisted = false;
        do{
            System.out.println("Please enter your email address");
            typeInput = scan.nextLine().trim();
            while(typeInput.equals("")||typeInput.contains(" "))
            {
                System.out.println("Please enter the email");
                typeInput = scan.nextLine().trim();
            }
            ArrayList<String> email = new ArrayList<String>();
            try
            {               
                Scanner parser = new Scanner(new File("user.txt"));
                while (parser.hasNextLine())
                {
                    String outputLine = parser.nextLine();
                    String[] output = outputLine.split(",");
                    email.add(output[1]);
                }
                parser.close();
            }
            catch (Exception e)
            {
                System.out.println("Error!");
            }
            for(int i = 0; i < email.size(); i++)
            {
                if((typeInput.toLowerCase()+"@primeevent.com.au").equals(email.get(i)))
                {
                    alreadyRegisted = true;
                    System.out.println("Email already exists!!");
                    System.out.println("Please enter different email");
                }
            }
        }while(alreadyRegisted);
        user.setEmail(typeInput.toLowerCase()+"@primeevent.com.au");

        System.out.println("Please enter your first name");
        typeInput = scan.nextLine().trim();
        user.setFirstName(typeInput);

        System.out.println("Please enter your last name");
        typeInput = scan.nextLine().trim();
        while(typeInput.equals("")||typeInput.contains(" "))
        {
            System.out.println("Last name should be in one word without space");
            System.out.println("Please re-enter your last name");
            typeInput = scan.nextLine().trim();
        }
        user.setLastName(typeInput.toUpperCase());

        System.out.println("Please enter your address");
        typeInput = scan.nextLine().trim();
        user.setAddress(typeInput);

        boolean phoneCheck = false;
        do{
            System.out.println("Please enter contact phone: ");  
            try
            {
                typeInput = scan.nextLine().trim();
                Long.parseLong(typeInput);
                if (typeInput.length()==10)
                {
                    user.setPhone(typeInput);
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

        System.out.println("Please enter your password: ");
        typeInput = scan.nextLine();
        while(typeInput.equals("")||typeInput.contains(" "))
        {
            System.out.println("Password should be a series");
            System.out.println("Please re-enter your passward");
            typeInput = scan.nextLine().trim();
        }
        System.out.println("Please confirm your password");
        String confirm = scan.nextLine();
        while(!confirm.equals(typeInput))
        {
            System.out.println("Password is incorrect, please re-enter password");
            confirm = scan.nextLine();
        }
        user.setPassword(typeInput);

        try
        {
            File outputFile = new File("user.txt");
            try
            {
                BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, true));

                bw.append(user.getType() + "," + user.getEmail() + "," + user.getPassword() + "," + user.getFirstName() + "," + user.getLastName() + "," + user.getAddress() + "," + user.getPhone() + "\r\n");
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

        System.out.println("Congratulations! Your account already creating successfully!");                       
        System.out.println("=============================================");                  
        System.out.println("Press enter to return to menu...");
        scan.nextLine();
        ui.displayBeforeLoginMenu();
    }

    public void login()
    {
        ArrayList<String> type = new ArrayList<String>();
        ArrayList<String> email = new ArrayList<String>();
        ArrayList<String> password = new ArrayList<String>();
        try
        {               
            Scanner parser = new Scanner(new File("user.txt"));
            while (parser.hasNextLine())
            {
                String outputLine = parser.nextLine();
                String[] output = outputLine.split(",");
                type.add(output[0]);
                email.add(output[1]);
                password.add(output[2]);
            }
            parser.close();
        }
        catch (Exception e)
        {
            System.out.println("Error!");
        }

        Scanner scan = new Scanner(System.in);
        ui = new UI();
        ui.displayLogin();
        System.out.println("Please enter your email: ");
        String input = scan.nextLine();
        boolean userExist = false;
        int index = 0;
        for(int i = 0; i < email.size(); i++)
            if((input.toLowerCase()+"@primeevent.com.au").equals(email.get(i)) || input.toLowerCase().equals(email.get(i).substring(0, input.length())))
            {
                userExist = true;
                index = i;
            }            

        if(userExist)
        {
            System.out.println("Please enter the password: ");
            input = scan.nextLine();
            while (!input.equals(password.get(index)))
            {
                System.out.println("Password is incorrect, please re-enter password");
                input = scan.nextLine();
            }
            System.out.println("You are successfully login as " + type.get(index));
            if(type.get(index).equals("Customer"))
                ui.displayCustomerLoginMenu();
            else
                ui.displayOwnerLoginMenu();
        }
        else
        {
            System.out.println("Sorry, the user is not exist.");
            System.out.println("Press enter to return to menu...");
            scan.nextLine();
            ui.displayBeforeLoginMenu();
        }
    }

    public void logout()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("You have been logged out.");
        System.out.println("Press enter to return to menu...");
        scan.nextLine();
        ui.displayBeforeLoginMenu();
    }
    
}
