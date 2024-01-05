package br.com.cezarcruz.core.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import br.com.cezarcruz.fixtures.ContractFixtures;
import java.time.Month;
import org.junit.jupiter.api.Test;

class ContractDomainTest {

  @Test
  void shouldTestMonthIntervalSameYear() {
    var contract = ContractFixtures.with(Month.JANUARY, Month.APRIL, 2023, 2023);
    assertNotNull(contract);
    assertEquals(4, contract.contractMonths());
  }

  @Test
  void shouldTestMonthIntervalSameMonthAndSameYear() {
    var contract = ContractFixtures.with(Month.JANUARY, Month.JANUARY, 2023, 2023);
    assertNotNull(contract);
    assertEquals(1, contract.contractMonths());
  }

  @Test
  void shouldTestMonthIntervalNextYear() {
    var contract = ContractFixtures.with(Month.JANUARY, Month.JANUARY, 2023, 2024);
    assertNotNull(contract);
    assertEquals(13, contract.contractMonths());
  }

  @Test
  void shouldTestMonthIntervalNextYearButLessThanYear() {
    var contract = ContractFixtures.with(Month.NOVEMBER, Month.JANUARY, 2023, 2024);
    assertNotNull(contract);
    assertEquals(3, contract.contractMonths());
  }


}