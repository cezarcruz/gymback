package br.com.cezarcruz.gymback.gateway.out.persistence.mysql.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentEntity extends CommonFields {

  @Id
  @UuidGenerator(style = UuidGenerator.Style.TIME)
  @Column(name = "id", columnDefinition = "VARCHAR(36)", updatable = false, unique = true, nullable = false)
  private String id;
  private String name;
  private Integer age;
  private String email;

  @OneToOne
  @JoinColumn(name = "address_id")
  private AddressEntity address;

}
