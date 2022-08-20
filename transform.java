/*
ID: maximus9
LANG: JAVA
TASK: transform
*/


import java.io.*;
import java.util.*;

public class transform{
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("transform.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
    int n = Integer.parseInt(f.readLine());
    String[][] grid = new String[n][n];
    String[][] grid2 = new String[n][n];
    for(int i = 0; i < n; i++){
      grid[i] = f.readLine().split("");
    }
    for(int j = 0; j < n; j++){
      grid2[j] = f.readLine().split("");
    }
    int counter = 1;
    grid = rotateGrid(grid, n);
    while(!check(grid, grid2) && counter < 9){
      grid = rotateGrid(grid, n);
      counter++;
      if(counter == 4 || counter == 8){
        grid = reflectGrid(grid, n);
      }
    }

    if(counter == 6 || counter == 7){
      counter = 5;
    }
    else if(counter == 8){
      counter = 6;
    }
    else if(counter == 9){
      counter = 7;
    }
    out.println(counter);
    out.close();
  }

  public static String[][] rotateGrid(String[][] grid, int n){
    String[][] newGrid = new String[n][n];
    for(int r = 0; r < grid.length; r++){
      for(int c = 0; c < grid[0].length; c++){
        newGrid[c][n-r-1] = grid[r][c];
      }
    }
    return newGrid;
  }

  public static String[][] reflectGrid(String[][] grid, int n){
    String[][] newGrid = new String[n][n];
    for(int r = 0; r < grid.length; r++){
      for(int c = 0; c < grid[0].length; c++){
        newGrid[r][n-c-1] = grid[r][c];
      }
    }
    return newGrid;
  }

  public static boolean check(String[][] grid, String[][] grid2){
    for(int r = 0; r < grid.length; r++){
      for(int c = 0; c < grid[0].length; c++){
        if(!grid[r][c].equals(grid2[r][c]))
          return false;
      }
    }
    return true;
  }

  public static void printGrid(String[][] grid){
    for(String[] row: grid){
      for(String x: row){
        System.out.print(x);
      }
      System.out.println();
    }
  }
}
