package br.com.gymback.application.rest.dto.response;

import br.com.gymback.core.enums.ContractStatus;
import br.com.gymback.core.enums.ContractType;
import java.math.BigDecimal;
import java.time.Month;
import java.util.List;

public record ContractResponse(
  String id,
  Month startMonth,
  Month endMonth,
  Integer startYear,
  Integer endYear,
  Integer dueDay,
  BigDecimal discount,
  ContractType contractType,
  ContractStatus contractStatus,

  StudentResponse student,

  ClassRoomResponse classRoom,

  List<PaymentResponse> payments
) {

}
