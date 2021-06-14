package Files.streams;


import Files.data.Student;
import Files.data.StudentDataBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamReduceExample {
	
	public static Optional<Integer> performMultiplicationWithoutIdentity(List<Integer> integerList){

        return integerList.stream()
               
                .reduce((a,b) -> a*b); // if identity is not passed then it returns an optional object

    }


    public static int performMultiplication(List<Integer> integerList){

        return integerList.stream()
                //1
                //3
                //5
                //7
                // a=1,b=1(from stream) => result 1 is returned
                //a=1,b=3(from stream -> result 3 is returned
                //a=3,b=5 (from stream) ->result 15 is returned
                //a=15, b =7(From stream) -> result 105
                .reduce(1,(a,b) -> a*b);

    }
    
    public static Optional<Student> getStudentHighestGpa(){
    	return StudentDataBase.getAllStudents().stream()
    			.reduce((s1,s2)->{
    				if(s1.getGpa()>s2.getGpa())return s1;
    				else return s2;
    			});
    }


    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1,3,5,7);
        List<Integer> integer1=new ArrayList<>();
        System.out.println(performMultiplication(integers));
        
        Optional<Integer> res=performMultiplicationWithoutIdentity(integers);
        System.out.println(res.isPresent()); // returns boolean
        System.out.println(res.get()); // returns actual value
        
        Optional<Integer> res1=performMultiplicationWithoutIdentity(integer1);
        System.out.println(res1.isPresent());
        if(res1.isPresent()) System.out.println(res1.get());
        
        Optional<Student> studentHighestGpa=getStudentHighestGpa();
        if(studentHighestGpa.isPresent())
        System.out.println(studentHighestGpa.get());


    }
}

