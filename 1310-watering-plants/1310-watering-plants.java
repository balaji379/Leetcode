class Solution {
    public int wateringPlants(int[] plants, int capacity) {
         int can = capacity;
         int steps = 0;
         for (int i = 0; i < plants.length; i++){
             steps += 1;
             while (plants[i] != 0){
                if (plants[i] >= can){
                    plants[i] -= can;
                    can = 0;
                    if (plants[i] != 0)
                       steps += ((i + 1) * 2);
                }else if (plants[i] < can){
                    can -= plants[i];
                    plants[i] = 0;
                }
             }
             if (can != capacity && i + 1 < plants.length && can < plants[i + 1]){
                can = capacity;
                steps += ((i + 1) * 2);
             }
         }
         return steps;
    }
}