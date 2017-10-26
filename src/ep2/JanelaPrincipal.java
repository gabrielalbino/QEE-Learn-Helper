package ep2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class JanelaPrincipal extends JFrame {

	private JPanel contentPane;

	public JanelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("APRENDA QEE");
		title.setFont(new Font("Serif", Font.PLAIN, 27));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(24, 16, 300, 40);
		contentPane.add(title);
		
		JButton btnSFPH = new JButton("Simular fluxo de pot\u00EAncia harm\u00F4nico");
		btnSFPH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnSFPH.setBounds(50, 80, 250, 40);
		contentPane.add(btnSFPH);
		
		JButton btnSFPF = new JButton("Simular fluxo de pot\u00EAncia fundamental ");
		btnSFPF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSFPF.setBounds(50, 140, 250, 40);
		contentPane.add(btnSFPF);
		
		JButton btnSDH = new JButton("Simular distor\u00E7\u00E3o harm\u00F4nica");
		btnSDH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSDH.setBounds(50, 200, 250, 40);
		contentPane.add(btnSDH);
	}

}
