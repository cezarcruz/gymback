package br.com.gymback.persistence.out.mysql;

import br.com.gymback.persistence.out.mysql.mapper.PaymentPersistenceMapper;
import br.com.gymback.persistence.out.mysql.repository.PaymentRepository;
import br.com.gymback.core.domain.PaymentDomain;
import br.com.gymback.core.gateway.payment.SavePaymentGateway;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentMysqlGateway implements SavePaymentGateway {

  private final PaymentPersistenceMapper paymentPersistenceMapper;
  private final PaymentRepository paymentRepository;

  @Override
  public PaymentDomain save(PaymentDomain payment) {
    final var paymentEntity = paymentPersistenceMapper.fromModel(payment);
    final var paymentSaved = paymentRepository.save(paymentEntity);
    return paymentPersistenceMapper.fromEntity(paymentSaved);
  }

  @Override
  public List<PaymentDomain> saveAll(List<PaymentDomain> payments) {
    var paymentEntityList = paymentPersistenceMapper.fromModelList(payments);
    var savedList = paymentRepository.saveAll(paymentEntityList);
    return paymentPersistenceMapper.fromEntityList(savedList);
  }
}
