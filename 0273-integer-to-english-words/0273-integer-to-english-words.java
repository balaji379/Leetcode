class Solution {
    public static final String[] tens = {"","Ten","Twenty" ,"Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    public static final  String hundereds = "Hundred";
    public static final String thousands = "Thousand";
    public static final String[] gtenl20 = {"","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    public static final String[] ones = {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    public static final String billions = "Billion";
    public static final String millions = "Million";

    public String numberToWords(int num) {
        return findNumberToWord(num).trim();
    }
    public  String  findNumberToWord(int num){

        if (num >= 11 && num <= 19){
            return gtenl20[num % 10];
        }

        if (num <= 99 && num >= 10) {
            if (num % 10 == 0)
                return tens[num / 10 ];
            else{
                String answer = tens[num / 10];
                answer += " " +findNumberToWord(num % 10);
                return  answer;
            }
        }

        if (num < 10)
            return ones[num];

        int one = num % 10;
        int ten = (num % 100) / 10;
        int hundered = (num % 1000) / 100;
        int thousand = (num % 1000000) / 1000;
        int million = (num % 1000000000) / 1000000;
        int billion = (num / 1000000000);
        String answer = "";
        if (billion != 0)
            answer = ones[billion] +" " +billions;

        if (million != 0)
             answer += (" " + findNumberToWord(million)) + " "+millions;

        if (thousand != 0)
             answer += (" " + findNumberToWord(thousand)) + " " + thousands;

        if (hundered != 0)
             answer += (" " + findNumberToWord(hundered) +" "+ hundereds);

if (ten != 0){
            if (ten == 1 && one >= 1 && one <= 9) {
                answer += (" ") + gtenl20[one];
                ten = 0;
                one = 0;
            } else
                answer += (" " + tens[ten]);
    }

        if (one != 0){
            answer += (" ") + ones[one] ;
        }
return answer.trim();
    }
}