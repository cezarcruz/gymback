package br.com.gymback.core.gateway.contract;

import br.com.gymback.core.domain.ContractDomain;
import br.com.gymback.core.gateway.GetGateway;
import java.util.Optional;

public interface GetContractGateway extends GetGateway<ContractDomain> {
  Optional<ContractDomain> getByStudentId(final Long studentId);
  boolean exists(final Long contractId);

  boolean notExists(Long contractId);
}
