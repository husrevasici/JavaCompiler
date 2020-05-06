package JavaCompiler;

import java.util.Hashtable;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

class gui implements MouseListener {
	int comp = 0;
	Main m = new Main();
	public static JTextArea text2;
	JFrame frame;
	JButton com, run, clear;
	JPanel panel;
	JTextArea text;

	public void go() {
	//?? RunError.GetArea(frame);

		Font font = new Font("Verdana", Font.BOLD, 17);
		Font font2 = new Font("TimesRoman", Font.BOLD, 17);

		frame = new JFrame();
		// frame.setUndecorated(true);
		

		JPanel panel = new JPanel();

		panel.setBounds(5, 5, 805, 360);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		Border panel_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
		panel.setBorder(panel_border);// kenarlarını ayarlar.

		panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.GRAY));
		text = new JTextArea();
		text2 = new JTextArea();

		com = new JButton("Çalıştır");
		com.setBackground(new Color(0, 101, 183));
		com.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				com.setBackground(new Color(235, 47, 6));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				com.setBackground(new Color(0, 101, 183));
			}
		});
		run = new JButton("Temizle");
		run.setBackground(new Color(0, 101, 183));
		run.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				run.setBackground(new Color(235, 47, 6));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				run.setBackground(new Color(0, 101, 183));
			}
		});
		clear = new JButton("Clear");
		clear.setVisible(false);

		com.addMouseListener(this);
		run.addMouseListener(this);
		clear.addMouseListener(this);

		text.setBounds(5, 5, 350, 350);
		text2.setBounds(450, 5, 350, 350);
		// frame.add(text);
		// frame.add(text2);
		// frame.add(com);
		// frame.add(run);
		// frame.add(clear);
		panel.add(text);
		panel.add(text2);
		panel.add(com);
		// panel.add(clear);
		panel.add(run);

		com.setBounds(362, 150, 80, 30);
		run.setBounds(362, 200, 80, 30);
		clear.setBounds(345, 250, 80, 30);

		com.setVisible(true);
		run.setVisible(true);
		// clear.setVisible(true);

		frame.setBounds(0, 0, 805, 360);

		frame.setLayout(null);
		frame.setVisible(true);

		text.setFont(font);
		text.setForeground(Color.BLUE);
		text2.setFont(font2);
		text2.setForeground(Color.BLACK);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == com) {
			try {
//				IfElseControlandInteger i = new IfElseControlandInteger();
//				i.mGroup1 = (Integer) null;
//				i.mGroup3 = (Integer) null;
//				i.operators = null;
				text2.setText(null);
				comp = m.compile();

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace(); // hata veren satiri g�ster
			}

		} else if (e.getSource() == run) {
			if (comp != 0) {
				try {
					go();
					// m.run();
				} catch (Exception e1) {
					// TODO Auto-generated catch block

				}
			}
		} else if (e.getSource() == clear) {

			text2.setText("");
		} else {
			// JOptionPane.showMessageDialog(frame, "Derleme Hatasi -> 'gui' Classi");
			text2.setText("Derleme Hatasi -> 'gui' Classi");
			// text.setText("Derlenme hatasi -> gui classi");
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}