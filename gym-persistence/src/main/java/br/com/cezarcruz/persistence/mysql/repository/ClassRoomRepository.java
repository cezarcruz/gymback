package br.com.cezarcruz.persistence.mysql.repository;

import br.com.cezarcruz.persistence.mysql.entity.ClassRoomEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRoomRepository extends JpaRepository<ClassRoomEntity, String> {
  @Query(
      """
        select cr from ClassRoomEntity cr
        inner join fetch cr.schedule
        inner join fetch cr.schedule.weekDay
        inner join fetch cr.teacher
        inner join fetch cr.modality
      """
  )
  List<ClassRoomEntity> findAllWithJoin();
}