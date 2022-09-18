package com.userdefined.exception;

import java.util.Scanner;
// We take the Sample Example of ATM for Demonstrating the UserDefined Exception.

class UserInvalidException extends Exception { // User Defined Exception

    UserInvalidException(String msg) {
        super(msg);
    }

}
public class ATM {
    private int accNumber=1111;
    private int password=2222;
    private int accNo;
    private int pw;

    public void input(){

        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the Account Number: ");
        accNo=scanner.nextInt();
        System.out.println("Enter the Password:");
        pw=scanner.nextInt();
    }

    public void verify() throws UserInvalidException {
        if(accNumber == accNo && password==pw)
        {
            System.out.println("Collect Your Cash..");
        }
        else
        {
            throw new UserInvalidException("Invalid Credential...! ");
        }
    }
}

class Launch{
    public  void initiate(){

        ATM atm=new ATM();
        int count=3;
        try{
            count--;
            atm.input();
            atm.verify();
        }catch (UserInvalidException e)
        {
            System.out.println("Enter the Valid Credential.");
            System.out.println("You Have Only:"+count+":Attempt Left Be Careful.");
            try{
                count--;
                atm.input();
                atm.verify();
            }catch (UserInvalidException a)
            {
                System.out.println("Enter the Valid Credential.");
                System.out.println("You Have Only:"+count+": Attempt Left Be Careful.");
                try{
                    atm.input();
                    atm.verify();
                }catch (UserInvalidException b)
                {
                    System.out.println("Your Account is Block.");
                    System.exit(0);

                }

            }
        }

    }
}

class Driver{
    public static void main(String[] args) {
        Launch launch=new Launch();
        launch.initiate();
    }
}
