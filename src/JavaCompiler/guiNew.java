package JavaCompiler;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.Font;
import javax.swing.JTextArea;

public class guiNew extends JFrame {

	int comp=0;
	Main m=new Main();
	public JPanel contentPane;
	public JButton calistir;
	public static JTextArea text, text2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiNew frame = new guiNew();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public guiNew() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 927, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.LIGHT_GRAY));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 5, 380, 400);
		contentPane.add(scrollPane);
		// setUndecorated(true);

		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		panel.setForeground(Color.WHITE);
		panel.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 120, 215)));
		
		text = new JTextArea();
		text.setBounds(10, 11, 358, 376);
		panel.add(text);

		text2 = new JTextArea();

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(514, 5, 380, 400);
		contentPane.add(scrollPane_1);

		JPanel panel_1 = new JPanel();
		scrollPane_1.setViewportView(panel_1);
		panel_1.setForeground(Color.WHITE);
		panel_1.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 0, 0)));
		panel_1.setLayout(null);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 11, 358, 376);
		panel_1.add(scrollPane_3);

		text2 = new JTextArea();
		scrollPane_3.setViewportView(text2);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(395, 92, 109, 227);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JButton btnNewButton_1 = new JButton("Temizle");
		btnNewButton_1.setBounds(0, 123, 109, 43);
		panel_2.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 14));

		calistir = new JButton("Çalıştır");
		calistir.setBounds(0, 57, 109, 43);
		panel_2.add(calistir);
		calistir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
//					IfElseControlandInteger i = new IfElseControlandInteger();
//					i.mGroup1 = (Integer) null;
//					i.mGroup3 = (Integer) null;
//					i.operators = null;
					text2.setText(null);
					comp = m.compile();

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace(); // hata veren satiri g�ster
				}
			}
		});

		calistir.setForeground(Color.WHITE);
		calistir.setForeground(Color.BLACK);
		calistir.setFont(new Font("Arial", Font.BOLD, 16));
		calistir.setBackground(new Color(0, 84, 140));
		calistir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
}
