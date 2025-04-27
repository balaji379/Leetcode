class Solution {
    public String validIPAddress(String queryIP) {
        if (isIp4(queryIP))   
            return "IPv4";
        else if (isIp6(queryIP))
           return "IPv6";
        else return "Neither";
    }
    public boolean isIp6(String queryIP){
        String[] add = queryIP.split(":");
        System.out.println(Arrays.toString(add));
        Set<Character> validChar = Set.of('1','2','3','4','5','6','7','8','9','0','a','b','c','d','e','f','A','B','C','D','E','F');
        if (add.length != 8)
           return false;
        for (String sub : add){
            if (sub.isEmpty())
                return false;
              if (sub.length() > 4)
                 return false;
                int len = sub.length();
              for (int i = 0; i < len; i++){
                if (!validChar.contains(sub.charAt(i)))
                    return false;
              }
        }
        if (queryIP.charAt(0) != ':' && queryIP.charAt(queryIP.length() - 1) != ':')
            return true;
        else return false;
        
    }
    public boolean isIp4 (String add){
        String[] subadd = add.split("[.]");
        if (subadd.length != 4)
           return false;
        for (String part : subadd){
            if (part.isEmpty())
                return false;
            if (part.charAt(0) == '0'){
                if (part.length() > 1)
                     return false;
            }
            int val_add = 0,len = part.length(),pow = (int)Math.pow(10,len - 1);
            if (len > 3)
                return false;
                int i = 0;
            while (pow > 0){
                char c = part.charAt(i);
                if (c < '0' || c > '9')
                   return false;
                val_add += (part.charAt(i)- '0') * pow;
                pow /= 10;
                i += 1;
            }
            if (val_add > 255 || val_add < 0)
               return false;
        }
      if (add.charAt(0) != '.' && add.charAt(add.length() - 1) != '.')
          return true;
     else return false;
    }
}