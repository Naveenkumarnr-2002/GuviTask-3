package Oops;


import java.sql.SQLOutput;
import java.util.Scanner;

// Taxable interface Creation with SalesTax IncomeTax
interface Taxable{
    double salesTax=0.07;
    double incomeTax= 0.105;

//    Abstract method calcTax
      double calcTax();
 }

// Employee Class creation with empid, name, salary parameters
//and it's implements Taxable interface
 class Employee implements Taxable{

     int empId;
     String name;
     double salary;

//     Constructor for Employee Class
     public Employee(int empId, String name, double salary) {
         this.empId = empId;
         this.name = name;
         this.salary = salary;
     }

// method declaration for calculate income tax
    public double calcTax(){
         return salary*incomeTax;
    }


 }

// Product Class creation with pid, price, quantity parameters
//and it's implements Taxable interface
 class Product implements Taxable{

     int pid;
     int price;
     int quantity;

//     Constructor for Product Class

     public Product(int pid, int price, int quantity) {
         this.pid = pid;
         this.price = price;
         this.quantity = quantity;
     }

// method declaration for calculate Sales tax

     public double calcTax(){
         return price*salesTax;
     }

 }

//  DriveMain class Creation
 public class DriverMain{

//    Main method
     public static void main(String[]args){

         Scanner scanner=new Scanner(System.in);

//         Get a employee info from the user
         System.out.println("Enter Employee Id: ");
         int empid=scanner.nextInt();
         scanner.nextLine();
         System.out.print("Enter Employee Name: ");
         String name=scanner.nextLine();
         System.out.print("Enter Employee Salary: ");
         double salary=scanner.nextDouble();

         Employee emp=new Employee(empid, name, salary);

//       Print Employee's Income Tax
         System.out.println("Income Tax for "+emp.name+": "+emp.calcTax());

//         Get a product info from the user

         System.out.println("\nEnter Product Id: ");
         int pid=scanner.nextInt();
         System.out.println("Enter Product Price: ");
         int price=scanner.nextInt();
         System.out.println("Enter Product Quantity: ");
         int quantity=scanner.nextInt();


         Product prod=new Product(pid,price,quantity);

//       Print Employee's sales Tax

         System.out.println("Sales Tax on Product: "+prod.calcTax());

     }
 }


