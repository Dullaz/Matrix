/*
 * No Rights Reserved 
 * 
 * 
 */
package com.qmul.matrix;

/**
 *
 * @author Windows 10
 */
public class TestClass {
    public static void main(String[] args)
    {
        Fraction[][] newMatrix = new Fraction[3][3];
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                newMatrix[i][j] = new Fraction(i+1,j+1);
            }
        }
        Matrix matrix = new Matrix(newMatrix);
        System.out.println(matrix.toString());
        /*matrix = matrix.transpose();
        System.out.println(matrix.toString());
        matrix = matrix.add(matrix);
        System.out.println(matrix.toString());
        matrix = matrix.sub(matrix);
        System.out.println(matrix.toString());*/
        //matrix = matrix.scaleRow(1, new Fraction(5,1));
        //System.out.println(matrix.toString());
       // matrix = matrix.swap(0, 1);
        //System.out.println(matrix.toString());
        matrix = matrix.addRow(1, 2, new Fraction(5,1));
        System.out.println(matrix.toString());
    }
}
