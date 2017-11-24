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
    
    @Override
    public int determinant(){
        int det;
        det = this.get(0,0)*this.get(1,1) - this.get(0,1)*this.get(1,0);
        return det;
    }
    
    @Override
    public Matrix2x2 inverse(){
        int[][] invertedMatrix = new int[2][2];
        int det = this.determinant();
        if(det!=0){
            invertedMatrix[0][0] = (1/det)*this.get(1, 1);
            invertedMatrix[0][1] = (1/det)*(-1)*this.get(0,1);
            invertedMatrix[1][0] = (1/det)*(-1)*this.get(1,0);
            invertedMatrix[1][1] = (1/det)*this.get(0,0);
        }
        else{
            throw new ArithmeticException("Inverse cant be calculated if the determinant is 0");
        }
        return new Matrix2x2(invertedMatrix);
    }
}
