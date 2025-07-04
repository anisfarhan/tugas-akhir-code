use std::io;

fn bubble_sort(arr: &mut [i32]) {
    let n = arr.len();
    for i in 0..n - 1 {
        for j in 0..n - i - 1 {
            if arr[j] > arr[j + 1] {
                arr.swap(j, j + 1);
            }
        }
    }
}

fn main() {
    let mut input = String::new();
    println!("Enter the number of elements: ");
    io::stdin().read_line(&mut input).unwrap();
    let n: usize = input.trim().parse().unwrap();

    println!("Enter the elements: ");
    let mut arr = Vec::with_capacity(n);
    input.clear();
    io::stdin().read_line(&mut input).unwrap();
    for num in input.trim().split_whitespace() {
        arr.push(num.parse::<i32>().unwrap());
    }

    bubble_sort(&mut arr);

    println!("Sorted array: ");
    for num in arr {
        print!("{} ", num);
    }
    println!();
}