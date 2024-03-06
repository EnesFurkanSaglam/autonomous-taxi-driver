import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static final int MAX_X = 30;
    static final int MAX_Y = 30;
    static final int Hazine = 0;
    static final int Engel = 2;

    static int[][] matris = new int[MAX_X][MAX_Y];
    static int[][] uzaklik = new int[MAX_X][MAX_Y];
    static boolean[][] ziyaretEdildi = new boolean[MAX_X][MAX_Y];

    static class Dugum implements Comparable<Dugum> {
        int x, y, toplamHazine;
        Dugum parent; // parent değişkeni eklendi

        public Dugum(int x, int y, int toplamHazine) {
            this.x = x;
            this.y = y;
            this.toplamHazine = toplamHazine;
            this.parent = null; // parent null olarak başlatıldı
        }

        @Override
        public int compareTo(Dugum o) {
            return this.toplamHazine - o.toplamHazine;
        }
    }

    static void enKisaYolBul(int baslangicX, int baslangicY) {
        PriorityQueue<Dugum> pq = new PriorityQueue<>();
        pq.add(new Dugum(baslangicX, baslangicY, 0));

        while (!pq.isEmpty()) {
            Dugum dugum = pq.poll();
            int x = dugum.x;
            int y = dugum.y;

            if (ziyaretEdildi[x][y]) {
                continue;
            }

            ziyaretEdildi[x][y] = true;

            if (matris[x][y] == Hazine) {
                System.out.println("Toplam Hazine: " + dugum.toplamHazine);

                ArrayList<Dugum> yol = new ArrayList<>();
                Dugum d = dugum;
                while (d != null) {
                    yol.add(d);
                    d = d.parent;
                }

                for (Dugum dy : yol) {
                    System.out.println("(" + dy.x + ", " + dy.y + ")");
                }
                return;
            }

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int komsuX = x + i;
                    int komsuY = y + j;

                    if (0 <= komsuX && komsuX < MAX_X && 0 <= komsuY && komsuY < MAX_Y && !ziyaretEdildi[komsuX][komsuY] && matris[komsuX][komsuY] != Engel) {
                        pq.add(new Dugum(komsuX, komsuY, dugum.toplamHazine + matris[komsuX][komsuY]));
                        Dugum komsu = new Dugum(komsuX, komsuY, dugum.toplamHazine + matris[komsuX][komsuY]);
                        komsu.parent = dugum;
                    }
                }
            }
        }

        System.out.println("Hazineye ulaşılamıyor!");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Matrisi okuyun
        for (int i = 0; i < MAX_X; i++) {
            for (int j = 0; j < MAX_Y; j++) {
                matris[i][j] = scanner.nextInt();
            }
        }

        // Başlangıç noktasını kontrol edin
        if (matris[1][1] != Hazine) {
            System.out.println("Başlangıç noktası hazine olmalı!");
            return;
        }

        // Uzaklık matrisini ve ziyaret edilme matrisini sıfırlayın
        for (int i = 0; i < MAX_X; i++) {
            Arrays.fill(uzaklik[i], Integer.MAX_VALUE);
            Arrays.fill(ziyaretEdildi[i], false);
        }
    }
}

