package br.com.cezarcruz.gymback.core.domain;

import br.com.cezarcruz.gymback.core.enums.ContractStatus;
import br.com.cezarcruz.gymback.core.enums.ContractType;
import java.math.BigDecimal;
import java.time.Month;
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
    return 12;
  }
}
