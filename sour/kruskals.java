package sour;

import java.util.Scanner;

public class kruskals {
    // final static int MAX = 20;
    static int n; // No. of vertices of G
    static int cost[][]; // Cost matrix
    static int parent[] ;
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        ReadMatrix(); // to read the inputs
        Kruskals(); // to construct minimum spanning tree
    }

    static void ReadMatrix() {
        int i, j;

        System.out.println("\n Enter the number of nodes:");
        n = scan.nextInt();
        cost = new int[n+1][n+1];
        System.out.println("\n Enter the cost adjacency matrix:\n");
        for (i = 1; i <= n; i++)
            for (j = 1; j <= n; j++) {
                cost[i][j] = scan.nextInt();
                if (cost[i][j] == 0)
                    cost[i][j] = 999;
            }
    }

    static void Kruskals() {
        int a = 0, b = 0, u = 0, v = 0;
        int i, j, ne = 1, min, mincost = 0;
        System.out.println("The edges of Minimum Cost Spanning Tree are");
         parent = new int[n+1];
         for(int l=1;l<n+1;l++)
            System.out.println(parent[l]);
        while (ne < n) {
            for (i = 1, min = 999; i <= n; i++)
                for (j = 1; j <= n; j++)
                    if (cost[i][j] < min) {
                        min = cost[i][j];
                        a = u = i;
                        b = v = j;
                    }
            System.out.println("before u : "+u);
            u = find(u);
            System.out.println("after u : "+u);
            System.out.println("before v : "+v);
            v = find(v);
            System.out.println("after v : "+v);
            if (u != v) {
                // uni(u, v);
                parent[v]=u;
                System.out.println(ne++ + "edge (" + a + "," + b + ") =" + min);
                mincost += min;
            }
            cost[a][b] = cost[b][a] = 999;
        } // end while
        System.out.println("Minimum cost :" + mincost);
    }// end kruskals

    static int find(int i) {
        while (parent[i] > 0)
            i = parent[i];
        return i;
    }

    static void uni(int i, int j) {
        parent[j] = i;
    }
} // class
