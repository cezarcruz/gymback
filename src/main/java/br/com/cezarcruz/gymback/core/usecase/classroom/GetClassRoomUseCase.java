package br.com.cezarcruz.gymback.core.usecase.classroom;

import br.com.cezarcruz.gymback.core.domain.ClassRoom;
import br.com.cezarcruz.gymback.gateway.out.gateway.classroom.GetClassRoomGateway;
import jakarta.inject.Named;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class GetClassRoomUseCase {

  private final GetClassRoomGateway getClassRoomGateway;

  public Stream<ClassRoom> findAll() {
    return getClassRoomGateway.findAll();
  }

}
