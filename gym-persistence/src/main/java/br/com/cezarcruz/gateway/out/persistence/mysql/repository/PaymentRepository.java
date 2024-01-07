package br.com.cezarcruz.gateway.out.persistence.mysql.repository;

import br.com.cezarcruz.gateway.out.persistence.mysql.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, String> {

}
