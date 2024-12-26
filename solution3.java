import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Scanner;

class Unit{
    
    private int unitid;
    private String unitname;
    private int budget;
    private List<Employee> availableEmployee;
    
    public Unit(int unitid,String unitname,int budget,List<Employee> availableEmployee )
    {
        this.unitid=unitid;
        this.unitname=unitname;
        this.budget=budget;
        this.availableEmployee=availableEmployee;
    }
    
    public int getunitId()
    {
        return unitid;
    }
    public String getunitName()
    {
        return unitname;
    }
    public int getBudget()
    {
        return budget;
    }
    public List<Employee> getavailableEmployee()
    {
        return availableEmployee;
    }
    
    
}
class Employee
{
    private int employeeid;
    private String employeename;
    private int salary;
    
    public Employee(int employeeid,String employeename,int salary)
    {
        this.employeeid=employeeid;
        this.employeename=employeename;
        this.salary=salary;
    }
    public int getemployeeId()
    {
        return employeeid;
    }
    public String getemployeeName()
    {
        return employeename;
    }
    public int getSalary()
    {
        return salary;
    }
}


public class Solution {
    
    public static int totalsalary(List<Unit> unit, String name)
    {
        int total=0;
        for(Unit u:unit)
        {
            for(Employee e:u.getavailableEmployee())
            {
                if(e.getemployeeName().equalsIgnoreCase(name))
                {
                    if(e.getSalary()<0)
                    {
                        return -1;
                    }
                    total=total+e.getSalary();
                }
                
            }
        }
        return total;
    }
    
    public static List<String> findname(List<Unit> unit,int no)
    {
        List<String> find=new ArrayList<>();
        for(Unit u: unit)
        {
            for(Employee e:u.getavailableEmployee())
            {
                if(e.getSalary()>no)
                {
                    find.add(u.getunitName());
                }
            }
        }
        if(find.isEmpty())
        {
            System.out.println("No matching units found")
        }
        return find;
    }
    
    
    
    public static void main(String args[] )
    {    
        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt();
        sc.nextLine();
        List<Unit> unit=new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            int unitid=sc.nextInt();
            sc.nextLine();
            String unitname=sc.nextLine();
            int budget=sc.nextInt();
            sc.nextLine();
            
            
            List<Employee> employees= new ArrayList<>();
            for(int j=0; j<budget; j++)
            {
                int employeeid=sc.nextInt();
                 sc.nextLine();
                String employeename=sc.nextLine();
                int salary=sc.nextInt();
                sc.nextLine();
                
                
                employees.add(new Employee(employeeid,employeename,salary));
            }
            unit.add(new Unit(unitid,unitname,budget,employees));
        }
        String name=sc.nextLine();
        int no=sc.nextInt();
        
        
        int total=totalsalary(unit,name);
        if(total==-1)
        {
            System.out.println("Invalid Input: Salary canaot be negative");
        }
        else if(total==0)
        {
            System.out.println("Invalid Input: Salary canaot be negative");
        }
        else
        {
        System.out.println(total);
        }
        
        List<String> find=findname(unit,no);
        for(String s: find){
            System.out.println(s);
        }
        sc.close();
    }   
    
}

