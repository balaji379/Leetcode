class Solution {
    public List<String> restoreIpAddresses(String s) {

   List<String> answer = new ArrayList<>();
   if (s.length() > 12)
      return answer;
        formValidIP(0, 0, "", s,s.length() , answer);
        return answer;
    }

    public static void formValidIP(int count, int index, String temp, String s, int len, List<String> answer) {
        if (count == 3 || index == len) {
            if ((temp.length() - (len + 3)) == 0)
                answer.add(temp);
            return;
        }
        String str1 = s.substring(index, index + 1);
        int istr1 = Integer.parseInt(str1);
        formValidIP(temp.isEmpty() ? 0 : count + 1, index + 1, temp.isEmpty() ? str1 : temp + "." + str1, s, len, answer);
        if (istr1 != 0 && index  < len - 1) {
            str1 = s.substring(index, index + 2);
            formValidIP(temp.isEmpty() ? 0 : count + 1, index + 2, temp.isEmpty() ? str1 : temp + "." + str1, s, len, answer);
        }
        if (istr1 != 0 && index < len - 2) {
            str1 = s.substring(index, index + 3);
            istr1 = Integer.parseInt(str1);
            if (istr1 <= 255) {
                formValidIP(temp.isEmpty() ? 0 : count + 1, index + 3, temp.isEmpty() ? str1 : temp + "." + str1, s, len, answer);
            }
        }
    }
}