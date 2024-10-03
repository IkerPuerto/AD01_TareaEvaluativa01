package src;

import java.io.*;
import java.util.ArrayList;

public class Ejercicio1 {
	public static void main(String[] args) throws IOException {
		
		//Creamos la ruta del archivo y lo leemos
		File archivoEntrada = new File("src" + File.separator + "txt" + File.separator + "Texto.txt");
		FileReader lector = new FileReader(archivoEntrada);
		int i;
		String texto = "";
		ArrayList<String> palabras = new ArrayList<String>();
		while ((i = lector.read()) != -1) {
			if ((char) i ==  ' ') {
				palabras.add(texto);
				texto = "";
			} else {				
				texto = texto + (char) i;
			}
		}
		palabras.add(texto);
		
		//Creamos la ruta de salida y erscribimos en el archivo
		File archivoSalida = new File("src" + File.separator + "txt" + File.separator + "Salida.txt");
		FileWriter escritor = new FileWriter(archivoSalida);
		for(String objeto : palabras) {
			char[] cadena = objeto.toCharArray();
			for(i = cadena.length - 1; i >= 0; i--) {
				escritor.write(cadena[i]);
			}
			escritor.write(" ");
		}
		
		//Cerramos el lector y el escritor
		lector.close();
		escritor.close();
	}
}
