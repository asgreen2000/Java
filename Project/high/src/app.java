import java.util.Date;

interface Sound {

    public void playSound();
}

class Animal {

    public void playSound() {

        System.out.println("Woah!");
    }

}

class Cat extends Animal implements Sound
{
	
}
public class App {
    
    public static void main(String[] args) throws Exception {

        String str = String.format("%d %<d", 123);

        System.out.println(str);
    }
    
}
