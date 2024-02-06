/* Under MIT License (C)2024 */
package br.com.gymback.persistence.out.mysql.repository;

import br.com.gymback.persistence.out.mysql.entity.ClassRoomEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRoomRepository extends JpaRepository<ClassRoomEntity, Long> {
  @Query(
      value = """
        select cr from ClassRoomEntity cr
      """,
      countQuery = "select count(cr) from ClassRoomEntity cr")
  Page<ClassRoomEntity> findAllWithJoin(final Pageable pageable);
}
