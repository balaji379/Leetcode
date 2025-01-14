/**
 * @param {number[]} A
 * @param {number[]} B
 * @return {number[]}
 */
var findThePrefixCommonArray = function(A, B) {
    return findThePrefixCommonArrays(A,B);
};
function findThePrefixCommonArrays(a, b) {
  const map1 = new Map();
  const map2 = new Map();
  var count = 0;
  return a.map((val, index) => {
    map1.set(a[index], 1);
    map2.set(b[index], 1);
    if (map1.has(b[index]) && map2.has(a[index])) {
      if (a[index] === b[index]) count += 1;
      else count += 2;
      return count;
    } else if (map1.has(b[index])) {
      count += 1;
      return count;
    } else if (map2.has(a[index])) {
      count += 1;
      return count;
    } else return count;
  });
}