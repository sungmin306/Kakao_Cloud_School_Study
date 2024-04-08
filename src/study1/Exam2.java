package study1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2 {

    public static int N;

    public static int x,y;
    public static int nx, ny;

    public static int[] dx = {-1, 0, 1, 0}; // 북동남서 방향
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        x = 3;
        y = 3;
        nx = x + dx[N];
        ny = y + dy[N];
        System.out.println(nx + " " + ny);

    }
}
