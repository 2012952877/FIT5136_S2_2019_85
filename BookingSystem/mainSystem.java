import java.util.Scanner;

/**
 * Write a description of class mainSystem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class mainSystem
{

    public void startSystem()
    {
        startInformation();
        displayMenu();
    }

    public void startInformation()
    {
        System.out.println("#############################################");
        System.out.println("#                                           #");
        System.out.println("#                                           #");
        System.out.println("#       Welcome to Hall Booking System      #");
        System.out.println("#                                           #");
        System.out.println("#                                           #");
        System.out.println("#############################################");
    }

    public void displayMenu()
    {
        System.out.println();
        System.out.println("Hall Booking System");
        System.out.println("=============================================");
        System.out.println("1.Login");
        System.out.println("2.Register");
        System.out.println("3.Exit");
        System.out.println("=============================================");
        System.out.println();
        System.out.print("Please enter your choice: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input.equals("1"))
        {
            displayLoginPage();
        }
        else if (input.equals("2"))
        {
            displayRegisterPage();
        }
        else if (input.equals("3"))
        {
            System.exit(0);
        }
        else
        {
            System.out.println("Sorry! Please check your option exist in menu!");
            displayMenu();
        }
    }

    public void displayLoginPage()
    {
        System.out.println("");
        System.out.println("#############################################");         
        System.out.println("#                                           #");         
        System.out.println("#             This is Login Page            #");         
        System.out.println("#  Please enter your username and password  #");         
        System.out.println("#                                           #");         
        System.out.println("#                                           #");         
        System.out.println("#############################################");
        System.out.println("");
        System.out.println("Username: ");
        Scanner sc = new Scanner(System.in);         
        String username = sc.nextLine();
        System.out.println("Password: ");
        Scanner sc2 = new Scanner(System.in);
        String password = sc.nextLine();
        System.out.println("");
        System.out.println("Login Successfully!");
        System.out.println("");
    }

    public void afterLogin()
    {
        System.out.println("");         
        System.out.println("#############################################");                  
        System.out.println("#                                           #");                  
        System.out.println("#             Welcome! #Username            #");                  
        System.out.println("#       You may make a reaservation now!    #");                  
        System.out.println("#                                           #");                  
        System.out.println("#                                           #");                  
        System.out.println("#############################################");         
        System.out.println("");
        System.out.println();         
        System.out.println("Hall Booking System");         
        System.out.println("=============================================");         
        System.out.println("1.View availble Hall");
        System.out.println("2.Search Hall");
        System.out.println("3.Logout");                  
        System.out.println("=============================================");         
        System.out.println();
        System.out.println("Pleae enter your choice ");
        Scanner sc = new Scanner(System.in);
        String option = sc.nextLine();
        if (option.equals("1"))
        {
            displayAvailbleHall();
        }
        else if (option.equals("2"))
        {
            displaySearchHall();
        }
        else
        {
            System.exit(0);
        }
    }
    
    public void displaySearchHall()
    {
        
    }
    
    public void displayAvailbleHall()
    {
        System.out.println("");                  
        System.out.println("#############################################");                           
        System.out.println("#                                           #");                           
        System.out.println("#             Welcome! #Username            #");                           
        System.out.println("#   Availble Hall are in the following list #");                           
        System.out.println("#                                           #");                           
        System.out.println("#                                           #");                           
        System.out.println("#############################################");                  
        System.out.println("");
        System.out.println("Hall Booking System");                  
        System.out.println("=============================================");                 
        System.out.println("1.View availble hall");                  
        System.out.println("2.Logout");                           
        System.out.println("=============================================");                  
        System.out.println();
    }

    public void displayRegisterPage()
    {
        System.out.println("");         
        System.out.println("#############################################");                  
        System.out.println("#                                           #");                  
        System.out.println("#            This is Register Page          #");                  
        System.out.println("#  Please enter your username and password  #");                  
        System.out.println("#                                           #");                  
        System.out.println("#                                           #");                  
        System.out.println("#############################################");         
        System.out.println("");
        System.out.println("Username: ");
        Scanner sc = new Scanner(System.in);                  
        String username = sc.nextLine();
        System.out.println("Password: ");         
        Scanner pw = new Scanner(System.in);         
        String password = pw.nextLine();
        confirmPassword(password);
    }

    public void confirmPassword(String pw)
    {   
        System.out.println("Please confirm your password: ");
        Scanner pw2 = new Scanner(System.in);
        String password2 = pw2.nextLine();
        if (!password2.equals(pw))
        {
            System.out.println("Sorry! Your password doesn't match!");
            System.out.println("Please try again!");
            confirmPassword(pw);
        }
        System.out.println("");
        System.out.println("Congratulations! Your account creat sucessfully!");
        System.out.println("Please press enter turn to home page.");
        Scanner scanner = new Scanner(System.in);             
        scanner.nextLine();
        displayMenu();
    }
}
