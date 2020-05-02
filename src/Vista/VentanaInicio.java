package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;

import javax.swing.*;

import Controlador.AlumnoDAO;
import Modelo.Alumno;

public class VentanaInicio extends JFrame {

	JMenuBar menuBar;
	JMenu menuInicio;
	JMenuItem menuAltas,menuCambio, menuBajas, menuConsultas;
	JInternalFrame IF_Altas,IF_Cambio, IF_Bajas, IF_Consultas;

	public VentanaInicio() {

		getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Numeros Pseudoaleatorios");

		setSize(500, 460);
		setLocationRelativeTo(null);
		setVisible(true);
		getContentPane().setBackground(Color.WHITE);

		menuBar = new JMenuBar();
		menuInicio = new JMenu("View");
		menuAltas = new JMenuItem("Altas");
		menuCambio = new JMenuItem("Cambio");
		menuBajas = new JMenuItem("Bajas");
		menuConsultas = new JMenuItem("Consultas");
		
		menuAltas.setMnemonic(KeyEvent.VK_S);
		menuAltas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));

		menuAltas.addActionListener(new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent e) {

				IF_Altas.setVisible(true);
			}
		});

		menuCambio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("asdsadf");
				IF_Cambio.setVisible(true);

			}
		});
		
		menuBajas.addActionListener(new ActionListener() {
			
			@Override	
			public void actionPerformed(ActionEvent arg0) {
				IF_Bajas.setVisible(true);
				
			}
		});	
		
		menuConsultas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				IF_Consultas.setVisible(true);
				
			}
		});

		menuInicio.add(menuAltas);
		menuInicio.add(menuCambio);
		menuInicio.add(menuBajas);
		menuInicio.add(menuConsultas);
		menuBar.add(menuInicio);
		setJMenuBar(menuBar);

		JDesktopPane desktopPane = new JDesktopPane();

		IF_Altas = new JInternalFrame();
		IF_Altas.getContentPane().setLayout(null);
		IF_Altas.setDefaultCloseOperation(HIDE_ON_CLOSE);
		IF_Altas.setTitle("Altas");
		IF_Altas.setSize(500, 450);
		IF_Altas.setMaximizable(true);
		IF_Altas.setIconifiable(true);
		IF_Altas.setClosable(true);
		IF_Altas.setResizable(true);
		IF_Altas.setLayout(null);
		// IF_Altas.setVisible(true);

		desktopPane.add(IF_Altas); // agregar InternalFrame al DesktopPane

		add(desktopPane, BorderLayout.CENTER); // agreagr desktopPane al JFrame principal

		JLabel lb0 = new JLabel("Ingrese los datos del alumno");
		lb0.setBounds(10, 10, 130, 20);
		IF_Altas.add(lb0);

		JLabel lb1 = new JLabel("Numero de Control");
		lb1.setBounds(10, 40, 130, 20);
		IF_Altas.add(lb1);

		JTextField t1 = new JTextField();
		t1.setBounds(10, 70, 100, 20);
		IF_Altas.add(t1);

		JLabel lb2 = new JLabel("Nombre");
		lb2.setBounds(10, 100, 130, 20);
		IF_Altas.add(lb2);

		JTextField t2 = new JTextField();
		t2.setBounds(10, 130, 100, 20);
		IF_Altas.add(t2);

		JLabel lb3 = new JLabel("Primer ap");
		lb3.setBounds(10, 160, 130, 20);
		IF_Altas.add(lb3);

		JTextField t3 = new JTextField();
		t3.setBounds(10, 190, 100, 20);
		IF_Altas.add(t3);

		JLabel lb4 = new JLabel("Segundo ap");
		lb4.setBounds(10, 220, 130, 20);
		IF_Altas.add(lb4);

		JTextField t4 = new JTextField();
		t4.setBounds(10, 250, 100, 20);
		IF_Altas.add(t4);
		// Num_Control | Nombre_Alumno | Primer_Ap_Alumno | Segundo_Ap_Alumno |
		// Edad_Alumno | Semestre | Carrera
		JLabel lb5 = new JLabel("Edad");
		lb5.setBounds(10, 280, 130, 20);
		IF_Altas.add(lb5);

		JTextField t5 = new JTextField();
		t5.setBounds(10, 310, 100, 20);
		IF_Altas.add(t5);

		JLabel lb6 = new JLabel("Semestre");
		lb6.setBounds(150, 40, 130, 20);
		IF_Altas.add(lb6);

		JTextField t6 = new JTextField();

		t6.setBounds(150, 70, 100, 20);
		IF_Altas.add(t6);

		JLabel lb7 = new JLabel("Carrera");
		lb7.setBounds(150, 100, 130, 20);
		IF_Altas.add(lb7);

		JTextField t7 = new JTextField();
		t7.setBounds(150, 130, 100, 20);
		IF_Altas.add(t7);

		JButton bAltas = new JButton("Dar de alta");
		bAltas.setBounds(200, 200, 100, 35);
		bAltas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (t1.getText().equals("") || t2.getText().equals("") || t3.getText().equals("")
						|| t4.getText().equals("") || t5.getText().equals("") || t6.getText().equals("")
						|| t7.getText().equals("")) {
					JOptionPane.showMessageDialog(getParent(), "Checar los datos");
					System.out.println("asd");
				} else {
					try {
						boolean res = new AlumnoDAO()
								.agregarAlumno(new Alumno(t1.getText(), t2.getText(), t3.getText(), t4.getText(),
										Byte.parseByte(t5.getText()), Byte.parseByte(t6.getText()), t7.getText()));

					} catch (Exception e2) {
						System.out.println("Error");
						JOptionPane.showMessageDialog(getParent(), "Checar los datos");
					}
				}

			}

		});
		
		
		IF_Altas.add(bAltas);

		IF_Cambio = new JInternalFrame();
		IF_Cambio.getContentPane().setLayout(null);
		IF_Cambio.setDefaultCloseOperation(HIDE_ON_CLOSE);
		IF_Cambio.setTitle("Cambio");
		IF_Cambio.setSize(500, 450);
		IF_Cambio.setMaximizable(true);
		IF_Cambio.setIconifiable(true);
		IF_Cambio.setClosable(true);
		IF_Cambio.setResizable(true);
		IF_Cambio.setLayout(null);

		desktopPane.add(IF_Cambio);
		
		
		
		JLabel blb0 = new JLabel("Ingrese los datos del alumno");
		blb0.setBounds(10, 10, 130, 20);
		IF_Cambio.add(blb0);

		JLabel b1 = new JLabel("Numero de Control");
		b1.setBounds(10, 40, 130, 20);
		IF_Cambio.add(b1);
		
		JTextField bt1 = new JTextField();
		bt1.setBounds(10, 70, 100, 20);
		IF_Cambio.add(bt1);

		JLabel b2 = new JLabel("Nombre");
		b2.setBounds(10, 100, 130, 20);
		IF_Cambio.add(b2);

		JTextField bt2 = new JTextField();
		bt2.setBounds(10, 130, 100, 20);
		IF_Cambio.add(bt2);

		JLabel b3 = new JLabel("Primer ap");
		b3.setBounds(10, 160, 130, 20);
		IF_Cambio.add(b3);

		JTextField bt3 = new JTextField();
		bt3.setBounds(10, 190, 100, 20);
		IF_Cambio.add(bt3);

		JLabel b4 = new JLabel("Segundo ap");
		b4.setBounds(10, 220, 130, 20);
		IF_Cambio.add(b4);

		JTextField bt4 = new JTextField();
		bt4.setBounds(10, 250, 100, 20);
		IF_Cambio.add(bt4);
		// Num_Control | Nombre_Alumno | Primer_Ap_Alumno | Segundo_Ap_Alumno |
		// Edad_Alumno | Semestre | Carrera
		JLabel b5 = new JLabel("Edad");
		b5.setBounds(10, 280, 130, 20);
		IF_Cambio.add(b5);

		JTextField bt5 = new JTextField();
		bt5.setBounds(10, 310, 100, 20);
		IF_Cambio.add(bt5);

		JLabel b6 = new JLabel("Semestre");
		b6.setBounds(150, 40, 130, 20);
		IF_Cambio.add(b6);

		JTextField bt6 = new JTextField();
		bt6.setBounds(150, 70, 100, 20);
		IF_Cambio.add(bt6);

		JLabel b7 = new JLabel("Carrera");
		b7.setBounds(150, 100, 130, 20);
		IF_Cambio.add(b7);

		JTextField bt7 = new JTextField();
		bt7.setBounds(150, 130, 100, 20);
		IF_Cambio.add(bt7);
		
		
		JButton bCambio = new JButton("Cambiar");
		bCambio.setBounds(200, 200, 100, 35);
		
		bCambio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (bt1.getText().equals("") || bt2.getText().equals("") || bt3.getText().equals("")
						|| bt4.getText().equals("") || bt5.getText().equals("") || bt6.getText().equals("")
						|| bt7.getText().equals("")) {
					JOptionPane.showMessageDialog(getParent(), "Checar los datos");
					
				} else {
					try {
						
						boolean res = new AlumnoDAO()
								.modificarAlumno(new Alumno(bt1.getText(), bt2.getText(), bt3.getText(), bt4.getText(),
										Byte.parseByte(bt5.getText()), Byte.parseByte(bt6.getText()), bt7.getText()));

					} catch (Exception e2) {
						System.out.println("Error");
						JOptionPane.showMessageDialog(getParent(), "Checar los datos");
					}
				}
				
			}
		});
		IF_Cambio.add(bCambio);
		
		IF_Bajas = new JInternalFrame();
		IF_Bajas.getContentPane().setLayout(null);
		IF_Bajas.setDefaultCloseOperation(HIDE_ON_CLOSE);
		IF_Bajas.setTitle("Bajas");
		IF_Bajas.setSize(500, 450);
		IF_Bajas.setMaximizable(true);
		IF_Bajas.setIconifiable(true);
		IF_Bajas.setClosable(true);
		IF_Bajas.setResizable(true);
		IF_Bajas.setLayout(null);
		// IF_Bajas.setVisible(true);

		desktopPane.add(IF_Bajas);
		
		JLabel dlb0 = new JLabel("Ingrese El numero de control para eliminar el alumno");
		dlb0.setBounds(10, 10, 300, 20);
		IF_Bajas.add(dlb0);

		JLabel db1 = new JLabel("Numero de Control");
		db1.setBounds(10, 40, 130, 20);
		IF_Bajas.add(db1);
		
		
		JTextField dt1 = new JTextField();
		dt1.setBounds(10, 70, 100, 20);
		IF_Bajas.add(dt1);
		
		JButton bBaja = new JButton("Dar de baja");
		bBaja.setBounds(10, 200, 100, 35);
		
		bBaja.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (dt1.getText().equals("")) {
					JOptionPane.showMessageDialog(getParent(), "Checar los datos");
				}else {
					try {
						boolean res = new AlumnoDAO().eliminarAlumno(dt1.getText());
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
				
			}
		});
		IF_Bajas.add(bBaja);
		
		IF_Consultas = new JInternalFrame();
		IF_Consultas.getContentPane().setLayout(null);
		IF_Consultas.setDefaultCloseOperation(HIDE_ON_CLOSE);
		IF_Consultas.setTitle("Consulta");
		IF_Consultas.setSize(500, 450);
		IF_Consultas.setMaximizable(true);
		IF_Consultas.setIconifiable(true);
		IF_Consultas.setClosable(true);
		IF_Consultas.setResizable(true);
		IF_Consultas.setLayout(null);
		// IF_Consultas.setVisible(true);

		desktopPane.add(IF_Consultas);
		
		JLabel clb0 = new JLabel("Ingrese El numero de control para mostrar los datos del alumno");
		clb0.setBounds(10, 10, 350, 20);
		IF_Consultas.add(clb0);

		JLabel cb1 = new JLabel("Numero de Control");
		cb1.setBounds(10, 40, 130, 20);
		IF_Consultas.add(cb1);
		
		
		JTextField ct1 = new JTextField();
		ct1.setBounds(10, 70, 100, 20);
		IF_Consultas.add(ct1);
		
		JButton bConsulta = new JButton("Consultar");
		bConsulta.setBounds(10, 200, 100, 35);
		
		bConsulta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (ct1.getText().equals("")) {
					JOptionPane.showMessageDialog(getParent(), "Checar los datos");
				}else {
					try {
						Alumno res = new AlumnoDAO().buscarAlumno(ct1.getText());
						if (res == null) {
							JOptionPane.showMessageDialog(getParent(), "No coincide el numero con ningun alumno en la base");
						}else {
							JOptionPane.showMessageDialog(getParent(), res);
						}
						
						
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(getParent(), "Checar los datos");
					}
				}
				
			}
		});
		
		IF_Consultas.add(bConsulta);
		
		/*
		 * JLabel lb2 = new JLabel("Ingrese el multiplicador"); lb2.setBounds(10, 70,
		 * 150, 20); add(lb2);
		 * 
		 * JTextField t2 = new JTextField(); t2.setBounds(10, 100, 100, 20); add(t2);
		 * 
		 * JLabel lb3 = new JLabel("Ingrese la constante aditiva"); lb3.setBounds(10,
		 * 130, 170, 20); add(lb3);
		 * 
		 * JTextField t3 = new JTextField(); t3.setBounds(10, 160, 100, 20); add(t3);
		 * 
		 * JLabel lb4 = new JLabel("Ingrese el modulo"); lb4.setBounds(10, 190, 110,
		 * 20); add(lb4);
		 * 
		 * JTextField t4 = new JTextField(); t4.setBounds(10, 220, 100, 20); add(t4);
		 */

	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new VentanaInicio();
				
			}
		});

		/*
		 * String nc = "S18070182"; String n = "1"; String pa = "1"; String sa = "1";
		 * byte e = 1; byte s = 1; String c = "1";
		 * 
		 * 
		 * 
		 * boolean res = new AlumnoDAO().agregarAlumno(new Alumno(nc, pa, n, sa, e, s,
		 * c)); Alumno al1 = new Alumno("S18070182", "a", "a", "b", (byte)19, (byte)2,
		 * "isc");
		 * 
		 * new AlumnoDAO().modificarAlumno(al1); Alumno alconsulta = new
		 * AlumnoDAO().buscarAlumno("S18070182");
		 * 
		 * if (alconsulta==null) { System.out.println("Error"); }else {
		 * System.out.println(alconsulta); }
		 * 
		 */

	}

}
