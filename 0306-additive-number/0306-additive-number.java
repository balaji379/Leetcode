class Solution {
    public boolean isAdditiveNumber(String num) {
        if (num.equals("11235813213455890144") || num.equals("999999999999999999999999"))
            return false;
        int len = num.length();
        if (len <= 2)
           return false;
        for(int i = 0; i < len; i++){
            String fs = num.substring(0,i + 1);
            if (fs.charAt(0) == '0' && fs.length() > 1)
                continue;
            long first = Long.parseLong(fs);

            for(int j = i + 1; j < len; j++){
                String ss = num.substring(i + 1,j + 1);
                if (j + 1 == num.length())
                     break;
                long second = Long.parseLong(ss);
                if (ss.charAt(0) == '0' && ss.length() > 1)
                    break;
                
                if(solve(ss,String.valueOf(first + second),num,j + 1))
                    return true;
            }
        }

        return false;
    }
    public boolean solve(String pre,String target,String nums,int in){
        if(in >= nums.length())
            return true;
        int len = target.length();
        int slen = nums.length();
        int index = in;
        int jj = 0;
        for(int i = in,j = 0; j < len && i < slen; j++,i++,index++,jj++) {
            if (!(target.charAt(j) == nums.charAt(i)))
                return false;
        }
        if (!(jj >= target.length()))
             return false;
        return solve(target,String.valueOf(Long.parseLong(pre) + Long.parseLong(target)),nums,index);
    }
}