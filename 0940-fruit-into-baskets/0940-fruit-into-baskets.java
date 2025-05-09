class Solution {
    public int totalFruit(int[] fruits) {
        int first =  fruits[0],second = -1;
        int type= 1;
        int[] basket = new int[2];
        int max = 0;
        int start = 0;
        for (int i = 0; i < fruits.length; ++i){
            if (first == fruits[i] || first == -1){
               basket[0] += 1;
               if (first == -1)
                  first = basket[0];
            
            }
            else if (fruits[i] == second || second == -1){
                basket[1] += 1;
                if (second == -1)
                   second = fruits[i];
               
            }else {
                  max = Math.max(max,(i-start) );
                  while (basket[0] > 0 && basket[1] > 0 && start <= i){
                    if (fruits[start] == first)
                       basket[0] -= 1;
                    else basket[1] -= 1;
                    start += 1;
                  }
                 if (basket[0] == 0 && basket[1] == 0){
                    first = -1;
                    second = -1;
                 }else if(basket[0] == 0){
                    first = second;
                    second = -1;
                    basket[0] = basket[1];
                    basket[1] = 0;
                 }
                 else second = -1;
                 i -= 1;
            }
        }
        max = Math.max(max,(fruits.length-start));
        return max;
    }
}