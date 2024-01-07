package br.com.cezarcruz.gymback.gateway.out.persistence.mysql.entity;

import br.com.cezarcruz.gymback.core.enums.PaymentStatus;
import br.com.cezarcruz.gymback.core.enums.PaymentType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Getter
@Setter
@Table(name = "payment")
public class PaymentEntity extends CommonFields {

  @Id
  @UuidGenerator(style = UuidGenerator.Style.TIME)
  @Column(name = "id", columnDefinition = "VARCHAR(36)", updatable = false, unique = true, nullable = false)
  private String id;

  private BigDecimal value;

  @Column(name = "payment_day")
  private LocalDate paymentDay;

  @Column(name = "payment_type")
  @Enumerated(EnumType.STRING)
  private PaymentType paymentType;

  @Column(name = "payment_status")
  @Enumerated(EnumType.STRING)
  private PaymentStatus paymentStatus;

}
