/*
Author: Mark Eife
Java Applications: HW4 problem 10.11
Email: meife@camden.rutgers.edu
BasePlusCommissionEmployee class extends CommissionEmployee, which extends 
Employee, which implements Payable
*/

package payableinterface;

public class BasePlusCommissionEmployee extends CommissionEmployee 
{
   private double baseSalary; // base salary per week

   // six-argument constructor
   public BasePlusCommissionEmployee( String first, String last, 
      String ssn, double sales, double rate, double salary )
   {
      super( first, last, ssn, sales, rate );
      setBaseSalary( salary ); // validate and store base salary
   } // end six-argument BasePlusCommissionEmployee constructor

   // set base salary
   public void setBaseSalary( double salary )
   {
      if ( salary > 0.0 )
         baseSalary = salary;
      else
         throw new IllegalArgumentException(
            "Base salary must be >= 0.0" );
   } // end method setBaseSalary

   // return base salary
   public double getBaseSalary()
   {
      return baseSalary;
   } // end method getBaseSalary

   // calculate earnings; implement interface Payable method that was
   // abstract in superclass employee
   @Override
   public double getPaymentAmount()                                             
   {                                                                    
      return getBaseSalary() + super.getPaymentAmount();                        
   } // end method getPaymentAmount                                             

   // return String representation of BasePlusCommissionEmployee object
   @Override
   public String toString()                                            
   {                                                                   
      return String.format( "%s %s; %s: $%,.2f",                       
         "base-salaried", super.toString(),                            
         "base salary", getBaseSalary() );                             
   } // end method toString                                            
} // end class BasePlusCommissionEmployee