package br.com.cezarcruz.core.domain;

import java.math.BigDecimal;
import java.util.List;
import lombok.Builder;
import lombok.With;

@Builder
public record ClassRoomDomain(

    String id,
    String name,
    @With
    ModalityDomain modality,
    @With
    Teacher teacher,
    @With
    List<ScheduleDomain> schedule,

    BigDecimal value
) {

}