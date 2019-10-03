package ChallengeSet.Leetcode;

public class NumberOfIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * leetcode 200
	 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
	 * An island is surrounded by water and is formed by connecting adjacent lands horizontally 
	 * or vertically. 
	 * You may assume all four edges of the grid are all surrounded by water.
	 * @param grid
	 * @return
	 */
	 public static int numIslands(char[][] grid) {
         int m = grid.length;
     if(m==0) return 0;
     int n = grid[0].length;
     int res = 0;
     for(int i = 0; i < m; i++){
         for(int j = 0; j < n; j++){
             if(grid[i][j] == '1'){
                 dfs(i,j,grid);
                 res++;
             }
         }
     }
     return res;
}
 public static void dfs(int i, int j, char[][] grid){
     if(i < 0 || j < 0 || i >=grid.length || j>= grid[0].length || grid[i][j] == '0') return;
     grid[i][j] = '0';
     dfs(i,j-1,grid);
     dfs(i+1,j,grid);
     dfs(i-1,j,grid);
     dfs(i,j+1,grid);
     return;
 }
}
