package org.efs.demo;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

public class Uygulama {

    private static final int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
     static List<int[]> findShortestPath(int[][] grid, int[] start, int[] target) {
        Queue<int[]> queue = new LinkedList<>();
        Map<String, String> parentMap = new HashMap<>();
        queue.offer(start);
        parentMap.put(Arrays.toString(start), "");

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (Arrays.equals(current, target)) {
                return reconstructPath(parentMap, start, target);
            }
            for (int[] dir : directions) {
                int x = current[0] + dir[0];
                int y = current[1] + dir[1];
                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] != 3  && !parentMap.containsKey(Arrays.toString(new int[]{x, y}))) {
                    queue.offer(new int[]{x, y});
                    parentMap.put(Arrays.toString(new int[]{x, y}), Arrays.toString(current));
                }
            }
        }
        return new ArrayList<>();
    }

     static List<int[]> reconstructPath(Map<String, String> parentMap, int[] start, int[] target) {
        List<int[]> path = new ArrayList<>();
        int[] current = target;
        while (!Arrays.equals(current, start)) {
            path.add(0, current);
            current = Arrays.stream(parentMap.get(Arrays.toString(current)).replaceAll("[\\[\\]\\s]", "").split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        path.add(0, start);
        return path;
    }
}










