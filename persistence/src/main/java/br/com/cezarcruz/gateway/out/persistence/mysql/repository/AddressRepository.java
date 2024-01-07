package br.com.cezarcruz.gymback.gateway.out.persistence.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.entity.AddressEntity;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, String> {

}
