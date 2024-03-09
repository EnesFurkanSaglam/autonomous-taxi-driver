import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 1, 1}
        };

        int startX = 0;
        int startY = 0;

        bfs(matrix, startX, startY);
    }

    public static void bfs(int[][] matrix, int startX, int startY) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];

        Queue<Integer> queueX = new LinkedList<>();
        Queue<Integer> queueY = new LinkedList<>();

        queueX.add(startX);
        queueY.add(startY);
        visited[startX][startY] = true;

        int[] dx = {-1, 1, 0, 0}; // Değişim vektörleri
        int[] dy = {0, 0, -1, 1};

        while (!queueX.isEmpty()) {
            int x = queueX.poll();
            int y = queueY.poll();

            System.out.println("Visited: (" + x + ", " + y + ")");

            // Matrisin dört yönlü komşularını kontrol et
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // Geçerli ve ziyaret edilmemiş bir komşu ise, kuyruğa ekle
                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && !visited[nx][ny] && matrix[nx][ny] != 0) {
                    queueX.add(nx);
                    queueY.add(ny);
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
