
public class Pelicula {
	private int codPelicula;
	private String titulo;
	private int anoEstreno;
	private String nombreProta;
	private int costeProd;
	
	public Pelicula() {}

	public Pelicula(int codPelicula, String titulo, int anoEstreno, String nombreProta, int costeProd) {
		super();
		this.codPelicula = codPelicula;
		this.titulo = titulo;
		this.anoEstreno = anoEstreno;
		this.nombreProta = nombreProta;
		this.costeProd = costeProd;
	}

	public int getCodPelicula() {
		return codPelicula;
	}

	public void setCodPelicula(int codPelicula) {
		this.codPelicula = codPelicula;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnoEstreno() {
		return anoEstreno;
	}

	public void setAnoEstreno(int anoEstreno) {
		this.anoEstreno = anoEstreno;
	}

	public String getNombreProta() {
		return nombreProta;
	}

	public void setNombreProta(String nombreProta) {
		this.nombreProta = nombreProta;
	}

	public int getCosteProd() {
		return costeProd;
	}

	public void setCosteProd(int costeProd) {
		this.costeProd = costeProd;
	}

	@Override
	public String toString() {
		return "[Código Película: " + codPelicula + ", Título: " + titulo + ", Año de estreno: " + anoEstreno
				+ ", Nombre del protagonista: " + nombreProta + ", Coste de Producción: " + costeProd + "]";
	}

}
