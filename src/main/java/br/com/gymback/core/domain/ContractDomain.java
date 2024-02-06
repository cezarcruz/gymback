/* Under MIT License (C)2024 */
package br.com.gymback.core.domain;

import br.com.gymback.core.enums.ContractStatus;
import br.com.gymback.core.enums.ContractType;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.With;

@Getter
@AllArgsConstructor
public final class ContractDomain {

  private Long id;
  private Month startMonth;
  private Month endMonth;
  private Integer startYear;
  private Integer endYear;
  private Integer dueDay;
  private BigDecimal discount;
  private ContractType contractType;
  private ContractStatus contractStatus;

  @With private final StudentDomain student;
  @With private final ClassRoomDomain classRoom;
  @With private final List<PaymentDomain> payments;

  public ContractDomain activate() {
    this.contractStatus = ContractStatus.ACTIVE;
    return this;
  }

  public LocalDate getEndDate() {
    return LocalDate.of(endYear, endMonth, dueDay);
  }

  public LocalDate getStartDate() {
    return LocalDate.of(startYear, startMonth, dueDay);
  }

  public Optional<PaymentDomain> getPaymentById(final Long id) {
    return payments.stream().filter(p -> Objects.equals(p.getId(), id)).findFirst();
  }

  public int contractMonths() {

    var startDate = getStartDate();
    var endDate = getEndDate();

    var interval = Period.between(startDate, endDate);
    return interval.getMonths() + 1 + (interval.getYears() * 12);
  }

  public boolean isActive() {
    var startDate = getStartDate();
    var endDate = getEndDate();

    var interval = Period.between(startDate, endDate);

    return interval.getDays() > 0;
  }
}
