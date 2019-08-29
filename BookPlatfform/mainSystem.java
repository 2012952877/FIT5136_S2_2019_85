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
        System.out.print("Please input your option: ");
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
    }
    
    public void displayRegisterPage()
    {
        
    }
}
