/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knpoenonogram;

/**
 *
 * @author Keira
 */

import java.io.File;

import java.util.Scanner;
public class KnpoeNonogram {


    public static void main(String[] args) 
    {
       File picrossFile = new File("picross.txt");
       int rows;
       int cols;
       char[][] solution;
       int[] rowCount;
       int[] colCount;
       
       
       String line;

       System.out.println("Let's see what today's contestant thought of today's puzzle!");
       
       try
       {
           Scanner piCrossData = new Scanner(picrossFile);
           rows = piCrossData.nextInt();
           cols = piCrossData.nextInt();
           rowCount = new int[rows];
           colCount = new int[cols];
           solution = new char[rows][cols];
           for(int i = 0; i < cols; i++)
           {
               colCount[i] = piCrossData.nextInt();
           }
           int i = 0;
           while(piCrossData.hasNext())
           {
               rowCount[i] = piCrossData.nextInt();
               line = piCrossData.nextLine();
               int j = 0;
               int k = 0;
               while(j < line.length())
               {
                   if(line.charAt(j) == '_' || line.charAt(j) == '*')
                   {
                       solution[i][k] = line.charAt(j);
                       k++;
                   }
                   j++;
               }
               
               i++;
           }
           carryOn(rows, cols, rowCount, colCount, solution);
 
       }//end try
       catch(Exception ex)
       {
           System.out.println("Error reading file '" + picrossFile + "'.\n");
           System.out.print(ex);           
       }
       
       
    }//end main
    
    public static void carryOn(int rows, int cols, int[] rowCount, int[] colCount, 
                           char [][]solution)
    {
        System.out.println("Column rules");
        printIntArray(colCount,cols);
        System.out.println("Row rules");
        printIntArray(rowCount, rows);
        System.out.println("\nTheir entry? \n");
        printCharArray(solution, rows, cols); 
        System.out.println("\nLet's see how they did!");
        
        
    }
    
    
    public static void printIntArray(int[] toPrint, int max)
    {
        String printMe = "";
        for(int i = 0; i < max; i++)
        {
            printMe += toPrint[i] + " ";
        }
        System.out.println(printMe);
    }
    
    public static void printCharArray(char[][] toPrint, int rows, int cols)
    {
        String printMe = "";
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                printMe += toPrint[i][j] + " ";
            }
            printMe += "\n";
        }
        System.out.println(printMe);
    }

    
}
