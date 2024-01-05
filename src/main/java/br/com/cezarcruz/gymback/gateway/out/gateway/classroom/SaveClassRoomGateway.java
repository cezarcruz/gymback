package br.com.cezarcruz.gymback.gateway.out.gateway.classroom;

import br.com.cezarcruz.gymback.core.domain.ClassRoomDomain;

public interface SaveClassRoomGateway {
  ClassRoomDomain save(final ClassRoomDomain classRoom);
}
