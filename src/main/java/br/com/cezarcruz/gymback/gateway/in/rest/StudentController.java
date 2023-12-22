package br.com.cezarcruz.gymback.gateway.in.rest;

import br.com.cezarcruz.gymback.core.usecase.student.CreateStudentUseCase;
import br.com.cezarcruz.gymback.core.usecase.student.GetStudentUseCase;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.request.CreateStudentRequest;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.response.StudentResponse;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {

  private final CreateStudentUseCase createStudentUseCase;
  private final GetStudentUseCase getStudentUseCase;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public StudentResponse create(@Valid @RequestBody CreateStudentRequest createStudentRequest) {

    final var modality = createStudentRequest.toStudent();
    final var createdModality = createStudentUseCase.create(modality);
    return StudentResponse.from(createdModality);

  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<StudentResponse> findAll() {
    return getStudentUseCase.findAll()
        .map(StudentResponse::from)
        .collect(Collectors.toList());
  }

}
