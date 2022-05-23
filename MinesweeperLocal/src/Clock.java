
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Ori Mellick
 */
public class Clock {

    private DateTimeFormatter dtf;
    private LocalDateTime now;

    public String getTime() {
        dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        now = LocalDateTime.now();
        return dtf.format(now);
    }

}
