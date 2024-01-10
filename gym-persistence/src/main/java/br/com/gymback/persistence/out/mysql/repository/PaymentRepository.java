package br.com.gymback.persistence.out.mysql.repository;

import br.com.gymback.persistence.out.mysql.entity.PaymentEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, String> {

  List<PaymentEntity> findAllByStudentId(String studentId);
}
