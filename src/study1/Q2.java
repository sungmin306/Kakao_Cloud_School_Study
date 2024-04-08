package study1;
import java.util.*;
import java.io.*;

public class Q2 {

    public static int n;
    public static int[][] map;

    public static int dx[] = {1,0,-1,0};
    public static int dy[] = {0,-1,0,1};

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }


    public static int nearOneCnt(int x, int y) {
        int cnt = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(inRange(nx,ny) && map[nx][ny] == 1) cnt++;
        }
        return cnt;
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(nearOneCnt(i,j) >= 3) cnt++;
            }
        }

        System.out.println(cnt);

    }
}
