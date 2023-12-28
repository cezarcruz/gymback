package br.com.cezarcruz.gymback.core.domain;

import br.com.cezarcruz.gymback.core.enums.ContractStatus;
import br.com.cezarcruz.gymback.core.enums.ContractType;
import java.time.LocalDate;
import java.util.List;

public record Contract(
    String id,
    LocalDate startDate,
    LocalDate endDate,
    String dueDay,
    Integer discount,
    ContractType contractType,
    ContractStatus contractStatus,
    List<Student> students,
    List<Payment> payments
) {

}
