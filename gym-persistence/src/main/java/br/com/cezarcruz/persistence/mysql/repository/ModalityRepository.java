package br.com.cezarcruz.persistence.mysql.repository;

import br.com.cezarcruz.persistence.mysql.entity.ModalityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModalityRepository extends JpaRepository<ModalityEntity, String> {
}
