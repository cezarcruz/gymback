package br.com.gymback.persistence.out.mysql;

import br.com.gymback.core.domain.PaymentDomain;
import br.com.gymback.core.enums.PaymentStatus;
import br.com.gymback.core.gateway.payment.GetPaymentGateway;
import br.com.gymback.core.gateway.payment.SavePaymentGateway;
import br.com.gymback.persistence.out.mysql.mapper.PaymentPersistenceMapper;
import br.com.gymback.persistence.out.mysql.repository.ContractRepository;
import br.com.gymback.persistence.out.mysql.repository.PaymentRepository;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentMysqlGateway implements SavePaymentGateway, GetPaymentGateway {

  private final PaymentPersistenceMapper paymentPersistenceMapper;
  private final PaymentRepository paymentRepository;
  private final ContractRepository contractRepository;

  @Override
  public PaymentDomain save(final PaymentDomain payment) {
    final var paymentEntity = paymentPersistenceMapper.fromModel(payment);
    final var paymentSaved = paymentRepository.save(paymentEntity);
    return paymentPersistenceMapper.fromEntity(paymentSaved);
  }

  @Override
  public List<PaymentDomain> saveAll(final List<PaymentDomain> payments) {
    var paymentEntityList = paymentPersistenceMapper.fromModelList(payments);
    var savedList = paymentRepository.saveAll(paymentEntityList);
    return paymentPersistenceMapper.fromEntityList(savedList);
  }

  @Override
  public List<PaymentDomain> findBy(final Long contractId, final PaymentStatus paymentStatus) {
    var payments = paymentRepository.findAllByContractIdAndPaymentStatus(contractId, paymentStatus.name());
    return paymentPersistenceMapper.fromEntityList(payments);
  }

  @Override
  public List<PaymentDomain> findAllBy(final PaymentStatus paymentStatus, final LocalDate date) {
    var payments = paymentRepository.findAllByPaymentStatusAndPaymentDayLessThan(paymentStatus, date);
    return paymentPersistenceMapper.fromEntityList(payments);
  }
}
