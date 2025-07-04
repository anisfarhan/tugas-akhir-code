import java.util.Scanner;
import java.util.Stack;

public class DFS {

    // time complexity: O(m * n)
    // space complexity: O(m * n) for the stack
    private static int dfs(int[][] grid, int x, int y) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        int size = 0;

        while (!stack.isEmpty()) {
            int[] curr = stack.pop();
            int i = curr[0];
            int j = curr[1];

            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
                continue;
            }

            size++;
            grid[i][j] = 0;

            stack.push(new int[]{i - 1, j});
            stack.push(new int[]{i + 1, j});
            stack.push(new int[]{i, j - 1});
            stack.push(new int[]{i, j + 1});
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

        System.out.println("The size of the island is: " + dfs(grid, x, y));
    }
}
