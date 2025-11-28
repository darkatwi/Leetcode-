/*This solution uses recursion...(dfs)

Approach: Recursive DFS
Scan the entire grid cell by cell.
When a '1' (land) is found:
Increment the island count.
Explore the entire island recursively using DFS.
Mark visited cells by changing '1' → '0' to avoid counting the same island multiple times.
Continue scanning until all cells are processed.
Why DFS works:
DFS visits all connected land cells in one island before returning.
Each call to DFS represents a cell that is part of the island.
Returning 1 for the starting cell allows counting exactly one per island

*/

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int numOfIslands = 0;
        // Loop through every cell in the grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // countIslands returns 1 if a new island is found starting at (i,j)
                numOfIslands += countIslands(i, j, grid);
            }
        }
        return numOfIslands;
    }

    private int countIslands(int i, int j, char[][] grid) {
        // Base case: stop if out of bounds or water
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') 
            return 0;

        // Mark current land as visited
        grid[i][j] = '0';
        // Recursively explore all 4 directions
        countIslands(i, j + 1, grid); // right
        countIslands(i, j - 1, grid); // left
        countIslands(i + 1, j, grid); // down
        countIslands(i - 1, j, grid); // up
        // Return 1 because this starting cell contributed to a new island
        return 1;
    }
}
