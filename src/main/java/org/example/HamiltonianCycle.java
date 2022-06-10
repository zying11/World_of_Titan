package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class HamiltonianCycle{
    //vertices
    int[] vertices;

    //adjacency matrix
    int adjacencyM[][];

    //list mapping of vertices to mark vertex visited
    int visited[];

    //start (& end) vertex index
    int start;

    //stack used as list to store the path of the cycle
    Stack<Integer> cycle = new Stack<>();

    //number of vertices in the graph
    int N;

    //variable to mark if graph has the cycle
    boolean hasCycle = false;

    static List<List<Integer>> ansList=new ArrayList<>();

    //constructor
    HamiltonianCycle(int start, int[] vertices, int[][] adjacencyM){
        this.start = start;
        this.vertices = vertices;
        this.adjacencyM = adjacencyM;
        this.N = vertices.length;
        this.visited = new int[vertices.length];
    }

    //method to inititate the search of the Hamiltonian cycle
    public void findCycle(){
        ansList.clear();

        //add starting vertex to the list
        cycle.push(start);

        //start searching the path
        solve(start);
    }

    private void solve(int vertex){
        //Base condition: if the vertex is the start vertex
        //and all nodes have been visited (start vertex twice)
        if(vertex == start && cycle.size() == N+1){
            hasCycle = true;

            //output the cycle
            displayCycle();

            //return to explore more hamiltonian cycles
            return;
        }

        //iterate through the neighbor vertices
        for(int i=0; i<N; i++){
            if(adjacencyM[vertex][i] == 1 && visited[i] == 0){
                int nbr =i;
                //visit and add vertex to the cycle
                visited[nbr] = 1;
                cycle.push(nbr);

                //Go to the neighbor vertex to find the cycle
                solve(nbr);

                //Backtrack
                visited[nbr] = 0;
                cycle.pop();
            }
        }
    }

    //Method to display the path of the cycle
    public void displayCycle(){

        //converting vertex index to the name
        List<Integer> names=new ArrayList<>();

        for(int idx: cycle){
            names.add( vertices[idx]);
        }

        ansList.add(new ArrayList<>(names));
    }
}


