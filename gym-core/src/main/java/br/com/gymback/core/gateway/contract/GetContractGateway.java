package br.com.gymback.core.gateway.contract;

import br.com.gymback.core.domain.ContractDomain;
import java.util.Optional;

public interface GetContractGateway {
  Optional<ContractDomain> getByStudentId(final Long studentId);
}
