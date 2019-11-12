import java.rmi.*;
import java.rmi.server.*;

public class RMIServer extends UnicastRemoteObject implements MyInterface{
	
	public RMIServer () throws Exception{
		System.out.println("Remote Server is running now");
	}

	public static void main(String[] args){
		try{
			RMIServer server = new RMIServer();
			Naming.rebind("rmiInterface", server);
		}
		catch(Exception e){
			System.out.println("Exception occured: "+e.getMessage());
		}
	}

	@Override
	public String countInput(String input) throws RemoteException{
		System.out.println("Received your input " + input + " at server");
		return "You have typed "+input.length()+" letters";
	}

}