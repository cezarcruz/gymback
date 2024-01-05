package br.com.cezarcruz.persistence.mysql.repository;

import br.com.cezarcruz.persistence.mysql.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, String> {

}
