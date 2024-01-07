package br.com.cezarcruz.gateway.out.persistence.mysql.repository;

import br.com.cezarcruz.gateway.out.persistence.mysql.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, String> {

}
