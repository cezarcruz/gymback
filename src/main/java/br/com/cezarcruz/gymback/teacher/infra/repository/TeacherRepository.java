package br.com.cezarcruz.gymback.teacher.infra.repository;

import br.com.cezarcruz.gymback.teacher.domain.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity, Long> {
}
