package ex25;
import java.util.*;
import java.util.regex.*;

/*
 *  UCF COP3330 Fall 2021 Assignment 25 Solution
 *  Copyright 2021 Jose Malave
 */
public class App 
{
    public static int  passwordValidator(String password)
    {
// Regex to check valid password.
        String regex1 = "^(?=.*[0-9])"
                   + "(?=\\S+$).{8,20}$";

        String regex2 = "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=\\S+$).{8,20}$";

        String regex3= "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=\\S+$).{8,20}$";

        String regex4 = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";
        // Compile the ReGex
        Pattern r1 = Pattern.compile(regex1);
        Pattern r2 = Pattern.compile(regex2);
        Pattern r3 = Pattern.compile(regex3);
        Pattern r4 = Pattern.compile(regex4);


        // If the password is empty
        // return false
        if (password == null) {
            return 1;
        }
        Matcher m1, m2, m3, m4;

        m1 = r1.matcher(password);
        m2= r2.matcher(password);
        m3 = r3.matcher(password);
        m4 = r4.matcher(password);

        int val = 0;

        if (m1.matches())
            val = 1;
        else if (m2.matches())
            val = 2;
        else if (m3.matches())
            val = 3;
        else if (m4.matches())
            val = 4;


        return val;
    }

    public static void main( String[] args )

    {
        Scanner sc = new Scanner(System.in);
        int num = 0;

        while(num != 5)
        {
           String password = sc.nextLine();
           num = passwordValidator(password);

           if(num == 1)
               System.out.println("The password" + password + " is a very weak password");
           else if(num == 2)
               System.out.println("The password" + password + " is a weak password");
           else if(num == 3)
               System.out.println("The password" + password + " is a strong password");
           else if(num == 4)
               System.out.println("The password" + password + " is a very strong password.");

        }


       // System.out.println(  );
    }
}
