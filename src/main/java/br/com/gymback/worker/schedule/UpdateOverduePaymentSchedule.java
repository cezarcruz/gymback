/* Under MIT License (C)2024 */
package br.com.gymback.worker.schedule;

import br.com.gymback.core.usecase.payment.UpdateOverduePaymentUseCase;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
@Named
@RequiredArgsConstructor
public class UpdateOverduePaymentSchedule {

  private final UpdateOverduePaymentUseCase updateOverduePaymentUseCase;

  @Scheduled(fixedRate = 60_000)
  public void run() {
    log.info("staring update overdue schedule");
    updateOverduePaymentUseCase.execute();
    log.info("schedule successfully executed");
  }
}
