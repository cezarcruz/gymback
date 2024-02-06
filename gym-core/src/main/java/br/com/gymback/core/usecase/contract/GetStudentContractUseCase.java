/* Under MIT License (C)2024 */
package br.com.gymback.core.usecase.contract;

import br.com.gymback.core.domain.ContractDomain;
import br.com.gymback.core.exceptions.ContractNotFoundException;
import br.com.gymback.core.gateway.contract.GetContractGateway;
import jakarta.inject.Named;

@Named
public class GetStudentContractUseCase {

  private final GetContractGateway getContractGateway;

  public GetStudentContractUseCase(GetContractGateway getContractGateway) {
    this.getContractGateway = getContractGateway;
  }

  public ContractDomain getBy(final Long studentId) {
    return getContractGateway
        .getByStudentId(studentId)
        .orElseThrow(() -> new ContractNotFoundException(studentId));
  }
}
