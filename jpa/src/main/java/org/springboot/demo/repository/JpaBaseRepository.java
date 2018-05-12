package org.springboot.demo.repository;

import org.springboot.demo.domain.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

//https://stackoverflow.com/questions/19417670/using-generics-in-spring-data-jpa-repositories
@NoRepositoryBean
public interface JpaBaseRepository<T extends BaseEntity, ID extends Serializable> extends JpaRepository<T, ID> {
    //
//    @Query("update #{#entityName} e where e.")
//    void softDelete(Iterable<T> iterable);
    public static final String YEAR_9999 = "#{T(java.time.LocalDateTime).parse('9999-12-31 00:00:00', T(java.time.format.DateTimeFormatter).ofPattern('yyyy-MM-dd HH:mm:ss'))}";

    @Query("select e from #{#entityName} e where e.audit.effectiveEndDate = ?" + YEAR_9999)
    List<T> findAllActive();

}
