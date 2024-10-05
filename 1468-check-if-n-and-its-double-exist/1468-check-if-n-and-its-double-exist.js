/**
 * @param {number[]} arr
 * @return {boolean}
 */
var checkIfExist = function(arr) {
    const seen =  new Map();
    arr.forEach((num,index)=> seen.set(num , index));
    var answer = false;
    arr.forEach((num,index)=> {
        if(seen.has(arr[index] * 2) && seen.get(arr[index] * 2) != index)
                answer = true;
    });
    return answer;
}