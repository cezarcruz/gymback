package br.com.cezarcruz.gymback.core.domain;

import br.com.cezarcruz.gymback.core.enums.ContractStatus;
import br.com.cezarcruz.gymback.core.enums.ContractType;
import java.math.BigDecimal;
import java.time.Month;
import java.util.List;


public record Contract(
    String id,
    Month startMonth,
    Month endMonth,
    Integer startYear,
    Integer endYear,
    Integer dueDay,
    BigDecimal discount,
    ContractType contractType,
    ContractStatus contractStatus,
    List<Student> students,
    List<Payment> payments) {

  public int contractMonths() {
    return 2;
    //return Period.between(startDate, endDate).getMonths();
  }

}
