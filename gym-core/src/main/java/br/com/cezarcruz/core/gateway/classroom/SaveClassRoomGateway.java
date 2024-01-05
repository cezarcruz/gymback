package br.com.cezarcruz.core.gateway.classroom;

import br.com.cezarcruz.core.domain.ClassRoomDomain;

public interface SaveClassRoomGateway {
  ClassRoomDomain save(final ClassRoomDomain classRoom);
}
