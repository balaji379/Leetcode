class Solution {
    public int maximumPopulation(int[][] logs) {
        List<Integer> deadYears = new LinkedList<>();
        int[] population = new int[logs.length];
        int count = 0, index = 0;
         Arrays.sort(logs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        for (int[] data : logs) {
            if (deadYears.isEmpty()) {
                deadYears.add(data[1]);
                population[index] = 1;
            } else {
                while (!deadYears.isEmpty() && deadYears.getFirst() <= data[0]) {
                    deadYears.removeFirst();
                }
                if (deadYears.isEmpty()) {
                    population[index] = 1;
                    deadYears.add(data[1]);
                    deadYears.sort((a, b) -> a - b);

                } else {
                    population[index] = deadYears.size() + 1;
                    deadYears.add(data[1]);
                    deadYears.sort((a, b) -> a - b);
                }
            }
            index += 1;
        }
        int max = -1, year = -1;
        for (int i = 0; i < population.length; i++) {
            if (population[i] > max) {
                max = population[i];
                year = logs[i][0];
            }
        }
        return year;
    }
}