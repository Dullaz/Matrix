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
    public Matrix2x2(Fraction[][] A){
        super(A);
        if(A.length != 2 || A[0].length != 2){
            throw new IllegalArgumentException("Every 2x2 matrix must have 2 rows and 2 columns");
        }
    }
    
    @Override
    public Fraction determinant(){
        Fraction det;
        det = this.get(0,0).multiply(this.get(1,1)).subtract(this.get(0,1).multiply(this.get(1,0)));
        return det.invert();
    }
    
    @Override
    public Matrix2x2 inverse(){
        Fraction[][] invertedMatrix = new Fraction[2][2];
        Fraction det = this.determinant();
        if(det.intValue()!=0){
            invertedMatrix[0][0] = det.multiply(this.get(1, 1));
            invertedMatrix[0][1] = det.multiply(this.get(0,1)).negate();
            invertedMatrix[1][0] = det.multiply(this.get(1,0));
            invertedMatrix[1][1] = det.multiply(this.get(0,0)).negate();
        }
        else{
            throw new ArithmeticException("Inverse cant be calculated if the determinant is 0");
        }
        return new Matrix2x2(invertedMatrix);
    }
}
