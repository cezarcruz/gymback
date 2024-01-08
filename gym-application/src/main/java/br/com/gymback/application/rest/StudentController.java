package br.com.gymback.application.rest;

import br.com.gymback.application.rest.dto.request.CreateStudentRequest;
import br.com.gymback.application.rest.dto.response.StudentResponse;
import br.com.gymback.core.usecase.student.CreateStudentUseCase;
import br.com.gymback.core.usecase.student.GetStudentUseCase;
import br.com.gymback.application.rest.mapper.StudentMapper;
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
  private final StudentMapper studentMapper;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public StudentResponse create(@Valid @RequestBody final CreateStudentRequest createStudentRequest) {

    final var modality = studentMapper.toStudent(createStudentRequest);
    final var createdModality = createStudentUseCase.create(modality);
    return studentMapper.from(createdModality);

  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<StudentResponse> findAll() {
    return getStudentUseCase.findAll()
        .map(studentMapper::from)
        .collect(Collectors.toList());
  }

}
