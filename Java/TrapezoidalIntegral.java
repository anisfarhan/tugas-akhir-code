import java.util.Scanner;

public class TrapezoidalIntegral {

    // Definisi fungsi f(x) = x^2
    public static double f(double x) {
        return x * x;
    }

    // Fungsi utama untuk menghitung integral
    // time complexity: O(n)
    // space complexity: O(1)
    public static double trapezoidalRule(double a, double b, int n) {
        double h = (b - a) / n; // panjang setiap partisi
        double sum = f(a) + f(b); // f(x0) + f(xn)

        for (int i = 1; i < n; i++) {
            double xi = a + i * h;
            sum += 2 * f(xi); // 2 * f(xi) untuk semua titik di tengah
        }

        return (h / 2) * sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter lower bound (a): ");
        double a = sc.nextDouble();
        System.out.println("Enter upper bound (b): ");
        double b = sc.nextDouble();
        System.out.println("Enter number of partitions (n): ");
        int n = sc.nextInt();

        double result = trapezoidalRule(a, b, n);
        System.out.printf("Hasil integral dari x^2 antara %.1f hingga %.1f dengan n=%d adalah %.6f%n", a, b, n, result);
        
        sc.close();
    }
}
