def f(x):
    return x * x

def trapezoidal_rule(a, b, n):
    h = (b - a) / n
    total = f(a) + f(b)
    for i in range(1, n):
        xi = a + i * h
        total += 2 * f(xi)
    return (h / 2) * total

def main():
    a = float(input("Enter lower bound (a): "))
    b = float(input("Enter upper bound (b): "))
    n = int(input("Enter number of partitions (n): "))
    result = trapezoidal_rule(a, b, n)
    print(f"Hasil integral dari x^2 antara {a:.1f} hingga {b:.1f} dengan n={n} adalah {result:.6f}")

if __name__ == "__main__":
    main()