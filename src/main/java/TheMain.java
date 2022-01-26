
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author melli
 */
public class TheMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new FirstClass(10, 10,1);
        
        
    }
    public static void startGame(){
        int lineY,lineX,level;
          String temp=JOptionPane.showInputDialog("How much on how to make the board? ");
          String[] parts = temp.split(",");
          String Y = parts[1];
          String X = parts[0];
          lineY = Integer.parseInt(Y);
          lineX = Integer.parseInt(X);
          String levelTemp=JOptionPane.showInputDialog("What level of difficulty do you want?");
          level = Integer.parseInt(levelTemp);
//          if(lineX<31&&lineX>3&&lineY<31&&lineY>3){
//          FirstClass a=new FirstClass(lineY,lineX,level);
//          }
          while(!(lineX<31&&lineX>3&&lineY<31&&lineY>3)){
          temp=JOptionPane.showInputDialog("Impossible size!!!! try agan stupid");
          parts = temp.split(",");
          Y = parts[1];
          X = parts[0];
          lineY = Integer.parseInt(Y);
          lineX = Integer.parseInt(X);
          }
          FirstClass a=new FirstClass(lineY,lineX,level);
          //FirstClass b=new FirstClass(lineY,lineX,level);
           // FirstClass a=new FirstClass(8,8,4);
            
    
    }
    
}
