package com.qmul.matrix;

/**
 *
 * @author Abdullah Hasan
 */
public class Fraction extends Number{
    private int d,n;
    
    
    public Fraction()
    {
        this.n = 0;
        this.d = 1;
        
    }
    
    public Fraction(Fraction A)
    {
        this.n = A.n;
        this.d = A.d;
    }
    
    public Fraction(int n, int d)
    {
        if(d == 0)
            throw new IllegalArgumentException("Denominator can't be zero");
        this.d = d;
        this.n = n;
    }
    
    public Fraction(String s)
    {
        String[] in = s.split("/");
        if(in.length != 3) throw new IllegalArgumentException("Invalid fraction string");
        int a, b;
        a = Integer.parseInt(in[2]);
        b = Integer.parseInt(in[0]);
        if(a == 0) throw new IllegalArgumentException("Denominator can't be zero");
        this.d = a;
        this.n = b;
    }
    
    /**
     * Add fraction
     * @param A Fraction to add
     * @return Fraction result of addition
     */
    public Fraction add(Fraction A)
    {
        int a = A.getDeno();
        int b = A.getNumer();
        return simplify(new Fraction((a * d),(a*n + d*b)));
    }
    
    /**
     * Subtracts fraction
     * @param A Fraction to subtract
     * @return Fraction result of subtraction
     */
    public Fraction subtract(Fraction A)
    {
        int a = A.getDeno();
        int b = A.getNumer();
        return simplify(new Fraction((a * d),(a*n - d*b)));
    }
    
    /**
     * Multiply fractions
     * @param A Fraction to multiply
     * @return Fraction result
     */
    public Fraction multiply(Fraction A)
    {
        int a = A.getDeno();
        int b = A.getNumer();
        return simplify(new Fraction(a*d,b*n));
    }
    
    /**
     * Divides by Fraction
     * @param A Fraction to divide by
     * @return Fraction result of division
     */
    public Fraction divide(Fraction A)
    {
        int a = A.getDeno();
        int b = A.getNumer();
        return simplify(new Fraction(a*n,b*d));
    }
    
    
    /**
     * Simplifies a fraction
     * @param A Fraction to simplify
     * @return Simplified Fraction
     */
    public Fraction simplify(Fraction A)
    {
        int a = A.getDeno();
        int b = A.getNumer();
        int gcd = GCD(a,b);
        return new Fraction((a/gcd),(b/gcd));
    }
    
    public Fraction invert()
    {
        return new Fraction(this.d,this.n);
    }
    
    public Fraction negate()
    {
        return new Fraction(-this.n,this.d);
    }
    /**
     * Finds greatest common divisor of two integers using Euclidean algorithm
     * @param a first integer 
     * @param b second integer
     * @return integer that is GCD of both arguments
     */
    private int GCD(int a, int b)
    {
        if(b == 0) return a;
        return GCD(b, a%b);
    }
    
    /**
     * Converts fraction to string representation
     * 
     * @return String
     */
    @Override
    public String toString()
    {
        return Integer.toString(this.n) + "/" + Integer.toString(this.d);
    }
    

    /**
     * Compares two fractions
     * @param A Fraction to compare to
     * @return integer. -1 if argument is larger, 0 if the same, 1 if argument is smaller
     */
    public int compareTo(Fraction A) {
        int f = this.d * A.getNumer();
        int s = this.n * A.getDeno();
        if(f < s) return 1;
        else if(f > s) return -1;
        else return 0;
    }
    
    /**
     * Gets denominator
     * @return int
     */
    public int getDeno()
    {
        return d;
    }
    
    /**
     * gets numerator
     * @return int
     */
    public int getNumer()
    {
        return n;
    }

    @Override
    public int intValue() {
        return n/d;
    }

    @Override
    public long longValue() {
        return n/d;
    }

    @Override
    public float floatValue() {
      return n/d;
    }

    @Override
    public double doubleValue() {
      return n/d;
    }
    
    
}
