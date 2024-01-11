package br.com.gymback.application.rest;

import br.com.gymback.application.rest.dto.request.CreateStudentRequest;
import br.com.gymback.application.rest.dto.request.GetPagingRequest;
import br.com.gymback.application.rest.dto.response.ContractResponse;
import br.com.gymback.application.rest.dto.response.PageResponse;
import br.com.gymback.application.rest.dto.response.StudentResponse;
import br.com.gymback.application.rest.mapper.ContractMapper;
import br.com.gymback.application.rest.mapper.StudentMapper;
import br.com.gymback.core.usecase.contract.GetStudentContractUseCase;
import br.com.gymback.core.usecase.student.CreateStudentUseCase;
import br.com.gymback.core.usecase.student.GetStudentUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
  private final GetStudentContractUseCase getContractUseCase;
  private final ContractMapper contractMapper;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public StudentResponse create(@Valid @RequestBody final CreateStudentRequest createStudentRequest) {

    final var modality = studentMapper.toStudent(createStudentRequest);
    final var createdModality = createStudentUseCase.create(modality);
    return studentMapper.from(createdModality);

  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public PageResponse<StudentResponse> findAll(@ParameterObject final GetPagingRequest paging) {
    var page = studentMapper.fromRequest(paging);
    var students =  getStudentUseCase.findAll(page);
    return studentMapper.fromPageDomain(students);
  }

  @GetMapping("/{studentId}/contract")
  @ResponseStatus(HttpStatus.OK)
  public ContractResponse getByStudentId(@PathVariable final Long studentId) {
    var contract = getContractUseCase.getBy(studentId);
    return contractMapper.fromModel(contract);
  }

}
