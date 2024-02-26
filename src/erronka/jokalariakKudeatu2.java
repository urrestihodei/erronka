package erronka;

import java.io.File;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class jokalariakKudeatu2 {
	private JFrame frame;
	private JPanel panel;
	private ArrayList<jokalaria> jokalariak;

	public jokalariakKudeatu2() {
		frame = new JFrame("Jokalaria Kudeatu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 150);

		panel = new JPanel();
		frame.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

		JButton btnGehitu = new JButton("Jokalariak Gehitu");
		btnGehitu.setBounds(20, 220, 150, 30);
		panel.add(btnGehitu);

		JButton btnErakutsi = new JButton("Jokalariak Erakutsi");
		btnErakutsi.setBounds(200, 220, 150, 30);
		panel.add(btnErakutsi);

		JButton btnSortu = new JButton("Fitxategia Sortu");
		btnSortu.setBounds(20, 260, 150, 30);
		panel.add(btnSortu);

		JButton btnAmaitu = new JButton("Amaitu");
		btnAmaitu.setBounds(200, 260, 150, 30);
		panel.add(btnAmaitu);

		jokalariak = new ArrayList<>();

		btnGehitu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gehituJokalaria();
			}
		});

		btnErakutsi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				erakutsiJokalariak();
			}
		});

		btnSortu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fitxategiaSortu();
			}
		});

		btnAmaitu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

		frame.setVisible(true);
	}

	private void fitxategiaSortu() {
		String fitxategiIzena = JOptionPane.showInputDialog("Sartu fitxategiaren izena:");
		fitxategiIzena += ".sql";
		String ruta = System.getProperty("user.home") + "/Desktop/";
		File archivo = new File(ruta + fitxategiIzena);

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));
			for (jokalaria jok : jokalariak) {
				String sql = "INSERT INTO `jokalaria` (`nan`, `izena`, `abizena`, `jaiotze_data`, `herrialdea`) VALUES ('"
						+ jok.getNan() + "', '" + jok.getIzena() + "', '" + jok.getAbizena() + "', '"
						+ jok.getJaiotze_data() + "', '" + jok.getHerrialdea() + "');\n";
				writer.write(sql);
			}
			writer.close();
			JOptionPane.showMessageDialog(null, "Fitxategia ondo idatzi da.");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Errorea fitxategia idazteko garaian: " + e.getMessage());
		}
	}

	private void gehituJokalaria() {
	    boolean datosValidos = false;

	    while (!datosValidos) {
	        JPanel panel = new JPanel();
	        panel.setLayout(new GridLayout(5, 2));

	        JTextField nanField = new JTextField(10);
	        JTextField izenaField = new JTextField(10);
	        JTextField abizenaField = new JTextField(10);
	        JTextField jaiotzeDataField = new JTextField(10);
	        JTextField herrialdeaField = new JTextField(10);

	        panel.add(new JLabel("NAN (8 digitu):"));
	        panel.add(nanField);
	        panel.add(new JLabel("Izena:"));
	        panel.add(izenaField);
	        panel.add(new JLabel("Abizena:"));
	        panel.add(abizenaField);
	        panel.add(new JLabel("Jaiotze Data:"));
	        panel.add(jaiotzeDataField);
	        panel.add(new JLabel("Herrialdea:"));
	        panel.add(herrialdeaField);

	        int result = JOptionPane.showConfirmDialog(null, panel, "Jokalariaren informazioa sartu", JOptionPane.OK_CANCEL_OPTION);

	        if (result == JOptionPane.OK_OPTION) {
	            String nanInput = nanField.getText();
	            String izena = izenaField.getText();
	            String abizena = abizenaField.getText();
	            int jaiotze_data = 0;
	            String herrialdea = herrialdeaField.getText();

	            try {
	                jaiotze_data = Integer.parseInt(jaiotzeDataField.getText());

	                if (nanInput.length() == 8 && nanInput.matches("[0-9]+") && !izena.matches(".*\\d.*") && !abizena.matches(".*\\d.*") && !herrialdea.matches(".*\\d.*")) {
	                    int nan = Integer.parseInt(nanInput);
	                    jokalaria jokalari = new jokalaria(nan, izena, abizena, jaiotze_data, herrialdea);
	                    jokalariak.add(jokalari);
	                    datosValidos = true;
	                } else {
	                    JOptionPane.showMessageDialog(null, "Datuak ez dira zuzenak. Mesedez, ziurtatu sartutako datuak.");
	                }
	            } catch (NumberFormatException e) {
	                JOptionPane.showMessageDialog(null, "Jaiotze Data zenbaki bat izan behar du.");
	            }
	        } else {
	            break; // Bukletik atera
	        }
	    }
	}
 


	private void erakutsiJokalariak() {
		// Crear una ventana de diálogo para mostrar la información
		JDialog dialog = new JDialog(frame, "Jokalariak", true);
		JPanel panel = new JPanel(new GridLayout(jokalariak.size(), 1));

		for (jokalaria jokalari : jokalariak) {
			JTextArea textArea = new JTextArea();
			textArea.append("Nan: " + jokalari.getNan() + "\n");
			textArea.append("Izena: " + jokalari.getIzena() + "\n");
			textArea.append("Abizena: " + jokalari.getAbizena() + "\n");
			textArea.append("Jaiotze data: " + jokalari.getJaiotze_data() + "\n");
			textArea.append("Herrialdea: " + jokalari.getHerrialdea() + "\n\n");

			panel.add(textArea);
		}

		// Crear JScrollPane y agregar el panel a él
		JScrollPane scrollPane = new JScrollPane(panel);

		// Ajustar la política de desplazamiento
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		// Agregar el JScrollPane al diálogo
		dialog.add(scrollPane);

		// Ajustar el tamaño del diálogo
		dialog.setSize(400, 400);

		// Hacer visible el diálogo
		dialog.setVisible(true);
	}

	public static void main(String[] args) {
		new jokalariakKudeatu2();
	}
}

