package ep2.View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ep2.Controller.CalculosUC3;
import ep2.Controller.GraphPanel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.InvalidParameterException;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;

@SuppressWarnings("serial")
public class JanelaUC3 extends JFrame {

	GraphPanel graphPanelCompFundamental;
	GraphPanel graphHarmonico1;
	GraphPanel graphHarmonico2;
	GraphPanel graphHarmonico3;
	GraphPanel graphHarmonico4;
	GraphPanel graphHarmonico5;
	GraphPanel graphHarmonico6;
	GraphPanel graphFormaDeOndaDistorcida;
	
	private JPanel contentPane;
	private JTextField textAmplitude;
	private JTextField textAngulo;
	
	CalculosUC3 calcUC3;
	
	private JTextField textNroHarmonicos;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField AmplitudeH1;
	private JTextField AnguloH1;
	private JTextField OrdemH1;
	private JTextField AmplitudeH2;
	private JTextField AnguloH2;
	private JTextField OrdemH2;
	private JTextField AmplitudeH3;
	private JTextField AnguloH3;
	private JTextField OrdemH3;
	private JTextField AmplitudeH4;
	private JTextField AnguloH4;
	private JTextField OrdemH4;
	private JTextField AmplitudeH5;
	private JTextField AnguloH5;
	private JTextField OrdemH5;
	private JTextField AmplitudeH6;
	private JTextField AnguloH6;
	private JTextField OrdemH6;

	/**
	 * Create the frame.
	 */
	public JanelaUC3() {
		JButton btnAplicar_1 = new JButton("Aplicar");
		JPanel panelAplicar2 = new JPanel();
		JPanel panelHarmonico1 = new JPanel();
		JPanel panelHarmonico2 = new JPanel();
		JPanel panelHarmonico3 = new JPanel();
		JPanel panelHarmonico4 = new JPanel();
		JPanel panelHarmonico6 = new JPanel();
		JPanel panelHarmonico5 = new JPanel();
		
		JInternalFrame FrameHarmonicos = new JInternalFrame("Harmônicos");
		
		JButton btnOk = new JButton("Ok");
		
		calcUC3 = new CalculosUC3();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnVoltar.setBounds(10, 11, 89, 23);
		contentPane.add(btnVoltar);
		
		JInternalFrame FrameEntradas = new JInternalFrame("Entradas Componente Fundamental");
		FrameEntradas.setMaximizable(true);
		FrameEntradas.setResizable(true);
		FrameEntradas.setBounds(20, 45, 538, 136);
		contentPane.add(FrameEntradas);
		FrameEntradas.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelEntradas = new JPanel();
		FrameEntradas.getContentPane().add(panelEntradas);
		panelEntradas.setLayout(new GridLayout(4, 0, 0, 0));
		
		JLabel lblEntradas = new JLabel("Entradas");
		lblEntradas.setHorizontalAlignment(SwingConstants.CENTER);
		panelEntradas.add(lblEntradas);
		lblEntradas.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JPanel panelAmplitude = new JPanel();
		panelEntradas.add(panelAmplitude);
		panelAmplitude.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblAmplitude = new JLabel("Amplitude");
		lblAmplitude.setHorizontalAlignment(SwingConstants.CENTER);
		panelAmplitude.add(lblAmplitude);
		
		textAmplitude = new JTextField();
		panelAmplitude.add(textAmplitude);
		textAmplitude.setColumns(10);
		
		JPanel panelAngulo = new JPanel();
		panelEntradas.add(panelAngulo);
		panelAngulo.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblngulo = new JLabel("\u00C2ngulo");
		lblngulo.setHorizontalAlignment(SwingConstants.CENTER);
		panelAngulo.add(lblngulo);
		
		textAngulo = new JTextField();
		panelAngulo.add(textAngulo);
		textAngulo.setColumns(10);
		
		JPanel panelAplicar = new JPanel();
		panelEntradas.add(panelAplicar);
		panelAplicar.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel fillPanel1 = new JPanel();
		panelAplicar.add(fillPanel1);
		
		JPanel fillPanel2 = new JPanel();
		panelAplicar.add(fillPanel2);
		
		JButton btnAplicar = new JButton("Aplicar");
		panelAplicar.add(btnAplicar);
		btnAplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					calcUC3.setAngV(Integer.parseInt(textAngulo.getText()));
					calcUC3.setVrms(Integer.parseInt(textAmplitude.getText()));
					calcUC3.calcular();
					if(graphPanelCompFundamental != null)
						graphPanelCompFundamental.setScores(calcUC3.getFormaDeOndaDaFundamental());
					else {
						graphPanelCompFundamental = new GraphPanel(calcUC3.getFormaDeOndaDaFundamental());	
					}
					btnOk.setEnabled(true);
					FrameHarmonicos.setVisible(true);
				}
				catch(InvalidParameterException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "O valor inserido não é um número!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		JPanel panelGraficoEntradas = new JPanel();
		FrameEntradas.getContentPane().add(panelGraficoEntradas);
		panelGraficoEntradas.setLayout(new GridLayout(1, 1));
		graphPanelCompFundamental = new GraphPanel(calcUC3.getFormaDeOndaDaFundamental());
		panelGraficoEntradas.add(graphPanelCompFundamental);
		
		
		FrameHarmonicos.setMaximizable(true);
		FrameHarmonicos.setResizable(true);
		FrameHarmonicos.setBounds(20, 183, 538, 536);
		contentPane.add(FrameHarmonicos);
		FrameHarmonicos.getContentPane().setLayout(new GridLayout(8, 0, 0, 0));
		
		JPanel panelEntradasHarmonicos = new JPanel();

		panelEntradasHarmonicos.setLayout(new GridLayout(0, 4, 0, 0));
		
		JPanel panelNroHarmonicos = new JPanel();
		panelEntradasHarmonicos.add(panelNroHarmonicos);
		panelNroHarmonicos.setLayout(new GridLayout(2, 0, 0, 0));
		
		JLabel lblNumeroDeHarmonicos = new JLabel("Numero de Harm\u00F4nicos");
		lblNumeroDeHarmonicos.setHorizontalAlignment(SwingConstants.CENTER);
		panelNroHarmonicos.add(lblNumeroDeHarmonicos);
		
		textNroHarmonicos = new JTextField();
		panelNroHarmonicos.add(textNroHarmonicos);
		textNroHarmonicos.setColumns(10);
		
		JPanel fillPanel3 = new JPanel();
		panelEntradasHarmonicos.add(fillPanel3);
		
		JPanel panelTipoHarmonicos = new JPanel();
		panelEntradasHarmonicos.add(panelTipoHarmonicos);
		panelTipoHarmonicos.setLayout(new GridLayout(3, 0, 0, 0));
		
		JLabel lblHarmnicos = new JLabel("Harm\u00F4nicos");
		lblHarmnicos.setHorizontalAlignment(SwingConstants.CENTER);
		panelTipoHarmonicos.add(lblHarmnicos);
		
		JRadioButton rdbtImpares = new JRadioButton("\u00CDmpares");
		rdbtImpares.setSelected(true);
		buttonGroup.add(rdbtImpares);
		panelTipoHarmonicos.add(rdbtImpares);
		
		JRadioButton rdbtnPares = new JRadioButton("Pares");
		buttonGroup.add(rdbtnPares);
		panelTipoHarmonicos.add(rdbtnPares);
		
		JPanel panelOk = new JPanel();
		panelEntradasHarmonicos.add(panelOk);
		panelOk.setLayout(new GridLayout(3, 3, 0, 0));
		
		JPanel fillPanel4 = new JPanel();
		panelOk.add(fillPanel4);
		
		
		btnOk.setEnabled(false);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int value = Integer.parseInt(textNroHarmonicos.getText());
					calcUC3.setNroHarmonicos(value);
					calcUC3.setPar(rdbtnPares.isSelected());
					panelHarmonico1.setVisible(false);
					panelHarmonico2.setVisible(false);
					panelHarmonico3.setVisible(false);
					panelHarmonico4.setVisible(false);
					panelHarmonico5.setVisible(false);
					panelHarmonico6.setVisible(false);
					FrameHarmonicos.getContentPane().removeAll();
					FrameHarmonicos.getContentPane().setLayout(new GridLayout(value+2, 1, 0, 0));
					FrameHarmonicos.getContentPane().add(panelEntradasHarmonicos);
					switch(value) {
					case 6:
						FrameHarmonicos.getContentPane().add(panelHarmonico6);
						panelHarmonico6.setVisible(true);
					case 5:
						FrameHarmonicos.getContentPane().add(panelHarmonico5);
						panelHarmonico5.setVisible(true);
					case 4:
						FrameHarmonicos.getContentPane().add(panelHarmonico4);
						panelHarmonico4.setVisible(true);
					case 3:
						FrameHarmonicos.getContentPane().add(panelHarmonico3);
						panelHarmonico3.setVisible(true);
					case 2:
						FrameHarmonicos.getContentPane().add(panelHarmonico2);
						panelHarmonico2.setVisible(true);
						
					case 1:
						FrameHarmonicos.getContentPane().add(panelHarmonico1);
						panelHarmonico1.setVisible(true);
					}
					FrameHarmonicos.getContentPane().add(panelAplicar2);
					btnAplicar_1.setEnabled(true);
				}
				catch(InvalidParameterException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "O valor inserido não é um número!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panelOk.add(btnOk);
		

		panelHarmonico1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelGraficoHarmonico1 = new JPanel();
		panelHarmonico1.add(panelGraficoHarmonico1);
		panelGraficoHarmonico1.setLayout(new GridLayout(1, 1, 0, 0));
		graphHarmonico1 = new GraphPanel(calcUC3.getFormaDeOndaDaOrdemHarmonicaH1());
		panelGraficoHarmonico1.add(graphHarmonico1);
		graphHarmonico1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panelEntradaHarmonico1 = new JPanel();
		panelEntradaHarmonico1.setBackground(Color.GRAY);
		panelHarmonico1.add(panelEntradaHarmonico1);
		panelEntradaHarmonico1.setLayout(new GridLayout(3, 3, 0, 0));
		
		JLabel lblAmplitude_1 = new JLabel("Amplitude");
		panelEntradaHarmonico1.add(lblAmplitude_1);
		
		AmplitudeH1 = new JTextField();
		panelEntradaHarmonico1.add(AmplitudeH1);
		AmplitudeH1.setColumns(10);
		
		JLabel lblngulo_1 = new JLabel("\u00C2ngulo");
		panelEntradaHarmonico1.add(lblngulo_1);
		
		AnguloH1 = new JTextField();
		panelEntradaHarmonico1.add(AnguloH1);
		AnguloH1.setColumns(10);
		
		JLabel lblOrdemHarmnica = new JLabel("Ordem Harm\u00F4nica");
		panelEntradaHarmonico1.add(lblOrdemHarmnica);
		
		OrdemH1 = new JTextField();
		panelEntradaHarmonico1.add(OrdemH1);
		OrdemH1.setColumns(10);
		FrameHarmonicos.getContentPane().add(panelEntradasHarmonicos);
		
		JInternalFrame FrameGraficoResultado = new JInternalFrame("Forma de onda distorcida resultante ");
		FrameGraficoResultado.setBounds(568, 45, 430, 195);
		contentPane.add(FrameGraficoResultado);
		FrameGraficoResultado.getContentPane().setLayout(new GridLayout(1, 1, 0, 0));
		graphFormaDeOndaDistorcida = new GraphPanel(calcUC3.getFormaDeOndaDistorcidaResultante());
		FrameGraficoResultado.getContentPane().add(graphFormaDeOndaDistorcida);
		
		JInternalFrame FrameFourrier = new JInternalFrame("série de Fourrier");
		FrameFourrier.setBounds(568, 251, 430, 171);
		contentPane.add(FrameFourrier);
		FrameFourrier.getContentPane().setLayout(new GridLayout(1, 1, 0, 0));
		
		JLabel lblSerieFourrier = new JLabel("");
		FrameFourrier.getContentPane().add(lblSerieFourrier);
		FrameFourrier.setVisible(false);
		FrameGraficoResultado.setVisible(false);

		panelHarmonico2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelGraficoHarmonico2 = new JPanel();
		panelHarmonico2.add(panelGraficoHarmonico2);
		panelGraficoHarmonico2.setLayout(new GridLayout(1, 0, 0, 0));
		graphHarmonico2 = new GraphPanel(calcUC3.getFormaDeOndaDaOrdemHarmonicaH2());
		panelGraficoHarmonico2.add(graphHarmonico2);
		
		JPanel panelEntradaHarmonico2 = new JPanel();
		panelEntradaHarmonico2.setBackground(Color.LIGHT_GRAY);
		panelHarmonico2.add(panelEntradaHarmonico2);
		panelEntradaHarmonico2.setLayout(new GridLayout(3, 3, 0, 0));
		
		JLabel label = new JLabel("Amplitude");
		panelEntradaHarmonico2.add(label);
		
		AmplitudeH2 = new JTextField();
		AmplitudeH2.setColumns(10);
		panelEntradaHarmonico2.add(AmplitudeH2);
		
		JLabel label_1 = new JLabel("\u00C2ngulo");
		panelEntradaHarmonico2.add(label_1);
		
		AnguloH2 = new JTextField();
		AnguloH2.setColumns(10);
		panelEntradaHarmonico2.add(AnguloH2);
		
		JLabel label_2 = new JLabel("Ordem Harm\u00F4nica");
		panelEntradaHarmonico2.add(label_2);
		
		OrdemH2 = new JTextField();
		OrdemH2.setColumns(10);
		panelEntradaHarmonico2.add(OrdemH2);

		panelHarmonico3.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelGraficoHarmonico3 = new JPanel();
		panelHarmonico3.add(panelGraficoHarmonico3);
		panelGraficoHarmonico3.setLayout(new GridLayout(1, 0, 0, 0));
		graphHarmonico3 = new GraphPanel(calcUC3.getFormaDeOndaDaOrdemHarmonicaH3());
		panelGraficoHarmonico3.add(graphHarmonico3);
		
		JPanel panelEntradaHarmonico3 = new JPanel();
		panelEntradaHarmonico3.setBackground(Color.GRAY);
		panelHarmonico3.add(panelEntradaHarmonico3);
		panelEntradaHarmonico3.setLayout(new GridLayout(3, 3, 0, 0));
		
		JLabel label_3 = new JLabel("Amplitude");
		panelEntradaHarmonico3.add(label_3);
		
		AmplitudeH3 = new JTextField();
		AmplitudeH3.setColumns(10);
		panelEntradaHarmonico3.add(AmplitudeH3);
		
		JLabel label_4 = new JLabel("\u00C2ngulo");
		panelEntradaHarmonico3.add(label_4);
		
		AnguloH3 = new JTextField();
		AnguloH3.setColumns(10);
		panelEntradaHarmonico3.add(AnguloH3);
		
		JLabel label_5 = new JLabel("Ordem Harm\u00F4nica");
		panelEntradaHarmonico3.add(label_5);
		
		OrdemH3 = new JTextField();
		OrdemH3.setColumns(10);
		panelEntradaHarmonico3.add(OrdemH3);

		panelHarmonico4.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelGraficoHarmonico4 = new JPanel();
		panelHarmonico4.add(panelGraficoHarmonico4);
		panelGraficoHarmonico4.setLayout(new GridLayout(1, 0, 0, 0));
		graphHarmonico4 = new GraphPanel(calcUC3.getFormaDeOndaDaOrdemHarmonicaH4());
		panelGraficoHarmonico4.add(graphHarmonico4);
		
		JPanel panelEntradaHarmonico4 = new JPanel();
		panelEntradaHarmonico4.setBackground(Color.LIGHT_GRAY);
		panelHarmonico4.add(panelEntradaHarmonico4);
		panelEntradaHarmonico4.setLayout(new GridLayout(3, 3, 0, 0));
		
		JLabel label_6 = new JLabel("Amplitude");
		panelEntradaHarmonico4.add(label_6);
		
		AmplitudeH4 = new JTextField();
		AmplitudeH4.setColumns(10);
		panelEntradaHarmonico4.add(AmplitudeH4);
		
		JLabel label_7 = new JLabel("\u00C2ngulo");
		panelEntradaHarmonico4.add(label_7);
		
		AnguloH4 = new JTextField();
		AnguloH4.setColumns(10);
		panelEntradaHarmonico4.add(AnguloH4);
		
		JLabel label_8 = new JLabel("Ordem Harm\u00F4nica");
		panelEntradaHarmonico4.add(label_8);
		
		OrdemH4 = new JTextField();
		OrdemH4.setColumns(10);
		panelEntradaHarmonico4.add(OrdemH4);

		panelHarmonico5.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelGraficoHarmonico5 = new JPanel();
		panelHarmonico5.add(panelGraficoHarmonico5);
		panelGraficoHarmonico5.setLayout(new GridLayout(1, 0, 0, 0));
		graphHarmonico5 = new GraphPanel(calcUC3.getFormaDeOndaDaOrdemHarmonicaH5());
		panelGraficoHarmonico5.add(graphHarmonico5);
		
		JPanel panelEntradaHarmonico5 = new JPanel();
		panelEntradaHarmonico5.setBackground(Color.GRAY);
		panelHarmonico5.add(panelEntradaHarmonico5);
		panelEntradaHarmonico5.setLayout(new GridLayout(3, 3, 0, 0));
		
		JLabel label_9 = new JLabel("Amplitude");
		panelEntradaHarmonico5.add(label_9);
		
		AmplitudeH5 = new JTextField();
		AmplitudeH5.setColumns(10);
		panelEntradaHarmonico5.add(AmplitudeH5);
		
		JLabel label_10 = new JLabel("\u00C2ngulo");
		panelEntradaHarmonico5.add(label_10);
		
		AnguloH5 = new JTextField();
		AnguloH5.setColumns(10);
		panelEntradaHarmonico5.add(AnguloH5);
		
		JLabel label_11 = new JLabel("Ordem Harm\u00F4nica");
		panelEntradaHarmonico5.add(label_11);
		
		OrdemH5 = new JTextField();
		OrdemH5.setColumns(10);
		panelEntradaHarmonico5.add(OrdemH5);

		
		panelHarmonico6.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelGraficoHarmonico6 = new JPanel();
		panelHarmonico6.add(panelGraficoHarmonico6);
		panelGraficoHarmonico6.setLayout(new GridLayout(1, 0, 0, 0));
		graphHarmonico6 = new GraphPanel(calcUC3.getFormaDeOndaDaOrdemHarmonicaH6());
		FlowLayout flowLayout = (FlowLayout) graphHarmonico6.getLayout();
		flowLayout.setAlignOnBaseline(true);
		panelGraficoHarmonico6.add(graphHarmonico6);
		
		JPanel panelEntradaHarmonico6 = new JPanel();
		panelEntradaHarmonico6.setBackground(Color.LIGHT_GRAY);
		panelHarmonico6.add(panelEntradaHarmonico6);
		panelEntradaHarmonico6.setLayout(new GridLayout(3, 3, 0, 0));
		
		JLabel label_12 = new JLabel("Amplitude");
		panelEntradaHarmonico6.add(label_12);
		
		AmplitudeH6 = new JTextField();
		AmplitudeH6.setColumns(10);
		panelEntradaHarmonico6.add(AmplitudeH6);
		
		JLabel label_13 = new JLabel("\u00C2ngulo");
		panelEntradaHarmonico6.add(label_13);
		
		AnguloH6 = new JTextField();
		AnguloH6.setColumns(10);
		panelEntradaHarmonico6.add(AnguloH6);
		
		JLabel label_14 = new JLabel("Ordem Harm\u00F4nica");
		panelEntradaHarmonico6.add(label_14);
		
		OrdemH6 = new JTextField();
		OrdemH6.setColumns(10);
		panelEntradaHarmonico6.add(OrdemH6);
		
		

		panelAplicar2.setLayout(new GridLayout(0, 6, 0, 0));
		
		JPanel panel = new JPanel();
		panelAplicar2.add(panel);
		
		JPanel panel_1 = new JPanel();
		panelAplicar2.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panelAplicar2.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panelAplicar2.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panelAplicar2.add(panel_4);
		
		
		btnAplicar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String fourrier = "";
					int value = Integer.parseInt(textNroHarmonicos.getText());
					int ordemHarmonica[] = new int[value];
					double vrmsh[] = new double[value];
					double angVh[] = new double[value];
					fourrier = String.format("f(t) = %scos(wt+%s)",textAmplitude.getText(), textAngulo.getText());
					switch(value) {
					case 6:
						ordemHarmonica[5] = Integer.parseInt(OrdemH6.getText());
						vrmsh[5] = Double.parseDouble(AmplitudeH6.getText());
						angVh[5] = Double.parseDouble(AnguloH6.getText());
						if(!AnguloH6.getText().contains("-")){
							AnguloH6.setText(String.format("%c%s",'+', AnguloH6.getText()));
						}
						fourrier += String.format(" + %scos(%swt%s)",AmplitudeH6.getText(),OrdemH6.getText() ,AnguloH6.getText());
					case 5:
						ordemHarmonica[4] = Integer.parseInt(OrdemH5.getText());
						vrmsh[4] = Double.parseDouble(AmplitudeH5.getText());
						angVh[4] = Double.parseDouble(AnguloH5.getText());
						if(!AnguloH5.getText().contains("-")){
							AnguloH5.setText(String.format("%c%s",'+', AnguloH5.getText()));
						}
						
						fourrier += String.format(" + %scos(%swt%s)",AmplitudeH5.getText(),OrdemH5.getText() ,AnguloH5.getText());
					case 4:
						ordemHarmonica[3] = Integer.parseInt(OrdemH4.getText());
						vrmsh[3] = Double.parseDouble(AmplitudeH4.getText());
						angVh[3] = Double.parseDouble(AnguloH4.getText());
						if(!AnguloH4.getText().contains("-")){
							AnguloH4.setText(String.format("%c%s",'+', AnguloH4.getText()));
						}
						fourrier += String.format(" + %scos(%swt%s)",AmplitudeH4.getText(),OrdemH4.getText() ,AnguloH4.getText());
					case 3:
						ordemHarmonica[2] = Integer.parseInt(OrdemH3.getText());
						vrmsh[2] = Double.parseDouble(AmplitudeH3.getText());
						angVh[2] = Double.parseDouble(AnguloH3.getText());
						if(!AnguloH3.getText().contains("-")){
							AnguloH3.setText(String.format("%c%s",'+', AnguloH3.getText()));
						}
						fourrier += String.format(" + %scos(%swt%s)",AmplitudeH3.getText(),OrdemH3.getText() ,AnguloH3.getText());
					case 2:
						ordemHarmonica[1] = Integer.parseInt(OrdemH2.getText());
						vrmsh[1] = Double.parseDouble(AmplitudeH2.getText());
						angVh[1] = Double.parseDouble(AnguloH2.getText());
						if(!AnguloH2.getText().contains("-")){
							AnguloH2.setText(String.format("%c%s",'+', AnguloH2.getText()));
						}
						fourrier += String.format(" + %scos(%swt%s)",AmplitudeH2.getText(),OrdemH2.getText() ,AnguloH2.getText());
					case 1:
						ordemHarmonica[0] = Integer.parseInt(OrdemH1.getText());
						vrmsh[0] = Double.parseDouble(AmplitudeH1.getText());
						angVh[0] = Double.parseDouble(AnguloH1.getText());
						if(!AnguloH1.getText().contains("-")){
							AnguloH1.setText(String.format("%c%s",'+', AnguloH1.getText()));
						}
						fourrier += String.format(" + %scos(%swt%s)",AmplitudeH1.getText(),OrdemH1.getText() ,AnguloH1.getText());
					}
					calcUC3.setOrdemHarmonica(ordemHarmonica);
					calcUC3.setAngVh(angVh);
					calcUC3.setVrmsh(vrmsh);
					calcUC3.calcular();
					if(graphHarmonico1 != null)
						graphHarmonico1.setScores(calcUC3.getFormaDeOndaDaOrdemHarmonicaH1());
					else {
						graphHarmonico1 = new GraphPanel(calcUC3.getFormaDeOndaDaOrdemHarmonicaH1());	
					}
					if(graphHarmonico2 != null)
						graphHarmonico2.setScores(calcUC3.getFormaDeOndaDaOrdemHarmonicaH2());
					else {
						graphHarmonico2 = new GraphPanel(calcUC3.getFormaDeOndaDaOrdemHarmonicaH2());	
					}
					if(graphHarmonico3 != null)
						graphHarmonico3.setScores(calcUC3.getFormaDeOndaDaOrdemHarmonicaH3());
					else {
						graphHarmonico3 = new GraphPanel(calcUC3.getFormaDeOndaDaOrdemHarmonicaH3());	
					}
					if(graphHarmonico4 != null)
						graphHarmonico4.setScores(calcUC3.getFormaDeOndaDaOrdemHarmonicaH4());
					else {
						graphHarmonico4 = new GraphPanel(calcUC3.getFormaDeOndaDaOrdemHarmonicaH4());	
					}
					if(graphHarmonico5 != null)
						graphHarmonico5.setScores(calcUC3.getFormaDeOndaDaOrdemHarmonicaH5());
					else {
						graphHarmonico5 = new GraphPanel(calcUC3.getFormaDeOndaDaOrdemHarmonicaH5());	
					}
					if(graphHarmonico6 != null)
						graphHarmonico6.setScores(calcUC3.getFormaDeOndaDaOrdemHarmonicaH6());
					else {
						graphHarmonico6 = new GraphPanel(calcUC3.getFormaDeOndaDaOrdemHarmonicaH6());	
					}
					graphFormaDeOndaDistorcida.setScores(calcUC3.getFormaDeOndaDistorcidaResultante());
					FrameGraficoResultado.setVisible(true);
					lblSerieFourrier.setText(fourrier);
					FrameFourrier.setVisible(true);
				}
				catch(InvalidParameterException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "O valor inserido não é um número!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnAplicar_1.setEnabled(false);
		panelAplicar2.add(btnAplicar_1);
		
		panelHarmonico1.setVisible(false);
		panelHarmonico2.setVisible(false);
		panelHarmonico3.setVisible(false);
		panelHarmonico4.setVisible(false);
		panelHarmonico5.setVisible(false);
		panelHarmonico6.setVisible(false);
		
		FrameHarmonicos.setVisible(false);
		FrameEntradas.setVisible(true);
	}
}
