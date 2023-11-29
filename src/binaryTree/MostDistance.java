package binaryTree;



public class MostDistance {
    public static class Info{
        public int maxDistance;
        public int height;
        public Info(int dis, int h){
            maxDistance = dis;
            height = h;
        }
    }
    //最大距离 
    public static Info process(Node X){
        if(X == null){
            return new Info(0, 0);
        }
        Info leftInfo = process(X.left);
        Info rightInfo = process(X.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int maxDistance = Math.max(Math.max(leftInfo.maxDistance, rightInfo.maxDistance), leftInfo.height + rightInfo.height + 1);
        return new Info(maxDistance, height);
    }
}
