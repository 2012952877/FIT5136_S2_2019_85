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

    public void setOwner(String name)
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
}
