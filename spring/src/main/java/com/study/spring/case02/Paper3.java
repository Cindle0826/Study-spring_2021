package com.study.spring.case02;

public class Paper3 {
	private Integer id;
	private Size size;
	private Color color;

	public Paper3() {
		System.out.println("C");
	}

	public Paper3(Color color, Size size) {
		System.out.println("A");
		this.color = color;
		this.size = size;
	}

	public Paper3(Size size, Color color) {
		System.out.println("B");
		this.color = color;
		this.size = size;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Paper3 [id=" + id + ", size=" + size + ", color=" + color + "]";
	}
	
	
}
