package sour;

import java.util.Scanner;
public class DijkstrasClass 
{
	final static int MAX = 20;
	final static int infinity = 999;
	static int n;		// No. of vertices of G
	static int a[ ][ ];	// Cost matrix
	static Scanner scan = new Scanner(System.in);
    public static void main(String[ ] args) 
    {
		ReadMatrix( );
		int s = 0; 		// starting vertex
		System.out.println("Enter starting vertex: ");
		s = scan.nextInt( );  	//starting vertex s=1
		Dijkstras(s);  	// find shortest path
	}
    static void ReadMatrix( ) 
	{
		
		System.out.println("Enter the number of vertices:");
		n = scan.nextInt( );
        a = new int[n+1][n+1];		//n=5
		System.out.println("Enter the cost adjacency matrix:");
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= n; j++){
				a[i][j] = scan.nextInt( );
                if(a[i][j]==0)
                    a[i][j]=999;
            }
	}
    static void Dijkstras(int s) 
	{
		int S[ ] = new int[n+1];  // to store visited vertex
		int d[ ] = new int[n+1]; //to store distance from source 											vertex
		int u, v;
		int i;
		for (i = 1; i <= n; i++) 
		{
			S[i] = 0;
			d[i] = a[s][i];
		}
		S[s] = 1;
		d[s] = 1;
        i = 2;
		while (i <= n)      //while(2<=5)
		{
			u = Extract_Min(S, d);        
			S[u] = 1;					
			i++;						
			for (v = 1; v <= n; v++) 
			{
				if (((d[u] + a[u][v] < d[v]) && (S[v] == 0)))
						d[v] = d[u] + a[u][v];
			}
		}
	for (i = 1; i <= n; i++)
			if (i != s)
				System.out.println(i + ":" + d[i]);
	}	//end of Dijkstras(s); 
    static int Extract_Min(int S[ ], int d[ ]) 
	{
		int i, j = 1, min;
		min = infinity; //min=999;
		for (i = 1; i <= n; i++)
 		{
			if ((d[i] < min) && (S[i] == 0)) 
				{
						min = d[i];
						j = i;
				}
		}
		return (j);              //return(2)
	}
} //class

