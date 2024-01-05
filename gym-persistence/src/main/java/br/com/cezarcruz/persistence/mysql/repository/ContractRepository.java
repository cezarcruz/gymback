package br.com.cezarcruz.persistence.mysql.repository;

import br.com.cezarcruz.persistence.mysql.entity.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<ContractEntity, String> {

}
