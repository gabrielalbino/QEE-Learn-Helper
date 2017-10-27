package ep2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class JanelaUC2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtValPotAtiva;
	private JTextField txtValPotReativa;
	private JTextField txtValPotAparente;
	private JTextField txtValFatPot;
	private CalculosUC2 calcular;
	private JTextField lblAmplitudeCorrente;
	private JTextField lblAnguloCorrente;
	private JTextField lblAmplitudeTensao;
	private JTextField lblAnguloTensao;
	
	public JanelaUC2() {
		calcular = new CalculosUC2();
		setResizable(false);
		setTitle("Simular fluxo de potência fundamental");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JInternalFrame frameSaidas = new JInternalFrame("New JInternalFrame");
		frameSaidas.setBorder(UIManager.getBorder("CheckBox.border"));
		frameSaidas.setMaximizable(true);
		frameSaidas.setBounds(25, 30, 348, 300);
		contentPane.add(frameSaidas);
		frameSaidas.getContentPane().setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel = new JPanel();
		frameSaidas.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		frameSaidas.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(4, 2, 0, 0));
		
		JLabel lblValPotAtiva = new JLabel("Valor da pot\u00EAncia ativa:");
		panel_1.add(lblValPotAtiva);
		
		txtValPotAtiva = new JTextField();
		txtValPotAtiva.setEditable(false);
		panel_1.add(txtValPotAtiva);
		txtValPotAtiva.setColumns(10);
		
		JLabel lblValPotReativa = new JLabel("Valor da pot\u00EAncia reativa:");
		panel_1.add(lblValPotReativa);
		
		txtValPotReativa = new JTextField();
		txtValPotReativa.setEditable(false);
		panel_1.add(txtValPotReativa);
		txtValPotReativa.setColumns(10);
		
		JLabel lblValPotAparente = new JLabel("Valor da pot\u00EAncia aparente:");
		panel_1.add(lblValPotAparente);
		
		txtValPotAparente = new JTextField();
		txtValPotAparente.setEditable(false);
		panel_1.add(txtValPotAparente);
		txtValPotAparente.setColumns(10);
		
		JLabel lblValFatPot = new JLabel("Valor do fator de pot\u00EAncia:");
		panel_1.add(lblValFatPot);
		
		txtValFatPot = new JTextField();
		txtValFatPot.setEditable(false);
		panel_1.add(txtValFatPot);
		txtValFatPot.setColumns(10);
		frameSaidas.setVisible(true);
		
		JInternalFrame frameVariaveis = new JInternalFrame("Entradas");
		frameVariaveis.setBackground(UIManager.getColor("CheckBox.focus"));
		frameVariaveis.getContentPane().setBackground(UIManager.getColor("Button.darkShadow"));
		frameVariaveis.setBorder(UIManager.getBorder("PopupMenu.border"));
		frameVariaveis.setResizable(true);
		frameVariaveis.setBounds(400, 30, 205, 300);
		contentPane.add(frameVariaveis);
		frameVariaveis.getContentPane().setLayout(new GridLayout(5, 0, 0, 0));
		
		JPanel panelAmplitudeCorrente = new JPanel();
		panelAmplitudeCorrente.setBackground(UIManager.getColor("Button.darkShadow"));
		frameVariaveis.getContentPane().add(panelAmplitudeCorrente);
		panelAmplitudeCorrente.setBorder(new TitledBorder(null, "Amplitude da corrente:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelAmplitudeCorrente.setLayout(null);
		
		JSlider sliderAmplitudeCorrente = new JSlider();
		sliderAmplitudeCorrente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				calcular.setAmpCorrente(sliderAmplitudeCorrente.getValue());
				txtValPotAtiva.setText(Double.toString(calcular.getValorPotAtiva()));
				txtValPotReativa.setText(Double.toString(calcular.getValorPotReativa()));
				txtValPotAparente.setText(Double.toString(calcular.getValorPotAparente()));
				txtValFatPot.setText(Double.toString(calcular.getValorFatPotencia()));
			}
		});
		sliderAmplitudeCorrente.setBackground(UIManager.getColor("Button.darkShadow"));
		sliderAmplitudeCorrente.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				lblAmplitudeCorrente.setText(Integer.toString(sliderAmplitudeCorrente.getValue()));
			}
		});
		
		lblAmplitudeCorrente = new JTextField();
		lblAmplitudeCorrente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		lblAmplitudeCorrente.setBackground(UIManager.getColor("Button.darkShadow"));
		lblAmplitudeCorrente.setBounds(125, 17, 38, 14);
		panelAmplitudeCorrente.add(lblAmplitudeCorrente);
		lblAmplitudeCorrente.setColumns(10);
		sliderAmplitudeCorrente.setValue(0);
		sliderAmplitudeCorrente.setBounds(10, 17, 100, 20);
		panelAmplitudeCorrente.add(sliderAmplitudeCorrente);
		
		JPanel panelAnguloCorrente = new JPanel();
		panelAnguloCorrente.setBackground(UIManager.getColor("Button.darkShadow"));
		frameVariaveis.getContentPane().add(panelAnguloCorrente);
		panelAnguloCorrente.setBorder(new TitledBorder(null, "Ângulo de fase da corrente:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelAnguloCorrente.setLayout(null);
		
		JSlider sliderAnguloCorrente = new JSlider();
		sliderAnguloCorrente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				calcular.setAngCorrente(sliderAnguloCorrente.getValue());
				txtValPotAtiva.setText(Double.toString(calcular.getValorPotAtiva()));
				txtValPotReativa.setText(Double.toString(calcular.getValorPotReativa()));
				txtValPotAparente.setText(Double.toString(calcular.getValorPotAparente()));
				txtValFatPot.setText(Double.toString(calcular.getValorFatPotencia()));
			}
		});
		
		lblAnguloCorrente = new JTextField();
		lblAnguloCorrente.setColumns(10);
		lblAnguloCorrente.setBackground(SystemColor.controlDkShadow);
		lblAnguloCorrente.setBounds(125, 17, 38, 14);
		panelAnguloCorrente.add(lblAnguloCorrente);
		sliderAnguloCorrente.setBackground(UIManager.getColor("Button.darkShadow"));
		sliderAnguloCorrente.setBounds(10, 17, 100, 20);
		panelAnguloCorrente.add(sliderAnguloCorrente);
		sliderAnguloCorrente.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				lblAnguloCorrente.setText(Integer.toString(sliderAnguloCorrente.getValue()) + "\u00BA");
			}
		});
		sliderAnguloCorrente.setMinimum(-180);
		sliderAnguloCorrente.setMaximum(180);
		sliderAnguloCorrente.setValue(0);
		
		JPanel panelAmplitudeTensao = new JPanel();
		panelAmplitudeTensao.setBackground(UIManager.getColor("Button.darkShadow"));
		frameVariaveis.getContentPane().add(panelAmplitudeTensao);
		panelAmplitudeTensao.setLayout(null);
		panelAmplitudeTensao.setBorder(new TitledBorder(null, "Amplitude da tensão:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JSlider sliderAmplitudeTensao = new JSlider();
		sliderAmplitudeTensao.setMaximum(220);
		sliderAmplitudeTensao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				calcular.setAmpTensao(sliderAmplitudeTensao.getValue());
				txtValPotAtiva.setText(Double.toString(calcular.getValorPotAtiva()));
				txtValPotReativa.setText(Double.toString(calcular.getValorPotReativa()));
				txtValPotAparente.setText(Double.toString(calcular.getValorPotAparente()));
				txtValFatPot.setText(Double.toString(calcular.getValorFatPotencia()));
			}
		});
		sliderAmplitudeTensao.setBackground(UIManager.getColor("Button.darkShadow"));
		sliderAmplitudeTensao.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				lblAmplitudeTensao.setText(Integer.toString(sliderAmplitudeTensao.getValue()));
			}
		});
		
		lblAmplitudeTensao = new JTextField();
		lblAmplitudeTensao.setColumns(10);
		lblAmplitudeTensao.setBackground(SystemColor.controlDkShadow);
		lblAmplitudeTensao.setBounds(125, 17, 38, 14);
		panelAmplitudeTensao.add(lblAmplitudeTensao);
		sliderAmplitudeTensao.setValue(0);
		sliderAmplitudeTensao.setBounds(10, 17, 100, 20);
		panelAmplitudeTensao.add(sliderAmplitudeTensao);
		
		JPanel panelAnguloTensao = new JPanel();
		panelAnguloTensao.setBackground(UIManager.getColor("Button.darkShadow"));
		frameVariaveis.getContentPane().add(panelAnguloTensao);
		panelAnguloTensao.setLayout(null);
		panelAnguloTensao.setBorder(new TitledBorder(null, "Ângulo de fase da tensão:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JSlider sliderAnguloTensao = new JSlider();
		sliderAnguloTensao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				calcular.setAngTensao(sliderAnguloTensao.getValue());
				txtValPotAtiva.setText(Double.toString(calcular.getValorPotAtiva()));
				txtValPotReativa.setText(Double.toString(calcular.getValorPotReativa()));
				txtValPotAparente.setText(Double.toString(calcular.getValorPotAparente()));
				txtValFatPot.setText(Double.toString(calcular.getValorFatPotencia()));
			}
		});
		
		lblAnguloTensao = new JTextField();
		lblAnguloTensao.setColumns(10);
		lblAnguloTensao.setBackground(SystemColor.controlDkShadow);
		lblAnguloTensao.setBounds(125, 17, 38, 14);
		panelAnguloTensao.add(lblAnguloTensao);
		sliderAnguloTensao.setBackground(UIManager.getColor("Button.darkShadow"));
		sliderAnguloTensao.setBounds(10, 17, 100, 20);
		panelAnguloTensao.add(sliderAnguloTensao);
		sliderAnguloTensao.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				lblAnguloTensao.setText(Integer.toString(sliderAnguloTensao.getValue()) + "\u00BA");
			}
		});
		sliderAnguloTensao.setValue(0);
		sliderAnguloTensao.setMinimum(-180);
		sliderAnguloTensao.setMaximum(180);
		
		JButton btnResetPosEntradas = new JButton("Resetar Posi\u00E7\u00E3o");
		btnResetPosEntradas.setBackground(UIManager.getColor("Button.darkShadow"));
		frameVariaveis.getContentPane().add(btnResetPosEntradas);
		btnResetPosEntradas.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnResetPosEntradas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frameVariaveis.setBounds(400, 30, 205, 300);
			}
		});
		frameVariaveis.setVisible(true);
	
	}
}
