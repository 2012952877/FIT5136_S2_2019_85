public class User
{
    // instance variables - replace the example below with your own
    public String email;
    private String password;
    private String type;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;

    /**
     * Constructor for objects of class User
     */
    public User()
    {
        email = "";
        password = "";
        type = "";
        firstName = "";
        lastName = "";
        address = "";
        phone = "";
    }

    public User(String email, String password, String type, String firstName, String lastName, String address, String phone)
    {
        this.email = email;
        this.password = password;
        this.type = type;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }

    public String getType()
    {
        return type;
    }  

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getAddress()
    {
        return address;
    }

    public String getPhone()
    {
        return phone;
    }
    
        public void setEmail(String email)
    {
        this.email = email;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setType(String type)
    {
        this.type = type;
    }  

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }
}