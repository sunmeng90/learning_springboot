package org.springboot.demo.web;

import org.springboot.demo.domain.Student;
import org.springboot.demo.repository.Student2JpaRepository;
import org.springboot.demo.repository.StudentJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentJpaRepository studentJpaRepository;


    @Autowired
    private Student2JpaRepository student2JpaRepository;

    @RequestMapping(value = "/all")
    public List<Student> getAll() {
        return student2JpaRepository.findAllActive();
    }

    @RequestMapping(value = "/all2")
    public List<Student> getAllByJoin() {
        return student2JpaRepository.findAllStudentByJoin();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody Student student) {
        studentJpaRepository.save(student);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        studentJpaRepository.deleteById(id);
    }
}
