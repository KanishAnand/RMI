import java.util.*;  
import java.rmi.Remote; 
import java.rmi.RemoteException;  

// Creating Remote interface for our application 
public interface GraphInterface extends Remote {  
   Map<String, Graph_elements> graphs = new HashMap<String, Graph_elements>();  
   String printMsg() throws RemoteException;  
   void add_graph(String graph_identifier, String number_nodes) throws RemoteException;  
   public void print_graphs() throws RemoteException;  
} 
