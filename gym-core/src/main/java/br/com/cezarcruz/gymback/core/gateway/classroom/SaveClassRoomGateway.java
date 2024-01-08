package br.com.cezarcruz.gymback.core.gateway.classroom;

import br.com.cezarcruz.gymback.core.domain.ClassRoomDomain;

public interface SaveClassRoomGateway {
  ClassRoomDomain save(final ClassRoomDomain classRoom);
}
