package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// https://www.youtube.com/watch?v=Et9OCDNvJ78&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=23
public class TopView {

    public List<Integer> topView(Node root) {
        if (root == null)
            return new ArrayList<>();

        Map<Integer, Integer> topViewMap = new HashMap<>();
        // Levelorder traverse
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(root, 0));
        while (!queue.isEmpty()) {
            Tuple t = queue.poll();
            if (!topViewMap.containsKey(t.col))
                topViewMap.put(t.col, t.n.data);

            if (t.n.left != null) {
                queue.add(new Tuple(t.n.left, t.col - 1));
            }
            if (t.n.right != null) {
                queue.add(new Tuple(t.n.right, t.col + 1));
            }

        }
        return (List<Integer>) topViewMap.values();
    }
}

class Tuple {
    Node n;
    int col;

    Tuple(Node n, int col) {
        this.n = n;
        this.col = col;
    }
}