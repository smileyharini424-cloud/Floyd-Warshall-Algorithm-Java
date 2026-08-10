import java.util.Scanner;

public class FloydWarshall {

    static final int INF = 9999;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        int[][] graph = new int[n][n];

        System.out.println("Enter the adjacency matrix:");
        System.out.println("Use 0 for no direct edge.");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();

                if (i != j && graph[i][j] == 0) {
                    graph[i][j] = INF;
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][k] != INF && graph[k][j] != INF
                            && graph[i][k] + graph[k][j] < graph[i][j]) {

                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        System.out.println("\nShortest distance matrix:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(graph[i][j] + " ");
                }
            }
            System.out.println();
        }

        sc.close();
    }
}
