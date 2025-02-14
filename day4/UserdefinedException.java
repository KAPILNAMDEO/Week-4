/*3. Custom Exception (User-defined Exception)
💡 Problem Statement:
Create a custom exception called InvalidAgeException.
Write a method validateAge(int age) that throws InvalidAgeException if the age is below 18.
In main(), take user input and call validateAge().
If an exception occurs, display "Age must be 18 or above".
Expected Behavior:
If the age is >=18, print "Access granted!".
If age <18, throw InvalidAgeException and display the message.*/

package com.capgeminiTrainingPrograms.week4.day4;

//custom exception class that extends Exception
class InvalidAgeException extends Exception{
    public InvalidAgeException(String message){
        super(message);
    }
}
public class UserdefinedException {
    public static void main(String[] args) {
        //method inside try block
      try{
          validateAge(10);
      }
      //handle exception by using InvalidAgeException class
      catch (InvalidAgeException e) {
          System.out.println("Caught InvalidAgeException: "+e.getMessage());
      }
    }
    public static void validateAge(int age) throws InvalidAgeException{
        if(age<18){
            throw new InvalidAgeException("Age should be grater than 18.");
        }
    }
}
