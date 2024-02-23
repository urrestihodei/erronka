package erronka;

public class jokalaria {
	
	private int nan;
	private String izena;
	private String abizena;
	private int jaiotze_data;
	private String herrialdea;
	
	
	public jokalaria(int nan, String izena, String abizena, int jaiotze_data, String herrialdea) {
		setNan(nan);
		setIzena(izena);
		setAbizena(abizena);
		setJaiotze_data(jaiotze_data);
		setHerrialdea(herrialdea);
	}
	
	public void setNan(int balio) {
		this.nan = balio;
	}
	
	public void setIzena(String balio) {
		this.izena = balio;
	}
	
	public void setAbizena(String balio) {
		this.abizena = balio;
	}
	
	public void setJaiotze_data(int balio) {
		this.jaiotze_data = balio;
	}
	
	public void setHerrialdea(String balio) {
		this.herrialdea = balio;
	}
	
	
	public int getNan() {
		return nan;
	}
	
	public String getIzena() {
		return izena;
	}
	
	public String getAbizena() {
		return abizena;
	}
	
	public int getJaiotze_data() {
		return jaiotze_data;
	}
	
	public String getHerrialdea() {
		return herrialdea;
	}

}
