package br.com.gymback.core.gateway.classroom;

import br.com.gymback.core.domain.ClassRoomDomain;
import br.com.gymback.core.domain.PageDomain;
import br.com.gymback.core.gateway.GetGateway;

public interface GetClassRoomGateway extends GetGateway<ClassRoomDomain> {
  PageDomain<ClassRoomDomain> getAll(PageDomain<ClassRoomDomain> page);
}
