class Complex{
  
private double re;
    private double im;

    final private static Complex I = new Complex(0.0, 1.0);
    final private static Complex ZERO = new Complex(0.0, 0.0);
    final private static Complex ONE = new Complex(1.0, 0.0);

    public Complex() {
        re = 0.0;
        im = 0.0;
    }

    public Complex(double Re, double Im) {
        re = Re;
        im = Im;
    }

    public Complex(double Re) {
        re = Re;
        im = 0.0;
    }

    public String toString() {
        if (re == 0.0 && im != 0)
            return (signOfB() + im + "i");
        if (im == 0.0 && re != 0)
            return (re + "");
        if (re == 0 && im == 0)
            return (re + "");
        return (re + signOfB() + Math.abs(im) + "i");
    }

    public String signOfB() {
        if (im < 0)
            return " - ";
        if (im >= 0 && re == 0)
            return "";
        return " + ";
    }

    public double getRe() {
        return re;
    }

    public void setRe(double Re) {
        re = Re;
    }

    public double getIm() {
        return im;
    }

    public void setIm(double Im) {
        im = Im;
    }

    public static Complex add(Complex c1, Complex c2) {
        return (new Complex(c1.re + c2.re, c1.im + c2.im));
    }

    public static Complex subtract(Complex c1, Complex c2) {
        return (new Complex(c1.re - c2.re, c1.im - c2.im));
    }

    public static Complex multiply(Complex c1, Complex c2) {
        return (new Complex(c1.re * c2.re - c1.im * c2.im,
                c1.im * c2.re + c1.re * c2.im));
    }

    public static Complex multiply(Complex c, double x) {
        return (new Complex(c.re * x, c.im * x));
    }

    public static Complex divide(Complex c1, Complex c2) {
        Complex tmp = new Complex(c1.re * c2.re + c1.im * c2.im,
                c1.im * c2.re - c1.re * c2.im);
        return (multiply(tmp, 1 / (Math.pow(c2.re, 2) + Math.pow(c2.im, 2))));
    } 

    public double mod() {
        return (Math.sqrt(Math.pow(re, 2) + Math.pow(im, 2)));
    }

    public static Complex sqrt(double re) {
        Complex c = new Complex(re);

        double phi;
        if (c.re < 0) {
            phi = Math.PI - Math.atan(c.im / Math.abs(c.re));
        } else {
            phi = Math.atan(c.im / c.re);
        }

        Complex cSqrt = new Complex();
        cSqrt.re = Math.sqrt(c.mod()) * Math.cos((phi + 2.0 * Math.PI * 0) / 2.0);
        cSqrt.im = Math.sqrt(c.mod()) * Math.sin((phi + 2.0 * Math.PI * 0) / 2.0);

        double eps = 1e-15;
        if (cSqrt.re < eps)
            cSqrt.re = 0;
        if (cSqrt.im < eps)
            cSqrt.im = 0;

        return cSqrt;
    }

    public Boolean equals(Complex c) {
        return (getRe() == c.re && getIm() == c.im);
    }

    public boolean equals(Object o) {
        return false;
    }

    public void conjugate() {
        im *= -1;
    }

    public void opposite() {
        setIm(im * -1);
        setRe(re * -1);
    }





  public void test() {
        // Wykorzystanie konstruktorów:
        Complex c1 = new Complex(2.5, 13.1);
        Complex c2 = new Complex(-8.5, -0.9);
        System.out.println(c1); // 2.5 + 13.1i
        System.out.println(c2); // -8.5 - 0.9i
        System.out.println(new Complex(4.5)); // 4.5
        System.out.println(new Complex()); // 0.0
        System.out.println(new Complex(0, 5.1)); // 5.1i
        System.out.println();

        // Stałe typu Complex:
        System.out.println(Complex.I); // 1.0i
        System.out.println(Complex.ZERO); // 0.0
        System.out.println(Complex.ONE); // 1.0
        System.out.println();

        // Wykorzystanie metod zwracających wynik obliczeń:
        System.out.println("Re(c1) = " + c1.getRe()); // Re(c1) = 2.5
        System.out.println("Im(c1) = " + c1.getIm()); // Im(c1) = 13.1
        System.out.println("c1 + c2 = " + Complex.add(c1, c2)); // c1 + c2 = -6.0 + 12.2i
        System.out.println("c1 - c2 = " + Complex.subtract(c1, c2)); // c1 - c2 = 11.0 + 14.0i
        System.out.println("c1 * c2 = " + Complex.multiply(c1, c2)); // c1 * c2 = -9.46 - 113.6i
        System.out.println("c1 * 15.1 = " + Complex.multiply(c1, 15.1)); // c1 * 15.1 = 37.75 + 197.81i
        System.out.println("c1 / c2 = " + Complex.divide(c1, c2)); // c1 / c2 = -0.4522310429783739 - 1.4932931836846426i
        System.out.println("|c1| = " + c1.mod()); // |c1| = 13.336416310238668
        System.out.println("sqrt(243.36) = " + Complex.sqrt(243.36)); // sqrt(243.36) = 15.6
        System.out.println("sqrt(-243.36) = " + Complex.sqrt(-243.36)); // sqrt(-243.36) = 15.6i
        Complex c3 = new Complex(2.5, 13.1);
        System.out.println(c1.equals(c2)); // false
        System.out.println(c1.equals(c3)); // true
        // Poniższe wywołanie - dla chętnych :)
        System.out.println(c1.equals("test ze zlym obiektem")); // false
        System.out.println();

        // Metoda zamieniająca liczbę na jej sprzężenie:
        c1.conjugate();
        System.out.println("c1* = " + c1); // c1* = 2.5 - 13.1i

        // Metoda zamieniająca liczbę na przeciwną:
        c1.opposite();
        System.out.println("-c1 = " + c1); // -c1 = -2.5 + 13.1i
    }
}