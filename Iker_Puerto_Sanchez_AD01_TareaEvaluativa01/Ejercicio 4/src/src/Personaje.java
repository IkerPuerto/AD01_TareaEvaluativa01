package src;
import java.io.Serializable;

public class Personaje implements Serializable{
	
	//Variables
	public int id;
	public String DNI;
	public String nombre;
	public String identidadSecreta;
	public String tipo;
	public int peso;
	public int altura;
	
	//Constructor
	public Personaje(int id, String DNI, String nombre, String identidadSecreta, String tipo, int peso, int altura) {
		this.id = id;
		this.DNI = DNI;
		this.nombre = nombre;
		this.identidadSecreta = identidadSecreta;
		this.tipo = tipo;
		this.peso = peso;
		this.altura = altura;
	}
	
	//Metodo para poder visualizar el personaje por pantalla
	@Override
	public String toString() {
		return String.format("%-5d %-12s %-15s %-20s %-10s %-5d %-5d", id, DNI, nombre, identidadSecreta, tipo,  peso, altura);
	} 
}
