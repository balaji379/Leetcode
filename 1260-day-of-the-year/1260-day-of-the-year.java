class Solution {

    public  boolean findLeapYear(int year){
      return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public int dayOfYear(String datee) {
        String[] date = datee.split("-");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        boolean leapYear = findLeapYear(year);
        int total_days = 0;
        for (int i = 1; i < month; i++){
           
           if ( i == 4 || i == 6 || i == 9 || i == 11)  
              total_days += 30;
           else if ( i== 2 ) {
             total_days += (leapYear == true ? 29 :28);
           }
           else total_days += 31;
        }

        total_days += day;
        return total_days;
    }
}
