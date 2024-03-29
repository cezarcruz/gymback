/* Under MIT License (C)2024 */
package br.com.gymback.core.domain;

import java.math.BigDecimal;
import java.util.List;
import lombok.Builder;
import lombok.With;

@Builder
public record ClassRoomDomain(
    Long id,
    String name,
    @With ModalityDomain modality,
    @With TeacherDomain teacher,
    @With List<ScheduleDomain> schedule,
    BigDecimal value)
    implements GenericDomain {}
