package br.com.gymback.persistence.out.mysql.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "class_room")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClassRoomEntity extends CommonFields implements GenericEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @ManyToOne
  @JoinColumn(name = "modality_id")
  private ModalityEntity modality;

  @ManyToOne
  @JoinColumn(name = "teacher_id")
  private TeacherEntity teacher;

  private BigDecimal value;

  @ManyToMany
  @JoinTable(
      name = "class_room_schedule",
      joinColumns = @JoinColumn(name = "class_room_id"),
      inverseJoinColumns = @JoinColumn(name = "schedule_id")
  )
  private List<ScheduleEntity> schedule;

}
