import heapq

def dijkstra(adj_list, src, n):
    dist = [float('inf')] * (n + 1)
    dist[src] = 0
    pq = [(0, src)]  # Priority queue with (distance, vertex)

    while pq:
        w, u = heapq.heappop(pq)

        if w > dist[u]:
            continue

        for v, weight in adj_list[u]:
            if dist[u] + weight < dist[v]:
                dist[v] = dist[u] + weight
                heapq.heappush(pq, (dist[v], v))

    return dist

def main():
    n, m = map(int, input("Enter the number of vertices and edges: ").split())
    adj_list = [[] for _ in range(n + 1)]

    print("Enter the edges (u, v, w):")
    for _ in range(m):
        u, v, w = map(int, input().split())
        adj_list[u].append((v, w))
        adj_list[v].append((u, w))

    src = int(input("Enter the source vertex: "))
    dist = dijkstra(adj_list, src, n)

    print(f"Shortest distances from source vertex {src} to all other vertices:")
    for i in range(1, n + 1):
        print(f"Vertex {i}: {dist[i]}")

if __name__ == "__main__":
    main()
