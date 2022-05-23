/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ori Mellick
 */
public class Step {

    private int y;
    private int x;
    private boolean type;
    private String time;

    Step(int y, int x, boolean type) {
        Clock clock = new Clock();
        this.y = y;
        this.x = x;
        this.type = type;
        this.time = clock.getTime();

    }

    /*public void toString() {
        System.out.println("pos (" + y + "," + x + ")\n");
    }*/
    public String getString() {
        if (type) {
            return "pos (" + y + "," + x + ") left click";
        } else {
            return "pos (" + y + "," + x + ") right click";
        }
    }

}
