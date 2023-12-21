package br.com.cezarcruz.gymback.gateway.out.mysql;

import br.com.cezarcruz.gymback.gateway.out.mysql.entity.ModalityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModalityRepository extends JpaRepository<ModalityEntity, Long> {
}
