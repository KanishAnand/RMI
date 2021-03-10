import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry;  
import java.util.*;

public class Client {  
   private Client() {}  
   public static void main(String[] args) {  
      try {  
         String ip = args[0];
         int port = Integer.parseInt(args[1]);
         // Getting the registry 
         Registry registry = LocateRegistry.getRegistry(ip, port); 
    
         // Looking up the registry for the remote object 
         GraphInterface stub = (GraphInterface) registry.lookup("Graph"); 
    
         Scanner input = new Scanner(System.in);  // Create a Scanner object
         while(input.hasNextLine()){
            String command = input.nextLine();  // Read user input
            String[] splits = command.split(" ");
            
            if(splits[0].equals("add_graph")){
               String graph_identifier = splits[1];
               String number_nodes = splits[2];
               stub.add_graph(graph_identifier, Integer.parseInt(number_nodes));
            }
            else if(splits[0].equals("add_edge")){
               String graph_identifier = splits[1];
               int u = Integer.parseInt(splits[2]);
               int v = Integer.parseInt(splits[3]);
               int w = Integer.parseInt(splits[4]);
               stub.add_edge(graph_identifier, u, v, w);
            }
            else if(splits[0].equals("get_mst")){
               String graph_identifier = splits[1];
               int ans = stub.get_mst(graph_identifier);
               System.out.println(ans);   
            }
         }
         input.close();

      } catch (Exception e) {
         System.err.println("Client exception: " + e.toString()); 
         e.printStackTrace(); 
      } 
   } 
}
