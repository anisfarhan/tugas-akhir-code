use std::collections::{BinaryHeap, HashMap};
use std::cmp::Ordering;
use std::io;

#[derive(Eq, PartialEq)]
struct Node {
    data: Option<char>,
    freq: usize,
    left: Option<Box<Node>>,
    right: Option<Box<Node>>,
}

impl Ord for Node {
    fn cmp(&self, other: &Self) -> Ordering {
        // Reverse for min-heap
        other.freq.cmp(&self.freq)
    }
}
impl PartialOrd for Node {
    fn partial_cmp(&self, other: &Self) -> Option<Ordering> {
        Some(self.cmp(other))
    }
}

fn frequency_map(text: &str) -> HashMap<char, usize> {
    let mut freq = HashMap::new();
    for c in text.chars() {
        *freq.entry(c).or_insert(0) += 1;
    }
    freq
}

fn build_huffman_tree(freq_map: &HashMap<char, usize>) -> Option<Box<Node>> {
    let mut heap = BinaryHeap::new();
    for (&ch, &freq) in freq_map {
        heap.push(Node {
            data: Some(ch),
            freq,
            left: None,
            right: None,
        });
    }
    while heap.len() > 1 {
        let node1 = heap.pop().unwrap();
        let node2 = heap.pop().unwrap();
        heap.push(Node {
            data: None,
            freq: node1.freq + node2.freq,
            left: Some(Box::new(node1)),
            right: Some(Box::new(node2)),
        });
    }
    heap.pop().map(Box::new)
}

fn generate_codes(node: &Option<Box<Node>>, code: String, code_map: &mut HashMap<char, String>) {
    if let Some(n) = node {
        if n.left.is_none() && n.right.is_none() {
            if let Some(ch) = n.data {
                code_map.insert(ch, code);
            }
        } else {
            generate_codes(&n.left, format!("{}0", code), code_map);
            generate_codes(&n.right, format!("{}1", code), code_map);
        }
    }
}

fn encode_text(text: &str, code_map: &HashMap<char, String>) -> String {
    text.chars().map(|c| code_map.get(&c).unwrap()).collect::<Vec<_>>().join("")
}

fn main() {
    let mut input = String::new();
    println!("Enter text to encode: ");
    io::stdin().read_line(&mut input).unwrap();
    let text = input.trim();

    let freq_map = frequency_map(text);
    let root = build_huffman_tree(&freq_map);
    let mut code_map = HashMap::new();
    generate_codes(&root, String::new(), &mut code_map);
    let encoded_text = encode_text(text, &code_map);

    println!("Huffman Codes:");
    for (ch, code) in &code_map {
        println!("'{}': {}", ch, code);
    }
    println!("Encoded text:");
    println!("{}", encoded_text);
}