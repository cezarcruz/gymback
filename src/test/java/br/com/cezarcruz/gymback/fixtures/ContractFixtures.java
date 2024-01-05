package br.com.cezarcruz.gymback.fixtures;

import static org.instancio.Select.field;

import br.com.cezarcruz.gymback.core.domain.ContractDomain;
import java.time.Month;
import org.instancio.Instancio;

public class ContractFixtures {

  public static ContractDomain getContract() {
    return Instancio.create(ContractDomain.class);
  }

  public static ContractDomain with(
      final Month startMonth,
      final Month endMonth,
      final Integer startYear,
      final Integer endYear) {

    return Instancio.of(ContractDomain.class)
        .set(field("startMonth"), startMonth)
        .set(field("endMonth"), endMonth)
        .set(field("startYear"), startYear)
        .set(field("endYear"), endYear)
        .set(field("dueDay"), 10)
        .create();
  }

  public static ContractDomain withOneYearInterval() {
    return with(Month.JANUARY, Month.DECEMBER, 2023, 2023);
  }
}
