package br.com.cezarcruz.gymback.core.domain;

import java.math.BigDecimal;
import java.util.List;
import lombok.Builder;
import lombok.With;

@Builder
public record ClassRoom (

    String id,
    String name,
    @With
    Modality modality,
    @With
    Teacher teacher,
    @With
    List<Schedule> schedule,

    BigDecimal value
) {

}
