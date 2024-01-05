package br.com.cezarcruz.persistence.mysql;

import br.com.cezarcruz.core.domain.ClassRoomDomain;
import br.com.cezarcruz.core.gateway.classroom.GetClassRoomGateway;
import br.com.cezarcruz.core.gateway.classroom.SaveClassRoomGateway;
import br.com.cezarcruz.persistence.mysql.mapper.ClassRoomPersistenceMapper;
import br.com.cezarcruz.persistence.mysql.repository.ClassRoomRepository;
import jakarta.inject.Named;
import java.util.Optional;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class ClassRoomMysqlGateway implements SaveClassRoomGateway, GetClassRoomGateway {

  private final ClassRoomRepository classRoomRepository;
  private final ClassRoomPersistenceMapper classRoomPersistenceMapper;

  @Override
  public ClassRoomDomain save(ClassRoomDomain classRoom) {
    final var classRoomEntity = classRoomPersistenceMapper.from(classRoom);
    var saved = classRoomRepository.save(classRoomEntity);
    return classRoomPersistenceMapper.from(saved);
  }

  @Override
  public Stream<ClassRoomDomain> findAll() {
    return classRoomRepository.findAllWithJoin()
        .stream()
        .map(classRoomPersistenceMapper::from);
  }

  @Override
  public Optional<ClassRoomDomain> findById(String id) {
    return classRoomRepository.findById(id)
        .map(classRoomPersistenceMapper::from);
  }
}
