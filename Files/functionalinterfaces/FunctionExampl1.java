package Files.functionalinterfaces;

import Files.data.Student;
import Files.data.StudentDataBase;

public class FunctionExampl1 {

    public static String performConcat(String str) {

        return FunctionExample.addSomeString.apply(str);
    }

    public static void main(String[] args) {

        String result = performConcat("Hello");

        System.out.println("Result : "+ result);

    }
}

