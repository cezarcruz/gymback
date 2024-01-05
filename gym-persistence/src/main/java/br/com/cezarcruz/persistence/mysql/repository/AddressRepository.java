package br.com.cezarcruz.persistence.mysql.repository;

import br.com.cezarcruz.persistence.mysql.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

}
