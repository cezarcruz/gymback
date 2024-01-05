package br.com.cezarcruz.persistence.mysql;

import br.com.cezarcruz.core.domain.ContractDomain;
import br.com.cezarcruz.core.gateway.contract.SaveContractGateway;
import br.com.cezarcruz.persistence.mysql.mapper.ContractPersistenceMapper;
import br.com.cezarcruz.persistence.mysql.repository.ContractRepository;
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
