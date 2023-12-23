package br.com.cezarcruz.gymback.core.domain;

import java.util.List;
import lombok.With;

public record ClassRoom (
    String name,
    @With
    Modality modality,
    @With
    Teacher teacher,
    List<String> weekDays
) {

}
