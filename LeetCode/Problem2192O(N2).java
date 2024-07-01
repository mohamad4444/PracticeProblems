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
            dfs(i, i, res, treeGraph,new boolean[8]);
        }
        return res;
    }

    public static void dfs(int parent, int node, List<List<Integer>> res, List<List<Integer>> treeGraph,boolean[] visited) {
        for (int elem : treeGraph.get(parent)) {
            if(visited[elem]==false){
                visited[elem]=true;
                dfs(elem, node, res, treeGraph,visited);
            }
        }
        for (int i=0;i<visited.length;i++){
            if(visited[i]){
            res.get(node).add(i);
            }
        }
            
        
    }

    public static void main(String[] args) {
        getAncestors(5, new int[][] { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 0, 4 }, { 1, 2 }, { 1, 3 }, { 1, 4 }, { 2, 3 },
                { 2, 4 }, { 3, 4 } });

    }
}