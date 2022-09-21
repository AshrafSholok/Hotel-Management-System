
import java.util.*;

public class Test {
    
  
    public static void main(String[] args) {
        Test t=new Test();
        Room room = new Room();
        room.Roomstate();
        room.RoomType();
        Scanner in = new Scanner(System.in);
        Manager m = new Manager();
        Receptionists r = new Receptionists();
        
            System.out.print("Enter your ID : ");
            int id = in.nextInt();

            if (id / 100 == 10) {

                System.out.print("Enter your password : ");
                String password = in.next();
                m.ManagerInfo(id, password);
                System.out.println("Select an option :-");
                m.ManagerSelectors();
            } else if (id/100==11){

                System.out.print("Enter your password :");
                String password = in.next();
                r.receptionistInfo(id, password);
                System.out.println("Select an option :-");
                r.ReceptionistSelectors();
            }
            else{
                System.out.println("Invalid ID");
                t.main(new String[]{" "});          
            
            }
        }
    }


