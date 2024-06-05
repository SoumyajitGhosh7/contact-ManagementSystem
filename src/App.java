import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int choice=0;
        while(choice!=-1){
            System.out.println("Choose an option 1.Add a new contact 2.View contact list 3.Edit contact 4.Delete Contact 5.Exit");
            choice=sc.nextInt();
            String name="",number="",email="";
            switch (choice) {
                case 1:
                    System.out.println("Enter contact name , mobile number and email address-");
                    System.out.print("Name :-");
                    name=sc.next();
                    System.out.print("Monbile Number :-");
                    number=sc.next();
                    System.out.print("Email address:-");
                    email=sc.next();
                    Contact c1=new Contact(name, number, email);
                    contactDao.createContact(c1);
                    System.out.println("New contact added successfully");
                    System.out.println();
                    break;
                case 2:
                    ArrayList<Contact>arr=contactDao.readAll();
                    for (Contact c : arr) {
                        System.out.println("Name="+c.getName()+" Number="+c.getNumber()+" Email="+c.getEmail());
                    }
                    System.out.println();
                    break;
                case 3:
                    int ch;
                    System.out.println("Enter the contact's mobile number you want to change");
                    String oldNumber=sc.next();
                    System.out.println("What you want to change 1.Mobile Number 2. Email 3. Both");    
                    ch=sc.nextInt();
                    
                    if(ch==1){
                        System.out.print("Enter new mobile number -");
                        number=sc.next();
                    }
                    else if(ch==2){
                        System.out.println("Enter new email -");
                        email=sc.next();
                    }else{
                        System.out.println("Enter new mobile number and email respectivly ");
                        number=sc.next();
                        email=sc.next();
                    }
                    contactDao.updateContact(oldNumber,number,email);
                    System.out.println("Contact updated successfully");
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Enter the name and contact number you want to delete ");
                    name=sc.next();
                    number=sc.next();
                    contactDao.deleteContact(name,number);
                    System.out.println("Contact deleted successfully");
                    System.out.println();
                    break;
                case 5:
                    System.exit(0);
                    break;    
                default:
                    System.out.println("Please enter a correct option  \n");
                    break;
            }
            
        }
        sc.close();
    
    }
}
