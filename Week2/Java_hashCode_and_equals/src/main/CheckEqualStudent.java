package main;
import java.util.HashSet;
import java.util.Set;
public class CheckEqualStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student1 = new Student(1, "Nguyen Van A", 20);
		Student student2 = new Student(1, "Nguyen van B", 21);
		Student student3 = new Student(3, "Tran van C", 21);
		
		Set<Student> hset = new HashSet<Student>();
		hset.add(student1);
		hset.add(student2);
		hset.add(student3);
		
		for (Student s:hset) {
			System.out.println(s);
		}
		
	}

}
