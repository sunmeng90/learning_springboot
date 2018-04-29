package org.springboot.demo.repository;

import org.springboot.demo.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BookJpaRepository extends JpaRepository<Book, Integer> {
}
