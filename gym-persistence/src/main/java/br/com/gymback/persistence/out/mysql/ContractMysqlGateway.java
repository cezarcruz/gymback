package br.com.gymback.persistence.out.mysql;

import br.com.gymback.core.domain.ContractDomain;
import br.com.gymback.core.gateway.contract.GetContractGateway;
import br.com.gymback.core.gateway.contract.SaveContractGateway;
import br.com.gymback.persistence.out.mysql.mapper.ContractPersistenceMapper;
import br.com.gymback.persistence.out.mysql.repository.ContractRepository;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class ContractMysqlGateway implements SaveContractGateway, GetContractGateway {

  private final ContractPersistenceMapper contractPersistenceMapper;
  private final ContractRepository contractRepository;

  @Override
  public ContractDomain save(ContractDomain model) {

    final var entity = contractPersistenceMapper.fromModel(model);
    final var entitySaved = contractRepository.save(entity);

    return contractPersistenceMapper.fromEntity(entitySaved);
  }

  @Override
  public ContractDomain getByStudentId(final Long studentId) {
    var contract = contractRepository.findByStudentId(studentId);
    return contractPersistenceMapper.fromEntity(contract);
  }
}
