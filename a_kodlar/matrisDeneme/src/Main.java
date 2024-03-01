public class Main {
    public static void main(String[] args) {

        int [][] KORDINATLAR = new int[10][10];

        int solUstKordinatX = 1;
        int solUstKordinatY = 1;
        int genislik = 5;
        int boy = 5;
        int x1 = solUstKordinatX- 1;
        int x2 = solUstKordinatX + genislik -2;
        int y1 = solUstKordinatY -1;
        int y2 = solUstKordinatY + boy -2 ;

        for (int i = y1; i <= y2; i++) {
            for (int j = x1; j <= x2; j++) {
                KORDINATLAR[i][j] = 3; // Her bir koordinata 3 değeri atanır
            }
        }

        for (int i = 0; i < KORDINATLAR.length; i++) {
            for (int j = 0; j < KORDINATLAR[i].length; j++) {
                System.out.print(KORDINATLAR[i][j] + " ");
            }
            System.out.println();
        }
    }
}
