package ep2.View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.InvalidParameterException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import ep2.Controller.CalculosUC2;
import ep2.Controller.GraphPanel;
import ep2.Controller.TrianguloDraw;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class JanelaUC2 extends JFrame {

	GraphPanel graphPanelCorrente;
	GraphPanel graphPanelTensao;
	GraphPanel graphPanelPotInst;
	
	TrianguloDraw triangDraw;
	
	private JPanel contentPane;
	private JTextField textAngTensao;
	private JTextField textAmpTensao;
	private JTextField textAngCorrente;
	private JTextField textAmpCorrente;
	private JTextField textPotAtiva;
	private JTextField textPotReativa;
	private JTextField textPotAparente;
	private JTextField textFatPot;
	/**
	 * Create the frame.
	 */
	public JanelaUC2() {
		triangDraw = new TrianguloDraw(0,0,0,0);
		graphPanelCorrente = null;
		graphPanelTensao = null;
		graphPanelPotInst = null;
		
		CalculosUC2 calcUC2 = new CalculosUC2();
		setResizable(false);
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
		btnVoltar.setBounds(909, 696, 89, 23);
		contentPane.add(btnVoltar);
		
		JInternalFrame FrameResultado = new JInternalFrame("Resultado");
		FrameResultado.setBounds(10, 359, 988, 323);
		contentPane.add(FrameResultado);
		FrameResultado.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelResultadosETriangulo = new JPanel();
		FrameResultado.getContentPane().add(panelResultadosETriangulo);
		panelResultadosETriangulo.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelResultados = new JPanel();
		panelResultadosETriangulo.add(panelResultados);
		panelResultados.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Potência Ativa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(14, 25, 212, 42);
		panelResultados.add(panel_1);
		panel_1.setLayout(null);
		
		textPotAtiva = new JTextField();
		textPotAtiva.setEditable(false);
		textPotAtiva.setBounds(6, 16, 200, 20);
		panel_1.add(textPotAtiva);
		textPotAtiva.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Potência Reativa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(14, 87, 212, 42);
		panelResultados.add(panel_2);
		panel_2.setLayout(null);
		
		textPotReativa = new JTextField();
		textPotReativa.setEditable(false);
		textPotReativa.setBounds(6, 16, 200, 20);
		panel_2.add(textPotReativa);
		textPotReativa.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Potência Aparente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(14, 151, 212, 42);
		panelResultados.add(panel_3);
		panel_3.setLayout(null);
		
		textPotAparente = new JTextField();
		textPotAparente.setEditable(false);
		textPotAparente.setBounds(6, 16, 200, 20);
		panel_3.add(textPotAparente);
		textPotAparente.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Fator de Potência", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(14, 216, 212, 42);
		panelResultados.add(panel_4);
		panel_4.setLayout(null);
		
		textFatPot = new JTextField();
		textFatPot.setEditable(false);
		textFatPot.setBounds(6, 16, 200, 20);
		panel_4.add(textFatPot);
		textFatPot.setColumns(10);
		
		JPanel panelTrianguloPot = new JPanel();
		panelResultadosETriangulo.add(panelTrianguloPot);
		panelTrianguloPot.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "Triangulo de Potências", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(0, 11, 235, 194);
		panelTrianguloPot.add(panel_6);
		panel_6.setLayout(null);
		
		JPanel panelDesenhoTriangulo = new JPanel();
		panelDesenhoTriangulo.setBounds(6, 16, 223, 172);
		panelDesenhoTriangulo.setLayout(new GridLayout(1, 1));
		panelDesenhoTriangulo.add(triangDraw);
		panel_6.add(panelDesenhoTriangulo);
		
		JLabel lblVermelhoPotnciaAtiva = new JLabel("Vermelho: Pot\u00EAncia ativa");
		lblVermelhoPotnciaAtiva.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVermelhoPotnciaAtiva.setForeground(Color.RED);
		lblVermelhoPotnciaAtiva.setBounds(10, 216, 223, 14);
		panelTrianguloPot.add(lblVermelhoPotnciaAtiva);
		
		JLabel lblVerdePotnciaReativa = new JLabel("Verde: Pot\u00EAncia reativa");
		lblVerdePotnciaReativa.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVerdePotnciaReativa.setForeground(Color.GREEN);
		lblVerdePotnciaReativa.setBounds(10, 241, 159, 14);
		panelTrianguloPot.add(lblVerdePotnciaReativa);
		
		JLabel lblAzulPotnciaAparente = new JLabel("Azul: Pot\u00EAncia aparente");
		lblAzulPotnciaAparente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAzulPotnciaAparente.setForeground(Color.BLUE);
		lblAzulPotnciaAparente.setBounds(10, 266, 159, 14);
		panelTrianguloPot.add(lblAzulPotnciaAparente);
		
		JPanel panelGraficoPotenciaInstPrincipal = new JPanel();
		FrameResultado.getContentPane().add(panelGraficoPotenciaInstPrincipal);
		panelGraficoPotenciaInstPrincipal.setLayout(null);
		
		JPanel bordaGraficoPotInst = new JPanel();
		bordaGraficoPotInst.setBorder(new TitledBorder(null, "Forma de onda da potência instantânea:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		bordaGraficoPotInst.setBounds(25, 29, 438, 239);
		panelGraficoPotenciaInstPrincipal.add(bordaGraficoPotInst);
		bordaGraficoPotInst.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 16, 426, 217);
		panel.setLayout(new GridLayout(1, 1));
		graphPanelPotInst = new GraphPanel(calcUC2.getFormaDeOndaPotenciaInstantanea());
		panel.add(graphPanelPotInst);
		bordaGraficoPotInst.add(panel);
		FrameResultado.setVisible(true);
		
		JInternalFrame FrameEntrada = new JInternalFrame("Entradas");
		FrameEntrada.setBounds(10, 11, 988, 337);
		contentPane.add(FrameEntrada);
		FrameEntrada.getContentPane().setLayout(null);
		
		JPanel PanelTensao = new JPanel();
		PanelTensao.setBorder(new TitledBorder(null, "Tensão", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		PanelTensao.setBounds(4, 12, 165, 109);
		FrameEntrada.getContentPane().add(PanelTensao);
		PanelTensao.setLayout(null);
		
		JLabel lblAmplitudeT = new JLabel("Amplitude:");
		lblAmplitudeT.setBounds(6, 19, 65, 14);
		PanelTensao.add(lblAmplitudeT);
		
		JLabel lbAnguloT = new JLabel("\u00C2ngulo:");
		lbAnguloT.setBounds(6, 44, 46, 14);
		PanelTensao.add(lbAnguloT);
		
		textAngTensao = new JTextField();
		textAngTensao.setBounds(70, 40, 86, 20);
		PanelTensao.add(textAngTensao);
		textAngTensao.setColumns(10);
		
		textAmpTensao = new JTextField();
		textAmpTensao.setBounds(70, 16, 86, 20);
		PanelTensao.add(textAmpTensao);
		textAmpTensao.setColumns(10);
		
		JButton btnAplicarTensao = new JButton("Aplicar");
		btnAplicarTensao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					calcUC2.setAngV(Integer.parseInt(textAngTensao.getText()));
					calcUC2.setVrms(Integer.parseInt(textAmpTensao.getText()));
					calcUC2.calcular();
					if(graphPanelTensao != null)
						graphPanelTensao.setScores(calcUC2.getFormaDeOndaTensao());
					else {
						graphPanelTensao = new GraphPanel(calcUC2.getFormaDeOndaTensao());	
					}
				}
				catch(InvalidParameterException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "O valor inserido não é um número!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAplicarTensao.setBounds(66, 75, 89, 23);
		PanelTensao.add(btnAplicarTensao);
		
		JPanel panelCorrente = new JPanel();
		panelCorrente.setLayout(null);
		panelCorrente.setBorder(new TitledBorder(null, "Corrente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCorrente.setBounds(4, 161, 165, 109);
		FrameEntrada.getContentPane().add(panelCorrente);
		
		JLabel label = new JLabel("Amplitude:");
		label.setBounds(6, 19, 62, 14);
		panelCorrente.add(label);
		
		JLabel label_1 = new JLabel("\u00C2ngulo:");
		label_1.setBounds(6, 44, 46, 14);
		panelCorrente.add(label_1);
		
		textAngCorrente = new JTextField();
		textAngCorrente.setColumns(10);
		textAngCorrente.setBounds(70, 40, 86, 20);
		panelCorrente.add(textAngCorrente);
		
		textAmpCorrente = new JTextField();
		textAmpCorrente.setColumns(10);
		textAmpCorrente.setBounds(70, 16, 86, 20);
		panelCorrente.add(textAmpCorrente);
		
		JButton btnAplicarCorrente = new JButton("Aplicar");
		btnAplicarCorrente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					calcUC2.setAngI(Integer.parseInt(textAngCorrente.getText()));
					calcUC2.setIrms(Integer.parseInt(textAmpCorrente.getText()));
					calcUC2.calcular();
					if(graphPanelCorrente != null)
						graphPanelCorrente.setScores(calcUC2.getFormaDeOndaCorrente());
					else {
						graphPanelCorrente = new GraphPanel(calcUC2.getFormaDeOndaCorrente());	
					}
				}
				catch(InvalidParameterException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "O valor inserido não é um número!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAplicarCorrente.setBounds(66, 75, 89, 23);
		panelCorrente.add(btnAplicarCorrente);
		
		JPanel panelGraficos = new JPanel();
		panelGraficos.setBounds(182, 11, 780, 259);
		
		panelGraficos.setLayout(null);
		
		JPanel panelPrincipalGraficoTensao = new JPanel();
		panelPrincipalGraficoTensao.setBorder(new TitledBorder(null, "Forma de onda da tensão:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPrincipalGraficoTensao.setBounds(10, 14, 377, 234);
		panelGraficos.add(panelPrincipalGraficoTensao);
		panelPrincipalGraficoTensao.setLayout(null);
		
		JPanel panelGraficoTensao = new JPanel();
		panelGraficoTensao.setBounds(20, 16, 347, 209);
		panelPrincipalGraficoTensao.add(panelGraficoTensao);
		panelGraficoTensao.setLayout(new GridLayout(1, 1));
		graphPanelTensao = new GraphPanel(calcUC2.getFormaDeOndaTensao());
		panelGraficoTensao.add(graphPanelTensao);
		
		JPanel panelPrincipalGraficoCorrente = new JPanel();
		panelPrincipalGraficoCorrente.setBorder(new TitledBorder(null, "Forma de onda da corrente:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPrincipalGraficoCorrente.setBounds(393, 14, 362, 234);
		panelGraficos.add(panelPrincipalGraficoCorrente);
		panelPrincipalGraficoCorrente.setLayout(null);
		
		JPanel panelGraficoCorrente = new JPanel();
		panelGraficoCorrente.setBounds(6, 16, 348, 208);
		panelPrincipalGraficoCorrente.add(panelGraficoCorrente);
		panelGraficoCorrente.setLayout(new GridLayout(1, 1));
		graphPanelCorrente = new GraphPanel(calcUC2.getFormaDeOndaTensao());
		panelGraficoCorrente.add(graphPanelCorrente);
		
		FrameEntrada.getContentPane().add(panelGraficos);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					calcUC2.setAngI(Integer.parseInt(textAngCorrente.getText()));
					calcUC2.setIrms(Integer.parseInt(textAmpCorrente.getText()));
					calcUC2.setAngV(Integer.parseInt(textAngTensao.getText()));
					calcUC2.setVrms(Integer.parseInt(textAmpTensao.getText()));
					calcUC2.calcular();
					textPotAtiva.setText(String.format("%.2f",calcUC2.getValorPotenciaAtiva()));
					textPotReativa.setText(String.format("%.2f",calcUC2.getValorPotenciaReativa()));
					textPotAparente.setText(String.format("%.2f",calcUC2.getValorPotenciaAparente()));
					textFatPot.setText(String.format("%.2f",calcUC2.getValorDoFatorDePotencia()));
					if(graphPanelCorrente != null)
						graphPanelCorrente.setScores(calcUC2.getFormaDeOndaCorrente());
					else {
						graphPanelCorrente = new GraphPanel(calcUC2.getFormaDeOndaCorrente());	
					}
					if(graphPanelTensao != null)
						graphPanelTensao.setScores(calcUC2.getFormaDeOndaTensao());
					else {
						graphPanelTensao = new GraphPanel(calcUC2.getFormaDeOndaTensao());	
					}
					if(graphPanelPotInst != null)
						graphPanelPotInst.setScores(calcUC2.getFormaDeOndaPotenciaInstantanea());
					else {
						graphPanelPotInst = new GraphPanel(calcUC2.getFormaDeOndaPotenciaInstantanea());	
					}
					if(triangDraw != null) {
						triangDraw.refazTriangulo(calcUC2.getValorPotenciaAtiva(), calcUC2.getValorPotenciaReativa(), calcUC2.getValorPotenciaAparente(), calcUC2.getAngV()-calcUC2.getAngI());
					}
				}
				catch(InvalidParameterException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "O valor inserido não é um número!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCalcular.setBounds(467, 274, 89, 23);
		FrameEntrada.getContentPane().add(btnCalcular);

		FrameEntrada.setVisible(true);
	}
}
