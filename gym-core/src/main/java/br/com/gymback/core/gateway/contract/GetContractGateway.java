package br.com.gymback.core.gateway.contract;

import br.com.gymback.core.domain.ContractDomain;

public interface GetContractGateway {
  ContractDomain getByStudentId(final String studentId);
}
