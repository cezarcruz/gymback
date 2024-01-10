package br.com.gymback.application.rest;

import br.com.gymback.application.rest.dto.response.PaymentResponse;
import br.com.gymback.application.rest.mapper.PaymentMapper;
import br.com.gymback.core.usecase.payment.GetStudentPaymentUseCase;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payments")
public class PaymentController {

  private final GetStudentPaymentUseCase getStudentPaymentUseCase;
  private final PaymentMapper paymentMapper;

  @GetMapping("/student/{studentId}")
  public List<PaymentResponse> findByStudent(@PathVariable final String studentId) {
    var payments = getStudentPaymentUseCase.getBy(studentId);
    return paymentMapper.fromModelList(payments);
  }

}
