package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import bean.Student;

@RestController
public class StudentController {

	@GetMapping("student")
	public Student getStudent() {
		Student student = new Student(1,"Aratrika","Chatterjee");
				
		return student;
	}
	@GetMapping
	public List<Student> getStudents(){
		List<Student> students = new ArrayList<>();
		students.add(new Student(1,"ram","abcd"));
		students.add(new Student(2,"shyam","abcd"));
		students.add(new Student(3,"sam","abcd"));
		return students;
	}
	@GetMapping("students/{id}/{first-name}/{last-name}")
	public Student studentPathVariable(@PathVariable("id") int studentId,String firstName, String lastName) {
		return new Student(studentId, firstName,lastName);
	
	
	}
	@GetMapping("students/query")
public Student studentRequestVariable(@RequestParam int id,@RequestParam String firstName,@RequestParam String lastName) {
	return new Student(id,firstName,lastName );
	}
	
	@PostMapping("students/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Student createStudent(Student student) {
		System.out.println(student.getId());
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return student;
	}
	@PutMapping("students/{id}/update")
	public Student updateStudent(@RequestBody Student student, int studentId) {
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return student;
	}
}
