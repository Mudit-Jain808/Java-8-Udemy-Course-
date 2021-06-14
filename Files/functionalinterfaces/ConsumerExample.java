package Files.functionalinterfaces;


import Files.data.Student;
import Files.data.StudentDataBase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    static Consumer<Student> c2 = (student) -> System.out.println(student);
    static Consumer<Student> c3 = (student) -> System.out.print(student.getName());
    static Consumer<Student> c4 = (student) -> System.out.println(student.getActivities());



    public static void printStudents(){

		// Consumer<Student> c2 = (student) -> System.out.println(student);
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(c2);   // forEach() is used to print all the values
    }

    public static void printNameAndActivities(){
        System.out.println("printNameAndActivities :");
		
		//Consumer<Student> c3 = (student) -> System.out.print(student.getName());
		//Consumer<Student> c4 = (student) -> System.out.println(student.getActivities());
		
        List<Student> studentList = StudentDataBase.getAllStudents();

        studentList.forEach(c3.andThen(c4)); //consumer chaining using andThen()
        //studentList.forEach((s) -> {c3.andThen(c4).accept(s);}); // use accept() if using lambda expression inside forEach()
    }


    public static void printNameAndActivitiesUsingCondition(){

        System.out.println("printNameAndActivitiesUsingCondition :");
        List<Student> studentList = StudentDataBase.getAllStudents();

        studentList.forEach((student -> {
            if(student.getGradeLevel()>=3 && student.getGpa()>=3.9){
                c3.andThen(c4).andThen(c2).accept(student);  // accept() is used to pass parameters
            }
        }));
    }


    public static void main(String[] args) {

      Consumer<String> c1 = (s) -> System.out.println(s.toUpperCase());

      c1.accept("java8");
        //printStudents();
        printNameAndActivities();
        printNameAndActivitiesUsingCondition();
    }
}

