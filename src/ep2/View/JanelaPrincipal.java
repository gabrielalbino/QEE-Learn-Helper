package ep2.View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class JanelaPrincipal extends JFrame {

	private JPanel mainPane;


	public JanelaPrincipal() {
		setResizable(false);
		mainPane = new JPanel();
		JPanel contentPanel = new JPanel();
		JInternalFrame menuFrame = new JInternalFrame("Menu");
		JButton btnSDH = new JButton("Simular Distor\u00E7\u00E3o Harm\u00F4nica");
		JButton btnSFPF = new JButton("Simular Fluxo de Pot\u00EAncia Fundamental");
		JButton btnSFPH = new JButton("Simular Fluxo de Pot\u00EAncia Harm\u00F4nico");
		contentPanel.setBackground(SystemColor.activeCaption);
		
		setTitle("APRENDA QEE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPane);
		mainPane.setLayout(null);
		JPanel titlePanel = new JPanel();
		JSeparator separator = new JSeparator();
		JLabel lblTitle = new JLabel("AprendaQEE");
		titlePanel.setBackground(SystemColor.inactiveCaption);
		
		titlePanel.setBounds(0, 0, 784, 75);
		mainPane.add(titlePanel);
		titlePanel.setLayout(null);
		
		separator.setBackground(SystemColor.activeCaptionBorder);
		separator.setForeground(SystemColor.activeCaptionBorder);
		separator.setBounds(0, 73, 800, 4);
		titlePanel.add(separator);
		
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
		lblTitle.setBounds(250, 20, 384, 35);
		titlePanel.add(lblTitle);
		
		contentPanel.setBounds(0, 75, 784, 487);
		mainPane.add(contentPanel);
		contentPanel.setLayout(null);
		
		menuFrame.setVisible(true);
		menuFrame.setBounds(114, 30, 584, 387);
		contentPanel.add(menuFrame);
		menuFrame.getContentPane().setLayout(new GridLayout(3, 1, 0, 0));

		menuFrame.getContentPane().add(btnSFPF);
		menuFrame.getContentPane().add(btnSDH);
		menuFrame.getContentPane().add(btnSFPH);
		
		btnSFPF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							JanelaUC2 frame = new JanelaUC2();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		btnSDH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							JanelaUC3 frame = new JanelaUC3();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		

		btnSFPH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuFrame.setVisible(false);
			}
		});
	}
}
