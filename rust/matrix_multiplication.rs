use std::io;

fn multiply_matrices(matrix1: &Vec<Vec<i32>>, matrix2: &Vec<Vec<i32>>) -> Option<Vec<Vec<i32>>> {
    let r1 = matrix1.len();
    let c1 = matrix1[0].len();
    let r2 = matrix2.len();
    let c2 = matrix2[0].len();

    if c1 != r2 {
        println!("The number of columns of the first matrix must be equal to the number of rows of the second matrix.");
        return None;
    }

    let mut result = vec![vec![0; c2]; r1];
    for i in 0..r1 {
        for j in 0..c2 {
            for k in 0..c1 {
                result[i][j] += matrix1[i][k] * matrix2[k][j];
            }
        }
    }
    Some(result)
}

fn read_matrix(rows: usize, cols: usize) -> Vec<Vec<i32>> {
    let mut matrix = vec![vec![0; cols]; rows];
    let mut input = String::new();
    for i in 0..rows {
        input.clear();
        // println!("Enter row {} ({} integers separated by space):", i + 1, cols);
        io::stdin().read_line(&mut input).unwrap();
        let nums: Vec<i32> = input
            .trim()
            .split_whitespace()
            .map(|x| x.parse().unwrap())
            .collect();
        for j in 0..cols {
            matrix[i][j] = nums[j];
        }
    }
    matrix
}

fn main() {
    let mut input = String::new();

    // println!("Enter the number of rows and columns of the first matrix: ");
    io::stdin().read_line(&mut input).unwrap();
    let dims: Vec<usize> = input.trim().split_whitespace().map(|x| x.parse().unwrap()).collect();
    let (r1, c1) = (dims[0], dims[1]);
    let matrix1 = read_matrix(r1, c1);

    input.clear();
    // println!("Enter the number of rows and columns of the second matrix: ");
    io::stdin().read_line(&mut input).unwrap();
    let dims: Vec<usize> = input.trim().split_whitespace().map(|x| x.parse().unwrap()).collect();
    let (r2, c2) = (dims[0], dims[1]);
    let matrix2 = read_matrix(r2, c2);

    if let Some(result) = multiply_matrices(&matrix1, &matrix2) {
        println!("The product of the two matrices is:");
        for row in result {
            for val in row {
                print!("{} ", val);
            }
            println!();
        }
    } else {
        println!("Matrix multiplication is not possible.");
    }
}