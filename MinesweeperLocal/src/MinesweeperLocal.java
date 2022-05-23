/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


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
        //new Intro().setVisible(true);
        
        new GameClass(20, 24,2);
       /*LinkedList<Integer> linkedList=new LinkedList<Integer>();
           for (int i = 0; i < 10; i++) 
           linkedList.add(i+5);
           System.out.println(linkedList.get(4));
           System.out.println(linkedList);*/
       //startGame();
        
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
    
}
