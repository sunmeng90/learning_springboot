package org.springboot.demo.repository;

import org.springboot.demo.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface StudentJpaRepository extends JpaRepository<Student, Integer> {

    @Query("select stu from Student stu join fetch stu.courses sc join fetch sc.course c join fetch sc.books b where c.name = :courseName")
    List<Student> findStudentByCoursesName(@Param("courseName") String courseName);


    @Query("select stu from Student stu join stu.courses sc join sc.course c where c.name = :courseName")
    List<Student> findStudentByCoursesName2(@Param("courseName") String courseName);
}
