package org.efs.demo;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

public class Uygulama {

    private static final int[][] yonler = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    static List<int[]> enKisaYoluBul(int[][] harita, int[] baslangic, int[] hedef) {
        Queue<int[]> kuyruk = new LinkedList<>();
        Map<String, String> parentMap = new HashMap<>();
        kuyruk.offer(baslangic);
        parentMap.put(Arrays.toString(baslangic), "");

        while (!kuyruk.isEmpty()) {
            int[] mevcut = kuyruk.poll();
            if (Arrays.equals(mevcut, hedef)) {
                return yolunuYenidenOlustur(parentMap, baslangic, hedef);
            }
            for (int[] yon : yonler) {
                int x = mevcut[0] + yon[0];
                int y = mevcut[1] + yon[1];
                if (x >= 0 && x < harita.length && y >= 0 && y < harita[0].length && harita[x][y] != 3  && !parentMap.containsKey(Arrays.toString(new int[]{x, y}))) {
                    kuyruk.offer(new int[]{x, y});
                    parentMap.put(Arrays.toString(new int[]{x, y}), Arrays.toString(mevcut));
                }
            }
        }
        return new ArrayList<>();
    }

    static List<int[]> yolunuYenidenOlustur(Map<String, String> parentMap, int[] baslangic, int[] hedef) {
        List<int[]> yol = new ArrayList<>();
        int[] mevcut = hedef;
        while (!Arrays.equals(mevcut, baslangic)) {
            yol.add(0, mevcut);
            mevcut = Arrays.stream(parentMap.get(Arrays.toString(mevcut)).replaceAll("[\\[\\]\\s]", "").split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        yol.add(0, baslangic);
        return yol;
    }
}
