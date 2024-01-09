package br.com.gymback.core.arch;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;
import jakarta.inject.Named;
import org.junit.jupiter.api.Test;

public class CoreArchTest {

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

}
