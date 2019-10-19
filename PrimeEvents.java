import java.util.*;
/**
 * Write a description of class PrimeEvents here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PrimeEvents
{
    // instance variables - replace the example below with your own
    private ArrayList<Owner> owners;
    private ArrayList<Customer> customers;
    private ArrayList<Hall> halls;
    private ArrayList<Discount> discounts;
    private ArrayList<Quotation> quotations;
    private ArrayList<Booking> bookings;
    
    /**
     * Constructor for objects of class PrimeEvents
     */
    public PrimeEvents()
    {
        // initialise instance variables
        owners = new ArrayList<Owner>();
        customers = new ArrayList<Customer>();
        halls = new ArrayList<Hall>();
        discounts = new ArrayList<Discount>();
        quotations = new ArrayList<Quotation>();
        bookings = new ArrayList<Booking>();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public ArrayList<Owner> readOwners(int ownerIndex)
    {
        return owners;
    }
    
    public void writeOwner(Owner owner)
    {
        
    }
    
    public ArrayList<Owner> getOwners()
    {
        return owners;
    }
    
    public void setOwners(ArrayList<Owner> owners)
    {
        this.owners = owners;
    }
    
    public ArrayList<Customer> readCustomers(int customerIndex)
    {
        return customers;
    }
    
    public void writeCustomer(Customer customer)
    {

    }
    
    public ArrayList<Customer> getCustomer()
    {
        return customers;
    }
    
    public void setCustomer(ArrayList<Customer> customers)
    {
        this.customers = customers;
    }
    
    public ArrayList<Hall> readHalls()
    {
        return halls;
    }
    
    public void writeHall(Hall hall)
    {
        
    }
    
    public ArrayList<Hall> getHalls()
    {
        return halls;
    }
    
    public void setHalls(ArrayList<Hall> halls)
    {
        this.halls = halls;
    }
    
    public ArrayList<Discount> readDiscounts()
    {
        return discounts;
    }
    
    public void setDiscounts(ArrayList<Discount> discounts)
    {
        this.discounts = discounts;
    }
    
    public ArrayList<Booking> readBookings()
    {
        return bookings;
    }
    
    public void writeBookings(ArrayList<Booking> bookings)
    {
        this.bookings = bookings;
    }
    
    public ArrayList<Booking> getBookings()
    {
        return bookings;
    }
    
    public void setBookings(ArrayList<Booking> bookings)
    {
        this.bookings = bookings;
    }
    
    public ArrayList<Quotation> readQuotations()
    {
        return quotations;
    }
    
    public void writeQuotations(Quotation quotation)
    {
    
    }
    
    public ArrayList<Quotation> getQuotations()
    {
        return quotations;
    }
    
    public void setQuotations(ArrayList<Quotation> quotations)
    {
        this.quotations = quotations;
    }
}
