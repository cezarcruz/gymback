package br.com.gymback.core.usecase.classroom;

import br.com.gymback.core.domain.ClassRoomDomain;
import br.com.gymback.core.domain.PageDomain;
import br.com.gymback.core.gateway.classroom.GetClassRoomGateway;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class GetClassRoomUseCase {

  private final GetClassRoomGateway getClassRoomGateway;

  public PageDomain<ClassRoomDomain> findAll(final PageDomain<ClassRoomDomain> page) {
    return getClassRoomGateway.getAll(page);
  }

}
