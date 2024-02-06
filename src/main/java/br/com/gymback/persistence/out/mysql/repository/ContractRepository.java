/* Under MIT License (C)2024 */
package br.com.gymback.persistence.out.mysql.repository;

import br.com.gymback.persistence.out.mysql.entity.ContractEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<ContractEntity, Long> {

  Optional<ContractEntity> findByStudentId(Long studentId);
}
