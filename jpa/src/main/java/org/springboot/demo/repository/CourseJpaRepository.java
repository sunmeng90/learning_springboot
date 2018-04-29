package org.springboot.demo.repository;

import org.springboot.demo.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CourseJpaRepository extends JpaRepository<Course, Integer> {
}
