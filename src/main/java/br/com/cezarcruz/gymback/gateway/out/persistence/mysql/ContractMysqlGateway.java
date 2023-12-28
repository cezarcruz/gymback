package br.com.cezarcruz.gymback.gateway.out.persistence.mysql;

import br.com.cezarcruz.gymback.core.domain.Contract;
import br.com.cezarcruz.gymback.gateway.out.gateway.contract.SaveContractGateway;
import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.mapper.ContractPersistenceMapper;
import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContractMysqlGateway implements SaveContractGateway {

  private final ContractPersistenceMapper contractPersistenceMapper;
  private final ContractRepository contractRepository;

  @Override
  public Contract save(Contract model) {

    final var entity = contractPersistenceMapper.fromModel(model);
    final var entitySaved = contractRepository.save(entity);

    return contractPersistenceMapper.fromEntity(entitySaved);
  }
}
