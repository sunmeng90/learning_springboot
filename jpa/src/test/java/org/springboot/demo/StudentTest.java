package org.springboot.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springboot.demo.domain.Book;
import org.springboot.demo.domain.Course;
import org.springboot.demo.domain.Student;
import org.springboot.demo.domain.StudentCourses;
import org.springboot.demo.repository.CourseJpaRepository;
import org.springboot.demo.repository.StudentCourseJpaRepository;
import org.springboot.demo.repository.StudentJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    StudentJpaRepository studentJpaRepository;

    @Autowired
    CourseJpaRepository courseJpaRepository;

    @Autowired
    StudentCourseJpaRepository studentCourseJpaRepository;

/*    @Test
    public void testGet() {
        Map<String, String> multiValueMap = new HashMap<>();
        List<Student> result = restTemplate.getForObject("/student/all", List.class, multiValueMap);
        assertTrue(result.size() > 0);
    }*/

    @Test
    public void testAddMore() throws JsonProcessingException {
        Student student = new Student();
        student.setName("jack");
        student.setBirthday(LocalDate.now());
        ObjectMapper objectMapper = new ObjectMapper();
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        objectMapper.registerModule(javaTimeModule);
        String stuString = objectMapper.writeValueAsString(student);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> request = new HttpEntity<>(stuString, headers);
        restTemplate.postForEntity("/student", request, Void.class);
    }


    @Test
    public void testDeleteById() {
        restTemplate.delete("/student/" + 2);
    }


    @Test
    public void testAddStudentCourse() {
        Student lucy = new Student();
        lucy.setName("lucy");
        lucy.setBirthday(LocalDate.now());
        Course math = new Course();
        math.setName("Math");
        Course physics = new Course();
        physics.setName("physics");

        StudentCourses lucyMath = new StudentCourses();
        lucyMath.setCourse(math);
        lucyMath.setStudent(lucy);


        StudentCourses lucyPhysics = new StudentCourses();
        lucyPhysics.setCourse(physics);
        lucyPhysics.setStudent(lucy);

        Book lucyMathBook1 = new Book();
        lucyMathBook1.setName("Lucy Math book 1");
        Book lucyMathBook2 = new Book();
        lucyMathBook2.setName("Lucy Math book 2");

        Book lucPhysicsBook1 = new Book();
        lucPhysicsBook1.setName("Lucy physics book 1");
        Book lucPhysicsBook2 = new Book();
        lucPhysicsBook2.setName("Lucy physics book 2");
        Book lucPhysicsBook3 = new Book();
        lucPhysicsBook3.setName("Lucy physics book 3");


        lucyMath.addBook(lucyMathBook1);
        lucyMath.addBook(lucyMathBook2);
        lucyPhysics.addBook(lucPhysicsBook1);
        lucyPhysics.addBook(lucPhysicsBook2);
        lucyPhysics.addBook(lucPhysicsBook3);

        studentJpaRepository.save(lucy);

        courseJpaRepository.save(math);
        courseJpaRepository.save(physics);

        studentCourseJpaRepository.save(lucyMath);
        studentCourseJpaRepository.save(lucyPhysics);

    }

    @Test
    public void testQuery() {
        List<Student> students = studentJpaRepository.findAll();

        assertTrue(students.size() > 0);

        List<Student> studentList = studentJpaRepository.findStudentByCoursesName("Math");
        List<Student> studentList2 = studentJpaRepository.findStudentByCoursesName2("Math");

    }

}