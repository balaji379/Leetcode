/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var subarraySum = function(nums, k) {
     const map = new Map();
     var count = 0 , sum = 0;
     for( let val of nums ){
            sum += val;
            if( sum == k)
              count += 1;
            if( map.has(sum - k))
               count += map.get( sum - k );
            map.set( sum , ( map.has(sum) == true ? map.get( sum ) : 0 ) + 1 );
     }
     return count;
};