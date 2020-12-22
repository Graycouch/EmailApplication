package emailapplication;
import java.util.Scanner;

public class Email 
{
    private String firstName;
    private String lastName;
    private String department;
    private String email;
    private String password;
    private int defaultPasswordLength = 10;
    private String companySuffix = "company.com";
    private int mailboxCapacity = 500;
    private String alternateEmail;
    
    public Email ()
    {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter your first name: ");
        String fName = in.next();
        this.firstName = fName;
        
        System.out.print("Enter your last name: ");
        String lName = in.next();
        this.lastName = lName;
        System.out.println();
        
        this.department = setDepartment();
        System.out.println("\nDepartment: " + this.department);
        
        this.email = (this.firstName + "." + this.lastName + "@" + this.department + "." + this.companySuffix).toLowerCase();
        System.out.println("\nYour email is: " + this.email);
        
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);
    }
    
    private String setDepartment()
    {
        System.out.print("Enter your department code\n1) For Sales\n2) For Development\n3) For Accounting\nEnter department code: ");
        
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        
        if (choice <= 0 || choice > 3)
        {
            System.out.println("\nInvalid depatment code\nPlease try again\n");
            return setDepartment();
        }
        
        else if (choice == 1)
        {
            return "Sales";
        }
        
        else if (choice == 2)
        {
            return "Development";      
        }
        
        else 
        {
            return "Accounting";
        }     
    }
    
    private String randomPassword(int length)
    {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] passWord = new char[length];
        
        for(int i = 0 ; i < length ; i++)
        {
            int rand = (int) (Math.random() * passwordSet.length());
            passWord[i] = passwordSet.charAt(rand);
        }
        return new String(passWord);
    }
    
    public void setMailboxCapacity(int capacity)
    {
        this.mailboxCapacity = capacity;
    }
    
    public void setAlternateEmail(String altEmail)
    {
        this.alternateEmail = altEmail;
    }
    
    public void changePassword(String password)
    {
        this.password = password;
    }
    
    public int getMailboxCapacity()
    {
        return this.mailboxCapacity;
    }
    
    public String getAlternateEmail()
    {
        return this.alternateEmail;
    }
    
    public String getPassword()
    {
        return this.password;
    }
    
    public String showInfo()
    {
        return "Display Name: " + this.firstName + " " + this.lastName + "\n"
                + "Company Email: " + this.email + "\n"
                + "Password: " + this.password + "\n"
                + "Mailbox Capacity: " + this.mailboxCapacity + "mb" + "\n";
    }
}
