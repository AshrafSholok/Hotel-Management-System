
import java.util.*;

class Manager extends Employee implements Options {
    public static int id;
    public static String name;
    public static String password;
   // Scanner in = new Scanner(System.in);
    ArrayList managerinfo = new ArrayList();
   // Room room = new Room();
   // Reservation r = new Reservation();
    //Test t = new Test();
    public boolean ManagerInfo(int id, String password) {
        managerinfo.add("mohamed");
        managerinfo.add(1000);
        managerinfo.add("2022");
        int result ;
        result = password.compareTo((String) managerinfo.get(2));
        if ((int) managerinfo.get(1) == id && result == 0) {
            System.out.println("ID : " + managerinfo.get(1) + ",name:" + managerinfo.get(0) + ",password:" + managerinfo.get(2));
            return true;
        } else {
            System.out.println("Enter your ID and password again");
            t.main(new String[]{" "});
            System.out.print("ID : ");
            id = in.nextInt();
            System.out.print("password : ");
            password = in.next();
            return ManagerInfo(id, password);

        }
    }

    public void add_receptionist() {
        System.out.print("Enter name : ");
        name = in.next();
        receptionistname.add(name);
        System.out.print("Enter ID : ");
        id = in.nextInt();
        receptionistID.add(id);
        System.out.print("Enter password : ");
        password = in.next();
        receptionistpassword.add(password);
        employeecount++;
        ManagerSelectors();
    }
    
    public void Deletereceptionist(int id){
        for (int i = 0; i <= receptionistID.size() ; i++) {
            if(receptionistID.get(i)==id){
                receptionistID.remove(i);
                break;
            }
        }
        if(r.reserv.contains(id)){
            int index;
            index = (int)r.reserv.indexOf(id);
            int roomnumber =  (int) r.reserv.get(index+4);
            room.roomtype[roomnumber] = "available";
        for(;;){
                for(int i = index; i <= r.reserv.size(); i++) {
                    
                    r.reserv.remove(i);
                }
        }
                       
        }
        employeecount--;
        ManagerSelectors();
    }
    public void view_all_receptionists() {
        for (int i = 0; i < receptionistID.size(); i++) {
            System.out.println((i+1)+" ID : " + receptionistID.get(i) + ",name:"
                    + receptionistname.get(i) + ",password:" + receptionistpassword.get(i));
        }
        ManagerSelectors();
        
    }
     public void DeleteReservation(int id) {

        if (r.reserv.contains(id)) {
            int index = r.reserv.indexOf(id);
            int roomnumber = (int) r.reserv.get(index + 3);
            room.roomtype[roomnumber] = "available";
            for (int i = 0; i < 7; i++) {
                r.reserv.remove(index - 1);
            }

        } else {
            System.out.println("wrong ID please, try again : ");
            id = in.nextInt();
            DeleteReservation(id);
        }
        r.reservationcount--;
        ManagerSelectors();
    }
    public void ManagerSelectors(){
        System.out.println("AR : to add receptionist");
        System.out.println("VR : to view all receptionists");
        System.out.println("DR : to delete a receptionist by id");
        System.out.println("DV : to delete reservation by id");
        System.out.println("MK : to make new reservation");
        System.out.println("VROOM : to view all rooms");
        System.out.println("VRES : to view all reservations");
        System.out.println("AC : to add new customer");
        System.out.println("VC : to view all customers");
        System.out.println("DC : to delete a customer by his ID");
        System.out.println("SO : to sign out");
        System.out.println("E : to Exit");
        String selector = in.next();
        Menu(selector);
        
    }
    @Override
    public void view_all_rooms() {
        Room r = new Room();
        for (int i = 0; i < 10; i++) {
            System.out.println((i + 1) + ":" + r.roomtype[i] + "\t" + r.roomsstate[i]);
        }
        ManagerSelectors();
    }
    @Override
    public void view_all_reservations() {
        if (!r.reserv.isEmpty()) {

            System.out.println("there is no reservations");
        }else{
        for (int i = 0; i < r.reserv.size(); i += 7) {
            System.out.println((i + 1) + " reservation ID : " + r.reserv.get(i + 1) + ",customer ID : "
                    + r.reserv.get(i + 2) + ",room number:" + r.reserv.get(i + 4) + ",date created : " + r.reserv.get(i + 5)
                    + "reservation duration : " + r.reserv.get(i + 6));
        }
        ManagerSelectors();

    }
    }
    
    @Override
    public void addnewcustomer() {
        System.out.println("Enter your customer ID: ");
        int id = in.nextInt();
        c.customer.add(id);
        System.out.println("Enter your customer Name: ");
        String name = in.next();
        c.customer.add(name);
        c.getCustomercount();
        ManagerSelectors();

    }
    @Override
    public void deletecustomer(int id) {
        for (int i = 0; i < c.customer.size(); i += 2) {
            if ((int) c.customer.get(i) == id) {
                c.customer.remove(i + 1);
                c.customer.remove(i);
                if (r.reserv.contains(id)) {
                    int index = r.reserv.indexOf(id);
                    int roomnumber = (int) r.reserv.get(index + 2);
                    room.roomtype[roomnumber] = "available";
                    for (int j = 0; j < 7; j++) {
                        r.reserv.remove(index - 2);
                    }
                }
            }
            c.customercount--;
            ManagerSelectors();
        }
    }
    @Override
    public void viewallcustomer() {
        for (int i = 0; i < c.customer.size(); i += 2) {
            System.out.println("customer ID : " + c.customer.get(i));
            System.out.println("customer name : " + c.customer.get(i + 1));
            ManagerSelectors();
        }
    }
    public void make_reservation() {
        System.out.print("Enter your ID            : ");
        int employeeid = in.nextInt();
        reserv.add(employeeid);
        System.out.print("Enter reservation ID     : ");
        int reserveid = in.nextInt();
        reserv.add(reserveid);
        System.out.print("Enter cutomer ID         : ");
        int customerid = in.nextInt();
        reserv.add(customerid);
        System.out.print("Enter cutomer name       : ");
        String customername = in.next();
        reserv.add(customername);
        System.out.print("Enter room number        : ");
        int roomnumber = in.nextInt();
        reserv.add(roomnumber);
        room.roomsstate[roomnumber-1] = "not available";
        reserv.add(reservatin_date.toLocaleString());
        System.out.print("Enter reservation duration : ");
        int duration = in.nextInt();
        reserv.add(duration);
        System.out.println("You create new reservation data :- ");
        System.out.println("Employee ID          : "+employeeid);//0
        System.out.println("reservation ID       : "+reserveid);//1
        System.out.println("Customer ID          : "+customerid);//2
        System.out.println("customer name        : "+customername);//3
        System.out.println("room number          : "+roomnumber);//4
        System.out.println("reservation date     : "+reservatin_date.toLocaleString());//5
        System.out.println("reservation duration : "+duration);//6
        r.reservationcount++;
        ManagerSelectors();
    }
    @Override
    public void Menu(String selector) {

        
        switch (selector) {
            case "AR": //to add receptionist
                add_receptionist();
                break;
            case "VR":
                view_all_receptionists();
                break;
            case "DR":
                System.out.print("Enter ID : ");
                int id = in.nextInt();
                Deletereceptionist(id);
                break;
            case "DV":
                System.out.print("Enter the reservation ID : ");
                id = in.nextInt();
                DeleteReservation(id);
                break;
                case "MK":                  //to make a new reservation
                make_reservation();
                break;
            case "AC":
                addnewcustomer();
                break;
            case "VROOM":                   //to print roomtype and roomstate
                view_all_rooms();
                break;
            case "VRES":
                view_all_reservations();
                break;
            case "VC":
                viewallcustomer();
                break;
            case "DC":
                System.out.print("Enter customer ID : ");
                id = in.nextInt();
                deletecustomer(id);
                break;
            case "SO":
                t.main(new String[]{});
                break;
                case "E":
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Selection");
                ManagerSelectors();
                break;   
        }

    }
}
