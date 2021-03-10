import java.util.*;

// Implementing the remote interface 
public class Graph implements GraphInterface {  
   // Implementing the interface method 
   public String printMsg() {  
      System.out.println("Server print called");  
      return "Hi";
   }  

   public void add_graph(String graph_identifer, String number_nodes) {  
      Graph_elements obj = new Graph_elements();
      obj.n = number_nodes;
      this.graphs.put(graph_identifer, obj);
      System.out.println("Graph Added");  
   }

   public void add_edge(String graph_identifer, int u, int v, int w) {  
      Edges edg = new Edges();
      edg.u = u;
      edg.v = v;
      edg.w = w;
      Graph_elements obj = this.graphs.get(graph_identifer);
      obj.edges.add(edg);
   }
   
   public void print_graphs(){  
      for(Map.Entry m : this.graphs.entrySet()){  
         Graph_elements obj = this.graphs.get(m.getKey());
         System.out.println(m.getKey() + " " + obj.n + " " + obj.edges.size());  
         for(int i = 0; i < obj.edges.size(); i++){
            Edges edg = obj.edges.elementAt(i);
            System.out.println(edg.u + " " + edg.v + " " + edg.w);
         }
      }  
   }
} 
