package src;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import src.Personaje;

class Ejercicio4 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//Variables
		int contador;
		Scanner escaner = new Scanner(System.in);
		
		//Creamos la ruta de nuestro archivo y el escritor
		File archivo = new File("src" + File.separator + "fichero" + File.separator + "Marvel.dat");
		ObjectOutputStream escritura = new ObjectOutputStream(new FileOutputStream(archivo));
		
		//Datos de los personajes a introducir 
		int [] ids= {1, 2, 3, 4, 5, 6, 7};
		String[] dnis= {"01010101A", "03030303C", "05050505E", "07070707G", "02020202B", "04040404D", "06060606F"};
		String[] noms= {"Spiderman", "Green Goblin", "Storm", "Wolverine", "Mystique", "IronMan", "Mandarin"};
		String[] identidades = {"Peter Parker", "Norman Osborn", "Ororo Munroe","James Howlett", "Raven Darkholme", "Tony Stark", "Zhang Tong"};
		String[] tipos = {"heroe","villano","heroe","heroe","villano","heroe","villano"};
		int[] pesos = {76,84,66,136,78,102,70};
		int[] alturas = {178,183,156,152,177,182,188};
		
		//Guardamos los objetos en el fichero
		for(int i = 0; i < ids.length; i++) {
			Personaje personaje = new Personaje(ids[i], dnis[i], noms[i], identidades[i], tipos[i], pesos[i],alturas[i]);
			escritura.writeObject(personaje);
		}
		System.out.println("Los objetos se han guardado correctamente");
		
		//Pedir DNI y peso nuevo del personaje
		System.out.println("Introduzca el DNI (con letra) del personaje para control de peso:");
		String dni = escaner.next();
		System.out.println("Introduzca su peso actual:");
		int pesoNuevo = escaner.nextInt();
		
		//Comprobamos si el personaje existe y modificamos su peso
		ObjectInputStream lectura1 = new ObjectInputStream(new FileInputStream(archivo));
		contador = 0;
		try {
			while(true) {
				Personaje personajeLeido = (Personaje)lectura1.readObject();
				if(personajeLeido.DNI.equals(dni)) {
					contador++;
					if(personajeLeido.peso > pesoNuevo) {
						System.out.println(personajeLeido.nombre + " ha adelgazado " + (personajeLeido.peso - pesoNuevo) + " kilos");
					} else if(personajeLeido.peso < pesoNuevo) {
						System.out.println(personajeLeido.nombre + " ha engordado " + (pesoNuevo - personajeLeido.peso) + " kilos");
					} else {
						System.out.println(personajeLeido.nombre + " sigue igual");
					}
					personajeLeido.peso = pesoNuevo;
				}
				
			}
		} catch(EOFException e) {
			if (contador == 0) {
				System.out.println("El personaje no existe");
			}
			System.out.println("Fin de la lectura");
		}
		lectura1.close();
		
		//Pedimos un tipo de personaje e imprimimos todos de se tipo
		ObjectInputStream lectura2 = new ObjectInputStream(new FileInputStream(archivo));
		System.out.println("Elije un tipo de personaje:");
		String tipo = escaner.next();
		ArrayList<Personaje> lista = new ArrayList<Personaje>();
		contador = 0;
		try {
			while(true) {
				Personaje personajeLeido = (Personaje)lectura2.readObject();
				if(personajeLeido.tipo.equals(tipo)) {
					lista.add(personajeLeido);
					contador++;
				}
			}
		} catch(EOFException e) {
			System.out.println("Se han encontrado " + contador + " heroes.");
			for (Personaje objeto : lista) {
				System.out.println(objeto);
			}
		}
		
		//Cerramos el escaner y Streams
		escritura.close();
		lectura2.close();
		escaner.close();		
	}
}