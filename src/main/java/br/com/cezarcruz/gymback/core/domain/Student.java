package br.com.cezarcruz.gymback.core.domain;

import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.entity.StudentEntity;

public record Student (
    Long id,
    String name,
    Integer age,
    Address address
) {

  public static Student fromEntity(final StudentEntity studentEntity) {
    return new Student(studentEntity.getId(),
        studentEntity.getName(),
        studentEntity.getAge(),
        Address.fromEntity(studentEntity.getAddress()));
  }

  public StudentEntity toEntity() {
    var studentEntity = new StudentEntity();

    studentEntity.setAge(age());
    studentEntity.setName(name());
    studentEntity.setAddress(address.toEntity());
    return studentEntity;
  }

  public Student withAddress(final Address address) {
    return new Student(id(), name(), age(), address);
  }
}
