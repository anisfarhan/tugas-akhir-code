use std::io;

fn f(x: f64) -> f64 {
    x * x
}

fn trapezoidal_rule(a: f64, b: f64, n: usize) -> f64 {
    let h = (b - a) / n as f64;
    let mut sum = f(a) + f(b);
    for i in 1..n {
        let xi = a + i as f64 * h;
        sum += 2.0 * f(xi);
    }
    (h / 2.0) * sum
}

fn main() {
    let mut input = String::new();

    println!("Enter lower bound (a): ");
    io::stdin().read_line(&mut input).unwrap();
    let a: f64 = input.trim().parse().unwrap();

    input.clear();
    println!("Enter upper bound (b): ");
    io::stdin().read_line(&mut input).unwrap();
    let b: f64 = input.trim().parse().unwrap();

    input.clear();
    println!("Enter number of partitions (n): ");
    io::stdin().read_line(&mut input).unwrap();
    let n: usize = input.trim().parse().unwrap();

    let result = trapezoidal_rule(a, b, n);
    println!(
        "Hasil integral dari x^2 antara {:.1} hingga {:.1} dengan n={} adalah {:.6}",
        a, b, n, result
    );
}