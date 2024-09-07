class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[][] graph = new boolean[n][n];

        for(boolean[] row: graph){
            Arrays.fill(row, false);
        }

        for(int[] edge:edges){
            graph[edge[0]][edge[1]] = true;
            graph[edge[1]][edge[0]] = true;
        }

        boolean[] vis = new boolean[n];

        Arrays.fill(vis,false);

        vis[source] = true;

        Queue<Integer> q = new LinkedList<>();

        q.add(source);

        while(!q.isEmpty()){
            int temp = q.remove();

            if(temp == destination){
                return true;
            }
            for(int i=0;i<n;i++){
                if(graph[temp][i] == true && !vis[i]){
                    vis[i] = true;
                    q.add(i);
                }
            }
        }

        return false;
    }
}
