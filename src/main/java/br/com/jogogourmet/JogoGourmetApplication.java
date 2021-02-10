package br.com.jogogourmet;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import br.com.jogogourmet.domain.model.Node;
import br.com.jogogourmet.domain.service.JogoGourmet;
import br.com.jogogourmet.domain.service.NodeTraversalService;
import br.com.jogogourmet.usecase.JogoGourmetSwing;

public class JogoGourmetApplication extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = -5984691287423572625L;
	
	private NodeTraversalService nodeTraversal;

	public static void main(String[] args) {
		JogoGourmetApplication jogoGourmet = new JogoGourmetApplication();
		jogoGourmet.setVisible(true);
	}
	
	public JogoGourmetApplication() {
		setTitle("Jogo Gourmet");
		setDefaultCloseOperation(3);
	    JPanel panel = new JPanel();
	    panel.setLayout(new BoxLayout(panel, 3));
	    Border padding = BorderFactory.createEmptyBorder(20, 50, 20, 50);
	    panel.setBorder(padding);
	    JButton button = new JButton("OK");
	    button.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	        	  JogoGourmetApplication.this.iniciarJogo();
	          }
	        });
	    button.setAlignmentX(0.5F);
	    JLabel label = new JLabel("Pense em um prato que gosta");
	    label.setAlignmentX(0.5F);
	    panel.add(label);
	    panel.add(Box.createRigidArea(new Dimension(0, 10)));
	    panel.add(button);
	    setContentPane(panel);
	    pack();
	    setLocationRelativeTo(null);
	    
	    Node rootNode = new Node("massa");
		Node yesMassaNode = new Node("lasanha");
		Node noMassaNode = new Node("bolo");
		rootNode.setYesNode(yesMassaNode);
		rootNode.setNoNode(noMassaNode);
		this.nodeTraversal = new NodeTraversalService(rootNode);
		
	}
	
	public void iniciarJogo() {
		
		JogoGourmet jogoGourmet = new JogoGourmetSwing(nodeTraversal, this, "O prato que você pensou é ");
		jogoGourmet.play();
	}
}
