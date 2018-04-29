package org.springboot.demo.repository;

import org.springboot.demo.domain.StudentCourses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface StudentCourseJpaRepository extends JpaRepository<StudentCourses, Integer> {
}
