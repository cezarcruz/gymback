/* Under MIT License (C)2024 */
package br.com.gymback.core.gateway.classroom;

import br.com.gymback.core.domain.ClassRoomDomain;

public interface SaveClassRoomGateway {
  ClassRoomDomain save(final ClassRoomDomain classRoom);
}
