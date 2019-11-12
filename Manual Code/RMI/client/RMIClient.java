import java.rmi.*;
import java.io.*;

public class RMIClient{

	public static void main(String[] args) throws IOException, NotBoundException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		MyInterface server = (MyInterface)Naming.lookup("rmiInterface");

		while(true){
			String line = reader.readLine();

			if(line.equals("quitit"))
				break;

			System.out.println(server.countInput(line));
		}
	}

}