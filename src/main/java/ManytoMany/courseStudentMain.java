package ManytoMany;

public class courseStudentMain {
	
	public static void main(String[] args) {
		
		courseCrud courseCrud=new courseCrud();
		course course=new course("java",60,4900);
		courseCrud.saveCourse(course);
	}

}
