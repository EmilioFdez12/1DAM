package prog.unidad07.ejercicio01;

public class Triangulo extends Figura {
    private Punto punto1;
    private Punto punto2;
    private Punto punto3;

    public Triangulo(Punto punto1, Punto punto2, Punto punto3) {
        this.punto1 = punto1;
        this.punto2 = punto2;
        this.punto3 = punto3;
    }

    @Override
    public double getArea() {
        // Calculamos el área utilizando la fórmula de Herón
        double lado1 = punto1.calcDist(punto2);
        double lado2 = punto2.calcDist(punto3);
        double lado3 = punto3.calcDist(punto1);
        // Semiperímetro
        double s = (lado1 + lado2 + lado3) / 2; 
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }

    @Override
    public double getPerimetro() {
        // Calculamos el perímetro sumando las distancias entre los puntos
        return punto1.calcDist(punto2) + punto2.calcDist(punto3) + punto3.calcDist(punto1);
    }

    @Override
    public boolean isRegular() {
        // Verificamos si todos los lados son iguales
        double lado1 = punto1.calcDist(punto2);
        double lado2 = punto2.calcDist(punto3);
        double lado3 = punto3.calcDist(punto1);
        return lado1 == lado2 && lado2 == lado3;
    }
}
