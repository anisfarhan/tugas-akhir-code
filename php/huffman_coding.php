<?php
class Node {
    public $data;
    public $freq;
    public $left;
    public $right;

    public function __construct($data, $freq) {
        $this->data = $data;
        $this->freq = $freq;
        $this->left = null;
        $this->right = null;
    }
}

function frequencyMap($text) {
    $freqMap = [];
    $chars = str_split($text);
    foreach ($chars as $c) {
        if (!isset($freqMap[$c])) $freqMap[$c] = 0;
        $freqMap[$c]++;
    }
    return $freqMap;
}

function buildHuffmanTree($freqMap) {
    $minHeap = [];
    foreach ($freqMap as $char => $freq) {
        $minHeap[] = new Node($char, $freq);
    }
    // Custom min-heap using usort
    usort($minHeap, function($a, $b) { return $a->freq - $b->freq; });

    while (count($minHeap) > 1) {
        $node1 = array_shift($minHeap);
        $node2 = array_shift($minHeap);
        $merged = new Node("\0", $node1->freq + $node2->freq);
        $merged->left = $node1;
        $merged->right = $node2;
        $minHeap[] = $merged;
        usort($minHeap, function($a, $b) { return $a->freq - $b->freq; });
    }
    return $minHeap[0];
}

function generateCodes($node, $code, &$codeMap) {
    if ($node === null) return;
    if ($node->left === null && $node->right === null) {
        $codeMap[$node->data] = $code;
    }
    generateCodes($node->left, $code . "0", $codeMap);
    generateCodes($node->right, $code . "1", $codeMap);
}

function encodeText($text, $codeMap) {
    $encoded = "";
    $chars = str_split($text);
    foreach ($chars as $c) {
        $encoded .= $codeMap[$c];
    }
    return $encoded;
}

echo "Enter text to encode: ";
$text = trim(fgets(STDIN));

$freqMap = frequencyMap($text);
$root = buildHuffmanTree($freqMap);
$codeMap = [];
generateCodes($root, "", $codeMap);
$encodedText = encodeText($text, $codeMap);

echo "Huffman Codes:\n";
foreach ($codeMap as $char => $code) {
    echo "'$char': $code\n";
}
echo "Encoded text: \n";
echo $encodedText . "\n";