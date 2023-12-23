package br.com.cezarcruz.gymback.gateway.out.gateway.classroom;

import br.com.cezarcruz.gymback.core.domain.ClassRoom;
import java.util.stream.Stream;

public interface GetClassRoomGateway {

  Stream<ClassRoom> findAll();

}
