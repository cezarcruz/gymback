/* Under MIT License (C)2024 */
package br.com.gymback.persistence.out.mysql.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalTime;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "schedule")
public class ScheduleEntity extends CommonFields {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "week_day")
  private WeekDayEntity weekDay;

  @Column(name = "start_hour")
  private LocalTime startHour;

  @Column(name = "end_hour")
  private LocalTime endHour;
}
