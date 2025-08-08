public class Oops{
    public static void main(String[] args){
        
        Complex c1 = new Complex(4,5);
        Complex c2 = new Complex(3,9);

        Complex ans = Complex.add(c1,c2);
        
        System.out.println(ans.real +", " + ans.img);
    }
}

class Complex {
    int real;
    int img;

    public Complex(int r, int i){
        this.real = r;
        this.img = i;
    }

    public static Complex add(Complex a, Complex b){
        return new Complex((a.real + b.real), (a.img + b.img));
    }
}