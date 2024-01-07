package br.com.cezarcruz.gymback.gateway.out.persistence.mysql;

import br.com.cezarcruz.gymback.core.domain.PaymentDomain;
import br.com.cezarcruz.gymback.core.gateway.payment.SavePaymentGateway;
import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.mapper.PaymentPersistenceMapper;
import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.repository.PaymentRepository;
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
