/* Under MIT License (C)2024 */
package br.com.gymback.persistence.out.mysql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "week_day")
@AllArgsConstructor
@NoArgsConstructor
public class WeekDayEntity extends CommonFields {

  // TODO change this to another thing
  @Id private String name;
  private String label;
}
