package org.springboot.demo.repository;

import org.springboot.demo.domain.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface Student2JpaRepository extends JpaBaseRepository<Student, Integer> {


    @Query("select stu from Student stu join fetch stu.courses cs join fetch cs.course c left join fetch cs.books b where stu.audit.effectiveEndDate = :" + YEAR_9999 + " and cs.audit.effectiveEndDate = :" + YEAR_9999 + " and c.audit.effectiveEndDate = :" + YEAR_9999 + " and b.audit.effectiveEndDate = :" + YEAR_9999)
    List<Student> findAllStudentByJoin();
}
