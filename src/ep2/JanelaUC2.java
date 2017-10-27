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

@SuppressWarnings("serial")
public class JanelaUC2 extends JFrame {

	private JPanel contentPane;

	public JanelaUC2() {
		setResizable(false);
		setTitle("Simular fluxo de potência fundamental");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		JLabel lblAmplitudeCorrente = new JLabel("0");
		lblAmplitudeCorrente.setBounds(125, 17, 38, 14);
		panelAmplitudeCorrente.add(lblAmplitudeCorrente);
		
		JSlider sliderAmplitudeCorrente = new JSlider();
		sliderAmplitudeCorrente.setBackground(UIManager.getColor("Button.darkShadow"));
		sliderAmplitudeCorrente.setMaximum(220);
		sliderAmplitudeCorrente.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				lblAmplitudeCorrente.setText(Integer.toString(sliderAmplitudeCorrente.getValue()));
			}
		});
		sliderAmplitudeCorrente.setValue(0);
		sliderAmplitudeCorrente.setBounds(10, 17, 100, 20);
		panelAmplitudeCorrente.add(sliderAmplitudeCorrente);
		
		JPanel panelAnguloCorrente = new JPanel();
		panelAnguloCorrente.setBackground(UIManager.getColor("Button.darkShadow"));
		frameVariaveis.getContentPane().add(panelAnguloCorrente);
		panelAnguloCorrente.setBorder(new TitledBorder(null, "Ângulo de fase da corrente:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelAnguloCorrente.setLayout(null);
		
		JLabel lblAnguloCorrente = new JLabel("0\u00BA");
		lblAnguloCorrente.setBounds(125, 17, 38, 14);
		panelAnguloCorrente.add(lblAnguloCorrente);
		
		JSlider sliderAnguloCorrente = new JSlider();
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
		
		JLabel lblAmplitudeTensao = new JLabel("0");
		lblAmplitudeTensao.setBounds(125, 17, 38, 14);
		panelAmplitudeTensao.add(lblAmplitudeTensao);
		
		JSlider sliderAmplitudeTensao = new JSlider();
		sliderAmplitudeTensao.setBackground(UIManager.getColor("Button.darkShadow"));
		sliderAmplitudeTensao.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				lblAmplitudeTensao.setText(Integer.toString(sliderAmplitudeTensao.getValue()));
			}
		});
		sliderAmplitudeTensao.setValue(0);
		sliderAmplitudeTensao.setBounds(10, 17, 100, 20);
		panelAmplitudeTensao.add(sliderAmplitudeTensao);
		
		JPanel panelAnguloTensao = new JPanel();
		panelAnguloTensao.setBackground(UIManager.getColor("Button.darkShadow"));
		frameVariaveis.getContentPane().add(panelAnguloTensao);
		panelAnguloTensao.setLayout(null);
		panelAnguloTensao.setBorder(new TitledBorder(null, "Ângulo de fase da tensão:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblAnguloTensao = new JLabel("0\u00BA");
		lblAnguloTensao.setBounds(125, 17, 38, 14);
		panelAnguloTensao.add(lblAnguloTensao);
		
		JSlider sliderAnguloTensao = new JSlider();
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
