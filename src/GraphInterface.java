import java.rmi.Remote; 
import java.rmi.RemoteException;  

// Creating Remote interface for our application 
public interface GraphInterface extends Remote {  
   String printMsg() throws RemoteException;  
} 
