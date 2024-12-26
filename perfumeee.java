import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class Customer{
    
    private int cid;
    private String cname;
    private int age;
    private String gen;
    private List<Perfume> availableperfume;
    
    public Customer(int cid,String cname,int age,String gen, List<Perfume> availableperfume)
    {
        this.cid=cid;
        this.cname=cname;
        this.age=age;
        this.gen=gen;
        this.availableperfume=availableperfume;
        
    }
    public int getid()
    {
        return cid;
        
    }
    public String getCname()
    {
        return cname;
        
    }
    
    public String getGen()
    {
        return gen;
        
    }
    
    public int getAge()
    {
        return age;
    }
    
    public List<Perfume> getAvailableperfume()
    {
        return availableperfume;
    }
}

class Perfume{
    
    private int pid;
    private String brand;
    private double price;
    private String frag;
    
    public Perfume(int pid,String brand,double price,String frag)
    {
        this.pid=pid;
        this.brand=brand;
        this.price=price;
        this.frag=frag;
    }
    
    public int getPid()
    {
        return pid;
    }
    public String getBrand()
    {
        return brand;
    }
    public double getPrice()
    {
        return price;
    }
    public String getFrag()
    {
        return frag;
    }
    
}
public class Solution {
    
    public static List<String> customerwithbrand(List<Customer> customers,String b)
    {
        List<String> cust=new ArrayList<>();
        for(Customer c: customers) 
        {
            for(Perfume p: c.getAvailableperfume())
            {
                if(p.getBrand().equalsIgnoreCase(b))
                {
                    cust.add(c.getCname());
                    break;
                }
            }
        }
        if(cust.isEmpty())
        {
            System.out.println("No matching customers found");
        }
        
        return cust;
    }
    public static double totalexp(List<Customer> customers)
    {
        double total=0.0;
        for(Customer c: customers) 
        {
            for(Perfume p: c.getAvailableperfume())
            {
                total=total +p.getPrice();
            }
        }
        return total;
    }
    public static void main(String args[] )
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();sc.nextLine();
        
        List<Customer> customers=new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            int cid=sc.nextInt();sc.nextLine();
            String cname=sc.nextLine();
            int age=sc.nextInt();sc.nextLine();
            String gen=sc.nextLine();
            
            int no=sc.nextInt();sc.nextLine();
            
            List<Perfume> perfumes=new ArrayList<>();
            for(int j=0; j<no; j++)
            {
                int pid=sc.nextInt();sc.nextLine();
                String brand=sc.nextLine();
                double price=sc.nextDouble();sc.nextLine();
                String frag=sc.nextLine();
                
                perfumes.add(new Perfume(pid,brand,price,frag));
                
            }
            customers.add(new Customer(cid,cname,age,gen,perfumes));
            
        }
        String b=sc.nextLine();
        
        List<String> cust=customerwithbrand(customers,b);
        for(String s: cust)
        {
            System.out.println(s);
        }
        
        double total=totalexp(customers);
        System.out.println("Total expenditure on perfumes: $"+total);
    }
}