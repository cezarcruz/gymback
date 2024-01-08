package br.com.cezarcruz.gymback.application.rest.dto.request;

import br.com.gymback.core.enums.ContractType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Month;

public record CreateContractRequest(
    @NotNull
    @NotBlank
    String student,
    @NotNull
    @NotBlank
    String classRoom,
    BigDecimal discount,
    @NotNull
    @Max(31)
    Integer dueDay,
    ContractType contractType,
    Month startMonth,
    Month endMonth,
    @Schema(example = "2023", description = "Start Year")
    Integer startYear,
    @Schema(example = "2024", description = "End hour")
    Integer endYear

) {

}
