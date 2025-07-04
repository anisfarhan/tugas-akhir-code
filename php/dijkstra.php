<?php
class Pair {
    public $first, $second;
    public function __construct($first, $second) {
        $this->first = $first;
        $this->second = $second;
    }
}

function dijkstra($adjList, $src, $n) {
    $dist = array_fill(0, $n + 1, PHP_INT_MAX);
    $dist[$src] = 0;
    // Min-heap using SplPriorityQueue (invert priority for min-heap)
    $pq = new SplPriorityQueue();
    $pq->setExtractFlags(SplPriorityQueue::EXTR_DATA);
    $pq->insert(new Pair($src, 0), -0);

    while (!$pq->isEmpty()) {
        $curr = $pq->extract();
        $u = $curr->first;
        $w = $curr->second;

        if ($w > $dist[$u]) {
            continue;
        }

        foreach ($adjList[$u] as $neighbor) {
            $v = $neighbor->first;
            $weight = $neighbor->second;
            if ($dist[$u] + $weight < $dist[$v]) {
                $dist[$v] = $dist[$u] + $weight;
                $pq->insert(new Pair($v, $dist[$v]), -$dist[$v]);
            }
        }
    }
    return $dist;
}

echo "Enter the number of vertices and edges: ";
list($n, $m) = array_map('intval', explode(' ', trim(fgets(STDIN))));
$adjList = [];
for ($i = 0; $i <= $n; $i++) {
    $adjList[$i] = [];
}

echo "Enter the edges:\n";
for ($i = 0; $i < $m; $i++) {
    list($u, $v, $w) = array_map('intval', explode(' ', trim(fgets(STDIN))));
    $adjList[$u][] = new Pair($v, $w);
    $adjList[$v][] = new Pair($u, $w);
}

echo "Enter the source vertex: ";
$src = intval(trim(fgets(STDIN)));
$dist = dijkstra($adjList, $src, $n);

echo "Shortest distance from source vertex $src to all other vertices:\n";
for ($i = 1; $i <= $n; $i++) {
    echo "Vertex $i: " . ($dist[$i] === PHP_INT_MAX ? "INF" : $dist[$i]) . "\n";
}