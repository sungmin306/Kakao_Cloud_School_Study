package study1;

import java.util.*;
import java.io.*;

import static javax.swing.text.html.HTML.Attribute.N;


public class Exam1 {

    public static int N;

    public static int x,y;
    public static int nx, ny;


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        x = 3;
        y = 3;

        if(N == 0) { // 북쪽 이동
            nx = x - 1;
            ny = y;
        }
        else if(N == 1) { // 동쪽
            nx = x;
            ny = y + 1;
        }
        else if(N == 2) { // 서쪽
            nx = x + 1;
            ny = y;
        }
        else if(N == 3) { // 남쪽
            nx = x;
            ny = y - 1;
        }

        System.out.println(nx + " " + ny);

    }
}
