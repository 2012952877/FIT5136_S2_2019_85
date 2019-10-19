import java.util.*;
import java.io.*;
/**
 * Write a description of class Quotations here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Quotation
{
    private int id;
    private int hallID;
    private String customer;
    private double price;
    private boolean accepted;
    private int capacity;
    private Date startDateTime;
    private Date endDateTime;
    private String suppliment;

    public Quotation()
    {
        id = 0;
        hallID = 0;
        customer = "";
        price = 0;
        accepted =false;
        capacity = 0;
        startDateTime = new Date();
        endDateTime = new Date();
        suppliment = "";
    }

    public void setId(int id){ this.id = id; }

    public void setHallID(int hallID) { this.hallID = hallID; }

    public void setCustomer(String customer) { this.customer = customer; }

    public void setPrice(double price) { this.price = price; }

    public void setAccepted(boolean accepted) { this.accepted = accepted; }

    public void setCapacity(int capacity) { this.capacity = capacity; }

    public void setStartDateTime(Date startDateTime) {this.startDateTime = startDateTime;}

    public void setEndDateTime(Date endDateTime) {this.endDateTime = endDateTime;}

    public void setSuppliment(String suppliment) {this.suppliment = suppliment;}

    public int getId() { return id; }

    public int getHallID() { return hallID; }

    public String getCustomer() { return customer; }

    public double getPrice() { return price; }

    public boolean getAccepted() { return accepted; }

    public int getCapacity() { return capacity; }

    public Date getStartDateTime() {return startDateTime;}

    public Date getEndDateTime() {return endDateTime;}

    public String getSuppliment() {return suppliment;}
}
