package br.com.gymback.persistence.out.mysql.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentEntity extends CommonFields implements GenericEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String document;

  @Column(name = "birth_date")
  private LocalDate birthDate;

  @OneToOne
  @JoinColumn(name = "address_id")
  private AddressEntity address;

  @OneToOne
  @JoinColumn(name = "contact_id")
  private ContactEntity contact;

}
