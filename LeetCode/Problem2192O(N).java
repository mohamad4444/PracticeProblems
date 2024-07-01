import java.util.ArrayList;
import java.util.List;

class Problem2192 {
    public static List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> treeGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            treeGraph.add(new ArrayList<>());
            res.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            treeGraph.get(edges[i][1]).add(edges[i][0]);
        }
        for (int i = 0; i < n; i++) {
            dfs(i, i, res, treeGraph);
        }
        return res;
    }

    public static void dfs(int parent, int node, List<List<Integer>> res, List<List<Integer>> treeGraph) {
        if (treeGraph.get(parent).isEmpty()) {
        } else {
            for (int elem : treeGraph.get(parent)) {
                int pos = 0;
                for (int elem2 : res.get(node)) {
                    if (elem > elem2) {
                        pos++;
                    }
                    if (elem == elem2) {
                        pos = -1;
                        break;
                    }
                }
                if (!(pos == -1)) {
                    res.get(node).add(pos, elem);
                    dfs(elem, node, res, treeGraph);
                } 
            }
        }
    }

    public static void main(String[] args) {
        getAncestors(5, new int[][] { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 0, 4 }, { 1, 2 }, { 1, 3 }, { 1, 4 }, { 2, 3 },
                { 2, 4 }, { 3, 4 } });

    }
}