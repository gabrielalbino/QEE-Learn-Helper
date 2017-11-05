package ep2.View;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ep2.Controller.CalculaFormaOnda;
import ep2.Controller.GraphPanel;
import ep2.Controller.calculaValorPotencia;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class JanelaUC2 extends JFrame {

	private JPanel contentPane;
	private JTextField textPotAtiva;
	private JTextField textPotReativa;
	private JTextField textPotAparente;
	private JTextField textFatorDePotencia;
	
	private List<Double> valoresFOTensao, valoresFOCorrente, valoresFOPotenciaInst;
	private GraphPanel graphPanelTensao, graphPanelCorrente, graphPanelPotenciaInst;
	
	public JanelaUC2() {
		CalculaFormaOnda FOTensao = new CalculaFormaOnda();
		CalculaFormaOnda FOCorrente= new CalculaFormaOnda();
		calculaValorPotencia VPCalculos = new calculaValorPotencia();
		
		graphPanelTensao = new GraphPanel(new ArrayList<>());
		graphPanelCorrente = new GraphPanel(new ArrayList<>());
		graphPanelPotenciaInst = new GraphPanel(new ArrayList<>());
		
		JPanel panelGraficoCorrente = new JPanel();
		panelGraficoCorrente.setLayout(new GridLayout(1, 1, 0, 0));
		JPanel panelGraficoResultado = new JPanel();
		panelGraficoResultado.setLayout(new GridLayout(1, 1, 0, 0));
		JPanel panelGraficoTensao = new JPanel();
		panelGraficoTensao.setLayout(new GridLayout(1, 1, 0, 0));
		
		textPotAtiva = new JTextField();
		textPotReativa = new JTextField();
		textPotAparente = new JTextField();
		textFatorDePotencia = new JTextField();
		
		JPanel contentPanel = new JPanel();
		contentPanel.setBackground(SystemColor.activeCaption);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(SystemColor.activeCaption);
		setContentPane(contentPane);
		setTitle("Simular Fluxo de Pot\u00EAncia Fundamental");
		contentPane.setLayout(null);
		JInternalFrame EntradasTensaoFrame = new JInternalFrame("Entradas Tens\u00E3o");
		EntradasTensaoFrame.setResizable(true);
		EntradasTensaoFrame.setBounds(0, 11, 387, 302);
		contentPane.add(EntradasTensaoFrame);
		EntradasTensaoFrame.getContentPane().setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panelEntradas1 = new JPanel();
		EntradasTensaoFrame.getContentPane().add(panelEntradas1);
		panelEntradas1.setLayout(new GridLayout(2, 0, 0, 0));
		JSlider sliderAmplitudeTensao = new JSlider();
		sliderAmplitudeTensao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				valoresFOTensao = FOTensao.calculaL();
				valoresFOCorrente = FOCorrente.calculaL();
				valoresFOPotenciaInst = FOTensao.calculaFOPI(valoresFOCorrente, valoresFOTensao);
				if (panelGraficoResultado.getComponentCount() > 0) {
					Component c1 = panelGraficoResultado.getComponent(0);
					if (c1 instanceof GraphPanel)
						((GraphPanel) c1).setScores(valoresFOPotenciaInst);
				}
				if(panelGraficoTensao.getComponentCount() > 0) {
					Component c2 = panelGraficoTensao.getComponent(0);
					if (c2 instanceof GraphPanel)
						((GraphPanel) c2).setScores(valoresFOTensao);
				}
				if(panelGraficoCorrente.getComponentCount() > 0) {
					Component c3 = panelGraficoCorrente.getComponent(0);
					if (c3 instanceof GraphPanel)
						((GraphPanel) c3).setScores(valoresFOCorrente);
				}
			}
		});
		JPanel panelAmplitudeTensao = new JPanel();
		panelEntradas1.add(panelAmplitudeTensao);
		
		JTextField textAmplitudeTensao = new JTextField();
		
		panelAmplitudeTensao.setBorder(new TitledBorder(null, "Amplitude", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		sliderAmplitudeTensao.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				textAmplitudeTensao.setText(Integer.toString(sliderAmplitudeTensao.getValue()));
				FOTensao.setVrms(sliderAmplitudeTensao.getValue());
				VPCalculos.setVrms(sliderAmplitudeTensao.getValue());
				textPotAtiva.setText(String.format("%.2f", VPCalculos.calculaA()));
				textPotReativa.setText(String.format("%.2f", VPCalculos.calculaR()));
				textPotAparente.setText(String.format("%.2f", VPCalculos.calculaPotAp()));
				textFatorDePotencia.setText(String.format("%.2f", VPCalculos.calculaFatPot()));
			}
		});
		panelAmplitudeTensao.setLayout(new GridLayout(1, 2, 0, 0));
		sliderAmplitudeTensao.setValue(0);
		sliderAmplitudeTensao.setMaximum(220);
		panelAmplitudeTensao.add(sliderAmplitudeTensao);
		panelAmplitudeTensao.add(textAmplitudeTensao);
		textAmplitudeTensao.setColumns(10);
		JPanel panelAnguloTensao = new JPanel();
		panelEntradas1.add(panelAnguloTensao);
		panelAnguloTensao.setBorder(new TitledBorder(null, "Ângulo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelAnguloTensao.setLayout(new GridLayout(1, 1, 0, 0));
		JSpinner spinnerAnguloTensao = new JSpinner();
		panelAnguloTensao.add(spinnerAnguloTensao);
		spinnerAnguloTensao.setModel(new SpinnerNumberModel(0, null, null, 1));
		
		JButton btnResetTensao = new JButton("reset");
		panelAnguloTensao.add(btnResetTensao);

		panelGraficoTensao.add(graphPanelTensao);
		EntradasTensaoFrame.getContentPane().add(panelGraficoTensao);
		btnResetTensao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sliderAmplitudeTensao.setValue(0);
				textAmplitudeTensao.setText("0");
				spinnerAnguloTensao.setValue(0);
				EntradasTensaoFrame.setBounds(0, 11, 387, 302);
				FOTensao.setVrms(0);
				FOTensao.setAng(0);
				VPCalculos.setAngV(0);
				VPCalculos.setVrms(0);
				textPotAtiva.setText(String.format("%.2f", VPCalculos.calculaA()));
				textPotReativa.setText(String.format("%.2f", VPCalculos.calculaR()));
				textPotAparente.setText(String.format("%.2f", VPCalculos.calculaPotAp()));
				textFatorDePotencia.setText(String.format("%.2f", VPCalculos.calculaFatPot()));
				valoresFOTensao = FOTensao.calculaL();
				valoresFOCorrente = FOCorrente.calculaL();
				valoresFOPotenciaInst = FOTensao.calculaFOPI(valoresFOCorrente, valoresFOTensao);
				if (panelGraficoResultado.getComponentCount() > 0) {
					Component c1 = panelGraficoResultado.getComponent(0);
					if (c1 instanceof GraphPanel)
						((GraphPanel) c1).setScores(valoresFOPotenciaInst);
				}
				if(panelGraficoTensao.getComponentCount() > 0) {
					Component c2 = panelGraficoTensao.getComponent(0);
					if (c2 instanceof GraphPanel)
						((GraphPanel) c2).setScores(valoresFOTensao);
				}
				if(panelGraficoCorrente.getComponentCount() > 0) {
					Component c3 = panelGraficoCorrente.getComponent(0);
					if (c3 instanceof GraphPanel)
						((GraphPanel) c3).setScores(valoresFOCorrente);
				}
			}
		});
		spinnerAnguloTensao.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				int value= (Integer) spinnerAnguloTensao.getValue();
				if(value < -180 || value > 180) {
					JOptionPane.showMessageDialog(null, "O valor deve estar entre -180º e 180º!", "Entrada inválida!", JOptionPane.ERROR_MESSAGE);
					if(value < 0) spinnerAnguloTensao.setValue(-180);
					else spinnerAnguloTensao.setValue(180);
				}
				else {
					//atualizar as variaveis da classe de calculos
					FOTensao.setAng(value);
					VPCalculos.setAngV(value);
					textPotAtiva.setText(String.format("%.2f", VPCalculos.calculaA()));
					textPotReativa.setText(String.format("%.2f", VPCalculos.calculaR()));
					textPotAparente.setText(String.format("%.2f", VPCalculos.calculaPotAp()));
					textFatorDePotencia.setText(String.format("%.2f", VPCalculos.calculaFatPot()));
					valoresFOTensao.clear();
					valoresFOCorrente.clear();
					valoresFOPotenciaInst.clear();
					valoresFOTensao = FOTensao.calculaL();
					valoresFOCorrente = FOCorrente.calculaL();
					valoresFOPotenciaInst = FOTensao.calculaFOPI(valoresFOCorrente, valoresFOTensao);
					if (panelGraficoResultado.getComponentCount() > 0) {
						Component c1 = panelGraficoResultado.getComponent(0);
						if (c1 instanceof GraphPanel)
							((GraphPanel) c1).setScores(valoresFOPotenciaInst);
					}
					if(panelGraficoTensao.getComponentCount() > 0) {
						Component c2 = panelGraficoTensao.getComponent(0);
						if (c2 instanceof GraphPanel)
							((GraphPanel) c2).setScores(valoresFOTensao);
					}
					if(panelGraficoCorrente.getComponentCount() > 0) {
						Component c3 = panelGraficoCorrente.getComponent(0);
						if (c3 instanceof GraphPanel)
							((GraphPanel) c3).setScores(valoresFOCorrente);
					}
				}
			}
		});
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
					FOTensao.setVrms(value);
					VPCalculos.setVrms(value);
					textPotAtiva.setText(String.format("%.2f", VPCalculos.calculaA()));
					textPotReativa.setText(String.format("%.2f", VPCalculos.calculaR()));
					textPotAparente.setText(String.format("%.2f", VPCalculos.calculaPotAp()));
					textFatorDePotencia.setText(String.format("%.2f", VPCalculos.calculaFatPot()));
					valoresFOTensao = FOTensao.calculaL();
					valoresFOCorrente = FOCorrente.calculaL();
					valoresFOPotenciaInst = FOTensao.calculaFOPI(valoresFOCorrente, valoresFOTensao);
					if (panelGraficoResultado.getComponentCount() > 0) {
						Component c1 = panelGraficoResultado.getComponent(0);
						if (c1 instanceof GraphPanel)
							((GraphPanel) c1).setScores(valoresFOPotenciaInst);
					}
					if(panelGraficoTensao.getComponentCount() > 0) {
						Component c2 = panelGraficoTensao.getComponent(0);
						if (c2 instanceof GraphPanel)
							((GraphPanel) c2).setScores(valoresFOTensao);
					}
					if(panelGraficoCorrente.getComponentCount() > 0) {
						Component c3 = panelGraficoCorrente.getComponent(0);
						if (c3 instanceof GraphPanel)
							((GraphPanel) c3).setScores(valoresFOCorrente);
					}
				}
			}
		});
		JInternalFrame EntradasCorrenteFrame = new JInternalFrame("Entradas Corrente");
		EntradasCorrenteFrame.setResizable(true);
		EntradasCorrenteFrame.setBounds(397, 11, 387, 302);
		contentPane.add(EntradasCorrenteFrame);
		EntradasCorrenteFrame.getContentPane().setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panelEntradas2 = new JPanel();
		EntradasCorrenteFrame.getContentPane().add(panelEntradas2);
		panelEntradas2.setLayout(new GridLayout(2, 0, 0, 0));
		JTextField textAmplitudeCorrente = new JTextField();
		JPanel panelAmplitudeCorrente = new JPanel();
		panelEntradas2.add(panelAmplitudeCorrente);
		JSlider sliderAmplitudeCorrente = new JSlider();
		panelAmplitudeCorrente.setBorder(new TitledBorder(null, "Amplitude", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		sliderAmplitudeCorrente.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				textAmplitudeCorrente.setText(Integer.toString(sliderAmplitudeCorrente.getValue()));
						FOCorrente.setVrms(sliderAmplitudeCorrente.getValue());
						VPCalculos.setIrms(sliderAmplitudeCorrente.getValue());
						textPotAtiva.setText(String.format("%.2f", VPCalculos.calculaA()));
						textPotReativa.setText(String.format("%.2f", VPCalculos.calculaR()));
						textPotAparente.setText(String.format("%.2f", VPCalculos.calculaPotAp()));
						textFatorDePotencia.setText(String.format("%.2f", VPCalculos.calculaFatPot()));
						valoresFOTensao = FOTensao.calculaL();
						valoresFOCorrente = FOCorrente.calculaL();
						valoresFOPotenciaInst = FOTensao.calculaFOPI(valoresFOCorrente, valoresFOTensao);
						if (panelGraficoResultado.getComponentCount() > 0) {
							Component c1 = panelGraficoResultado.getComponent(0);
							if (c1 instanceof GraphPanel)
								((GraphPanel) c1).setScores(valoresFOPotenciaInst);
						}
						if(panelGraficoTensao.getComponentCount() > 0) {
							Component c2 = panelGraficoTensao.getComponent(0);
							if (c2 instanceof GraphPanel)
								((GraphPanel) c2).setScores(valoresFOTensao);
						}
						if(panelGraficoCorrente.getComponentCount() > 0) {
							Component c3 = panelGraficoCorrente.getComponent(0);
							if (c3 instanceof GraphPanel)
								((GraphPanel) c3).setScores(valoresFOCorrente);
						}
						//atualizar as variaveis da classe de calculos
			}
		});
		panelAmplitudeCorrente.setLayout(new GridLayout(0, 2, 0, 0));
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
					FOCorrente.setVrms(value);
					VPCalculos.setIrms(value);
					textPotAtiva.setText(String.format("%.2f", VPCalculos.calculaA()));
					textPotReativa.setText(String.format("%.2f", VPCalculos.calculaR()));
					textPotAparente.setText(String.format("%.2f", VPCalculos.calculaPotAp()));
					textFatorDePotencia.setText(String.format("%.2f", VPCalculos.calculaFatPot()));
					valoresFOTensao = FOTensao.calculaL();
					valoresFOCorrente = FOCorrente.calculaL();
					valoresFOPotenciaInst = FOTensao.calculaFOPI(valoresFOCorrente, valoresFOTensao);
					if (panelGraficoResultado.getComponentCount() > 0) {
						Component c1 = panelGraficoResultado.getComponent(0);
						if (c1 instanceof GraphPanel)
							((GraphPanel) c1).setScores(valoresFOPotenciaInst);
					}
					if(panelGraficoTensao.getComponentCount() > 0) {
						Component c2 = panelGraficoTensao.getComponent(0);
						if (c2 instanceof GraphPanel)
							((GraphPanel) c2).setScores(valoresFOTensao);
					}
					if(panelGraficoCorrente.getComponentCount() > 0) {
						Component c3 = panelGraficoCorrente.getComponent(0);
						if (c3 instanceof GraphPanel)
							((GraphPanel) c3).setScores(valoresFOCorrente);
					}
					
					//atualizar as variaveis da classe de calculos
				}
			}
		});
		panelAmplitudeCorrente.add(textAmplitudeCorrente);
		textAmplitudeCorrente.setColumns(10);
		JPanel panelAnguloCorrente = new JPanel();
		panelEntradas2.add(panelAnguloCorrente);
		JSpinner spinnerAnguloCorrente = new JSpinner();
		spinnerAnguloCorrente.setModel(new SpinnerNumberModel(0, null, null, 1));
		spinnerAnguloCorrente.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				int value= (Integer) spinnerAnguloCorrente.getValue();
				if(value < -180 || value > 180) {
					JOptionPane.showMessageDialog(null, "O valor deve estar entre -180º e 180º!", "Entrada inválida!", JOptionPane.ERROR_MESSAGE);
					if(value < 0) spinnerAnguloCorrente.setValue(-180);
					else spinnerAnguloCorrente.setValue(180);
					
				}
				else {
					FOCorrente.setAng(value);
					VPCalculos.setAngI(value);
					
					textPotAtiva.setText(String.format("%.2f", VPCalculos.calculaA()));
					textPotReativa.setText(String.format("%.2f", VPCalculos.calculaR()));
					textPotAparente.setText(String.format("%.2f", VPCalculos.calculaPotAp()));
					textFatorDePotencia.setText(String.format("%.2f", VPCalculos.calculaFatPot()));
					valoresFOTensao = FOTensao.calculaL();
					valoresFOCorrente = FOCorrente.calculaL();
					valoresFOPotenciaInst = FOTensao.calculaFOPI(valoresFOCorrente, valoresFOTensao);
					if (panelGraficoResultado.getComponentCount() > 0) {
						Component c1 = panelGraficoResultado.getComponent(0);
						if (c1 instanceof GraphPanel)
							((GraphPanel) c1).setScores(valoresFOPotenciaInst);
					}
					if(panelGraficoTensao.getComponentCount() > 0) {
						Component c2 = panelGraficoTensao.getComponent(0);
						if (c2 instanceof GraphPanel)
							((GraphPanel) c2).setScores(valoresFOTensao);
					}
					if(panelGraficoCorrente.getComponentCount() > 0) {
						Component c3 = panelGraficoCorrente.getComponent(0);
						if (c3 instanceof GraphPanel)
							((GraphPanel) c3).setScores(valoresFOCorrente);
					}
				}
			}
		});
		panelAnguloCorrente.setBorder(new TitledBorder(null, "Ângulo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelAnguloCorrente.setLayout(new GridLayout(0, 2, 0, 0));
		panelAnguloCorrente.add(spinnerAnguloCorrente);
		
		JButton btnResetCorrente = new JButton("reset");
		btnResetCorrente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EntradasCorrenteFrame.setBounds(397, 11, 387, 302);
				sliderAmplitudeCorrente.setValue(0);
				textAmplitudeCorrente.setText("0");
				spinnerAnguloCorrente.setValue(0);
				FOCorrente.setAng(0);
				VPCalculos.setAngI(0);
				FOCorrente.setVrms(0);
				VPCalculos.setIrms(0);
				textPotAtiva.setText(String.format("%.2f", VPCalculos.calculaA()));
				textPotReativa.setText(String.format("%.2f", VPCalculos.calculaR()));
				textPotAparente.setText(String.format("%.2f", VPCalculos.calculaPotAp()));
				textFatorDePotencia.setText(String.format("%.2f", VPCalculos.calculaFatPot()));
				valoresFOTensao = FOTensao.calculaL();
				valoresFOCorrente = FOCorrente.calculaL();
				valoresFOPotenciaInst = FOTensao.calculaFOPI(valoresFOCorrente, valoresFOTensao);
				if (panelGraficoResultado.getComponentCount() > 0) {
					Component c1 = panelGraficoResultado.getComponent(0);
					if (c1 instanceof GraphPanel)
						((GraphPanel) c1).setScores(valoresFOPotenciaInst);
				}
				if(panelGraficoTensao.getComponentCount() > 0) {
					Component c2 = panelGraficoTensao.getComponent(0);
					if (c2 instanceof GraphPanel)
						((GraphPanel) c2).setScores(valoresFOTensao);
				}
				if(panelGraficoCorrente.getComponentCount() > 0) {
					Component c3 = panelGraficoCorrente.getComponent(0);
					if (c3 instanceof GraphPanel)
						((GraphPanel) c3).setScores(valoresFOCorrente);
				}
			}
		});
		panelAnguloCorrente.add(btnResetCorrente);
		
		panelGraficoCorrente.add(graphPanelCorrente);
		EntradasCorrenteFrame.getContentPane().add(panelGraficoCorrente);
		
		JInternalFrame resultsFrame = new JInternalFrame("Resultados");
		resultsFrame.setResizable(true);
		resultsFrame.setBounds(0, 335, 784, 216);
		contentPane.add(resultsFrame);
		resultsFrame.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));

		panelGraficoResultado.add(graphPanelPotenciaInst);
		resultsFrame.getContentPane().add(panelGraficoResultado);
		
		JPanel panelValoresResultado = new JPanel();
		resultsFrame.getContentPane().add(panelValoresResultado);
		panelValoresResultado.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelTriangPot = new JPanel();
		panelValoresResultado.add(panelTriangPot);
		
		JPanel panelCalculos = new JPanel();
		panelValoresResultado.add(panelCalculos);
		panelCalculos.setLayout(new GridLayout(4, 2, 0, 0));
		
		JLabel lblPotAtiva = new JLabel("Pot\u00EAncia Ativa:");
		panelCalculos.add(lblPotAtiva);
		
		
		textPotAtiva.setEditable(false);
		panelCalculos.add(textPotAtiva);
		textPotAtiva.setColumns(10);
		
		JLabel lblPotReativa = new JLabel("Pot\u00EAncia Reativa:");
		panelCalculos.add(lblPotReativa);
		
		textPotReativa.setEditable(false);
		panelCalculos.add(textPotReativa);
		textPotReativa.setColumns(10);
		
		JLabel lblPotAparente = new JLabel("Pot\u00EAncia Aparente:");
		panelCalculos.add(lblPotAparente);
		
		textPotAparente.setEnabled(true);
		textPotAparente.setEditable(false);
		textPotAparente.setText("");
		panelCalculos.add(textPotAparente);
		textPotAparente.setColumns(10);
		
		JLabel lblFatorDePotencia = new JLabel("Fator De Pot\u00EAncia:");
		panelCalculos.add(lblFatorDePotencia);
		
		textFatorDePotencia.setEditable(false);
		panelCalculos.add(textFatorDePotencia);
		textFatorDePotencia.setColumns(10);
		resultsFrame.setVisible(true);
		
		EntradasCorrenteFrame.setVisible(true);
		EntradasTensaoFrame.setVisible(true);
	}
}
