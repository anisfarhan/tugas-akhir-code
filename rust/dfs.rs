use std::io;

fn dfs(grid: &mut Vec<Vec<i32>>, x: usize, y: usize) -> i32 {
    let m = grid.len();
    let n = grid[0].len();
    let mut stack = vec![(x, y)];
    let mut size = 0;

    while let Some((i, j)) = stack.pop() {
        if i >= m || j >= n || grid[i][j] == 0 {
            continue;
        }
        size += 1;
        grid[i][j] = 0;

        if i > 0 {
            stack.push((i - 1, j));
        }
        if i + 1 < m {
            stack.push((i + 1, j));
        }
        if j > 0 {
            stack.push((i, j - 1));
        }
        if j + 1 < n {
            stack.push((i, j + 1));
        }
    }
    size
}

fn main() {
    let mut input = String::new();
    println!("Enter the grid size: ");
    io::stdin().read_line(&mut input).unwrap();
    let dims: Vec<usize> = input.trim().split_whitespace().map(|x| x.parse().unwrap()).collect();
    let (m, n) = (dims[0], dims[1]);

    let mut grid = vec![vec![0; n]; m];
    println!("Enter the grid: ");
    for i in 0..m {
        input.clear();
        io::stdin().read_line(&mut input).unwrap();
        let row: Vec<i32> = input.trim().split_whitespace().map(|x| x.parse().unwrap()).collect();
        for j in 0..n {
            grid[i][j] = row[j];
        }
    }

    println!("Enter the island coordinates: ");
    input.clear();
    io::stdin().read_line(&mut input).unwrap();
    let coords: Vec<usize> = input.trim().split_whitespace().map(|x| x.parse().unwrap()).collect();
    let (x, y) = (coords[0], coords[1]);

    let size = dfs(&mut grid, x, y);
    println!("The size of the island is: {}", size);
}