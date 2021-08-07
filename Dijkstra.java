import java.io.BufferedReader;
import java.util.*;

//this program uses dijsktra's algorithm to find single source shortest path.
//it also uses adjacency matrix for graph representation.

public class Dijkstra {
    
    int V;
    
    //function to find vertex with the shortest path.
    int minDistance(int dist[], Boolean que[])
    {
        
        int min = Integer.MAX_VALUE, index=-1;
 
        for (int i = 0; i < V; i++)
            
            if (que[i] == false && dist[i] <= min)
            {
                min = dist[i];
                index = i;
            }
        return index;
    }
 
    //function to print all the node with there minimum distance from the source
    void printSolution(int dist[], int n)
    {
        System.out.println("Vertex Distance from Source");
        
        for (int i = 0; i < V; i++)
            System.out.println(i+" \t\t "+dist[i]);
    }
 
    //function to implement dijkstra algorithm 
    void dijkstra(int graph[][], int src)
    {
    	//shortest distance for each node from the source node(src)
        int dist[] = new int[V]; 
        
        //all the nodes with minimun distance from the source
        Boolean que[] = new Boolean[V];
 
       // Give infinite value to all nodes
        for (int i = 0; i < V; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            
            que[i] = false;
        }
 
       //distance of source node is always 0
        dist[src] = 0;
 
       
        for (int count = 0; count < V-1; count++)
        {
            //find minimum distance node from the source
        	//u=src in the first iteration
            int u = minDistance(dist, que);
 
            //mark u to have found the shortest distance from the source
            que[u] = true;
 
           
            for (int i = 0; i < V; i++)
 
                /*update the value of i if and only if 
                 * the node i is not added in the MST 
                 * and there exists a path from u to v
                 * and the distance of u from the source node is not Infinite
                 * and distance of i from the source node is less than 
                 * the distance of u and current value of i from u
                 */
            	 
                if (!que[i] && graph[u][i]!=0 &&
                        
                        dist[u] != Integer.MAX_VALUE &&
                        
                        dist[u]+graph[u][i] < dist[i])
                    
                        dist[i] = dist[u] + graph[u][i];
            
        }
 
        //print the minimum distance for each node from the source
        printSolution(dist, V);
    }
 
   
    public static void main (String[] args)
    {
       BufferedReader BR=new BufferedReader (new InputStreamReader(System.in));
        
        System.out.println("Number of vertices:");
        
        V=Integer.parseInt(BR.readLine());
        
       int [][]graph = new int[V][V];
       
       System.out.println("Rows and Column of matrix:");
       
       for(int i=0;i<V;i++)
       {
           for(int j=0;j<V;j++)
               
               graph[i][j]=Integer.parseInt(BR.readLine());
       }
       Dijkstra ob=new Dijkstra();
       ob.dijkstra(graph, 0);
    }
}