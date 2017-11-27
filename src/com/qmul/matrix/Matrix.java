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
    protected Fraction[][] A;
    protected int r,c;
    
    /**
     * Creates a new matrix from the 2D array
     * @param A 2D array representing the matrix
     */
    public Matrix(Fraction[][] A)
    {
        r = A.length;
        if(r == 0){
            throw new IllegalArgumentException("The array may not be empty!");
        }
        
        c = A[0].length;
        
        this.A = new Fraction[A.length][];
        for(int i = 0; i < A.length; i++){
            if(A[i].length != c){
                throw new IllegalArgumentException("Every array must have the same length!");
            }
            this.A[i] = A[i].clone();
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
        this.A = new Fraction[r][c];
    }
    
    /**
     * Creates a square matrix of the specified size
     * @param s Size
     */
    public Matrix(int s)
    {
        this(s,s);
    }
    
    /**
     * Creates an identity matrix of size s
     * @param s The size of the matrix
     * @return Identity matrix of size s
     */
    public static Matrix identity(int s){
        Fraction[][] A = new Fraction[s][s];
        for(int i = 0; i < s; i++)
        {
            A[i][i] = new Fraction(1,1);
        }
        return new Matrix(A);
    }
    
    /**
     * Gets the value at a certain position in the matrix
     * @param x Row
     * @param y Column
     * @return The value at row x and column y in the matrix
     */
    public Fraction get(int x, int y){
        
        return new Fraction(A[x][y]);
    }
    
    /**
     *
     * @return Number of rows
     */
    public int getRows()
    {
        return r;
    }
    
    /**
     *
     * @return Number of columns
     */
    public int getColumns()
    {
        return c;
    }
    
    /**
     * @param i row to return
     * @return A selected row
     */
    private Fraction[] getRow(int i)
    {
        Fraction[] newRow = new Fraction[c];
        for(int j=0;j<c;j++)
        {
            newRow[j] = A[i][j];
        }
        return newRow;
    }
    
    /**
     * @return 2D integer array of the matrix
     */
    private Fraction[][] getArray()
    {
        Fraction[][] newMatrix = new Fraction[r][c];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                newMatrix[i][j] = this.get(i, j);
            }
        }
        return newMatrix;
    }
    /**
     * 
     * @return The transpose of the given matrix
     */
    public Matrix transpose()
    {
        Fraction[][] transp = new Fraction[getColumns()][getRows()];
        for(int i = 0;i<getRows();i++)
        {
            for(int j=0;j<getColumns();j++)
            {
                transp[j][i] = get(i,j);
            }
        }
        return (new Matrix(transp));
    }
    
    @Override
    public String toString()
    {
        String s = "";
        for(Fraction[] B: A)
        {
            s += "[";
            for(Fraction C:B)
            {
                s += C.toString() + " ";
            }
            s += "]\n";
        }
        return s;
    }
    /**
     * Adds two matrices of the same size
     * @param matrix The matrix to be added
     * @return The sum of this and the specified matrix
     */
    public Matrix add(Matrix matrix)
    {
        if(matrix.getRows() == getRows() && matrix.getColumns() == getColumns())
        {
            Fraction[][] sum = new Fraction[getRows()][getColumns()];
            for(int i = 0; i < getRows(); i++)
                for(int j = 0; j < getColumns(); j++)
                    sum[i][j] = get(i,j).add(matrix.get(i, j));
            return new Matrix(sum);
        }else
        {
            throw new IllegalArgumentException("Matrices must be of the same size!");
        }
    }
    
    /**
     * Subtracts two matrices of the same size
     * @param matrix The matrix to be subtracted
     * @return The difference of this and the specified matrix
     */
    public Matrix sub(Matrix matrix)
    {
        if(matrix.getRows() == getRows() && matrix.getColumns() == getColumns())
        {
            Fraction[][] sum = new Fraction[getRows()][getColumns()];
            for(int i = 0; i < getRows(); i++)
                for(int j = 0; j < getRows(); j++)
                    sum[i][j] = get(i,j).subtract(matrix.get(i, j));
            return new Matrix(sum);
        }else
        {
            throw new IllegalArgumentException("Matrices must be of the same size!");
        }
    }
    
    /**
     * Elementary operation : Row swap
     * @param rowA The row to swap
     * @param rowB The row to swap
     * @return Matrix with rows swapped
     */
    public Matrix swap(int rowA, int rowB)
    {
        Fraction[][] newMatrix = getArray();
        newMatrix[rowA] = getRow(rowB);
        newMatrix[rowB] = getRow(rowA);
        return new Matrix(newMatrix);
    }
    
    /**
     * 
     * @param rowA Row to add to
     * @param rowB Row to add from
     * @param scale scalar of rowB
     * @return Matrix with rowA modified
     */
    public Matrix addRow(int rowA, int rowB, Fraction scale)
    {
        Fraction[] scaledRow = scalar(getRow(rowB),scale);
        Fraction[][] newMatrix = getArray();
        
        for(int i=0;i<c;i++)
        {
            newMatrix[rowA][i] = newMatrix[rowA][i].add(scaledRow[i]);
        }
        return new Matrix(newMatrix);
        
    }
    
    /**
     * 
     * @param rowA row to scale
     * @param scale scale factor
     * @return matrix with rowA modified
     */
    public Matrix scaleRow(int rowA, Fraction scale)
    {
        Fraction[][] newMatrix = getArray();
        newMatrix[rowA] = scalar(newMatrix[rowA],scale);
        return new Matrix(newMatrix);
    }
    
    /**
     * 
     * @param row Fraction[] to scale up
     * @param scale scale factor
     * @return Fraction[] with all fractions scaled
     */
    public Fraction[] scalar(Fraction[] row, Fraction scale)
    {
        Fraction[] newRow = new Fraction[row.length];
        for(int i=0;i<row.length;i++)
        {
           newRow[i] = row[i].multiply(scale); 
        }
        return newRow;
    }
    
    
    public Matrix inverse(){
        
        return this; //todo
    }
    
    public Fraction determinant(){
        return new Fraction(); //todo
    }
    
    public Matrix scalarMult(int scalar){
        return this;
    }
}
