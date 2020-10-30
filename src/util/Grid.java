package util;

public class Grid
{
    private boolean[][] grid;

    public Grid(int rows, int cols)
    {
        grid = new boolean[rows][cols];
        for (int r = 0; r < rows; r++)
        {
            for (int c =  (int)Math.ceil(Math.random()*5); c < cols; c+= (int)Math.ceil(Math.random()*10))
            {
                grid[r][c] = true;
            }
        }
    }

    public int[][] getCountsGrid()
    {
        int[][] newGrid = new int[grid.length][grid[0].length];
        for (int r = 0; r < grid.length; r++)
        {
            for (int c = 0; c < grid[r].length; c++)
            {
                if (grid[r][c] == true)
                {
                    newGrid[r][c] = 9;
                    if (inBounds(r-1,c) == true)
                    {
                        if (newGrid[r-1][c] <=8) { newGrid[r-1][c]++; }
                    }
                    if (inBounds(r-1,c+1) == true)
                    {
                        if (newGrid[r-1][c+1] <= 8) { newGrid[r-1][c+1]++; }
                    }
                    if (inBounds(r-1,c-1) == true)
                    {
                        if (newGrid[r-1][c-1] <=8) { newGrid[r-1][c-1]++; }
                    }
                    if (inBounds(r,c-1) == true)
                    {
                        if (newGrid[r][c-1] <=8) { newGrid[r][c-1]++; }
                    }
                    if (inBounds(r,c+1) == true)
                    {
                        if (newGrid[r][c+1] <=8) { newGrid[r][c+1]++; }
                    }
                    if (inBounds(r+1,c) == true)
                    {
                        if (newGrid[r+1][c] <=8) { newGrid[r+1][c]++; }
                    }
                    if (inBounds(r+1,c-1) == true)
                    {
                        if (newGrid[r+1][c-1] <=8) { newGrid[r+1][c-1]++; }
                    }
                    if (inBounds(r+1,c+1) == true)
                    {
                        if (newGrid[r+1][c+1] <=8) { newGrid[r+1][c+1]++; }
                    }
                }
            }
        }
        return newGrid;
    }

    private boolean inBounds( int r, int c)
    {
        if (r == -1)
        {
            return false;
        }
        if (c == -1)
        {
            return false;
        }
        if (r >= grid.length || c >= grid[r].length || r < 0 || c < 0)
        {
            return false;
        }
        else
        {
            return true;
        }

    }

    public String toString()
    {
        String output="";
        for (int r = 0; r < grid.length; r++)
        {
            for (int c = 0; c < grid[r].length; c++)
            {
                if (grid[r][c] == true)
                {
                    output += 1 + " " ;
                }
                else
                {
                    output += 0 + " ";
                }
            }
            output += "\n";
        }

        return output.trim();
    }
}
