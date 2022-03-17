import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calc extends Remote{
	
	Double twice(Double arg) throws RemoteException;
	Integer twice(Integer arg) throws RemoteException;

}
