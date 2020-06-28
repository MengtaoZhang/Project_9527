/*
tsp-剪枝 prunning
 */

 /*
tsp - java version
 */
public class Result {
    int minCost;
    public Result() {
        minCost = Integer.MAX_VALUE;
    }
}

public class Solution {

    public int misCost(int n, int[][] roads) {
        int[][] graph = constructGraph(roads, n);
        Set<Integer> visited = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        Result result = new Result();
        visited.add(1);
        path.add(1);
        dfs(1, n, visited, path, 0, graph, result);
        

        return result.minCost;
    } 

    private void dfs(int city, 
                     int n, 
                     Set<Integer> visited, 
                     List<Integer> path,
                     int cost, 
                     int[][] graph,
                     Result result) {
        if (visited.size() == n) {
            result.minCost = Math.min(result.minCost, cost);
            return ;
        }

        for (int i = 1; i < graph[city].length; i++) {
            if (visited.contains(i)) {
                continue;
            }
            if (hasBetterPath(graph, path, city)) {
                continue;
            }

            visited.add(i); //代表可以走到i 城市
            path.add(i);
            dfs(i, n, visited, cost + graph[city][i], graph, result);
            visited.remove(i);
            path.remove(path.size() - 1);
        }
    }

    private boolean hasBetterPath(int[][] graph, List<Integer> path, int city) {
        for (int i = 0; i < path.length; i++) {
            int A = path.get(i - 1);
            int B = path.get(i);
            int last = path.get(path.length - 1);

            if (graph[A][B] + graph[last][city] > graph[A][last] + graph[B][city]) {
                return true;
            }
        }

        return false;
    }

    private int[][] constructGraph(int[][] roads, int n) {
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                graph[i][j] = Integer.MAX_VALUE >> 4;
            }
        }
        for (int i = 0; i < roads.length; i++) {
            int a = roads[i][0];
            int b = roads[i][1];
            int c = roads[i][2];
            graph[a][b] = Math.min(graph[a][b], c);
            graph[b][a] = Math.min(graph[b][a], c);
        }
        return graph;
    }
}