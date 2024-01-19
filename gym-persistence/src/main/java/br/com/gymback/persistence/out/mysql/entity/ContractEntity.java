package br.com.gymback.persistence.out.mysql.entity;

import br.com.gymback.core.enums.ContractStatus;
import br.com.gymback.core.enums.ContractType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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

@Entity
@Table(name = "contract")
@Getter
@Setter
public class ContractEntity extends CommonFields {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  @Column(name = "start_month", columnDefinition = "varchar(10)")
  private Month startMonth;

  @Enumerated(EnumType.STRING)
  @Column(name = "end_month", columnDefinition = "varchar(10)")
  private Month endMonth;

  @Column(name = "start_year", length = 4, columnDefinition = "mediumint")
  private Integer startYear;

  @Column(name = "end_year", length = 4, columnDefinition = "mediumint")
  private Integer endYear;

  @Column(name = "due_day", length = 2, columnDefinition = "smallint")
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
