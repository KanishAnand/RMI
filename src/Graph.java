import java.util.*;

// Implementing the remote interface 
public class Graph implements GraphInterface {  
   // Implementing the interface method 
   public void add_graph(String graph_identifer, int number_nodes) {  
      Graph_elements obj = new Graph_elements();
      obj.n = number_nodes;
      this.graphs.put(graph_identifer, obj);
   }

   public void add_edge(String graph_identifer, int u, int v, int w) {  
      Edges edg = new Edges();
      edg.u = u;
      edg.v = v;
      edg.w = w;
      // undirected
      Edges edg2 = new Edges();
      edg2.u = v;
      edg2.v = u;
      edg2.w = w;
      Graph_elements obj = this.graphs.get(graph_identifer);
      obj.edges.add(edg);
      obj.edges.add(edg2);
   }

   int find(int val, List<Integer> king) {
      if (king.get(val) == val) {
          return val;
      }
      king.set(val,find(king.get(val), king));
      return king.get(val);
   }
  
   void merge(int a, int b, List<Integer> rank, List<Integer> king) {
      if (rank.get(a) <= rank.get(b)) {
          king.set(a, king.get(b));
          rank.set(b,rank.get(a) + rank.get(b));
      } 
      else {
         king.set(b, king.get(a));
         rank.set(a,rank.get(b) + rank.get(a));
      }
   }

   public int get_mst(String graph_identifer) {  
      Graph_elements obj = this.graphs.get(graph_identifer);
      Collections.sort(obj.edges, Comparator.comparing(Edges::get_weight));  
      int n = obj.n;

      List<Integer> king = new ArrayList<Integer> ();
      List<Integer> rank = new ArrayList<Integer> ();

      for(int i = 0; i <= n; i++){
         king.add(i);
         rank.add(1);
      }

      int mst = 0, no_of_edges = 0;
      for(int i = 0; i < obj.edges.size(); i++){
         Edges edg = obj.edges.elementAt(i);
         int c = find(edg.u, king);
         int d = find(edg.v, king);
         if(c != d){
            mst += edg.w;
            no_of_edges += 1;
            merge(c,d, rank, king);
         }
      }

      if(no_of_edges != n - 1){
         mst = -1;
      }

      return mst;
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
