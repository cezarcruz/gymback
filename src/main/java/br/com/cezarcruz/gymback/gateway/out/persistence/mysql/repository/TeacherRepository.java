package br.com.cezarcruz.gymback.gateway.out.persistence.mysql.repository;

import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.entity.TeacherEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity, String> {

  @Query("""
      select t from TeacherEntity t inner join fetch t.contacts
    """)
  List<TeacherEntity> findAllWithPerformance();
}
