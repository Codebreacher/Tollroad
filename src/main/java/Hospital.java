
class Vehicle {
	Vehicle(){
		this(4);
	}

	Vehicle(int i) {
		// TODO Auto-generated constructor stub
		System.out.print(i);
	}

}

 class Car extends Vehicle{
	 int a = 100;
	 
	 void num(int a) {
		 a= a+a;
	 }
	 
	 void printnum() {
		 System.out.println(a);
	 }
	 
	Car(){
		super();
	}
 }
	public class Hospital {
		
		public static void main(String[] args) {
		Car v = new Car();
		
		
		v.printnum();
		
		}
		
	}
	
	
	


/*class Doctor {
 void Doctor_Details() {
  System.out.println("Doctor Details...");
 }
}

class Surgeon extends Doctor {
 void Surgeon_Details() {
  System.out.println("Surgen Detail...");
 }
}

public class Hospital {
 public static void main(String args[]) {
  Doctor d = new Surgeon();
  d.Doctor_Details();
  d.Surgeon_Details();
 }
}*/