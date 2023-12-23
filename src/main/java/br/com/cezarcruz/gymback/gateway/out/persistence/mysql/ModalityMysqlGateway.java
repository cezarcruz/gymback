package br.com.cezarcruz.gymback.gateway.out.persistence.mysql;

import br.com.cezarcruz.gymback.core.domain.Modality;
import br.com.cezarcruz.gymback.gateway.out.gateway.modality.DeleteModalityGateway;
import br.com.cezarcruz.gymback.gateway.out.gateway.modality.GetModalityGateway;
import br.com.cezarcruz.gymback.gateway.out.gateway.modality.SaveModalityGateway;
import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.mapper.ModalityPersistenceMapper;
import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.repository.ModalityRepository;
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
  public Modality save(Modality modality) {
    final var entity = modalityPersistenceMapper.from(modality);
    final var saved = modalityRepository.save(entity);
    return modalityPersistenceMapper.from(saved);
  }

  @Override
  public Stream<Modality> getAll() {
    return modalityRepository.findAll()
        .stream()
        .map(modalityPersistenceMapper::from);
  }

  @Override
  public void deleteById(final String id) {
    modalityRepository.deleteById(id);
  }

  @Override
  public Optional<Modality> findById(String id) {
    return modalityRepository.findById(id)
        .map(modalityPersistenceMapper::from);
  }
}
