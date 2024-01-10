package br.com.cezarcruz.gateway.arch;

import static com.tngtech.archunit.core.domain.JavaClass.Predicates.resideInAPackage;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import br.com.gymback.persistence.out.mysql.entity.CommonFields;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;
import jakarta.persistence.Entity;
import org.junit.jupiter.api.Test;
import org.mapstruct.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

class PersistenceArchTest {

  private static final JavaClasses IMPORTED_CLASSES =
      new ClassFileImporter()
          .withImportOption(new DoNotIncludeTests())
          .importPackages("br.com.gymback.persistence.out.mysql");

  @Test
  void ensureRepositoryPatters() {
    var rule = classes()
        .that()
        .areAnnotatedWith(Repository.class)
        .should()
          .resideInAnyPackage("br.com.gymback.persistence.out.mysql.repository")
        .andShould()
          .haveNameMatching(".*Repository")
        .andShould()
          .beInterfaces();

    rule.check(IMPORTED_CLASSES);
  }

  @Test
  void ensureGatewayPatterns() {
    var rule = classes()
        .that()
          .haveNameMatching(".*Gateway")
        .should()
          .resideInAnyPackage("br.com.gymback.persistence.out.mysql")
        .andShould()
          .implement(resideInAPackage("br.com.gymback.core.gateway.*"))
        .orShould()
          .beAssignableTo(JpaRepository.class)
        ;

    rule.check(IMPORTED_CLASSES);
  }

  @Test
  void ensureMapperPattern() {
    var rule = classes()
        .that()
          .areAnnotatedWith(Mapper.class)
        .should()
          .resideInAPackage("br.com.gymback.persistence.out.mysql.mapper")
        .andShould()
        .haveNameMatching(".*PersistenceMapper");

    rule.check(IMPORTED_CLASSES);
  }

  @Test
  void ensureEntityPattern() {
    var rule = classes()
        .that()
            .areAnnotatedWith(Entity.class)
        .should()
            .resideInAPackage("br.com.gymback.persistence.out.mysql.entity")
        .andShould()
            .beAssignableTo(CommonFields.class)

        ;

    rule.check(IMPORTED_CLASSES);
  }

}
