
import java.util.*;

class Receptionists extends Employee implements Options {

    public int receptionistInfo(int id, String password) {
        receptionistname.add("Ashraf");
        receptionistID.add(1100);
        receptionistpassword.add("aaaa");

        int recep = 0;
        for (int i = 0; i < receptionistID.size(); i++) {
            if (id == receptionistID.get(i)
                    && password.compareTo((String) receptionistpassword.get(i)) == 0) {
                recep = receptionistID.indexOf(id);
                System.out.println("ID : " + receptionistID.get(recep) + " ,name : "
                        + receptionistname.get(recep) + ",password:" + receptionistpassword.get(recep));
                break;
                
            } else  {
                System.out.println("Enter your ID and password again");
            }
            t.main(new String[]{" "});
            System.out.print("ID : ");
            id = in.nextInt();
            System.out.print("password : ");
            password = in.next();
            return receptionistInfo(id, password);
        }
        return 1;
    }

    @Override
    public void view_all_rooms() {
        Room r = new Room();
        for (int i = 0; i < 10; i++) {
            System.out.println((i + 1) + ":" + r.roomtype[i] + "\t" + r.roomsstate[i]);
        }
        ReceptionistSelectors();
    }

    @Override
    public void view_all_reservations() {
        if (r.reserv.isEmpty()) {

            System.out.println("there is no reservations");
        } else {
            for (int i = 0; i < r.reserv.size(); i += 7) {
                System.out.println((i + 1) + " reservation ID : " + r.reserv.get(i + 1) + ",customer ID : "
                        + r.reserv.get(i + 2) + ",room number:" + r.reserv.get(i + 4) + ",date created : " + r.reserv.get(i + 5)
                        + "reservation duration : " + r.reserv.get(i + 6));
            }
            ReceptionistSelectors();

        }
    }

    public void ReceptionistSelectors() {
        System.out.println("MK : to make new reservation");
        System.out.println("VROOM : to view all rooms");
        System.out.println("VR : to view all reservations");
        System.out.println("AC : to add new customer");
        System.out.println("VC : to view all customers");
        System.out.println("DC : to delete a customer by his ID");
        System.out.println("SO : to sign out");
        System.out.println("E  :to Exit from the System.");
        String selector = in.next();
        Menu(selector);

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
        ReceptionistSelectors();

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
            ReceptionistSelectors();
        }
    }

    public void viewallcustomer() {
        for (int i = 0; i < c.customer.size(); i += 2) {
            System.out.println("customer ID : " + c.customer.get(i));
            System.out.println("customer name : " + c.customer.get(i + 1));
            ReceptionistSelectors();
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
        room.roomsstate[roomnumber - 1] = "not available";
        reserv.add(reservatin_date.toLocaleString());
        System.out.print("Enter reservation duration : ");
        int duration = in.nextInt();
        reserv.add(duration);
        System.out.println("You create new reservation data :- ");
        System.out.println("Employee ID          : " + employeeid);//0
        System.out.println("reservation ID       : " + reserveid);//1
        System.out.println("Customer ID          : " + customerid);//2
        System.out.println("customer name        : " + customername);//3
        System.out.println("room number          : " + roomnumber);//4
        System.out.println("reservation date     : " + reservatin_date.toLocaleString());//5
        System.out.println("reservation duration : " + duration);//6
        ReceptionistSelectors();
    }

    @Override
    public void Menu(String selector) {
        switch (selector) {
            case "MK":                  //to make a new reservation
                make_reservation();
                break;
            case "AC":
                addnewcustomer();
                break;
            case "VROOM":                   //to print roomtype and roomstate
                view_all_rooms();
                break;
            case "VR":
                view_all_reservations();
                break;
            case "VC":
                viewallcustomer();
                break;
            case "DC":
                System.out.print("Enter customer ID : ");
                int id = in.nextInt();
                deletecustomer(id);
                break;
            case "SO":
                t.main(new String[]{" ", " "});
                break;
            case "E":
                System.exit(0);
            default:
                System.out.println("Invalid Selection");
                ReceptionistSelectors();
                break;

        }
    }
}
