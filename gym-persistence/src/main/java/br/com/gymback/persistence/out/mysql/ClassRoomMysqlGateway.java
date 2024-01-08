package br.com.gymback.persistence.out.mysql;

import br.com.gymback.persistence.out.mysql.mapper.ClassRoomPersistenceMapper;
import br.com.gymback.persistence.out.mysql.repository.ClassRoomRepository;
import br.com.gymback.core.domain.ClassRoomDomain;
import br.com.gymback.core.gateway.classroom.GetClassRoomGateway;
import br.com.gymback.core.gateway.classroom.SaveClassRoomGateway;
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
