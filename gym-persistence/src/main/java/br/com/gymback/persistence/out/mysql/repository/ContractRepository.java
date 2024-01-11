package br.com.gymback.persistence.out.mysql.repository;


import br.com.gymback.persistence.out.mysql.entity.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<ContractEntity, Long> {

  ContractEntity findByStudentId(Long studentId);
}
