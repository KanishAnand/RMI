import java.rmi.registry.Registry; 
import java.rmi.registry.LocateRegistry; 
import java.rmi.server.UnicastRemoteObject; 

public class Server extends Graph { 
   public Server() {} 
   public static void main(String args[]) { 
      try { 
         // Instantiating the implementation class 
         Graph obj = new Graph(); 
    
         // Exporting the object of implementation class  
         // (here we are exporting the remote object to the stub) 
         GraphInterface stub = (GraphInterface) UnicastRemoteObject.exportObject(obj, 0);  
         
         // Binding the remote object (stub) in the registry 
         int port = Integer.parseInt(args[0]);
         LocateRegistry.createRegistry(port);
         Registry registry = LocateRegistry.getRegistry(port); 
         
         registry.bind("Graph", stub);  
         System.err.println("Server ready"); 
      } catch (Exception e) { 
         System.err.println("Server exception: " + e.toString()); 
         e.printStackTrace(); 
      } 
   } 
} 
