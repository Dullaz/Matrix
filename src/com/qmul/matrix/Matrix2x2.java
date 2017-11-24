/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qmul.matrix;

/**
 *
 * @author Bavan
 */
public class Matrix2x2 extends Matrix{
    
    public Matrix2x2(){
        super(2);
    }
    public Matrix2x2(int[][] A){
        super(A);
        if(A.length != 2 || A[0].length != 2){
            throw new IllegalArgumentException("Every 2x2 matrix must have 2 rows and 2 columns");
        }
    }
    
    
}
