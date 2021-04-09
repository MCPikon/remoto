import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Pelicula> pelis = new ArrayList<Pelicula>();
		String ruta = "peliculas.txt";
		File archivoPelis = new File(ruta);
		
		Scanner sn = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		int opc = 0, codPelicula = 0, anoEstreno = 0, costeProd = 0;
		String titulo = "", nombreProta = "";
		
		//leo el archivo y lo vuelco en el arraylist
		leerArchivo(archivoPelis, pelis);
		
		do {
			mostrarMenu();
			opc=sn.nextInt();
			switch (opc) {
			case 1:
				System.out.println("Introduce el código de la pelicula:");
				codPelicula=sn.nextInt();
				System.out.println("Introduce el título de la pelicula:");
				titulo=sc.nextLine();
				System.out.println("Introduce el año de estreno de la pelicula:");
				anoEstreno=sn.nextInt();
				System.out.println("Introduce el nombre del protagonista de la pelicula:");
				nombreProta=sc.nextLine();
				System.out.println("Introduce el coste de producción de la pelicula:");
				costeProd=sn.nextInt();
				altaPelicula(codPelicula, titulo, anoEstreno, nombreProta, costeProd, pelis);
				break;
				
			case 2:
				System.out.println("Introduce el código de la pelicula:");
				codPelicula=sn.nextInt();
				bajaPelicula(codPelicula, pelis);
				break;
				
			case 3:
				listaPelis(pelis);
				break;
				
			case 4:
				System.out.println("Introduce el código de la pelicula:");
				codPelicula=sn.nextInt();
				consultaPeli(codPelicula, pelis);
				break;
				
			case 5:
				System.out.println("Saliste del programa");
				break;
				
			default:
				System.out.println("Has introducido una opción errónea");
				break;
			}
		} while (opc!=5);
		
		escribirArchivo(archivoPelis, pelis);
	}
	
	public static void leerArchivo(File archivoPelis, ArrayList<Pelicula> pelis) {
		if (archivoPelis.exists()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(archivoPelis));
				try {
					String linea = br.readLine();
					while (linea!=null) {
						String[] partes = linea.split(Pattern.quote("||"));
						Pelicula peli = new Pelicula(Integer.parseInt(partes[0]), partes[1], Integer.parseInt(partes[2]), partes[3], Integer.parseInt(partes[4]));
						pelis.add(peli);
						linea=br.readLine();
					}
					br.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}else {
			try {
				archivoPelis.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void escribirArchivo(File archivoPelis, ArrayList<Pelicula> pelis) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(archivoPelis, false));
			String linea = "";
			for (int i=0; i < pelis.size(); i++) {
				linea = pelis.get(i).getCodPelicula() + "||" + pelis.get(i).getTitulo() + "||" + pelis.get(i).getAnoEstreno() 
						+ "||" + pelis.get(i).getNombreProta() + "||" + pelis.get(i).getCosteProd();
				bw.write(linea);
				if (pelis.size()-1!=i) {
					bw.newLine();
				}
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void mostrarMenu() {
		System.out.println("1. Alta de película");
		System.out.println("2. Baja de película");
		System.out.println("3. Consulta de todas las películas");
		System.out.println("4. Consulta de dato de una película por codigo.");
		System.out.println("5. Salir");
	}
	
	public static void altaPelicula(int codPelicula, String titulo, int anoEstreno, String nombreProta, int costeProd, ArrayList<Pelicula> pelis) {
		Pelicula nuevaPeli = new Pelicula(codPelicula, titulo, anoEstreno, nombreProta, costeProd);
		pelis.add(nuevaPeli);
	}
	
	public static void bajaPelicula(int codPelicula, ArrayList<Pelicula> pelis) {
		int cont = 0;
		for (int i = 0; i < pelis.size(); i++) {
			if (pelis.get(i).getCodPelicula() == codPelicula) {
				pelis.remove(pelis.get(i));
			}else {
				cont++;
			}
			if (cont == pelis.size()) {
				System.out.println("No se ha podido dar de baja la película (Código Incorrecto)");
			}
		}
	}
	
	public static void listaPelis(ArrayList<Pelicula> pelis) {
		System.out.println("Listado con todas las películas:");
		for (int i = 0; i < pelis.size(); i++) {
			System.out.println(pelis.get(i));
		}
	}
	
	public static void consultaPeli(int codPelicula, ArrayList<Pelicula> pelis) {
		int cont = 0;
		for (int i = 0; i < pelis.size(); i++) {
			if (pelis.get(i).getCodPelicula() == codPelicula) {
				System.out.println(pelis.get(i));
			}else {
				cont++;
			}
			if (cont == pelis.size()) {
				System.out.println("No se ha encontrado ninguna película con ese código");
			}
		}
	}

}
