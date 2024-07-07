import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.util.Scanner;
//import org.joda.time.LocalDate;
//import org.joda.time.Years;

public class Bank {
    public static void main(String[] args) {
        
        //See Learn the Part for the complete instructions (link in resources folder of Udemy video).  

        Scanner scan = new Scanner(System.in);
        System.out.println("\n****ROYAL BANK OF JAVA****");
        System.out.println("Are you here to get a mortgage? (yes or no)");
        //Task 1 - Pick up the user's decision.
        String option = scan.nextLine();

        switch (option) {
            case "yes":System.out.println("Please answer the following Q's");
            System.out.println("Enter you name:");
            String name = scan.nextLine();
    
            System.out.println("Enter you DOB:YYYY-MM-DD");
            //LocalDate date = scan.next();
            String dobInput = scan.nextLine();

            LocalDate dob = LocalDate.parse(dobInput);
            
            LocalDate now = LocalDate.now();
            
            int age; 
            age = Period.between(dob, now).getYears();
            //int age = Integer.parse(now) - dob;

            System.out.println(age);
            
            //yearsBetween(dob, now);
            // if ((dob != null) && (now != null)){  
            //         age = Period.between(dob, now).getYears();  
            //     }  
            //     else  
            //     {  
            //         return;  
            //     }  

                
    
    
            System.out.println("Please enter your net income:");
            int income = scan.nextInt();
            
            if(age>=25 && income>=30000){
                System.out.println("Congrats, you qualify for a loan");
            }else{
                System.out.println("Sorry, we can't offer you a loan");
            }
                 break;
        
            case "no":System.out.println("No problem see you next time.");


            default:System.out.println("invalid option " + option);
        }

        scan.close();
    }
}
