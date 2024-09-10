class Solution {
    public boolean isLongPressedName(String name, String value) {
        
       char[] namearr = name.toCharArray();
        char[] valuearr = value.toCharArray();
        if(namearr.length>valuearr.length)
            return false;
        int indexN = 0, indexV = 0;
        char top = ' ';
        while (indexN < namearr.length && indexV < valuearr.length) {
            if (namearr[indexN] == valuearr[indexV]) {
                top = namearr[indexN];
                indexN += 1;
                indexV += 1;
            } else {
                if (top == valuearr[indexV]) {
                    indexV += 1;
                } else
                    return false;
            }
        }
        if(indexN<namearr.length) 
         return false;
        if (indexV < valuearr.length) {
            while (indexV < valuearr.length)
                if (valuearr[indexV++] != top)
                    return false;
        }
        return true;
    }
}