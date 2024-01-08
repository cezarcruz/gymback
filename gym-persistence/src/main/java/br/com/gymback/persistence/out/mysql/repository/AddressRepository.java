package br.com.gymback.persistence.out.mysql.repository;

import br.com.gymback.persistence.out.mysql.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, String> {

}
