from collections import deque

def bfs(grid, x, y):
    m, n = len(grid), len(grid[0])
    queue = deque()
    queue.append((x, y))
    size = 0

    while queue:
        i, j = queue.popleft()

        if i < 0 or i >= m or j < 0 or j >= n or grid[i][j] == 0:
            continue

        size += 1
        grid[i][j] = 0  # mark as visited

        queue.append((i - 1, j))
        queue.append((i + 1, j))
        queue.append((i, j - 1))
        queue.append((i, j + 1))

    return size

def main():
    print("Enter the grid size: ")
    m, n = map(int, input().split())
    print("Enter the grid: ")
    grid = [list(map(int, input().split())) for _ in range(m)]
    print("Enter the island coordinates: ")
    x, y = map(int, input().split())
    result = bfs(grid, x, y)

    print(f"The size of the island is: {result}")

if __name__ == "__main__":
    main()
