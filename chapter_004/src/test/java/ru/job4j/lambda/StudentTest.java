package ru.job4j.lambda;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StudentTest {
    @Test
    public void testStudentsBound() {
        List<Student> lst = new ArrayList<Student>();
        Student s2 = new Student("Студент 2" , 2);
        Student s5 = new Student("Студент 5" , 5);
        Student s3 = new Student("Студент 3" , 3);
        Student s6 = new Student("Студент 6" , 6);
        Student s4 = new Student("Студент 4" , 4);
        lst.add(s2);
        lst.add(s5);
        lst.add(s3);
        lst.add(s6);
        lst.add(s4);
        lst.add(null);

        ArrayList<Student> etalon = new ArrayList<Student>();
        etalon.add(s6);
        etalon.add(s5);

        List<Student> result = Student.levelOf(lst, 4);

        assertThat(result, is(etalon));
    }


}