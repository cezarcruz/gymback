package br.com.cezarcruz.persistence.mysql.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressEntity extends CommonFields {

  @Id
  @UuidGenerator(style = UuidGenerator.Style.TIME)
  @Column(name = "id", columnDefinition = "VARCHAR(36)", updatable = false, unique = true, nullable = false)
  private String id;
  private String zipcode;
  private String street;
  private String neighborhood;
  private String city;
  private String state;
  private String addressNumber;

}


