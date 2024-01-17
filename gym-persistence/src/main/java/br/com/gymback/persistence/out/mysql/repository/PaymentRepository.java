package br.com.gymback.persistence.out.mysql.repository;

import br.com.gymback.core.enums.PaymentStatus;
import br.com.gymback.persistence.out.mysql.entity.PaymentEntity;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {

  @Query(nativeQuery = true, value = """
      SELECT p.* FROM payment p
      INNER JOIN contract_payment cp ON cp.payment_id = p.id
      INNER JOIN contract c ON c.id = cp.contract_id
      WHERE c.id = :contract
      AND p.payment_status = :paymentStatus
  """)
  List<PaymentEntity> findAllByContractIdAndPaymentStatus(@Param("contract") Long contractId,
      @Param("paymentStatus") String paymentStatus);

  List<PaymentEntity> findAllByPaymentStatusAndPaymentDayLessThan(PaymentStatus paymentStatus, LocalDate date);
}
