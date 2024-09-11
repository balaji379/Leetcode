/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int count = 0;
        int[][] mat = new int[m][n];

        int i = 0, j = 0, inc = m - 1, idec = 1, jinc = n - 1, jdec = 0;
        boolean incflag = false, idecflag = false, jdecflag = false, jincflag = true;
        while (count < m * n) {
            int val = -1;
            if (head != null ) {
                val = head.val;
                head = head.next;
            }
            mat[i][j] = val;
            count += 1;
            if (jincflag) {
                j += 1;
                if (j > jinc) {
                    jincflag = false;
                    incflag = true;
                    i += 1;
                    j -= 1;
                    jinc -= 1;
                }
            } else if (incflag) {
                i += 1;
                if (i > inc) {
                    jdecflag = true;
                    incflag = false;
                    j -= 1;
                    i -= 1;
                    inc -= 1;
                }
            } else if (jdecflag) {
                j -= 1;
                if (j < jdec) {
                    idecflag = true;
                    jdecflag = false;
                    j = jdec;
                    i -= 1;
                    jdec += 1;
                }
            } else if (idecflag) {
                i -= 1;
                if (i < idec) {
                    jincflag = true;
                    idecflag = false;
                    i = idec;
                    j += 1;
                    idec += 1;
                }
            }
        }
          return mat;
    }
  
    }
