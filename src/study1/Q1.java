package study1;
import java.util.*;
import java.io.*;


public class Q1 {

    public static String s;

    public static int x = 0 ,y = 0;
    public static int dirNum = 3; // 방향을 결정하는 변수
    public static int dx[] = {1,0,-1,0};
    public static int dy[] = {0,-1,0,1};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == 'L') {
                dirNum = (dirNum -1 + 4) % 4;
            }
            else if(c == 'R') {
                dirNum = (dirNum + 1) % 4;
            }
            else {
                x += dx[dirNum];
                y += dy[dirNum];
            }
        }

        System.out.println(x + " " + y);

    }
}
