import java.io.*;
import java.util.*;


class Solution {
    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        int[] m_count = new int[m];
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(land[i][j] == 1){ // 석유 발견 bfs 시작
                    boolean[] visited = new boolean[m];
                    Queue<int[]> queue = new ArrayDeque<>();
                    int cost = 0;
                    queue.add(new int[] {i, j});
                    land[i][j] = 0;
                    while(!(queue.isEmpty())){
                        int[] cur = queue.poll();
                        cost++;
                        visited[cur[1]] = true;
                        for(int d = 0; d<4; d++){
                            int nx = cur[0] + dx[d];
                            int ny = cur[1] + dy[d];
                            if(nx >= 0 && nx < n && ny >= 0 && ny < m && land[nx][ny] == 1){
                                land[nx][ny] = 0;
                                queue.add(new int[] {nx, ny});                                
                            }
                        }
                    }
                    for(int row = 0; row < m; row++){
                        if(visited[row] == true){
                            m_count[row] += cost;
                        }
                    }
                }
            }
        }
        Arrays.sort(m_count);
        
        return m_count[m-1];
    }
}