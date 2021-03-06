package br.com.jogogourmet.domain.service;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.jogogourmet.domain.model.Node;
import br.com.jogogourmet.domain.model.NodeTraversalResult;

public class NodeTraversalServiceFailureTest {

	@Test
	public void testNaoEhLasanha() {
		Node rootNode = new Node("massa");
		Node yesMassaNode = new Node("lasanha");
		Node noMassaNode = new Node("bolo");
		rootNode.setYesNode(yesMassaNode);
		rootNode.setNoNode(noMassaNode);
		NodeTraversalService nodeTraversal = new NodeTraversalService(rootNode);
		nodeTraversal.traverseNode(true);
		NodeTraversalResult traverseNodeResult = nodeTraversal.traverseNode(false);
		
		assertEquals(NodeTraversalResult.FAILURE, traverseNodeResult);
	}

}
