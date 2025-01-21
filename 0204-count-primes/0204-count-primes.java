class Solution {
    public int countPrimes(int n) {
        
        return countPrime(n);
    }
    public int countPrime(int n)
    {
        if(n==0 || n==1 || n==2)
        {
            return 0;
        }
        n = n-1;
        int count = n-1;
        boolean[] isPrime = new boolean[n+1]; 
        Arrays.fill(isPrime,true);
        isPrime[0] = false; 
        isPrime[1] = false; 
        int i,j;
        for(i=2 ; i<=Math.sqrt(n); i++)
        {
            if(isPrime[i]==true)
            {
               for(j=i*i ; j<=n ; j = j+i)
               {
                if(isPrime[j]==true)
                {
                   isPrime[j] = false; 
                   count--;
                }
               }
            }
        }  
        return count;

    }
}