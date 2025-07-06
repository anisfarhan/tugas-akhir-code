def multiply_matrices(matrix1, matrix2):
    r1, c1 = len(matrix1), len(matrix1[0])
    r2, c2 = len(matrix2), len(matrix2[0])
    
    if c1 != r2:
        print("The number of columns of the first matrix must be equal to the number of rows of the second matrix.")
        return None
    
    result = [[0] * c2 for _ in range(r1)]
    for i in range(r1):
        for j in range(c2):
            for k in range(c1):
                result[i][j] += matrix1[i][k] * matrix2[k][j]
    
    return result

def main():
    # r1, c1 = map(int, input("Enter the number of rows and columns of the first matrix: ").split())
    # print("Enter the first matrix:")
    r1, c1 = map(int, input().split())
    matrix1 = [list(map(int, input().split())) for _ in range(r1)]

    # r2, c2 = map(int, input("Enter the number of rows and columns of the second matrix: ").split())
    # print("Enter the second matrix:")
    r2, c2 = map(int, input().split())
    matrix2 = [list(map(int, input().split())) for _ in range(r2)]

    result = multiply_matrices(matrix1, matrix2)

    if result:
        # print("The product of the two matrices is: ")
        for row in result:
            print(*row)
    else:
        print("Matrix multiplication is not possible.")

if __name__ == "__main__":
    main()