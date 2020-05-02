package Modelo;

public class Alumno {
	
	private String numControl;
	private String primerAp;
	private String nombre;
	private String segundoAp;
	private byte edad;
	private byte semestre;
	private String carrera;

	
	
	
	public Alumno(String numControl, String primerAp, String nombre, String segundoAp, byte edad, byte semestre,
			String carrera) {
		
		
		this.numControl = numControl;
		this.primerAp = primerAp;
		this.nombre = nombre;
		this.segundoAp = segundoAp;
		this.edad = edad;
		this.semestre = semestre;
		this.carrera = carrera;
	}




	public String getNumControl() {
		return numControl;
	}




	public void setNumControl(String numControl) {
		this.numControl = numControl;
	}




	public String getPrimerAp() {
		return primerAp;
	}




	public void setPrimerAp(String primerAp) {
		this.primerAp = primerAp;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getSegundoAp() {
		return segundoAp;
	}




	public void setSegundoAp(String segundoAp) {
		this.segundoAp = segundoAp;
	}




	public byte getEdad() {
		return edad;
	}




	public void setEdad(byte edad) {
		this.edad = edad;
	}




	public byte getSemestre() {
		return semestre;
	}




	public void setSemestre(byte semestre) {
		this.semestre = semestre;
	}




	public String getCarrera() {
		return carrera;
	}




	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}




	@Override
	public String toString() {
		return "Alumno numControl = " + numControl + ", primerAp " + primerAp + ", nombre = " + nombre + ", segundoAp ="
				+ segundoAp + ", edad = " + edad + ", semestre = " + semestre + ", carrera = " + carrera ;
	}
	
	

}
