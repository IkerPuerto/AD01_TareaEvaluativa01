package src;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

class Ejercicio3 {
	public static void main(String[] args) throws IOException {
		
		//Creamos la ruta del archivo a leer y el lector
		File archivo = new File("src" + File.separator + "pdf" + File.separator + "Titulo.pdf");
		int[] pdfSignature = {37, 80, 68, 70}; //Cabecera de un PDF
		InputStream lector = new FileInputStream(archivo);
		
		//Comparamos la cabecera de un PDF con nuestro archivo
		int[] cabecera = new int[4];
		for (int i = 0; i < 4; i++) {
			cabecera[i]= lector.read();
		}
		if (Arrays.equals(cabecera, pdfSignature)) {
			System.out.println("Si es un archivo PDF");
		} else {
			System.out.println("No lo es");
		}
		
		//Cerramos el lector
		lector.close();
	}
}