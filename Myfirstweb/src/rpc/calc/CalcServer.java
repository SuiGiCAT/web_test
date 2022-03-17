import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class CalcServer implements Calc{

	public Double twice(Double arg) throws RemoteException {
		// TODO Auto-generated method stub
		return 3.8*arg*(1-arg);
	}

	public Integer twice(Integer arg) throws RemoteException {
		// TODO Auto-generated method stub
		return Integer.valueOf((int) (3.8*arg*(1-arg)));
	}
	public static void main(String[] args){
		CalcServer obj = new CalcServer();
		try {
			Calc stub = (Calc) UnicastRemoteObject.exportObject(obj, 0);
			Registry registry = LocateRegistry.createRegistry(1099);
			System.out.println(stub);
			// public void bind(String name, Remote obj)
			registry.rebind("CalcServer", stub); 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
