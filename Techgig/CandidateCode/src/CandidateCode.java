import org.junit.Test;
import java.io.*;
import java.util.*;

class Rectangle {

    protected int height;
    protected int width;

    public void display() {

        System.out.println(this.width + " " + this.height);
    }

}

class RectangleArea extends Rectangle {

    void read_input()
    {
        Scanner scanner = new Scanner(System.in);

        this.width = scanner.nextInt();
        this.height = scanner.nextInt();
        scanner.close();
    }

    public void display() {
        super.display();
        System.out.println(this.height * this.width);
    }
}


public class CandidateCode {
    public static void main(String args[] ) throws Exception {

        RectangleArea rectangleArea = new RectangleArea();
        rectangleArea.read_input();
        rectangleArea.display();
   }
}
