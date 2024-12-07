
/**
 * Write a description of class Discount here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Discount
{
    // instance variables - replace the example below with your own
    private String customerType;
    private double rate;
    
    /**
     * Constructor for objects of class Discount
     */
    public Discount()
    {
        // initialise instance variables
        customerType = "";
        rate = 0.0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getType()
    {
        // put your code here
        return customerType;
    }
    
    public void setType(String customerType)
    {
        this.customerType = customerType;
    }
    
    public double getRate()
    {
        return rate;
    }
    
    public void setRate(double rate)
    {
        this.rate = rate;
    }
}
