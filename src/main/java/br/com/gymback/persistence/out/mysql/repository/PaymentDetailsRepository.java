/* Under MIT License (C)2024 */
package br.com.gymback.persistence.out.mysql.repository;

import br.com.gymback.persistence.out.mysql.entity.PaymentDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDetailsRepository extends JpaRepository<PaymentDetailsEntity, Long> {}
