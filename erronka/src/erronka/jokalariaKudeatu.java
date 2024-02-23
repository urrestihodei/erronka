package erronka;

import javax.swing.JOptionPane;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;

public class jokalariaKudeatu {

	private Scanner sc;
	private ArrayList<jokalaria> jokalariak;

	public void jokalariakKudeatu() {
		sc = new Scanner(System.in);
		jokalariak = new ArrayList<>();
	}

	public void exekutatu() {
		boolean amaitu = false;
		int aukera;

		do {
			System.out.println("   Aukera bat sakatu");
			System.out.println("1- Jokalariak gehitu");
			System.out.println("2- Jokalariak erakutsi");
			System.out.println("3- Fitxategia sortu");
			System.out.println("4- Amaitu");

			aukera = sc.nextInt();
			sc.nextLine();

			switch (aukera) {

			case 1:
				gehituJokalaria();
				break;

			case 2:
				erakutsiJokalariak();
				break;

			case 3:
				fitxategiaSortu();
				break;

			case 4:
				amaitu = true;
				break;
			}

		} while (!amaitu);
	}

	private void fitxategiaSortu() {
		// Solicitar al usuario que ingrese el nombre del archivo (sin la extensión
		// .sql)
		String fitxategiIzena = JOptionPane.showInputDialog("Sartu fitxategiaren izena:");

		// Agregar la extensión .sql al nombre del archivo
		fitxategiIzena += ".sql";

		// Ruta del escritorio del usuario
		String ruta = System.getProperty("user.home") + "/Desktop/";

		// Crear el objeto File con la ruta completa del archivo en el escritorio
		File archivo = new File(ruta + fitxategiIzena);

		try {
			// Crear un BufferedWriter para escribir en el archivo
			BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));

			// Recorrer el ArrayList de jokalariak y escribir las sentencias SQL en el
			// archivo
			for (jokalaria jok : jokalariak) {
				String sql = "INSERT INTO `jokalaria` (`nan`, `izena`, `abizena`, `jaiotze_data`, `herrialdea`) VALUES ('"
						+ jok.getNan() + "', '" + jok.getIzena() + "', '" + jok.getAbizena() + "', '"
						+ jok.getJaiotze_data() + "', '" + jok.getHerrialdea() + "');\n";
				writer.write(sql);
			}

			// Cerrar el BufferedWriter después de escribir
			writer.close();

			JOptionPane.showMessageDialog(null, "Se ha escrito en el archivo correctamente.");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al escribir en el archivo: " + e.getMessage());
		}
	}

	private void gehituJokalaria() {
		String nanInput = JOptionPane.showInputDialog("Sartu nan (8 digitos): ");
		while (nanInput.length() != 8 || !nanInput.matches("[0-9]+")) {
			nanInput = JOptionPane.showInputDialog("Sartu nan (8 digitos): ");
		}
		int nan = Integer.parseInt(nanInput);

		String izena = "";
		while (true) {
			izena = JOptionPane.showInputDialog("Sartu izena");
			if (!izena.matches(".*\\d.*")) {
				break;
			} else {
				JOptionPane.showMessageDialog(null, "Izena ezin du zenbakiak izan.");
			}
		}

		String abizena = "";
		while (true) {
			abizena = JOptionPane.showInputDialog("Sartu abizena");
			if (!abizena.matches(".*\\d.*")) {
				break;
			} else {
				JOptionPane.showMessageDialog(null, "Abizena ezin du zenbakiak izan.");
			}
		}

		int jaiotze_data = Integer.parseInt(JOptionPane.showInputDialog("Sartu jaiotze data: "));

		String herrialdea = "";
		while (true) {
			herrialdea = JOptionPane.showInputDialog("Sartu herrialdea");
			if (!herrialdea.matches(".*\\d.*")) {
				break;
			} else {
				JOptionPane.showMessageDialog(null, "Herrialdea ezin du zenbakiak izan.");
			}
		}

		jokalaria jokalari = new jokalaria(nan, izena, abizena, jaiotze_data, herrialdea);

		jokalariak.add(jokalari);
	}

	private void erakutsiJokalariak() {
		int kontagailua = 1;
		for (jokalaria jokalari : jokalariak) {
			System.out.println(kontagailua + ". jokalakia:");
			System.out.println("Nan: " + jokalari.getNan());
			System.out.println("Izena: " + jokalari.getIzena());
			System.out.println("Abizena: " + jokalari.getAbizena());
			System.out.println("Jaiotze data: " + jokalari.getJaiotze_data());
			System.out.println("Herrialdea: " + jokalari.getHerrialdea());
		}
	}

	public static void main(String[] args) {
		jokalariaKudeatu kudeatu = new jokalariaKudeatu();
		kudeatu.jokalariakKudeatu(); // Initialize the Scanner object
		kudeatu.exekutatu();
	}

}
