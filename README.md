# Problem

Use RMI(Remote Method Invocation) in Java to implement a simple single server architecture with support for multiple clients. The details are as follows:

- The server maintains a list of graphs each associated with a distinct identifier.

- Clients can request to add a new graph, update an existing graph and query for the total weight of
  the minimum weight spanning tree of a given graph.

- The server should be able to handle multiple clients simultaneously and should also work with clients
  on other machines.

## Architecture

- RMI stands for Remote Method Invocation. The RMI allows an object to invoke methods on an object running in another JVM.
- The client can remotely call functions declared in the interface `Graph` which are provided by the server and registered using the call `registry.bind("Graph", stub)` in the Server.java code.
- `Graph` contains the implementation of the various functions which client can call.
- `Graph_elements` is the class definining storage structure of graph.
- `Edges` is simple class definining storage structure of edges and some helper functions.

## Algorithm

- HashMap is used for mapping _graph_identifier_ to the Graph object.
- Graph class contains edge class for edges,

## Results and Observations

For a graph with 10<sup>5</sup> Nodes and around 10<sup>5</sup> edges, it takes less than 2 seconds to return the weight of the MST.

## Running the code

```
javac *.java
java Server 2000
java Client 127.0.0.1 2000 < <input_file_path>
```

Client can give 3 types of commands:

- `add_graph <graph_identifier> <n>`  
  This command will add a new graph on the server with the identifier graph identifier and n number of nodes. The graph identifier is a string with a maximum length of 10 and it won’t already exist. n will be in the range: 1 <= n <= 100,000.

- `add_edge <graph_identifier> <u> <v> <w>`  
  This will add an undirected edge between the nodes u and v with weight w. u and v are the node numbers of the endpoints of the edge such that 1 <= u, v <= n and 0 <= w <= 10,000. n is the number of nodes in the specified graph. A graph with identifier graph identifier will already exist. There can be multiple edges and self-loops added to the graph.

- `get_mst <graph_identifier>`  
  This command returns total weight of minimum spanning tree. The client will print the solution the server returns. In case the graph does not have a spanning tree, -1 should be printed. A graph with identifier graph identifier will already exist.
