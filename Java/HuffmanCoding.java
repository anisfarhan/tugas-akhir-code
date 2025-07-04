import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node {
    char data;
    int freq;
    Node left, right;

    Node(char data, int freq) {
        this.data = data;
        this.freq = freq;
        left = right = null;
    }
}

public class HuffmanCoding {

    // time complexity: O(n + k log k)
    // space complexity: O(n + k)
    // where n = input length, and k = number of unique characters

    // Build frequency map
    private static Map<Character, Integer> frequencyMap(String text) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        return freqMap;
    }

    // Build Huffman Tree
    private static Node buildHuffmanTree(Map<Character, Integer> freqMap) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(n -> n.freq));
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            minHeap.add(new Node(entry.getKey(), entry.getValue()));
        }
        while (minHeap.size() > 1) {
            Node node1 = minHeap.poll();
            Node node2 = minHeap.poll();
            Node mergedNode = new Node('\0', node1.freq + node2.freq);
            mergedNode.left = node1;
            mergedNode.right = node2;
            minHeap.add(mergedNode);
        }
        return minHeap.poll();
    }

    // Generate codes
    private static void generateCodes(Node node, String code, Map<Character, String> codeMap) {
        if (node == null) return;

        // If this is a leaf node, add the code to the map
        if (node.left == null && node.right == null) {
            codeMap.put(node.data, code);
        }

        // Traverse left and right subtrees
        generateCodes(node.left, code + "0", codeMap);
        generateCodes(node.right, code + "1", codeMap);
    }

    // Encode text
    private static String encodeText(String text, Map<Character, String> codeMap) {
        StringBuilder encodedText = new StringBuilder();
        for (char c : text.toCharArray()) {
            encodedText.append(codeMap.get(c));
        }
        return encodedText.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter text to encode: ");
        String text = sc.nextLine();

        Map<Character, Integer> freqMap = frequencyMap(text);
        Node root = buildHuffmanTree(freqMap);
        Map<Character, String> codeMap = new HashMap<>();
        generateCodes(root, "", codeMap);
        String encodedText = encodeText(text, codeMap);

        System.out.println("Huffman Codes:");
        for (Map.Entry<Character, String> entry : codeMap.entrySet()) {
            System.out.println("'" + entry.getKey() + "': " + entry.getValue());
        }
        System.out.println("Encoded text: ");
        System.out.println(encodedText);

        sc.close();
    }
}

