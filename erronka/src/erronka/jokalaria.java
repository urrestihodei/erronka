package erronka;

import java.util.Date;

public class jokalaria {

	private String nan;
	private String izena;
	private String abizena;
	private Date jaiotze_data;
	private String herrialdea;
	private int tituluak;
	private String erabiltzailea;
	private String pasahitza;

	/**
	 * jokalariaren eraikitzailea
	 * @param nan = jokalariaren nan-a
	 * @param izena = jokalariaren izena
	 * @param abizena = jokalariaren abizena
	 * @param jaiotzeData = jokalariaren jaiotze data(UUUU/HH/EE formtuan)
	 * @param herrialdea = jokalariaren herrialdea
	 * @param tituluak = jokalariaren tituluak
	 * @param erabiltzailea = jokalariaren erabiltzailea
	 * @param pasahitza = jokalariaren pasahitza
	 */
	public jokalaria(String nan, String izena, String abizena, Date jaiotzeData, String herrialdea, int tituluak, String erabiltzailea, String pasahitza) {
		setNan(nan);
		setIzena(izena);
		setAbizena(abizena);
		setJaiotze_data(jaiotzeData);
		setHerrialdea(herrialdea);
		setTituluak(tituluak);
		setErabiltzailea(erabiltzailea);
		setPasahitza(pasahitza);
	}

	/**
	 * jokalariaren nan-a ezartzen du
	 * @param balio parametroa
	 */
	public void setNan(String balio) {
		this.nan = balio;
	}

	/**
	 * jokalariaren izena ezartzen du
	 * @param balio parametroa
	 */
	public void setIzena(String balio) {
		this.izena = balio;
	}

	/**
	 * jokalariaren abizena ezartzen du
	 * @param balio parametroa
	 */
	public void setAbizena(String balio) {
		this.abizena = balio;
	}

	/**
	 * jokalariaren jaiotze data ezartzen du
	 * @param balio parametroa(UUUU/HH/EE)
	 */
	public void setJaiotze_data(Date balioa) {
		this.jaiotze_data = balioa;
	}

	/**
	 * jokalariaren herrialdea ezartzen du
	 * @param balio parametroa
	 */
	public void setHerrialdea(String balio) {
		this.herrialdea = balio;
	}
	
	/**
	 * jokalariaren tituluak data ezartzen du
	 * @param balio parametroa
	 */
	public void setTituluak(int balio) {
		this.tituluak = balio;
	}
	
	/**
	 * jokalariaren erabiltzailea ezartzen du
	 * @param balio parametroa
	 */
	public void setErabiltzailea(String balio) {
		this.erabiltzailea = balio;
	}

	/**
	 * jokalariaren pasahitza ezartzen du
	 * @param balio parametroa
	 */
	public void setPasahitza(String balio) {
		this.pasahitza = balio;
	}
	
	/**
	 * Jokalariaren nan-a itzultzen du
	 * @return nan
	 */
	public String getNan() {
		return nan;
	}

	/**
	 * Jokalariaren izena itzultzen du
	 * @return izena
	 */
	public String getIzena() {
		return izena;
	}

	/**
	 * Jokalariaren abizena itzultzen du
	 * @return abizena
	 */
	public String getAbizena() {
		return abizena;
	}

	/**
	 * Jokalariaren jaiotze_data itzultzen du
	 * @return jaiotze_data
	 */
	public Date getJaiotze_data() {
		return jaiotze_data;
	}

	/**
	 * Jokalariaren herrialdea itzultzen du
	 * @return herrialdea
	 */
	public String getHerrialdea() {
		return herrialdea;
	}
	
	/**
	 * Jokalariaren tituluak itzultzen du
	 * @return tituluak
	 */
	public int getTituluak() {
		return tituluak;
	}
	
	/**
	 * Jokalariaren erabiltzailea itzultzen du
	 * @return erabiltzailea
	 */
	public String getErabiltzailea() {
		return erabiltzailea;
	}
	
	/**
	 * Jokalariaren pasahitza itzultzen du
	 * @return pasahitza
	 */
	public String getPasahitza() {
		return pasahitza;
	}

}
