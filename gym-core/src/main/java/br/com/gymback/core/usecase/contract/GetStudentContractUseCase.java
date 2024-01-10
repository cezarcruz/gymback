package br.com.gymback.core.usecase.contract;

import br.com.gymback.core.domain.ContractDomain;
import br.com.gymback.core.gateway.contract.GetContractGateway;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class GetStudentContractUseCase {

  private final GetContractGateway getContractGateway;

  public ContractDomain getBy(final String studentId) {
    return getContractGateway.getByStudentId(studentId);
  }
}
