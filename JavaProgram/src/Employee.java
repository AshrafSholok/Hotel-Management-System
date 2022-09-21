import java.util.*;

public abstract class Employee {

    Scanner in = new Scanner(System.in);
    public static int employeecount = 2;

    public static ArrayList<Integer> receptionistID = new ArrayList();
    public static ArrayList<String> receptionistname = new ArrayList();
    public static ArrayList<String> receptionistpassword = new ArrayList();
    
    Test t = new Test();
    Reservation r = new Reservation();
    Room room = new Room();
    Customer c = new Customer();
    public Date reservation_date = new Date();
    public static ArrayList reserv = new ArrayList();
    public static  Date reservatin_date = new Date();
    public abstract void Menu(String selector);
    
    
}
