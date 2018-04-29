package org.meng.springboot.journal.repository;

import org.meng.springboot.journal.domain.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepository extends JpaRepository<Journal, Long> {
}
