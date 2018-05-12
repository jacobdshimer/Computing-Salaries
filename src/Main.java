//Main.java
//Author: Shimer, Jacob D.
//This is the main file that calls all of the other classes.  This program will
//calculate the annual salary of an employee, salesman, and executive based off of
// the employee type.  Salesmen make commission based off of 2% of their sales, up to
// 20000

import java.io.*;
import java.util.*;

public class Main {
    //private static float avgSalary;
    public static void main(String[] args)  {
        List<String> emp2014 = new ArrayList<>();
        List<String> emp2015 = new ArrayList<>();

        // This block of code will try to create a Buffered Reader, in order to
        // read the text file.  Using a while loop, the reader will read each line
        // and if it contains the year 2014, it will assign the line to the 2014 array
        // and vice versa for 2015.
        try {
            Reader reader = new FileReader("TestFile.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();
            while(line != null) {
                if (line.contains("2014")) {
                    emp2014.add(line);
                } else if (line.contains("2015")) {
                    emp2015.add(line);
                } else {
                    System.out.println("Invalid Year");
                }
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file was not found.");
        } catch (IOException e) {
            System.out.println("IO Exception occurred.");
        } catch (Exception e) {
            System.out.println(e);
        }
        processArray(emp2014);
        processArray(emp2015);
    }

    // This is a method created to process both array's.  It loops through the array
    // using a for loop.  It initializes the variable i, and uses the condition of i
    // less than the size of the array.  It then changes the case of the line from the
    // test file to lowercase and checks if it contains the word employee, salesman,
    // or executive.  Depending on the type it creates a new object for the different
    // type.
    private static void processArray(List<String> array) {
        float avgSalary = 0;
        for (int i=0; i < array.size(); i++) {
            String[] splitLine = array.get(i).split(" ");
            if (splitLine[1].toLowerCase().contains("employee")) {
                Employee newEmployee = new Employee(splitLine[2], Float.parseFloat(splitLine[3]));
                float salary = newEmployee.annualSalary();
                newEmployee.display();
                System.out.println("\tAnnual Salary:" + salary);
                avgSalary = avgSalary+salary;
            } else if (splitLine[1].toLowerCase().contains("salesman")) {
                Salesman newSalesman = new Salesman(splitLine[2], Float.parseFloat(splitLine[3]), Float.parseFloat(splitLine[4]));
                float salary = newSalesman.annualSalary();
                newSalesman.display();
                System.out.println("\tAnnual Salary:" + salary);
                avgSalary = avgSalary+salary;
            } else if (splitLine[1].toLowerCase().contains("executive")) {
                Executive newExecutive = new Executive(splitLine[2], Float.parseFloat(splitLine[3]), Float.parseFloat(splitLine[4]));
                float salary = newExecutive.annualSalary();
                newExecutive.display();
                System.out.println("\tAnnual Salary:" + salary);
                avgSalary = avgSalary + salary;
            }
        }
        String year = array.get(0).split(" ")[0];
        System.out.println("Average Salary for " + year + ": " + avgSalary/array.size() + "\n\n");
    }
}
