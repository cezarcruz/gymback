package br.com.cezarcruz.gymback.modality.application.controller;

import br.com.cezarcruz.gymback.modality.domain.dto.request.CreateModalityRequest;
import br.com.cezarcruz.gymback.modality.domain.dto.response.ModalityResponse;
import br.com.cezarcruz.gymback.modality.domain.usecase.CreateModalityUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/modalities", produces = MediaType.APPLICATION_JSON_VALUE)
public class ModalityController {

    private final CreateModalityUseCase createModalityUseCase;

    public ModalityController(CreateModalityUseCase createModalityUseCase) {
        this.createModalityUseCase = createModalityUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ModalityResponse create(@Valid @RequestBody final CreateModalityRequest createModalityRequest) {
        final var modality = createModalityRequest.toModality();
        final var createdModality = createModalityUseCase.create(modality);
        return ModalityResponse.from(createdModality);
    }

}
