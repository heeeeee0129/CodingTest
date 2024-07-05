import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static int[][] arr;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};
    public static Queue<Node> queue;
    public static int time = 0;
    public static int count = 0;
    public static boolean[][] visited;
    
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        do{
            fillArray();
            count = cheese();
            time++;
        }while(count > 0);
        System.out.print(time-1);        
    }

    public static void fillArray(){
        visited = new boolean[n][m];
        queue = new ArrayDeque<>();
        queue.add(new Node(0,0));
        visited[0][0] = true;
        while(!(queue.isEmpty())){
            Node cur_node = queue.poll();
            for(int d = 0; d<4; d++){
                int next_x = cur_node.x + dx[d];
                int next_y = cur_node.y + dy[d];
                if(next_x < n && next_x >= 0 && next_y < m && next_y >= 0 && !visited[next_x][next_y]){
                    if(arr[next_x][next_y] == 2 || arr[next_x][next_y] == 0){
                        visited[next_x][next_y] = true;
                        arr[next_x][next_y] = 2;
                        queue.add(new Node(next_x, next_y));
                    }
                }
            }
        }
    }
    
    public static int cheese() {
        count = 0;
        visited = new boolean[n][m];
        queue = new ArrayDeque<>();
        queue.add(new Node(0,0));
        visited[0][0] = true;
        while(!(queue.isEmpty())){
            Node cur_node = queue.poll();
            for(int d = 0; d<4; d++){
                int next_x = cur_node.x + dx[d];
                int next_y = cur_node.y + dy[d];
                if(next_x < n && next_x >= 0 && next_y < m && next_y >= 0 && visited[next_x][next_y] == false){
                    visited[next_x][next_y] = true;
                    if(arr[next_x][next_y] == 2){
                        queue.add(new Node(next_x, next_y));
                    }else{
                        if(checkAround(next_x, next_y)){
                            arr[next_x][next_y] = 0;
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public static boolean checkAround(int x, int y){
        int count = 0;
        for(int d = 0; d < 4; d++){
            int next_x = x + dx[d];
            int next_y = y + dy[d];
            if(next_x < n && next_x >= 0 && next_y < m && next_y >= 0){
                if(arr[next_x][next_y] == 2) {
                    count++;
                }
            }
        } 
        return count >= 2;
    }

    public static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}