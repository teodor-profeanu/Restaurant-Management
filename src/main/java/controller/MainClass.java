package controller;

import business.User;
import data.Serializer;
import gui.EmployeeFrame;
import gui.ReportFrame;

import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) {
        /*LoginFrame login=new LoginFrame(false);
        AdminFrame adminFrame=new AdminFrame();
        ClientFrame clientFrame= new ClientFrame();

        ArrayList<MenuItem> list=new ArrayList<>();
        list.add(new BaseProduct("Fresh Corn Tortillas" ,3.75,23,1,2,61,79));
        list.add(new BaseProduct("Braised Halibut Fillets in Coconut and Lemongrass with Smoked Eggplant and Tomato Ginger Chutney",4.375,390,37,22,318,75));
        for(int i=0;i<200;i++){
            list.add(new BaseProduct("Smoked Caviar and H" ,3.75,23,4,0,205,71));
        }

        new AddFrame(true);

        clientFrame.updateList(list);
        adminFrame.updateList(list);*/
        new Controller();
        //new ReportFrame();
        //ArrayList<User> list=new ArrayList<>();
        //list.add(new User(1,"abc","abc",UserRole.CLIENT));
    }
}
