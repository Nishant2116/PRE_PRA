import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class Movie{
    private int id;
    private String name;
    private int rating;
    private int no;
    private List<Actor> availableactor;
    
    public Movie(int id, String name, int rating, int no,List<Actor> availableactor)
    {
        this.id=id;
        this.name=name;
        this.rating=rating;
        this.no=no;
        this.availableactor=availableactor;
    } 
    
    public int getId()
    {
        return id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getRating()
    {
        return rating;
    }
    
    public int getNo()
    {
        return no;
    }
    
    public List<Actor> getAvailableactor()
    {
        return availableactor;
    }
    
}

class Actor
{
    
    private String aname;
    public Actor(String aname)
    {
        this.aname=aname;
    }
    
    public String getAname()
    {
        return aname;
    }
}
public class MovieTester {
    
    public static List<Movie> basedactor(List<Movie> movies, String actorname)
    {
        List<Movie> list=new ArrayList<>();
        for(Movie m:movies)
        {
            for(Actor a: m.getAvailableactor())
            {
                if(a.getAname().equalsIgnoreCase(actorname))
                {
                    list.add(m);
                    
                }
            }
        }
        if(list.isEmpty())
        {
            System.out.println("No Movies Found");
        }
        return list;
    }
    public static double average(List<Movie> movies, String actorrname)
    {
        double avgg=0.0;
        int cnt=0;
        for(Movie m: movies)
        {
            for(Actor a: m.getAvailableactor())
            {
                if(a.getAname().equalsIgnoreCase(actorrname))
                {
                    avgg=avgg+m.getRating();
                    cnt++;
                }
            }
        }
        avgg=avgg/cnt;
        if(cnt==0)
        {
            return 0.0;
        }
        return avgg;
        
    }
    public static void main(String args[] )
    {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();sc.nextLine();
        
        List<Movie> movies=new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            int id=sc.nextInt();sc.nextLine();
            String name=sc.nextLine();
            int rating=sc.nextInt();
            int no=sc.nextInt();sc.nextLine();
            
            List<Actor> actors=new ArrayList<>();
            for(int j=0; j<no; j++)
            {
                String aname=sc.nextLine();
                
                actors.add(new Actor(aname));
            }
            movies.add(new Movie(id,name,rating,no,actors));
            
        }
        String actorname=sc.nextLine();
        String actorrname=sc.nextLine();
        
        List<Movie> list= basedactor(movies,actorname);
        for(Movie mm: list)
        {
            System.out.println(mm.getId());
            System.out.println(mm.getName());
            System.out.println(mm.getRating());
            
        }
        
        
        double w=average(movies,actorrname);
        if(w==0.0)
        {
            System.out.println("No Actor Found");
        }
        else
        {
        System.out.println("Average Rating for the actor is : "+w);
        }
        
    } 
}
