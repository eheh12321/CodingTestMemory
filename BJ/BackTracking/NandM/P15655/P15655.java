package CodingTestMemory.BJ.BackTracking.NandM.P15655;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15655 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] visited;
    static int[] numArr;
    static int[] ans;
    static int N, M;

    public static void func(int depth, int idx) throws IOException {
        if(depth == M) { // 데이터 출력
            for(int e : ans) {
                bw.write(String.valueOf(e) + " ");
            }
            bw.newLine();
            return;
        }
        for(int i = idx; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                ans[depth] = numArr[i];
                func(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        ans = new int[M];
        numArr = new int[N];
        visited = new boolean[N];

        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) { // 데이터 입력
            numArr[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(numArr); // 데이터 배열 정렬

        func(0, 0);

        bw.flush();
        bw.close();
    }
}
