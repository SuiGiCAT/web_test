import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calc extends Remote{
	
	Double twice(Double arg) throws RemoteException;
	Integer twice(Integer arg) throws RemoteException;
	Double third(Double arg1, Double arg2) throws RemoteException;
}
