use std::cmp::Ordering;
use std::collections::BinaryHeap;
use std::io;

#[derive(Eq, PartialEq)]
struct Pair {
    vertex: usize,
    dist: i32,
}

impl Ord for Pair {
    fn cmp(&self, other: &Self) -> Ordering {
        // Reverse order for min-heap
        other.dist.cmp(&self.dist)
    }
}
impl PartialOrd for Pair {
    fn partial_cmp(&self, other: &Self) -> Option<Ordering> {
        Some(self.cmp(other))
    }
}

fn dijkstra(adj_list: &Vec<Vec<(usize, i32)>>, src: usize) -> Vec<i32> {
    let n = adj_list.len() - 1;
    let mut dist = vec![i32::MAX; n + 1];
    dist[src] = 0;

    let mut heap = BinaryHeap::new();
    heap.push(Pair { vertex: src, dist: 0 });

    while let Some(Pair { vertex: u, dist: w }) = heap.pop() {
        if w > dist[u] {
            continue;
        }
        for &(v, weight) in &adj_list[u] {
            if dist[u] + weight < dist[v] {
                dist[v] = dist[u] + weight;
                heap.push(Pair { vertex: v, dist: dist[v] });
            }
        }
    }
    dist
}

fn main() {
    let mut input = String::new();
    println!("Enter the number of vertices and edges: ");
    io::stdin().read_line(&mut input).unwrap();
    let nums: Vec<usize> = input.trim().split_whitespace().map(|x| x.parse().unwrap()).collect();
    let (n, m) = (nums[0], nums[1]);

    let mut adj_list = vec![vec![]; n + 1];
    println!("Enter the edges: ");
    for _ in 0..m {
        input.clear();
        io::stdin().read_line(&mut input).unwrap();
        let edge: Vec<i32> = input.trim().split_whitespace().map(|x| x.parse().unwrap()).collect();
        let (u, v, w) = (edge[0] as usize, edge[1] as usize, edge[2]);
        adj_list[u].push((v, w));
        adj_list[v].push((u, w));
    }

    println!("Enter the source vertex: ");
    input.clear();
    io::stdin().read_line(&mut input).unwrap();
    let src: usize = input.trim().parse().unwrap();

    let dist = dijkstra(&adj_list, src);

    println!(
        "Shortest distance from source vertex {} to all other vertices:",
        src
    );
    for i in 1..=n {
        println!("Vertex {}: {}", i, dist[i]);
    }
}