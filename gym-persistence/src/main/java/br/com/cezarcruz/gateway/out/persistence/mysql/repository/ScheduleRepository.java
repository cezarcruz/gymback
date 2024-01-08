package br.com.cezarcruz.gateway.out.persistence.mysql.repository;

import br.com.cezarcruz.gateway.out.persistence.mysql.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<ScheduleEntity, String> {

}
