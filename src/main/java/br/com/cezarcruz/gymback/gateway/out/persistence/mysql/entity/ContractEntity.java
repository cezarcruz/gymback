package br.com.cezarcruz.gymback.gateway.out.persistence.mysql.entity;

import br.com.cezarcruz.gymback.core.enums.ContractStatus;
import br.com.cezarcruz.gymback.core.enums.ContractType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "contract")
@Getter
@Setter
public class ContractEntity extends CommonFields {

  @Id
  @UuidGenerator(style = UuidGenerator.Style.TIME)
  @Column(name = "id", columnDefinition = "VARCHAR(36)", updatable = false, unique = true, nullable = false)
  private String id;

  @Column(name = "start_date")
  private LocalDate startDate;

  @Column(name = "end_date")
  private LocalDate endDate;

  @Column(name = "due_day", length = 2)
  private String dueDay;

  private Integer discount;

  @Column(name = "contract_type")
  @Enumerated(EnumType.STRING)
  private ContractType contractType;

  @Column(name = "contract_status")
  @Enumerated(EnumType.STRING)
  private ContractStatus contractStatus;

  @ManyToMany
  @JoinTable(
      name = "contract_student",
      joinColumns = @JoinColumn(name = "contract_id"),
      inverseJoinColumns = @JoinColumn(name = "student_id")
  )
  private List<StudentEntity> students;

  @ManyToMany
  @JoinTable(
      name = "payment_student",
      joinColumns = @JoinColumn(name = "contract_id"),
      inverseJoinColumns = @JoinColumn(name = "payment_id")
  )
  private List<PaymentEntity> payments;

}
