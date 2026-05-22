package biblioteca.util;

public class Calculadora {

    public int sumar(int a, int b) {
        return a + b;
    }

    public int sumar(int a, int b, int c) {
        return a + b + c;
    }

    public double sumar(double a, double b) {
        return a + b;
    }

    public int sumar(int... numero) {
        int suma = 0;
        for (int iterable_element : numero) {
                suma += iterable_element;
        }
        return suma;
    }

    public int dividir (int a , int b){
        
        int resultado =0;

        try {
            resultado= a/b;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally{
             System.out.println("Operacion finalizada ");
        }

        
        return resultado;
    }

}
