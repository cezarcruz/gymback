package br.com.cezarcruz.gymback.gateway.in.rest;

import br.com.cezarcruz.gymback.core.usecase.modality.CreateModalityUseCase;
import br.com.cezarcruz.gymback.core.usecase.modality.DeleteModalityUseCase;
import br.com.cezarcruz.gymback.core.usecase.modality.GetModalityUseCase;
import br.com.cezarcruz.gymback.core.usecase.modality.UpdateModalityUseCase;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.request.CreateModalityRequest;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.request.UpdateModalityRequest;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.response.ModalityResponse;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/modalities", produces = MediaType.APPLICATION_JSON_VALUE)
public class ModalityController {

  private final CreateModalityUseCase createModalityUseCase;
  private final GetModalityUseCase getModalityUseCase;
  private final DeleteModalityUseCase deleteModalityUseCase;
  private final UpdateModalityUseCase updateModalityUseCase;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ModalityResponse create(
      @Valid @RequestBody final CreateModalityRequest createModalityRequest) {
    final var modality = createModalityRequest.toModality();
    final var createdModality = createModalityUseCase.create(modality);
    return ModalityResponse.from(createdModality);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<ModalityResponse> listAll() {
    return getModalityUseCase.getAll()
        .map(ModalityResponse::from)
        .collect(Collectors.toList());
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ModalityResponse update(@Valid @RequestBody final UpdateModalityRequest updateModalityRequest,
      @PathVariable("id") final Long id) {
    final var modality = updateModalityRequest.toModality(id);
    final var updatedModality = updateModalityUseCase.update(modality);
    return ModalityResponse.from(updatedModality);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("id") final Long id) {
    deleteModalityUseCase.deleteBy(id);
  }

}
