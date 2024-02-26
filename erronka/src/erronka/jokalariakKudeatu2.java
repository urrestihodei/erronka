package erronka;

import java.io.File;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class jokalariakKudeatu2 {
	private JFrame frame;
	private JPanel panel;
	private ArrayList<jokalaria> jokalariak;

	/**
	 * ingurune grafikoa jartzen dio hasierako menuari
	 */
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

	/**
	 * Funtzio honek sql fitxategiak sortu eta gorde egiten ditu
	 */
	private void fitxategiaSortu() {
	    String ruta = JOptionPane.showInputDialog("Sartu direktorioa:");
	    File karpeta = new File(ruta);
	    if (karpeta.isDirectory()) {
	        String fitxategiIzena = JOptionPane.showInputDialog("Sartu fitxategiaren izena:");
	        fitxategiIzena += ".sql"; 
	        File fitxategia = new File(karpeta.getAbsolutePath() + File.separator + fitxategiIzena); // / edo \ idaztean file separator erabili dezakegu

	        try {
	            BufferedWriter writer = new BufferedWriter(new FileWriter(fitxategia));
	            for (jokalaria jok : jokalariak) {
	            	String sql = "INSERT INTO `jokalaria` (`nan`, `izena`, `abizena`, `herria`, `jaiotze_data`, `tituluak`, `erabiltzailea`, `pasahitza`, `aktibo` ) VALUES ('"
	                        + jok.getNan() + "', '" + jok.getIzena() + "', '" + jok.getAbizena() + "', '"
	                        + jok.getHerrialdea() + "', '" + jok.getJaiotze_data() + "', '" + jok.getTituluak() + "', '" + jok.getErabiltzailea() + "', '" + jok.getPasahitza() + "', 1);\n"; //idatziko duen testua
	                writer.write(sql);
	            }
	            writer.close();
	            JOptionPane.showMessageDialog(null, "Fitxategia ondo idatzi da.");
	        } catch (IOException e) {
	            JOptionPane.showMessageDialog(null, "Errorea fitxategia idazteko garaian: " + e.getMessage());
	        }
	    } else {
	    	JOptionPane.showMessageDialog(null, "Sartu duzuna ez da direktorio bat edo ez da existitzen.");
	    }
	}


	/**
	 * Jokalarien informazioa gehitzeko funtzioa. Hau egiteko ingurune grafikoa ere badago
	 */
	private void gehituJokalaria() {
	    boolean datuakOndo = false;

	    while (!datuakOndo) {
	        JPanel panel = new JPanel();
	        panel.setLayout(new GridLayout(8, 2)); 

	        JTextField nanField = new JTextField(10);
	        JTextField izenaField = new JTextField(10);
	        JTextField abizenaField = new JTextField(10);
	        JTextField jaiotzeDataField = new JTextField(10);
	        JTextField herrialdeaField = new JTextField(10);
	        JTextField tituluakField = new JTextField(10);
	        JTextField erabiltzaileaField = new JTextField(10);
	        JTextField pasahitzaField = new JTextField(10);

	        panel.add(new JLabel("NAN (8 digitu + letra mayuskula):"));
	        panel.add(nanField);
	        panel.add(new JLabel("Izena:"));
	        panel.add(izenaField);
	        panel.add(new JLabel("Abizena:"));
	        panel.add(abizenaField);
	        panel.add(new JLabel("Jaiotze Data (YYYY/MM/DD):"));
	        panel.add(jaiotzeDataField);
	        panel.add(new JLabel("Herrialdea:"));
	        panel.add(herrialdeaField);
	        panel.add(new JLabel("Tituluak:"));
	        panel.add(tituluakField);
	        panel.add(new JLabel("Erabiltzailea:"));
	        panel.add(erabiltzaileaField);
	        panel.add(new JLabel("Pasahitza:"));
	        panel.add(pasahitzaField);

	        int result = JOptionPane.showConfirmDialog(null, panel, "Jokalariaren informazioa sartu",
	                JOptionPane.OK_CANCEL_OPTION);

	        if (result == JOptionPane.OK_OPTION) {
	            String nan = nanField.getText().toUpperCase();
	            String izena = izenaField.getText();
	            String abizena = abizenaField.getText();
	            String herrialdea = herrialdeaField.getText();
	            Date jaiotzeData = null;
	            int tituluak = 0;
	            String erabiltzailea = erabiltzaileaField.getText();
	            String pasahitza = pasahitzaField.getText();

	            String jaiotzeDataInput = jaiotzeDataField.getText();

	            if (nan.matches("\\d{8}[A-Z]") && jaiotzeDataInput.matches("\\d{4}/\\d{2}/\\d{2}")) { //data eta nan-aren formatuak
	                try {
	                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd"); //dataren formatua jarri
	                    dateFormat.setLenient(false);
	                    jaiotzeData = dateFormat.parse(jaiotzeDataInput);

	                    String tituluakStr = tituluakField.getText();
	                    try {
	                        tituluak = Integer.parseInt(tituluakStr); //String- aint izateko
	                    } catch (NumberFormatException e) {
	                        JOptionPane.showMessageDialog(null, "Mesedez, sartu zenbaki osoa tituluak eremuan.");
	                        continue; // bukle hasierara itzuli
	                    }

	                    if (!izena.matches(".*\\d.*") && !abizena.matches(".*\\d.*") && !herrialdea.matches(".*\\d.*")) {
	                        jokalaria jokalari = new jokalaria(nan, izena, abizena, jaiotzeData, herrialdea, tituluak,
	                                erabiltzailea, pasahitza);
	                        jokalariak.add(jokalari);
	                        datuakOndo = true;
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Datuak ez dira zuzenak. Mesedez, ziurtatu sartutako datuak.");
	                    }
	                } catch (ParseException e) {
	                    JOptionPane.showMessageDialog(null, "Data ez da zuzena, mesedez sartu datuak formato egokian (YYYY/MM/DD).");
	                }
	            } else {
	                JOptionPane.showMessageDialog(null, "NAN edo data ez da zuzena, mesedez sartu datuak formato egokian.");
	            }
	        } else {
	            break; // Atera
	        }
	    }
	}


	/**
	 * Gordeta dauden jokalari guztiak erakusten ditu
	 */
	private void erakutsiJokalariak() {
	    JDialog dialog = new JDialog(frame, "Jokalariak", true);
	    JPanel panel = new JPanel(new GridLayout(jokalariak.size(), 1));

	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd"); //data  formatu honeta erakutsiko du

	    for (jokalaria jokalari : jokalariak) {
	        JTextArea textArea = new JTextArea();
	        textArea.append("Nan: " + jokalari.getNan() + "\n");
	        textArea.append("Izena: " + jokalari.getIzena() + "\n");
	        textArea.append("Abizena: " + jokalari.getAbizena() + "\n");
	        textArea.append("Jaiotze data: " + dateFormat.format(jokalari.getJaiotze_data()) + "\n");
	        textArea.append("Herrialdea: " + jokalari.getHerrialdea() + "\n\n");
	        textArea.append("Tituluak: " + jokalari.getTituluak() + "\n");
	        textArea.append("Erabiltzailea: " + jokalari.getErabiltzailea() + "\n");
	        textArea.append("Pasahitza: " + jokalari.getPasahitza() + "\n");

	        panel.add(textArea);
	    }

	    JScrollPane scrollPane = new JScrollPane(panel);
	    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    dialog.add(scrollPane);
	    dialog.setSize(400, 400);
	    dialog.setVisible(true);
	}


	public static void main(String[] args) {
		new jokalariakKudeatu2();
	}
}
