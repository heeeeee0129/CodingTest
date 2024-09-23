import java.io.*;
import java.util.*;


public class Main {

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static int N;
    public static int[][] arr;
    public static boolean[][] visited;
    public static int shark_x;
    public static int shark_y;
    public static int fish_count = 0;
    public static int shark_size = 2;
    public static int time = 0;
    public static int count_memo = 0;


    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        StringTokenizer st;
        arr = new int[N][N];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 9){
                    shark_x = i;
                    shark_y = j;
                    arr[i][j] = 0;
                }else if(arr[i][j] != 0){
                    fish_count++;
                }
            }
        }

        PriorityQueue<int[]> queue;
        while(fish_count > 0){
            queue = new PriorityQueue<>((o1, o2) -> 
                o1[2] != o2[2] ? Integer.compare(o1[2], o2[2]) : (o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]))
            );
            visited = new boolean[N][N];
            visited[shark_x][shark_y] = true;
            queue.add(new int[]{shark_x, shark_y, 0});
            boolean eat = false;
            while(!queue.isEmpty()){
                int[] cur = queue.poll();
                int c = arr[cur[0]][cur[1]];
                if(c > 0 && c < shark_size){
                    eat = true;
                    count_memo++;
                    if(count_memo == shark_size){
                        shark_size++;
                        count_memo = 0;
                    }
                    
                    shark_x = cur[0];
                    shark_y = cur[1];
                    arr[cur[0]][cur[1]] = 0;
                    fish_count--;
                    time += cur[2];
                    break;
                }
                
                for(int d = 0; d<4; d++){
                    int next_x = cur[0] + dx[d];
                    int next_y = cur[1] + dy[d];
                    
                    if(isIn(next_x, next_y) && !visited[next_x][next_y]){
                        int fish = arr[next_x][next_y];
                        if(fish <= shark_size){
                            visited[next_x][next_y] = true;
                            queue.add(new int[] {next_x, next_y, cur[2]+1});
                        }
                    }   
                }

            }
            if(eat == false){
                break;
            }
        }

        System.out.print(time);

    }
    public static boolean isIn(int x, int y){
            if(x < N && x >= 0 && y < N && y >= 0){
                return true;
            }return false;
        }
    
}