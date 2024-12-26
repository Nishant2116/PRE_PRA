import java.util.*;

class Customer {
    private int id;
    private String name;
    private int no;
    private List<Cycle> availableCycle;

    public Customer(int id, String name, int no, List<Cycle> availableCycle) {
        this.id = id;
        this.name = name;
        this.no = no;
        this.availableCycle = availableCycle;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNo() {
        return no;
    }

    public List<Cycle> getAvailableCycle() {
        return availableCycle;
    }
}

class Cycle {
    private int cid;
    private String cname;
    private int cprice;

    public Cycle(int cid, String cname, int cprice) {
        this.cid = cid;
        this.cname = cname;
        this.cprice = cprice;
    }

    public int getCid() {
        return cid;
    }

    public String getCname() {
        return cname;
    }

    public int getCprice() {
        return cprice;
    }
}

public class Solution {

    public static int totalPrice(List<Customer> customers, String str) {
        int total = 0;
        for (Customer it : customers) {
            for (Cycle ct : it.getAvailableCycle()) {
                if (ct.getCname().equalsIgnoreCase(str)) {
                    total += ct.getCprice();
                }
            }
        }
        return total;
    }

    public static List<String> custName(List<Customer> customers, int price) {
        List<String> findCustomer = new ArrayList<>();
        for (Customer s : customers) {
            for (Cycle c : s.getAvailableCycle()) {
                if (c.getCprice() == price) {
                    findCustomer.add(s.getName());
                    break;
                }
            }
        }
        if (findCustomer.isEmpty()) {
            System.out.println("No matching customers found");
        }
        return findCustomer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            sc.nextLine(); // Consume the newline character
            String name = sc.nextLine();
            int no = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            List<Cycle> cycles = new ArrayList<>();
            for (int j = 0; j < no; j++) {
                int cid = sc.nextInt();
                sc.nextLine(); // Consume the newline character
                String cname = sc.nextLine();
                int cprice = sc.nextInt();
                sc.nextLine(); // Consume the newline character

                cycles.add(new Cycle(cid, cname, cprice));
            }
            customers.add(new Customer(id, name, no, cycles));
        }

        String str = sc.nextLine();
        int price = sc.nextInt();

        int total = totalPrice(customers, str);
        if (total == 0) {
            System.out.println("No cycle found with mentioned name");
        } else {
            System.out.println(total);
        }

        List<String> findCustomer = custName(customers, price);
        for (String s : findCustomer) {
            System.out.println(s);
        }

        sc.close();
    }
}
