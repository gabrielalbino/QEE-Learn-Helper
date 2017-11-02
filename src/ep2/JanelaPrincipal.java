package ep2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import java.awt.GridLayout;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

@SuppressWarnings("serial")
public class JanelaPrincipal extends JFrame {

	private JPanel mainPane;
	private JTextField textAmplitudeTensao;
	private JTextField textAmplitudeCorrente;

	public JanelaPrincipal() {
		mainPane = new JPanel();
		JPanel contentPanel = new JPanel();
		JInternalFrame menuFrame = new JInternalFrame("Menu");
		JButton btnSDH = new JButton("Simular Distor\u00E7\u00E3o Harm\u00F4nica");
		JButton btnSFPF = new JButton("Simular Fluxo de Pot\u00EAncia Fundamental");
		JButton btnSFPH = new JButton("Simular Fluxo de Pot\u00EAncia Harm\u00F4nico");
		JSlider sliderAmplitudeTensao = new JSlider();
		JPanel panelAmplitudeTensao = new JPanel();
		JInternalFrame EntradasTensaoFrame = new JInternalFrame("Entradas Tens\u00E3o");
		JPanel panelEntradas = new JPanel();
		JInternalFrame SFPFFrame = new JInternalFrame("Simular Fluxo de Pot\u00EAncia Fundamental");
		textAmplitudeTensao = new JTextField();

		JPanel panelAnguloTensao = new JPanel();
		JSpinner spinnerAnguloTensao = new JSpinner();
		JInternalFrame EntradasCorrenteFrame = new JInternalFrame("Entradas Corrente");
		JPanel panelAnguloCorrente = new JPanel();
		JSpinner spinnerAnguloCorrente = new JSpinner();
		JPanel panelAmplitudeCorrente = new JPanel();
		JSlider sliderAmplitudeCorrente = new JSlider();

		textAmplitudeCorrente = new JTextField();
	
		
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
		
		menuFrame.setVisible(false);
		//menuFrame.setBounds(114, 30, 584, 387);
		menuFrame.setBounds(114, 441, 584, 387);
		contentPanel.add(menuFrame);
		menuFrame.getContentPane().setLayout(new GridLayout(3, 1, 0, 0));

		menuFrame.getContentPane().add(btnSFPF);
		menuFrame.getContentPane().add(btnSDH);
		menuFrame.getContentPane().add(btnSFPH);

		SFPFFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		SFPFFrame.setResizable(true);
		SFPFFrame.setMaximizable(true);
		SFPFFrame.setBounds(114, 30, 584, 387);
		contentPanel.add(SFPFFrame);
		SFPFFrame.getContentPane().setLayout(new GridLayout(3, 0, 0, 0));
		
		SFPFFrame.getContentPane().add(panelEntradas);
		panelEntradas.setLayout(new GridLayout(0, 2, 0, 0));
		
		panelEntradas.add(EntradasTensaoFrame);
		EntradasTensaoFrame.getContentPane().setLayout(null);
		
		panelAmplitudeTensao.setBorder(new TitledBorder(null, "Amplitude", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelAmplitudeTensao.setBounds(6, 5, 254, 40);
		EntradasTensaoFrame.getContentPane().add(panelAmplitudeTensao);
		panelAmplitudeTensao.setLayout(null);
		
		sliderAmplitudeTensao.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				textAmplitudeTensao.setText(Integer.toString(sliderAmplitudeTensao.getValue()));
			}
		});
		sliderAmplitudeTensao.setValue(0);
		sliderAmplitudeTensao.setMaximum(220);
		sliderAmplitudeTensao.setBounds(10, 15, 150, 17);
		panelAmplitudeTensao.add(sliderAmplitudeTensao);

		
		textAmplitudeTensao.setBounds(164, 15, 70, 17);
		panelAmplitudeTensao.add(textAmplitudeTensao);
		textAmplitudeTensao.setColumns(10);
		textAmplitudeTensao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int value = 0;
				try {
					value = Integer.parseInt(textAmplitudeTensao.getText());
				}catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "O valor deve ser um número!", "Entrada inválida!", JOptionPane.ERROR_MESSAGE);
					textAmplitudeTensao.setText(Integer.toString(sliderAmplitudeTensao.getValue()));
					value = sliderAmplitudeTensao.getValue();
				}
				if(value < 0 || value > 220) {
					JOptionPane.showMessageDialog(null, "O valor deve estar entre 0 e 220!", "Entrada inválida!", JOptionPane.ERROR_MESSAGE);
					textAmplitudeTensao.setText(Integer.toString(sliderAmplitudeTensao.getValue()));
				}
				else {
					sliderAmplitudeTensao.setValue(value);
				}
			}
		});
		
		panelAnguloTensao.setLayout(null);
		panelAnguloTensao.setBorder(new TitledBorder(null, "Ângulo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelAnguloTensao.setBounds(6, 45, 254, 40);
		EntradasTensaoFrame.getContentPane().add(panelAnguloTensao);

		spinnerAnguloTensao.setBounds(100, 15, 54, 17);
		panelAnguloTensao.add(spinnerAnguloTensao);

		panelEntradas.add(EntradasCorrenteFrame);
		EntradasCorrenteFrame.getContentPane().setLayout(null);

		panelAnguloCorrente.setLayout(null);
		panelAnguloCorrente.setBorder(new TitledBorder(null, "Ângulo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelAnguloCorrente.setBounds(6, 45, 254, 40);
		EntradasCorrenteFrame.getContentPane().add(panelAnguloCorrente);

		spinnerAnguloCorrente.setBounds(100, 15, 54, 17);
		panelAnguloCorrente.add(spinnerAnguloCorrente);

		panelAmplitudeCorrente.setLayout(null);
		panelAmplitudeCorrente.setBorder(new TitledBorder(null, "Amplitude", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelAmplitudeCorrente.setBounds(6, 5, 254, 40);
		EntradasCorrenteFrame.getContentPane().add(panelAmplitudeCorrente);

		sliderAmplitudeCorrente.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				textAmplitudeCorrente.setText(Integer.toString(sliderAmplitudeCorrente.getValue()));
			}
		});
		sliderAmplitudeCorrente.setBounds(10, 15, 150, 17);
		sliderAmplitudeCorrente.setValue(0);
		panelAmplitudeCorrente.add(sliderAmplitudeCorrente);
		
		textAmplitudeCorrente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int value = 0;
				try {
					value = Integer.parseInt(textAmplitudeCorrente.getText());
				}catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "O valor deve ser um número!", "Entrada inválida!", JOptionPane.ERROR_MESSAGE);
					textAmplitudeCorrente.setText(Integer.toString(sliderAmplitudeCorrente.getValue()));
					value = sliderAmplitudeCorrente.getValue();
				}
				if(value < 0 || value > 100) {
					JOptionPane.showMessageDialog(null, "O valor deve estar entre 0 e 100!", "Entrada inválida!", JOptionPane.ERROR_MESSAGE);
					textAmplitudeCorrente.setText(Integer.toString(sliderAmplitudeCorrente.getValue()));
				}
				else {
					sliderAmplitudeCorrente.setValue(value);
				}
			}
		});
		textAmplitudeCorrente.setBounds(164, 15, 70, 17);
		panelAmplitudeCorrente.add(textAmplitudeCorrente);
		textAmplitudeCorrente.setColumns(10);
		
		
		EntradasCorrenteFrame.setVisible(true);
		EntradasTensaoFrame.setVisible(true);
		
		JPanel panel_1 = new JPanel();
		SFPFFrame.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		SFPFFrame.getContentPane().add(panel_2);
		SFPFFrame.setVisible(true);
		
		btnSFPF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuFrame.setVisible(false);
				
			}
		});
		
		btnSDH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuFrame.setVisible(false);
			}
		});
		

		btnSFPH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuFrame.setVisible(false);
			}
		});
	}
}
