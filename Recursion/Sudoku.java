
/**
 * ICS4U (Recursion Set)
 * Recursive program to generate sudokus and solve them
 * 
 *  
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Sudoku
{
	//variable for the sudoku grid
    private int[][] grid = new int[9][9];
    private boolean showOutput = false;
    
    //default constructor
    public Sudoku()
    {
    }
    
    //constructor with parameter for predefined sudoku grid
    public Sudoku(int[][] puzzle)
    {
        this.grid = puzzle;
    }

    public static void main(String[] args)
    {
    	Scanner sc = new Scanner(System.in);
    	//sample sudoku puzzle grid
    	int[][] sample = { 
		{ 2, 0, 8, 1, 3, 0, 4, 9, 0 },
		{ 0, 0, 7, 0, 0, 0, 6, 0, 8 }, 
		{ 0, 0, 4, 8, 0, 0, 0, 0, 3 },
		{ 4, 0, 0, 0, 0, 0, 1, 0, 0 }, 
		{ 3, 0, 0, 2, 0, 0, 0, 0, 0 },
		{ 0, 0, 0, 9, 1, 0, 0, 8, 0 }, 
		{ 5, 7, 0, 0, 9, 0, 0, 0, 0 },
		{ 0, 0, 6, 0, 0, 5, 0, 0, 0 }, 
		{ 9, 0, 0, 6, 0, 0, 5, 0, 0 } };
    	
    	//creating new object
        Sudoku s = new Sudoku();
        
        int input;
        do{
        	
        	System.out.println("1 - Load Sample Puzzle");
        	System.out.println("2 - Generate Random Puzzle");
        	System.out.println("3 - Solve Puzzle");
        	System.out.println("0 - Quit");
        	input = sc.nextInt();
        	if(input == 1)
        	{
        		s.showOutput=false;
            	s.grid = sample;
        		System.out.println(s.toString());
        	}else if(input == 2)
        	{
        		s.showOutput=false;
            	s.generate();
        		System.out.println(s.toString());
        	}else if(input == 3)
        	{
        		s.showOutput=true;
            	s.solve(0, 0);
        	}
        }while(input != 0);
        
        
        
        //output initial sudoku grid
        //System.out.println(s.toString());
        //solve sudoku grid with call to recursive solve(int, int) method
        //s.solve(0, 0);
        //output solved sudoku grid
        //System.out.println(s.toString());
    }
    
    //generate random puzzle
    private void generate()
    {
    	//set to empty grid and solve
    	grid = new int[9][9];
		solve(0, 0);
		
		//randomly shuffle indexes
		List<Integer> indexes = new ArrayList<Integer>();
		for(int i = 0; i < 81; i++)
		{
			indexes.add(i);
		}
		Collections.shuffle(indexes);
		
		//remove first 60 random indexes (leave 21 numbers)
		for(int i = 0; i < 60; i++)
		{
			int index = indexes.get(i);
			grid[index / 9][index % 9] = 0;
		}
    }
        
    //***************RECURSIVE METHOD************************
    //determines a valid value for the position at grid[row][col]
    private boolean solve(int row, int col)
    {
    	if(showOutput) {System.out.println(this.toString());try {Thread.sleep(50);} catch (Exception e) {}}
    	
    	//base case; exit if past the last row
        if(row == 9)
        {
            return true;
        }
        
        //if this grid is already occupied
        if(grid[row][col] != 0)
        {
            //solve for next grid position
            //NOTE RECURSIVE CALL
            //exits recursive method if solved
            if(solve(col == 8 ? (row + 1) : row, (col + 1) % 9))
            {
                return true;
            }
        }else
        {
        	//Create array of numbers 1-9 in random order
            Integer[] nums = randomNine();
            //Loop through and check each number to see if it is a valid solution in that position
            for(int i = 0; i < 9; i++)
            {
            	//if it is valid
                if(!invalid3x3Square(row, col, nums[i]) && !invalidRowOrCol(row, col, nums[i]))
                {
                	//set that position to the valid value
                	grid[row][col] = nums[i];
                    //solve for next grid position
                    //NOTE RECURSIVE CALL
                    //exit recursive method if solved
                	if(solve(col == 8 ? (row + 1) : row, (col + 1) % 9))
                	{
                		return true;
                	}else
                	{
                		//set to 0 when backtracking
                		grid[row][col] = 0;
                	}
                }                
            }
        }
        
        return false;
    }
    
    //checks to see if the value in the position of grid[row][col] would be valid
    private boolean invalid3x3Square(int row, int col, int value)
    {
    	//find topleft corner
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        //loop through entire 3x3 square
        for(int i = startRow; i < startRow + 3; i++)
        {
            for(int j = startCol; j < startCol + 3; j++)
            {
                if(!(row == i && col == j))
                {
                	//if the value was already used, then return true
                    if(grid[i][j] == value)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
 
    //checks to see if the value in the position of grid[row][col] would be valid
    private boolean invalidRowOrCol(int row, int col, int value)
    {
    	//loop through 1-9
        for(int i = 0; i < 9; i++)
        {
            if(i != col)
            {
            	//if the value is contained in the rest of that column, return true
                if(grid[row][i] == value)
                {
                    return true;
                }
            }
            if(i != row)
            {
            	//if the value is contained in the rest of that column, return true
                if(grid[i][col] == value)
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    //generates an array of 9 random Integer from 1-9 no duplicates
    private Integer[] randomNine()
    {
    	//ArrayList
        List<Integer> nums = new ArrayList<Integer>();
        for(int i = 0; i < 9; i++)
        {
            nums.add(i + 1);
        }
        //Library shuffle method
        Collections.shuffle(nums);
        //return an array of 9 Integer
        return nums.toArray(new Integer[9]);
    }
    
    //toString() method, overrides toString() method inherited from Object class
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        //loop through all indexes in grid
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
            	//appends to string
                sb.append(grid[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        //StringBuilder to String, replacing the 0s, and returning the String
        String s = sb.toString();
        return s.replace("0", "_");
    }
    
}
