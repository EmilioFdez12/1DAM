
public class Actividad203A {
		
	public static void main(String[] args) {
			
			CuentaCorriente cuenta1 = new CuentaCorriente("11111");
			cuenta1.ingresar(1000);
			
			System.out.println("Su saldo es de " + cuenta1.getSaldo() + "€");
			
			
			cuenta1.retirar(900);
			System.out.println("Su saldo es de " + cuenta1.getSaldo() + "€");
			
			
			cuenta1.ingresar(350);
			System.out.println("Su saldo es de " + cuenta1.getSaldo() + "€");

	}

}
