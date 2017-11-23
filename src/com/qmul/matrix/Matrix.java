/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qmul.matrix;

/**
 *
 * @author Windows 10
 */
public class Matrix {
    private int[][] A;
    private int r,c;
    
    /**
     * Creates a new matrix from the 2D array
     * @param A 2D array representing the matrix
     */
    public Matrix(int[][] A)
    {
        this.A = A;
        r = A.length;
        c = A[0].length;
        
        for (int[] A1 : A) {
            if (A1 == null) {
                //null
            } else {
                if (A1.length != c) {
                    //wrong length
                }
            }
        }
    }
    
    /**
     * Creates a matrix of the specified size filled with 0s
     * @param r Number of rows
     * @param c Number of columns
     */
    public Matrix(int r, int c)
    {
        this.r = r;
        this.c = c;
        this.A = new int[r][c];
    }
    
    /**
     * Gets the value at a certain position in the matrix
     * @param x Column
     * @param y Row
     * @return The value at (x,y) in the matrix
     */
    public int get(int x, int y){
        return A[x][y];
    }
    
    /**
     * 
     * @return The transpose of the given matrix
     */
    public Matrix transpose()
    {
        int[][] transp = new int[this.c][this.r];
        for(int i = 0;i<c;i++)
        {
            for(int j=0;j<r;j++)
            {
                transp[j][i] = A[i][j];
            }
        }
        return (new Matrix(transp));
    }
    
    /**
     * Adds two matrices of the same size
     * @param matrix The matrix to be added
     * @return The sum of this and the specified matrix
     */
    public Matrix add(Matrix matrix)
    {
        if(matrix.r == r && matrix.c == c)
        {
            int[][] sum = new int[r][c];
            for(int i = 0; i < r; i++)
                for(int j = 0; j < c; j++)
                    sum[i][j] = get(i,j) + matrix.get(i, j);
            return new Matrix(sum);
        }else
        {
            throw new IllegalArgumentException("Matrices must be of the same size!");
        }
    }
}
