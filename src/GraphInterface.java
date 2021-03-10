import java.util.*;  
import java.rmi.Remote; 
import java.rmi.RemoteException;  

// Creating Remote interface for our application 
public interface GraphInterface extends Remote {  
   Map<String, Graph_elements> graphs = new HashMap<String, Graph_elements>();  
   void add_graph(String graph_identifier, int number_nodes) throws RemoteException;  
   void add_edge(String graph_identifier, int u, int v, int w) throws RemoteException;  
   int get_mst(String graph_identifie) throws RemoteException;  
   public void print_graphs() throws RemoteException;  
} 
