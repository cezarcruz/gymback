/* Under MIT License (C)2024 */
package br.com.gymback.persistence.out.mysql.entity;

import br.com.gymback.core.enums.PaymentMethod;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "payment_details")
public class PaymentDetailsEntity extends CommonFields {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne
  @JoinColumn(name = "payment_id")
  private PaymentEntity payment;

  @Column(name = "payment_method")
  @Enumerated(EnumType.STRING)
  private PaymentMethod paymentMethod;

  private BigDecimal value;

  @Column(name = "paid_value")
  private BigDecimal paidValue;
}
