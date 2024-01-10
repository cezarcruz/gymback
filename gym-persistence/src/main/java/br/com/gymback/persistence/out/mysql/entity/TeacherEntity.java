package br.com.gymback.persistence.out.mysql.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "teacher")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherEntity extends CommonFields implements GenericEntity {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @Column(name = "id", columnDefinition = "VARCHAR(36)", updatable = false, unique = true, nullable = false)
    private String id;

    private String name;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @OneToOne
    @JoinColumn(name = "contact_id")
    private ContactEntity contact;

}

