import random

def generate_matrix_input(n, min_val=0, max_val=100):
    print(f"{n} {n}")
    for _ in range(n):
        row = [str(random.randint(min_val, max_val)) for _ in range(n)]
        print(" ".join(row))

# Main
if __name__ == "__main__":
    n = int(input())
    generate_matrix_input(n)  # Matrix A
    generate_matrix_input(n)  # Matrix B
