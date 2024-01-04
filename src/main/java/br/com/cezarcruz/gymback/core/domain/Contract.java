package br.com.cezarcruz.gymback.core.domain;

import br.com.cezarcruz.gymback.core.enums.ContractStatus;
import br.com.cezarcruz.gymback.core.enums.ContractType;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.With;

@Getter
@AllArgsConstructor
public final class Contract {

  private String id;
  private Month startMonth;
  private Month endMonth;
  private Integer startYear;
  private Integer endYear;
  private Integer dueDay;
  private BigDecimal discount;
  private ContractType contractType;
  private ContractStatus contractStatus;

  @With
  private final Student student;
  @With
  private final ClassRoom classRoom;
  @With
  private final List<Payment> payments;

  public Contract activate() {
    this.contractStatus = ContractStatus.ACTIVE;
    return this;
  }

  public int contractMonths() {

    var startDate = getStartDate();
    var endDate = getEndDate();

    var interval = Period.between(startDate, endDate);
    return interval.getMonths() + 1 + (interval.getYears() * 12);

  }

  public LocalDate getEndDate() {
    return LocalDate.of(endYear, endMonth, dueDay);
  }

  public LocalDate getStartDate() {
    return LocalDate.of(startYear, startMonth, dueDay);
  }
}
