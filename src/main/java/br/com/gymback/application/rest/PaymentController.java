/* Under MIT License (C)2024 */
package br.com.gymback.application.rest;

import br.com.gymback.application.rest.dto.request.DoPaymentRequest;
import br.com.gymback.application.rest.dto.response.PaymentResponse;
import br.com.gymback.application.rest.mapper.PaymentMapper;
import br.com.gymback.core.enums.PaymentStatus;
import br.com.gymback.core.usecase.payment.DoPaymentUseCase;
import br.com.gymback.core.usecase.payment.GetPaymentUseCase;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/payments", produces = MediaType.APPLICATION_JSON_VALUE)
public class PaymentController {

  private final DoPaymentUseCase doPaymentUseCase;
  private final GetPaymentUseCase getPaymentUseCase;
  private final PaymentMapper paymentMapper;

  @PutMapping("/{paymentId}/contract/{contractId}")
  @ResponseStatus(HttpStatus.OK)
  public PaymentResponse doPayment(
      @PathVariable("paymentId") final Long paymentId,
      @PathVariable("contractId") final Long contractId,
      @RequestBody final DoPaymentRequest doPaymentRequest) {
    var payment = paymentMapper.fromDoPaymentRequest(doPaymentRequest, paymentId);
    var paid = doPaymentUseCase.doPayment(payment, contractId);
    return paymentMapper.fromModel(paid);
  }

  @GetMapping("/contract/{contractId}/pending")
  public List<PaymentResponse> getPendingPayment(
      @PathVariable("contractId") final Long contractId) {
    var pendingPayment = getPaymentUseCase.findBy(contractId, PaymentStatus.PENDING);
    return paymentMapper.fromModelList(pendingPayment);
  }
}
