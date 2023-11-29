public class Tries {
    private static class Node1 {
        public int pass;
        public int end;
        public Node1[] nexts;

        public Node1() {
            pass = 0;
            end = 0;
            nexts = new Node1[26];
        }
    }

    public static class Tries1 {
        private Node1 root;

        public Tries1() {
            root = new Node1();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] str = word.toCharArray();
            Node1 node = root;
            node.pass++;
            int index = 0;
            for (int i = 0; i < str.length; i++) {
                index = str[i] - 'a';
                if (node.nexts[index] == null) {
                    node.nexts[index] = new Node1();
                }
                node = node.nexts[index];
                node.pass++;
            }
            node.end++;
        }

        public int prefixNumber(String pre) {
            if (pre == null)
                return 0;
            char[] str = pre.toCharArray();
            Node1 node = root;
            int index = 0;
            for (int i = 0; i < str.length; i++) {
                index = str[i] - 'a';
                if (node.nexts[index] == null)
                    return 0;
                node = node.nexts[index];
            }
            return node.pass;
        }

        public int search(String str) {
            if (str == null)
                return 0;
            char[] chs = str.toCharArray();
            Node1 node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null)
                    return 0;
                node = node.nexts[index];
            }
            return node.end;
        }

        public void delete(String word) {
            if (search(word) != 0){
                char[] chs = word.toCharArray();
                Node1 node = root;
                node.pass--;
                int index=0;
                for(int i = 0; i < chs.length; i++){
                    index = chs[i]-'a';
                    if(--node.nexts[index].pass == 0) {
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
               
        }
    }

}