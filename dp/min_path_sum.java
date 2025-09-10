public class min_path_sum {
    public static void main(String[] args) {
        int[][] grid={{1,3,1},{1,5,1},{4,2,1}};
        int cr=0;
        int cc=0;
        int[][] dp=new int[grid.length][grid[0].length];

        System.out.println(Minimum_path( grid, cr,cc,dp));
    }
    public static int Minimum_path(int[][] grid,int cr,int cc,int[][] dp){
        if(cr==grid.length-1 && cc==grid[0].length-1){
            return grid[cr][cc];

        }
        if(cc==grid[0].length || cr==grid.length){
            return Integer.MAX_VALUE;
        }
        if(dp[cr][cc]!=-1){
            return dp[cr][cc];
        }

        int d=Minimum_path(grid, cr+1, cc,dp);
        int r=Minimum_path(grid, cr, cc+1,dp);
        return dp[cr][cc]= Math.min(d,r)+grid[cr][cc];
    }
    
}
