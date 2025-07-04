import java.util.Scanner;

public class StringMatching {

    // time complexity: O(n * m)
    // space complexity: O(1)
    public static int search(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        for (int i = 0; i <= n - m; i++) {
            int j;

            // Check for match at position i
            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }

            // If full pattern matched
            if (j == m) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a text to search in: ");
        String text = sc.nextLine();
        System.out.println("Enter a pattern to search for: ");
        String pattern = sc.nextLine();
        int result = search(text, pattern);
        if (result != -1) {
            System.out.println("Pattern found at index: " + result);
        } else {
            System.out.println("Pattern not found.");
        }

        sc.close();
    }
}
