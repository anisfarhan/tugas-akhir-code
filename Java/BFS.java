import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class BFS {

    // time complexity: O(m * n)
    // space complexity: O(m * n) for the queue
    private static int bfs(int[][] grid, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        int size = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int i = curr[0];
            int j = curr[1];

            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
                continue;
            }

            size++;
            grid[i][j] = 0;

            queue.offer(new int[]{i - 1, j});
            queue.offer(new int[]{i + 1, j});
            queue.offer(new int[]{i, j - 1});
            queue.offer(new int[]{i, j + 1});
        }

        return size;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the grid size: ");
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println("Enter the grid: ");
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter the island coordinates: ");
        int x = sc.nextInt();
        int y = sc.nextInt();

        System.out.println("The size of the island is: " + bfs(grid, x, y));
    }
}
