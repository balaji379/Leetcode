class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
 LinkedList<Integer>l=new LinkedList<>();
    int right,mid,left,i=0;
    while(i<nums1.length){
        l.add(nums1[i]);
        i++;
    }i=0;
    while(i<nums2.length){
        l.add(nums2[i]);
        i++;
    }
    int len=l.size();
    Collections.sort(l);
    
    left=0;right=l.size()-1;mid=0;
    if(l.isEmpty())
    return 0;
    if(l.size()%2==0){
        mid=(left+right)/2;
        double answer=((double)l.get(mid)+((double)l.get(mid+1)));
        answer=answer/2;
        return answer;
    }
    else{
        mid=(left+right)/2;
    double answer=(double)l.get(mid);
    return answer;
    }
    
    }
    }