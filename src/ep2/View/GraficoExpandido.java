package ep2.View;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ep2.Controller.GraphPanel;

import java.awt.GridLayout;

@SuppressWarnings("serial")
public class GraficoExpandido extends JFrame {
	private GraphPanel grafico;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public GraficoExpandido(List<Double> points) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 1, 0, 0));
		grafico = new GraphPanel(points);
		contentPane.add(grafico);
	}

}
