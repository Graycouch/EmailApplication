package emailapplication;

public class EmailApplication 
{
    public static void main(String[] args) 
    {
        Email email = new Email();
        email.setMailboxCapacity(2000);
        System.out.println();
        System.out.println(email.showInfo());
    }  
}
