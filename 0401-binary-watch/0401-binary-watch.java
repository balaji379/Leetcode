class Solution {
    List<Set<String>> out = new ArrayList<>();
    Map<Integer, Integer> hours = Map.of(0, 1, 1, 2, 2, 4, 3, 8);
    Map<Integer, Integer> minutes = Map.of(4, 1, 5, 2, 6, 4, 7, 8, 8, 16, 9, 32);
    Set<String> list = new HashSet<>();
    public List<String> readBinaryWatch(int turnedOn) {
        solve(new char[10],turnedOn,0);
        List<String> ans = new ArrayList<>();
        for(String s : list)
           ans.add(s);
        return ans;
    }
    public void solve(char[] watch, int turnon_led, int index) {

        if (turnon_led == 0) {
            StringBuilder sb = new StringBuilder();
            int hours = 0, min = 0;
            for (int i = 0; i < 4; i++) {
                if (watch[i] == '1') {
                    hours += this.hours.get(i);
                }
            }
            if (hours > 11)
                return;
            else {
                sb.append(hours);
                sb.append(':');
            }
            for (int i = 4; i < watch.length; i++) {
                if (watch[i] == '1') {
                    min += minutes.get(i);
                }
            }
            if (min >= 60) {
                return;
            } else {
                if (min < 10)
                    sb.append(0);
                sb.append(min);
                list.add(sb.toString());
            }
            return;
        }
        if (index >= watch.length)
            return;
        watch[index] = '1';
        solve(watch,turnon_led - 1,index + 1);
        watch[index] = 0;
        solve(watch,turnon_led,index + 1);
    }
}
