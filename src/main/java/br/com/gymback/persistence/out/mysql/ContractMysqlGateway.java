/* Under MIT License (C)2024 */
package br.com.gymback.persistence.out.mysql;

import br.com.gymback.core.domain.ContractDomain;
import br.com.gymback.core.domain.PageDomain;
import br.com.gymback.core.gateway.contract.GetContractGateway;
import br.com.gymback.core.gateway.contract.SaveContractGateway;
import br.com.gymback.persistence.out.mysql.mapper.ContractPersistenceMapper;
import br.com.gymback.persistence.out.mysql.repository.ContractRepository;
import jakarta.inject.Named;
import java.util.Optional;
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
  public Optional<ContractDomain> getByStudentId(final Long studentId) {
    var contract = contractRepository.findByStudentId(studentId);
    return contract.map(contractPersistenceMapper::fromEntity);
  }

  @Override
  public PageDomain<ContractDomain> findAll(final PageDomain<ContractDomain> page) {
    throw new RuntimeException("not implemented yet");
  }

  @Override
  public Optional<ContractDomain> findById(final Long id) {
    return contractRepository.findById(id).map(contractPersistenceMapper::fromEntity);
  }

  @Override
  public boolean exists(final Long contractId) {
    return contractRepository.existsById(contractId);
  }

  @Override
  public boolean notExists(final Long contractId) {
    return !exists(contractId);
  }
}
