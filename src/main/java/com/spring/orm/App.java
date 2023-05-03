package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println(".....Welcome.....");
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
//        Student student = new  Student(101,"Uttu","nagpur");
//        int r = studentDao.insert(student);
//        System.out.println(r);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean go = true;
		while (go) {
			System.out.println("Press 1 for add new Student");
			System.out.println("Press 2 for Display all Student ");
			System.out.println("Press 3 for get single Student details ");
			System.out.println("Press 4 for delete Students");
			System.out.println("Press 5 for update Student");
			System.out.println("Press 6 for exit");

			try {
				int input = Integer.parseInt(br.readLine());
				switch (input) {
				case 1:
					// add student
					System.out.println("Enter Student id");
					int sId = Integer.parseInt(br.readLine());
					System.out.println("Enter Student name");
					String Sname = br.readLine();
					System.out.println("Enter Student Address");
					String Sadd = br.readLine();

					Student s = new Student();
					s.setStudentid(sId);
					s.setStudentname(Sname);
					s.setStudentaddress(Sadd);

					int r = studentDao.insert(s);
					System.out.println(r + "student added");

					System.out.println("********************************************");
					break;

				case 2:
					// display all student
					List<Student> allStudent = studentDao.getAllStudent();
					for (Student st : allStudent) {
						System.out.println("ID:" + st.getStudentid());
						System.out.println("NAME:" + st.getStudentname());
						System.out.println("ADDRESS:" + st.getStudentaddress());
						System.out.println("________________________________________________");

					}
					System.out.println("********************************************");
					break;
				case 3:
					// single student
					System.out.println("Enter Student id");
					int stId = Integer.parseInt(br.readLine());
					Student student = studentDao.getStudent(stId);
					System.out.println("ID:" + student.getStudentid());
					System.out.println("NAME:" + student.getStudentname());
					System.out.println("ADDRESS:" + student.getStudentaddress());
					System.out.println("********************************************");
	
					break;
				case 4:
					// delete student
					System.out.println("Enter Student id");
					int stdId = Integer.parseInt(br.readLine());
					studentDao.delete(stdId);
					System.out.println("Student Deleted");
					System.out.println("********************************************");

					break;
				case 5:
					// update student
					System.out.println("Enter Student id");
					int stdeId = Integer.parseInt(br.readLine());
					System.out.println("Press  1 to update name");
					System.out.println("Press  2 to update city");
					int choice = Integer.parseInt(br.readLine());
					Student student1 = studentDao.getStudent(stdeId);
					String uname = student1.getStudentname();
					String uadd = student1.getStudentaddress();
					switch(choice)
					{
					case 1:
						System.out.println("enter name to update");
						uname=br.readLine();
						student1=new Student(stdeId,uname,uadd);
						break;
					case 2:
						System.out.println("enter address to update");
						uadd=br.readLine();
						student1=new Student(stdeId,uname,uadd);
						break;
					}
					studentDao.update(student1);
					System.out.println("Update Successfully");
					System.out.println("********************************************");

					break;
				case 6:
					// exit
					go = false;
					break;

				}

			} catch (Exception e) {
				System.out.println("Invalid Input");
				System.out.println(e.getMessage());
			}
		}

		System.out.println("Thankyou");

	}
}
