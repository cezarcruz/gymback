package br.com.cezarcruz.gymback.modality.infra.repository;

import br.com.cezarcruz.gymback.modality.domain.entity.ModalityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModalityRepository extends JpaRepository<ModalityEntity, Long> {
}
