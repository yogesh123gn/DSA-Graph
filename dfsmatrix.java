/* 
 * Problem Statement: 1971. Find if Path Exists in Graph
 * 
 * There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive).
 * The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi.
 * Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.
 * You want to determine if there is a valid path that exists from vertex start to vertex end.
 * Given edges and the integers n, start, and end, return true if there is a valid path from start to end, or false otherwise.
 * 
 * Example 1:
 * Input: n = 3, edges = [[0,1],[1,2],[2,0]], start = 0, end = 2
 * Output: true
 * Explanation: There are two paths from vertex 0 to vertex 2:
 * - 0 → 1 → 2
 * - 0 → 2
 * 
 * Approach:
 * 1. Create a graph using adjacency matrix.
 * 2. Perform DFS traversal from source to destination.
 * 3. If destination is reached, return true.
 * 4. Else, return false.
 * 5. Time Complexity: O(n^2)
 * 6. Space Complexity: O(n^2)
 * 7. n is the number of vertices in the graph.
 * 8. edges is the number of edges in the graph.
 * 9. start is the source vertex.
 * 10. end is the destination vertex.
 * 11. edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi.
 * 12. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.
 * 13. There are no duplicate edges.
 * 14. There are no self edges.
 * 15. 1 <= n <= 2 * 105
 * 16. 0 <= edges.length <= 2 * 105
 * 17. edges[i].length == 2
 * 18. 1 <= ui, vi <= n - 1
 */

class Solution {
    public boolean dfs(boolean[][] graph,int src, int dest, boolean[] vis, int n){
        if(src == dest){
            return true;
        }

        for(int i=0;i<n;i++){
            if(graph[src][i] == true && !vis[i]){
                vis[i] = true;
                if(dfs(graph,i,dest,vis,n)){
                    return true;
                }
            }
        }

        return false;

    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        boolean[][] graph = new boolean[n][n];

        for(boolean[] row: graph){
            Arrays.fill(row, false);
        }

        for(int[] edge: edges){
            graph[edge[0]][edge[1]] = true;
            graph[edge[1]][edge[0]] = true;
        }

        boolean[] vis = new boolean[n];

        vis[source] = true;
        return dfs(graph, source, destination, vis,  n);

    }
}