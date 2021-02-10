package br.com.jogogourmet.domain.model;

public class Node {

	private String name;
	private Node yesNode;
	private Node noNode;
	private Node parentNode;
	
	public Node(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Node getYesNode() {
		return yesNode;
	}
	public void setYesNode(Node yesNode) {
		this.yesNode = yesNode;
		this.yesNode.setParentNode(this);
	}
	public Node getNoNode() {
		return noNode;
	}
	public void setNoNode(Node noNode) {
		this.noNode = noNode;
		this.noNode.setParentNode(this);
	}

	public Node getParentNode() {
		return parentNode;
	}

	public void setParentNode(Node parentNode) {
		this.parentNode = parentNode;
	}
	
}
