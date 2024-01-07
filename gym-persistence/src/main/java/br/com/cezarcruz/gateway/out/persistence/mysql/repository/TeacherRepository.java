package br.com.cezarcruz.gateway.out.persistence.mysql.repository;

import br.com.cezarcruz.gateway.out.persistence.mysql.entity.TeacherEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity, String> {

  @Query(
      value =
          """
                select t from TeacherEntity t
              """
  )
  Page<TeacherEntity> findAllWithPerformance(final Pageable pageable);
}
