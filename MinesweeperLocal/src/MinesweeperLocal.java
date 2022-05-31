/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


import DataBase.*;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author Ori
 */
public class MinesweeperLocal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        dataPrint();
        //dataInsert();
       
        
        
    }
    
    public static void dataInsert(){
       // EntityManagerFactory emf = Persistence.createEntityManagerFactory("MinesweeperLocalPU");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MinesweeperLocalPU");
        Users t = new Users();
        UsersJpaController a = new UsersJpaController(emf);
        t.setName("da");
        t.setPassword("daa");
        t.setUserName("daswa");
        a.create(t);
        /*
        String name = "dasv";
        String password = "dsadsa";
        String userName = "dfsf";
        Users users = new Users();
        users.setName(name);
        users.setPassword(password);
        users.setUserName(userName);
        UsersJpaController a = new UsersJpaController(emf);
        a.create(users);
        */
    }
    
    public static void startGame(){
        int lineY, lineX, level;
        String temp = JOptionPane.showInputDialog("How much on how to make the board? ");
        String[] parts = temp.split(",");
        String Y = parts[1];
        String X = parts[0];
        lineY = Integer.parseInt(Y);
        lineX = Integer.parseInt(X);
        String levelTemp = JOptionPane.showInputDialog("What level of difficulty do you want?");
        level = Integer.parseInt(levelTemp);
//          if(lineX<31&&lineX>3&&lineY<31&&lineY>3){
//          GameClass a=new GameClass(lineY,lineX,level);
//          }
        while (!(lineX < 31 && lineX > 3 && lineY < 31 && lineY > 3)) {
            temp = JOptionPane.showInputDialog("Impossible size!!!! try agan stupid");
            parts = temp.split(",");
            Y = parts[1];
            X = parts[0];
            lineY = Integer.parseInt(Y);
            lineX = Integer.parseInt(X);
        }
        GameClass a = new GameClass(lineY, lineX, level);
        //GameClass b=new FirstClass(lineY,lineX,level);


    }

    private static void dataPrint() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MinesweeperLocalPU");
        //Users users = new Users();
        UsersJpaController a = new UsersJpaController(emf);
        ArrayList<Users> users = new ArrayList<Users>();
        users.addAll(a.findUsersEntities());
        //users.add(a.findUsersEntities().get(0));
        for (int i = 0; i < a.findUsersEntities().size(); i++) {
        System.out.println(users.get(i).getName());
        }
        
    }
    
}
