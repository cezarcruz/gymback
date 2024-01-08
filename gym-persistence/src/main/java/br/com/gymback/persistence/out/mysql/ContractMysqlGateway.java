package br.com.gymback.persistence.out.mysql;

import br.com.gymback.persistence.out.mysql.mapper.ContractPersistenceMapper;
import br.com.gymback.persistence.out.mysql.repository.ContractRepository;
import br.com.gymback.core.domain.ContractDomain;
import br.com.gymback.core.gateway.contract.SaveContractGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContractMysqlGateway implements SaveContractGateway {

  private final ContractPersistenceMapper contractPersistenceMapper;
  private final ContractRepository contractRepository;

  @Override
  public ContractDomain save(ContractDomain model) {

    final var entity = contractPersistenceMapper.fromModel(model);
    final var entitySaved = contractRepository.save(entity);

    return contractPersistenceMapper.fromEntity(entitySaved);
  }
}
