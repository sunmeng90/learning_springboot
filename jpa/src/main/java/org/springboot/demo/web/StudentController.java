package org.springboot.demo.web;

import lombok.extern.slf4j.Slf4j;
import org.springboot.demo.domain.Student;
import org.springboot.demo.repository.Student2JpaRepository;
import org.springboot.demo.repository.StudentJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentJpaRepository studentJpaRepository;


    @Autowired
    private Student2JpaRepository student2JpaRepository;

    @GetMapping
    public List<Student> get() {
        return student2JpaRepository.findAllActive();
    }


    @GetMapping(value = "/{id}")
    public Optional<Student> getById(@PathVariable("id") Integer id) {
        return student2JpaRepository.findById(id);
    }


    @GetMapping(value = "/all2")
    public List<Student> getAllByJoin() {
        return student2JpaRepository.findAllStudentByJoin();
    }

    @PostMapping
    public void add(@RequestBody Student student) {
        studentJpaRepository.save(student);
    }


    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        studentJpaRepository.deleteById(id);
    }
}
