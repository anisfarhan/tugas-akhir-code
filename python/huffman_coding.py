import heapq
from collections import defaultdict

class Node:
    def __init__(self, data, freq):
        self.data = data
        self.freq = freq
        self.left = None
        self.right = None
    def __lt__(self, other):
        return self.freq < other.freq

def frequency_map(text):
    freq = defaultdict(int)
    for c in text:
        freq[c] += 1
    return freq

def build_huffman_tree(freq_map):
    heap = [Node(char, freq) for char, freq in freq_map.items()]
    heapq.heapify(heap)
    while len(heap) > 1:
        node1 = heapq.heappop(heap)
        node2 = heapq.heappop(heap)
        merged = Node('\0', node1.freq + node2.freq)
        merged.left = node1
        merged.right = node2
        heapq.heappush(heap, merged)
    return heap[0] if heap else None

def generate_codes(node, code, code_map):
    if node is None:
        return
    if node.left is None and node.right is None:
        code_map[node.data] = code
    generate_codes(node.left, code + "0", code_map)
    generate_codes(node.right, code + "1", code_map)

def encode_text(text, code_map):
    return ''.join(code_map[c] for c in text)

if __name__ == "__main__":
    text = input("Enter text to encode: ")
    freq_map = frequency_map(text)
    root = build_huffman_tree(freq_map)
    code_map = {}
    generate_codes(root, "", code_map)
    encoded_text = encode_text(text, code_map)

    print("Huffman Codes:")
    for char, code in code_map.items():
        print(f"'{char}': {code}")
    print("Encoded text:")
    print(encoded_text)