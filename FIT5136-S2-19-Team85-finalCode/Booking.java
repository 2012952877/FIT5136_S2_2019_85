
/**
 * Write a description of class Booking here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Booking
{
    // instance variables - replace the example below with your own
    private String review;
    private int quotation_id;
    private String startDateTime;
    private String endDateTime;
    private double price;
    private String receiptNo;

    /**
     * Constructor for objects of class Booking
     */
    public Booking()
    {
        // initialise instance variables
        review = "";
        quotation_id = 0;
        startDateTime = "";
        endDateTime = "";
        price = 0.0;
        receiptNo = "";
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getReview()
    {
        // put your code here
        return review;
    }
    
    public int getQuotation_id()
    {
        return quotation_id;
    }
    
    public String getStartDateTime()
    {
        return startDateTime;
    }
    
    public String getEndDateTime()
    {
        return endDateTime;
    }
    
    public double getPrice()
    {
        return price;
    }
    
    public String getReceiptNo()
    {
        return receiptNo;
    }
    
    public void setReview(String review)
    {
        this.review = review;
    }
    
    public void setQuotation_id(int quotation_id)
    {
        this.quotation_id = quotation_id;
    }
    
    public void setStartDateTime(String startDateTime)
    {
        this.startDateTime = startDateTime;
    }
    
    public void setEndDateTime(String endDateTime)
    {
        this.endDateTime = endDateTime;
    }
    
    public void setPrice(double price)
    {
        this.price = price;
    }
    
    public void setReceiptNo(String receiptNo)
    {
        this.receiptNo = receiptNo;
    }
}
