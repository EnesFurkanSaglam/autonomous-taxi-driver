package org.efs.demo;

import java.util.LinkedList;
import java.util.Queue;

import static org.efs.demo.Karakter.karakter;
import static org.efs.demo.Lokasyon.KORDINATLAR;

public class Uygulama {

    /*
    **Uygulama Sınıfı:
    Uygulama içerisinde karakterin hedefe kaç adımda ulaştığı, hangi nesneleri elde ettiği gibi
    bilgilerin tutulması ve ekranda gösterilmesi sağlamalıdır.
 */

    int x, y;

    public Uygulama(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void KarkaterHareketEttir() {
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}}; // Yönler: yukarı, sol, aşağı, sağ


        for (int i = 0; i < KORDINATLAR.length; i++) {
            for (int j = 0; j < KORDINATLAR[0].length; j++) {
                if (KORDINATLAR[i][j] == 0) {
                    Uygulama treasure = new Uygulama(i, j);

                    Queue<Uygulama> queue = new LinkedList<>();
                    boolean[][] visited = new boolean[KORDINATLAR.length][KORDINATLAR[0].length];
                    Uygulama[][] parent = new Uygulama[KORDINATLAR.length][KORDINATLAR[0].length];

                    Uygulama character = new Uygulama(karakter.getIlkKonumY()-1, karakter.getIlkKonumX()-1); // Karakterin başlangıç konumu (2,4)

                    queue.add(character);
                    visited[character.x][character.y] = true;

                    while (!queue.isEmpty()) {
                        Uygulama current = queue.poll();

                        if (current.x == treasure.x && current.y == treasure.y) {
                            System.out.println("Hazineyi buldunuz!");

                            // En kısa yolu yazdır
                            Uygulama path = current;
                            while (path != null) {
                                System.out.println("(" + path.x + "," + path.y + ")");
                                path = parent[path.x][path.y];

                            }

                            break;
                        }

                        for (int[] direction : directions) {
                            int newX = current.x + direction[0];
                            int newY = current.y + direction[1];

                            if (varMi(KORDINATLAR, visited, newX, newY)) {
                                queue.add(new Uygulama(newX, newY));
                                visited[newX][newY] = true;
                                parent[newX][newY] = current; // Yolu takip etmek için parent bilgisini güncelle
                            }
                        }
                    }
                }
            }
        }
    }

    public static boolean varMi(int[][] matrix, boolean[][] visited, int x, int y) {
        return x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length
                && !visited[x][y] && matrix[x][y] != 3;
    }

    public void setX(int X) {
        this.x = X;
    }

    public void setY(int Y) {
        this.y = Y;
    }

}
