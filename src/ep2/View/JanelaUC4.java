package ep2.View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ep2.Controller.CalculosUC4;
import ep2.Controller.GraphPanel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;

import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class JanelaUC4 extends JFrame {

	private CalculosUC4 calcUC4;
	
	private GraphPanel graficoCorrente;
	private GraphPanel graficoTensao;
	private GraphPanel graficoPotenciaHarmInst;
	
	private JPanel contentPane;
	private JTextField txtDicaClicarNo;
	private JTextField textAmplitudeCorrente;
	private JTextField textAnguloCorrente;
	private JTextField textAmplitudeTensao;
	private JTextField textOrdemHarmonicaCorrente;
	private JTextField textAnguloTensao;
	private JTextField textPotLiq;
	private JTextField textPotDis;
	private JTextField textTPF;

	public JanelaUC4() {
		calcUC4 = new CalculosUC4();
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1024, 768);
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
		
		txtDicaClicarNo = new JTextField();
		txtDicaClicarNo.setHorizontalAlignment(SwingConstants.CENTER);
		txtDicaClicarNo.setText("Dica: Clicar no gr\u00E1fico ir\u00E1 expandi-lo!");
		txtDicaClicarNo.setBounds(384, 541, 239, 20);
		contentPane.add(txtDicaClicarNo);
		txtDicaClicarNo.setColumns(10);
		
		JInternalFrame EntradasFrame = new JInternalFrame("Entradas");
		EntradasFrame.setBounds(10, 45, 988, 243);
		contentPane.add(EntradasFrame);
		EntradasFrame.getContentPane().setLayout(null);
		
		JPanel panelEntradas = new JPanel();
		panelEntradas.setBounds(0, 0, 972, 173);
		EntradasFrame.getContentPane().add(panelEntradas);
		graficoTensao = new GraphPanel(calcUC4.getFormaDeOndaTensao());
		graficoTensao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							GraficoExpandido frame = new GraficoExpandido(calcUC4.getFormaDeOndaTensao());
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		panelEntradas.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelTensao = new JPanel();
		panelEntradas.add(panelTensao);
		panelTensao.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelGraficoTensao = new JPanel();
		panelTensao.add(panelGraficoTensao);
		panelGraficoTensao.setLayout(new GridLayout(1, 1));
		panelGraficoTensao.add(graficoTensao);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Tensão", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTensao.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelValoresTensao = new JPanel();
		panel_4.add(panelValoresTensao);
		panelValoresTensao.setLayout(new GridLayout(4, 2, 0, 0));
		
		JLabel label = new JLabel("Amplitude");
		panelValoresTensao.add(label);
		
		textAmplitudeTensao = new JTextField();
		panelValoresTensao.add(textAmplitudeTensao);
		textAmplitudeTensao.setColumns(10);
		
		JLabel lblngulo_1 = new JLabel("\u00C2ngulo");
		panelValoresTensao.add(lblngulo_1);
		
		textAnguloTensao = new JTextField();
		panelValoresTensao.add(textAnguloTensao);
		textAnguloTensao.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panelValoresTensao.add(panel_1);
		
		JPanel panel_3 = new JPanel();
		panelValoresTensao.add(panel_3);
		
		JPanel panel_2 = new JPanel();
		panelValoresTensao.add(panel_2);
		
		JButton btnAplicarTensao = new JButton("Aplicar");
		btnAplicarTensao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					double valorAmpTensao, valorAngTensao;
					valorAmpTensao = Double.parseDouble(textAmplitudeTensao.getText());
					valorAngTensao = Double.parseDouble(textAnguloTensao.getText());
					calcUC4.setAmplitudeTensao(valorAmpTensao);
					calcUC4.setAnguloTensao(valorAngTensao);
					calcUC4.calcular();
					graficoTensao.setScores(calcUC4.getFormaDeOndaTensao());
				}				
				catch(InvalidParameterException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "O valor inserido não é um número!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panelValoresTensao.add(btnAplicarTensao);
		
		graficoCorrente = new GraphPanel(calcUC4.getFormaDeOndaCorrente());
		graficoCorrente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							GraficoExpandido frame = new GraficoExpandido(calcUC4.getFormaDeOndaCorrente());
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		JPanel panelCorrente = new JPanel();
		panelEntradas.add(panelCorrente);
		panelCorrente.setLayout(new GridLayout(1, 2, 5, 5));
		
		JPanel panelGraficoCorrente = new JPanel();
		panelCorrente.add(panelGraficoCorrente);
		panelGraficoCorrente.setLayout(new GridLayout(1,1, 0, 0));
		panelGraficoCorrente.add(graficoCorrente);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Corrente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCorrente.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelValoresCorrente = new JPanel();
		panel_5.add(panelValoresCorrente);
		panelValoresCorrente.setLayout(new GridLayout(4, 2, 0, 0));
		
		JLabel lblAmplitude = new JLabel("Amplitude");
		panelValoresCorrente.add(lblAmplitude);
		
		textAmplitudeCorrente = new JTextField();
		panelValoresCorrente.add(textAmplitudeCorrente);
		textAmplitudeCorrente.setColumns(10);
		
		JLabel lblngulo = new JLabel("\u00C2ngulo");
		panelValoresCorrente.add(lblngulo);
		
		textAnguloCorrente = new JTextField();
		panelValoresCorrente.add(textAnguloCorrente);
		textAnguloCorrente.setColumns(10);
		
		JLabel lblordem = new JLabel("Ordem Harm\u00F4nica");
		panelValoresCorrente.add(lblordem);
		
		textOrdemHarmonicaCorrente = new JTextField();
		panelValoresCorrente.add(textOrdemHarmonicaCorrente);
		textOrdemHarmonicaCorrente.setColumns(10);
		
		JPanel panel = new JPanel();
		panelValoresCorrente.add(panel);
		
		JButton btnAplicarCorrente = new JButton("Aplicar");
		btnAplicarCorrente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					double valorAmpCorrente, valorAngCorrente, valorOrdemHarmonica;
					valorAmpCorrente = Double.parseDouble(textAmplitudeCorrente.getText());
					valorAngCorrente = Double.parseDouble(textAnguloCorrente.getText());
					valorOrdemHarmonica = Double.parseDouble(textOrdemHarmonicaCorrente.getText());
					calcUC4.setAmplitudeCorrente(valorAmpCorrente);
					calcUC4.setAnguloCorrente(valorAngCorrente);
					calcUC4.setOrdemHarmonicaCorrente(valorOrdemHarmonica);
					calcUC4.calcular();
					graficoCorrente.setScores(calcUC4.getFormaDeOndaCorrente());
				}				
				catch(InvalidParameterException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "O valor inserido não é um número!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panelValoresCorrente.add(btnAplicarCorrente);
		
		JButton btnSimular = new JButton("Simular");
		btnSimular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					double valorAmpCorrente, valorAngCorrente, valorOrdemHarmonica, valorAmpTensao, valorAngTensao;
					valorAmpTensao = Double.parseDouble(textAmplitudeTensao.getText());
					valorAngTensao = Double.parseDouble(textAnguloTensao.getText());
					valorAmpCorrente = Double.parseDouble(textAmplitudeCorrente.getText());
					valorAngCorrente = Double.parseDouble(textAnguloCorrente.getText());
					valorOrdemHarmonica = Double.parseDouble(textOrdemHarmonicaCorrente.getText());
					calcUC4.setAmplitudeTensao(valorAmpTensao);
					calcUC4.setAnguloTensao(valorAngTensao);
					calcUC4.setAmplitudeCorrente(valorAmpCorrente);
					calcUC4.setAnguloCorrente(valorAngCorrente);
					calcUC4.setOrdemHarmonicaCorrente(valorOrdemHarmonica);
					calcUC4.calcular();
					graficoCorrente.setScores(calcUC4.getFormaDeOndaCorrente());
					graficoTensao.setScores(calcUC4.getFormaDeOndaTensao());
					graficoPotenciaHarmInst.setScores(calcUC4.getFormaDeOndaPotHarmInst());
				}				
				catch(InvalidParameterException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "O valor inserido não é um número!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSimular.setBounds(428, 180, 116, 23);
		EntradasFrame.getContentPane().add(btnSimular);
		
		JInternalFrame internalFrame = new JInternalFrame("Resultados");
		internalFrame.setBounds(176, 299, 655, 226);
		contentPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(new GridLayout(1, 0, 10, 0));
		
		JPanel panelGraficoPotInst = new JPanel();
		internalFrame.getContentPane().add(panelGraficoPotInst);
		panelGraficoPotInst.setLayout(new GridLayout(1, 1, 0, 0));
		graficoPotenciaHarmInst = new GraphPanel(new ArrayList<>());
		panelGraficoPotInst.add(graficoPotenciaHarmInst);
		
		JPanel panelResultados = new JPanel();
		internalFrame.getContentPane().add(panelResultados);
		panelResultados.setLayout(null);
		
		JLabel lblPotnciaLiquida = new JLabel("Pot\u00EAncia Liquida:");
		lblPotnciaLiquida.setBounds(36, 46, 117, 14);
		panelResultados.add(lblPotnciaLiquida);
		
		textPotLiq = new JTextField();
		textPotLiq.setEditable(false);
		textPotLiq.setBounds(181, 43, 117, 20);
		panelResultados.add(textPotLiq);
		textPotLiq.setColumns(10);
		
		JLabel lblPotDeDist = new JLabel("Pot\u00EAncia de distor\u00E7\u00E3o:");
		lblPotDeDist.setBounds(36, 91, 117, 14);
		panelResultados.add(lblPotDeDist);
		
		textPotDis = new JTextField();
		textPotDis.setEditable(false);
		textPotDis.setBounds(181, 88, 117, 20);
		panelResultados.add(textPotDis);
		textPotDis.setColumns(10);
		
		JLabel lblTpf = new JLabel("TPF:");
		lblTpf.setBounds(36, 133, 117, 14);
		panelResultados.add(lblTpf);
		
		textTPF = new JTextField();
		textTPF.setEditable(false);
		textTPF.setBounds(181, 130, 117, 20);
		panelResultados.add(textTPF);
		textTPF.setColumns(10);
		internalFrame.setVisible(true);
		EntradasFrame.setVisible(true);
	}
}
