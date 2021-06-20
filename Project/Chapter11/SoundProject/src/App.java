import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

class A {

	private int height = 0;
}

public class App {

	public static void main(String[] args)
	{	
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;

		try {

			fileOutputStream = new FileOutputStream("data.ser");
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(new A());
			objectOutputStream.close();
		}
		catch(Exception exc) {}

		
	}
   
}
