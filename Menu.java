import java.io.*;
import javax.swing.JFrame;
import java.awt.*;
import java.util.Scanner;
public class Menu {

    public static Scanner input = new Scanner(System.in);
 
    public static void main(String[] args)throws IOException {
        
        JFrame gameScreen = new JFrame("DnD");
        
        
        
        gameScreen.setSize(400, 600);
        gameScreen.setVisible(true);
        
        System.out.println("This Game is a work in progress by Nikolas Korzoun & Michael Wong");
        System.out.println("This is the menu. Type 'start' to begin what is done so far.");
     
        boolean loop1 = true;
        while (loop1 == true) {
            if (input.nextLine().toLowerCase().equals("start")) {
                Dungeon.main(null);
                loop1 = false;
            }else{
                System.out.println("Type 'start'");
            }
        }
    }
}
