package br.com.cezarcruz.gymback.modality.application.controller;

import br.com.cezarcruz.gymback.modality.domain.dto.request.CreateModalityRequest;
import br.com.cezarcruz.gymback.modality.domain.dto.response.ModalityResponse;
import br.com.cezarcruz.gymback.modality.domain.usecase.CreateModalityUseCase;
import br.com.cezarcruz.gymback.modality.domain.usecase.GetModalityUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/modalities", produces = MediaType.APPLICATION_JSON_VALUE)
public class ModalityController {

    private final CreateModalityUseCase createModalityUseCase;
    private final GetModalityUseCase getModalityUseCase;

    public ModalityController(final CreateModalityUseCase createModalityUseCase,
                              final GetModalityUseCase getModalityUseCase) {
        this.createModalityUseCase = createModalityUseCase;
        this.getModalityUseCase = getModalityUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ModalityResponse create(@Valid @RequestBody final CreateModalityRequest createModalityRequest) {
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

}
