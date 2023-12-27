package br.com.cezarcruz.gymback.gateway.out.persistence.mysql;

import br.com.cezarcruz.gymback.core.domain.ClassRoom;
import br.com.cezarcruz.gymback.gateway.out.gateway.classroom.GetClassRoomGateway;
import br.com.cezarcruz.gymback.gateway.out.gateway.classroom.SaveClassRoomGateway;
import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.mapper.ClassRoomPersistenceMapper;
import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.repository.ClassRoomRepository;
import jakarta.inject.Named;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class ClassRoomMysqlGateway implements SaveClassRoomGateway, GetClassRoomGateway {

  private final ClassRoomRepository classRoomRepository;
  private final ClassRoomPersistenceMapper classRoomPersistenceMapper;

  @Override
  public ClassRoom save(ClassRoom classRoom) {
    final var classRoomEntity = classRoomPersistenceMapper.from(classRoom);
    var saved = classRoomRepository.save(classRoomEntity);
    return classRoomPersistenceMapper.from(saved);
  }

  @Override
  public Stream<ClassRoom> findAll() {
    return classRoomRepository.findAllWithJoin()
        .stream()
        .map(classRoomPersistenceMapper::from);
  }
}
