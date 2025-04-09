class Solution {
     public int findMaximumXOR(int... nums) {
        Node root = new Node();
        List<String> list = new ArrayList<>();
        for (int val : nums) {
            String s = Integer.toBinaryString(val);
            String app = "0".repeat(32 - s.length());
            s = app + s;
            list.add(s);
            root.insert(s, root);
        }
        int max = 0;
        for (String s : list) {
            String res = root.findX(s, root);
            if (!res.isEmpty()) {
                int first = Integer.parseInt(s, 2);
                int second = Integer.parseInt(res, 2);
                max = Math.max(first ^ second, max);
            }
        }
        return max;
    }
}

class Node {
    Node[] links = new Node[2];
    boolean flag = false;

    public boolean containsNode(char c) {
        return links[c - '0'] != null;
    }

    public void setEnd() {
        flag = true;
    }

    public boolean isEnd() {
        return flag;
    }

    public void put(char c) {
        links[c - '0'] = new Node();
    }

    public Node nextNode(char c) {
        return links[c - '0'];
    }

    public void insert(String s, Node node) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (!node.containsNode(c))
                node.put(c);
            node = node.nextNode(c);
        }
        node.setEnd();
    }
    public String findX(String s, Node node) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            char c = s.charAt(i);
            char opos = (c == '0' ? '1' : '0');
            if (node.containsNode(opos)) {
                node = node.nextNode(opos);
                sb.append(opos);
            } else {
              if (node.containsNode('0')){
                  sb.append('0');
                  node = node.nextNode('0');
              }else if (node.containsNode('1')){
                  sb.append('1');
                  node = node.nextNode('1');
              }
            }
            }
            return sb.toString();
        }
}