package br.com.gymback.core.arch;

import static com.tngtech.archunit.base.DescribedPredicate.doesNot;
import static com.tngtech.archunit.core.domain.JavaClass.Predicates.resideOutsideOfPackages;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;
import jakarta.inject.Named;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

class CoreArchTest {

  private static final JavaClasses IMPORTED_CLASSES =
      new ClassFileImporter()
          .withImportOption(new DoNotIncludeTests())
          .importPackages("br.com.gymback.core");

  @Test
  void validateUseCaseAnnotations() {
    final var rule =
        classes()
            .that()
            .haveNameMatching(".*UseCase")
            .should()
            .beAnnotatedWith(Named.class)
            .andShould()
            .resideInAnyPackage("br.com.gymback.core.usecase.*")
        ;

    rule.check(IMPORTED_CLASSES);

  }

  @Test
  void ensureGatewayPattern() {
    var packageAndNameRule = classes()
        .that()
          .resideInAPackage("br.com.gymback.core.gateway.*")
        .and(doesNot(resideOutsideOfPackages("br.com.gymback.core.gateway.*")))
        .should()
          .haveNameMatching(".*Gateway")
        .andShould()
          .beInterfaces();

    packageAndNameRule.check(IMPORTED_CLASSES);
  }

  @Test
  void ensureDomainPattern() {
    var rule = classes()
        .that()
          .resideInAPackage("br.com.gymback.core.domain")
          .and(doesNot(resideOutsideOfPackages("br.com.gymback.core.domain", "br.com.gymback.core.domain.*")))
        .should()
          .haveNameMatching(".*Domain")
        .orShould()
          .haveNameMatching(".*DomainBuilder");

    rule.check(IMPORTED_CLASSES);
  }

  @Test
  void ensureDoesNotHaveAnyKindComponentAnnotated() {
    var rule = classes()
        .should()
          .notBeAnnotatedWith(Component.class)
        .andShould()
          .notBeAnnotatedWith(Service.class)
        .andShould()
          .notBeAnnotatedWith(Repository.class);

    rule.check(IMPORTED_CLASSES);
  }

}
