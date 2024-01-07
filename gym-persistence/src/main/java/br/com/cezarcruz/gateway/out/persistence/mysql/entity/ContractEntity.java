package br.com.cezarcruz.gateway.out.persistence.mysql.entity;

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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.Month;
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

  @Enumerated(EnumType.STRING)
  @Column(name = "start_month")
  private Month startMonth;

  @Enumerated(EnumType.STRING)
  @Column(name = "end_month")
  private Month endMonth;

  @Column(name = "start_year")
  private Integer startYear;

  @Column(name = "end_year")
  private Integer endYear;

  @Column(name = "due_day", length = 2)
  private Integer dueDay;

  private BigDecimal discount;

  @Column(name = "contract_type")
  @Enumerated(EnumType.STRING)
  private ContractType contractType;

  @Column(name = "contract_status")
  @Enumerated(EnumType.STRING)
  private ContractStatus contractStatus;

  @ManyToOne
  @JoinColumn(name = "student_id")
  private StudentEntity student;

  @ManyToOne
  @JoinColumn(name = "class_room_id")
  private ClassRoomEntity classRoom;

  @ManyToMany
  @JoinTable(
      name = "contract_payment",
      joinColumns = @JoinColumn(name = "contract_id"),
      inverseJoinColumns = @JoinColumn(name = "payment_id")
  )
  private List<PaymentEntity> payments;

}
