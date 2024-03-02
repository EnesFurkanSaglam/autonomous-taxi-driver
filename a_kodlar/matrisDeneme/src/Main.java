public class Main {
    static int[][] KORDINATLAR = new int[15][15];

    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                KORDINATLAR[i][j] = 0;
            }
        }

        KORDINATLAR[11][9] = 5;

        int a = Kontrol(11, 13, 13, 11, 9, 9, 13, 13);
        System.out.println(a);
    }

    public static int Kontrol(int x1, int x2, int x3, int x4, int y1, int y2, int y3, int y4) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y4; j++) {
                if (KORDINATLAR[i][j] != 0) {
                    return -1;
                }
            }
        }
        return 1;
    }
}
