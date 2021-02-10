package br.com.jogogourmet.domain.service;

import br.com.jogogourmet.domain.model.Node;
import br.com.jogogourmet.domain.model.NodeTraversalResult;

/**
 * Classe de servico responsavel pela logica da navegacao na arvore de decisoes
 * 
 * @author Jose Geraldo
 *
 */
public class NodeTraversalService {

	private Node root;
	private Node currentNode;
	
	public NodeTraversalService(Node root) {
		this.root = root;
		this.currentNode = root;
	}
	
	/**
	 * Metodo que retorna o resultado da opcao escolhida pelo usuario
	 * 
	 * @param option opcao escolhida pelo usuario
	 * @return
	 */
	public NodeTraversalResult traverseNode(boolean option) {
		
		NodeTraversalResult result = NodeTraversalResult.CONTINUE;
		if( option ) {
			
			final Node yesNode = this.currentNode.getYesNode();
			if( yesNode == null ) {
				result = NodeTraversalResult.SUCCESS;
			} else {
				this.currentNode = yesNode;
			}
			
		} else {
			final Node noNode = this.currentNode.getNoNode();
			if ( noNode == null ) {
				result = NodeTraversalResult.FAILURE;
			} else {
				this.currentNode = noNode;
			}
		}
		
		return result;
	}

	public Node getRoot() {
		return root;
	}
	
	public Node getCurrentNode() {
		return this.currentNode;
	}
	
	public void setCurrentNode(final Node currentNode) {
		this.currentNode = currentNode;
	}
}
