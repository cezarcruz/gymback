/* Under MIT License (C)2024 */
package br.com.gymback.core.fixtures;

import static org.instancio.Select.field;

import br.com.gymback.core.domain.ContractDomain;
import java.time.Month;
import org.instancio.Instancio;

public class ContractFixtures {

  public static ContractDomain getContract() {
    return Instancio.of(ContractDomain.class)
        .set(field("startYear"), 2024)
        .set(field("endYear"), 2024)
        .generate(field("dueDay"), gen -> gen.ints().range(1, 28))
        .create();
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
