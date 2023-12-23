package br.com.cezarcruz.gymback.gateway.out.gateway.classroom;

import br.com.cezarcruz.gymback.core.domain.ClassRoom;

public interface SaveClassRoomGateway {
  ClassRoom save(final ClassRoom classRoom);
}
