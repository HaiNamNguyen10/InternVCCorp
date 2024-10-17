package main;

public class Student {
	private int id;
	private String name;
	private int age;
	
	public Student(int id, String name,int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public String toString() {
		String info = "";
		info += "#" + this.id;
		info += " - Name: " + this.name;
		info += " - Age: " + this.age;
		return info;
	}
	@Override
	public boolean equals(Object s) {
		if (s instanceof Student) {
			Student newStudent = (Student) s;
			if(this.id == newStudent.id) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return 101 + id;
	}
	
	
}
