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
    public Matrix(int r, int c)
    {
        this.r = r;
        this.c = c;
        this.A = new int[r][c];
    }
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
}
