package br.com.cezarcruz.gymback.gateway.in.rest;

import br.com.cezarcruz.gymback.core.usecase.classroom.CreateClassRoomUseCase;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.request.CreateClassRoomRequest;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.response.ClassRoomResponse;
import br.com.cezarcruz.gymback.gateway.in.rest.mapper.ClassRoomMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/classes", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClassRoomController {

  private final CreateClassRoomUseCase createClassRoomUseCase;
  private final ClassRoomMapper classRoomMapper;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ClassRoomResponse create(@Valid @RequestBody final CreateClassRoomRequest createClassRoomRequest) {

    var classRoom = classRoomMapper.from(createClassRoomRequest);
    var createdClassRoom = createClassRoomUseCase.create(classRoom);
    return classRoomMapper.from(createdClassRoom);

  }

}
