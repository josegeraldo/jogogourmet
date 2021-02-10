package br.com.jogogourmet.usecase;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.com.jogogourmet.domain.model.Node;
import br.com.jogogourmet.domain.model.NodeTraversalResult;
import br.com.jogogourmet.domain.service.JogoGourmet;
import br.com.jogogourmet.domain.service.NodeTraversalService;

/**
 * Classe que implementa a interface JogoGourmet, com o jogo em swing
 * 
 * @author Jose Geraldo
 *
 */
public class JogoGourmetSwing implements JogoGourmet {
	
	private String label;
	private NodeTraversalService nodeTraversal;
	private JFrame frame;
	
	private final String MESSAGE_FORMAT = "%s%s?";

	
	public JogoGourmetSwing(NodeTraversalService nodeTraversal, JFrame frame, String label) {
		this.nodeTraversal = nodeTraversal;
		this.frame = frame;
		this.label = label;
		
	}
	
	private boolean getUserResponse() {
		final String message = String.format(MESSAGE_FORMAT, this.label, this.nodeTraversal.getCurrentNode().getName());
		boolean userResponse = (JOptionPane.showConfirmDialog(
		        this.frame, 
		        message, 
		        "Confirm", 
		        0) == 0);
		return userResponse;
	}
	
	@Override
	public void play() {
		
		nodeTraversal.setCurrentNode(nodeTraversal.getRoot());
		
		boolean lastUserResponse = false;
		boolean userResponse = this.getUserResponse();
		NodeTraversalResult nodeTraversalResult = this.nodeTraversal.traverseNode(userResponse);
		while(NodeTraversalResult.CONTINUE.equals(nodeTraversalResult)) {
			lastUserResponse = userResponse;
			userResponse = this.getUserResponse();
			nodeTraversalResult = this.nodeTraversal.traverseNode(userResponse);
		}
		
		if( NodeTraversalResult.SUCCESS.equals( nodeTraversalResult )) {
			JOptionPane.showMessageDialog(this.frame, "Acertei de novo!", "Jogo Gourmet", 1);
		} else {
			
			String newMealName = JOptionPane.showInputDialog(
			          this.frame, 
			          "Qual prato você pensou?", 
			          "Desisto", 
			          3);
			
			String decisionName = JOptionPane.showInputDialog(
			          this.frame, 
			          newMealName + " é _______ mas " + this.nodeTraversal.getCurrentNode().getName() + " não.",
			          "Complete", 
			          3);
			
			
			Node newNoNode = new Node(decisionName);
			
			Node parentNode = this.nodeTraversal.getCurrentNode().getParentNode();
			if( lastUserResponse ) {
				parentNode.setYesNode(newNoNode);
			} else {
				parentNode.setNoNode(newNoNode);
			}
			newNoNode.setYesNode(new Node(newMealName));
			newNoNode.setNoNode(this.nodeTraversal.getCurrentNode());
			
		}
		
	}
		

}
