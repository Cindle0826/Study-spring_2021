package com.study.spring.case02;

public class Paper {
	private Integer id;
	private Color color;
	private Size size;

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Paper [id=" + id + ", color=" + color + ", size=" + size + "]";
	}

}
