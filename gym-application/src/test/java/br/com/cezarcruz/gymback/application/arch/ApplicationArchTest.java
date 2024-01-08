package br.com.cezarcruz.gymback.application.arch;


import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.RestController;

public class ApplicationArchTest {

  @Test
  void validateApplicationModuleArch() {
    final var importedClasses = new ClassFileImporter().importPackages("br.com.cezarcruz.gymback.application");

    final var rule =
        classes().that()
            .areAnnotatedWith(RestController.class)
            .should()
              .haveNameMatching(".*Controller")
            .andShould()
              .resideInAPackage("br.com.cezarcruz.gymback.application.rest")
            .andShould()
              .onlyHaveDependentClassesThat()
            .resideInAnyPackage("br.com.cezarcruz.gymback.application.rest.mapper", "br.com.cezarcruz.gymback.core.usecase.teacher")

        ;

    rule.check(importedClasses);
  }

}
