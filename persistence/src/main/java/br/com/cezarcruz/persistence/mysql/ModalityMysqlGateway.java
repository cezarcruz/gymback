package br.com.cezarcruz.persistence.mysql;

import br.com.cezarcruz.core.domain.ModalityDomain;
import br.com.cezarcruz.core.gateway.modality.DeleteModalityGateway;
import br.com.cezarcruz.core.gateway.modality.GetModalityGateway;
import br.com.cezarcruz.core.gateway.modality.SaveModalityGateway;
import br.com.cezarcruz.persistence.mysql.mapper.ModalityPersistenceMapper;
import br.com.cezarcruz.persistence.mysql.repository.ModalityRepository;
import java.util.Optional;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class ModalityMysqlGateway implements
    SaveModalityGateway, GetModalityGateway, DeleteModalityGateway {

  private final ModalityRepository modalityRepository;
  private final ModalityPersistenceMapper modalityPersistenceMapper;

  @Override
  public ModalityDomain save(ModalityDomain modality) {
    final var entity = modalityPersistenceMapper.from(modality);
    final var saved = modalityRepository.save(entity);
    return modalityPersistenceMapper.from(saved);
  }

  @Override
  public Stream<ModalityDomain> getAll() {
    return modalityRepository.findAll()
        .stream()
        .map(modalityPersistenceMapper::from);
  }

  @Override
  public void deleteById(final String id) {
    modalityRepository.deleteById(id);
  }

  @Override
  public Optional<ModalityDomain> findById(String id) {
    return modalityRepository.findById(id)
        .map(modalityPersistenceMapper::from);
  }
}
