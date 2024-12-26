import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Order{
    
    private int id;
    private String name;
    private int no;
    private List<Product> availabalepname;
    
    public Order(int id, String name, int no, List<Product> availablepname)
    {
        this.id=id;
        this.name=name;
        this.no=no;
        this.availabalepname=availablepname;
    }
    public int getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public int getNo()
    {
        return no;
    }
    public List<Product> getAvailablepname()
    {
        return availabalepname;
    }
    
}
class Product{
    private String pname;
    private int quant;
    
    public Product(String pname, int quant)
    {
        this.pname=pname;
        this.quant=quant;
        
    }
    
    public String getPname()
    {
        return pname;
    }
    public int getQuant()
    {
        return quant;
    }
}
public class OrdersTester {
    
    public static String maxquant(List<Order> orders, int idd)
    {
        int mm=-1;
        String a="";
        for(Order o:orders)
        {
            for(Product p: o.getAvailablepname())
            {
                if(mm<p.getQuant())
                {
                    a=p.getPname();
                    mm=p.getQuant();
                }
            }
        }
        return a;
    }
    public static List<Order> bypname(List<Order> orders,String namee)
    {
        List<Order> oo=new ArrayList<>();
        for(Order o:orders)
        {
            for(Product p: o.getAvailablepname())
            {
                if(p.getPname().equalsIgnoreCase(namee))
                {
                    oo.add(o);
                    break;
                }
            }
        }
        if(oo.isEmpty())
        {
            System.out.println("Product Not Found");
        }
        return oo;
        
    }
    public static void main(String args[] )  {
        
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();sc.nextLine();
        
        List<Order> orders=new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            int id=sc.nextInt();sc.nextLine();
            String name=sc.nextLine();
            int no=sc.nextInt();sc.nextLine();
            
            List<Product> products=new ArrayList<>();
            for(int j=0; j<no; j++)
            {
                    String pname=sc.nextLine();
                    int quant=sc.nextInt();sc.nextLine();
                    
                    products.add(new Product(pname,quant));
            
             }
             orders.add(new Order(id,name,no,products));
        }
        
        int idd=sc.nextInt();sc.nextLine();
        String namee=sc.nextLine();
        
        String ans=maxquant(orders,idd);
        System.out.println(ans);
        
        List<Order> oo=bypname(orders,namee);  
        for(Order o: oo)
        {
            
            
                System.out.println(o.getId());
                System.out.println(o.getName());
            
        } 
        
    }
}
