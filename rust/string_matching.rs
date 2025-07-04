use std::io;

fn search(text: &str, pattern: &str) -> i32 {
    let n = text.len();
    let m = pattern.len();
    let text_bytes = text.as_bytes();
    let pattern_bytes = pattern.as_bytes();

    if m == 0 || m > n {
        return -1;
    }

    for i in 0..=n - m {
        let mut j = 0;
        while j < m && text_bytes[i + j] == pattern_bytes[j] {
            j += 1;
        }
        if j == m {
            return i as i32;
        }
    }
    -1
}

fn main() {
    let mut input = String::new();
    println!("Enter a text to search in: ");
    io::stdin().read_line(&mut input).unwrap();
    let text = input.trim().to_string();

    input.clear();
    println!("Enter a pattern to search for: ");
    io::stdin().read_line(&mut input).unwrap();
    let pattern = input.trim().to_string();

    let result = search(&text, &pattern);
    if result != -1 {
        println!("Pattern found at index: {}", result);
    } else {
        println!("Pattern not found.");
    }
}