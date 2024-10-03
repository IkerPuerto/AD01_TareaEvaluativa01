package src;
import java.io.*;
import java.util.Scanner;

class Ejercicio2 {
	public static void main(String[] args) throws IOException {
		
		//Creamos la ruta de archivo y el lector
		File archivoEntrada = new File("src" + File.separator + "txt" + File.separator + "Texto.txt");
		BufferedReader lector = new BufferedReader (new FileReader(archivoEntrada));
		
		//Creamos la ruta de salida y su escritor
		File archivoSalida = new File("src" + File.separator + "txt" + File.separator + "Salida.txt");
		BufferedWriter escritor = new BufferedWriter (new FileWriter(archivoSalida));
		
		//Leemos el texto y lo devolvemos escrito en otro archivo
		Scanner escaner = new Scanner(lector);
		while(escaner.hasNext()) {
			String palabra = escaner.next();
			if(palabra.length() == 5) {
				escritor.write(palabra + "\n");
			}
		}
		
		//Cerramos los escaneres
		lector.close();
		escritor.close();
		escaner.close();
	}
}