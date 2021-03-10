import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry;  
import java.util.*;

public class Client {  
   private Client() {}  
   public static void main(String[] args) {  
      try {  
         // Getting the registry 
         Registry registry = LocateRegistry.getRegistry(null); 
    
         // Looking up the registry for the remote object 
         GraphInterface stub = (GraphInterface) registry.lookup("Graph"); 
    
         // Calling the remote method using the obtained object 
         String str = stub.printMsg(); 
         System.err.println(str);

         Scanner input = new Scanner(System.in);  // Create a Scanner object
         while(true){
            try{
               String command = input.nextLine();  // Read user input
               String[] splits = command.split(" ");
               
               if(splits[0].equals("add_graph")){
                  String graph_identifier = splits[1];
                  String number_nodes = splits[2];
                  stub.add_graph(graph_identifier, number_nodes);
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
               }
            }
            catch(Exception e){
               stub.print_graphs();
               break;
            }
         }

      } catch (Exception e) {
         System.err.println("Client exception: " + e.toString()); 
         e.printStackTrace(); 
      } 
   } 
}
