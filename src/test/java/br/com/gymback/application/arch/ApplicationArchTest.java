/* Under MIT License (C)2024 */
package br.com.gymback.application.arch;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

class ApplicationArchTest {

  private static final JavaClasses IMPORTED_CLASSES =
      new ClassFileImporter()
          .withImportOption(new DoNotIncludeTests())
          .importPackages("br.com.gymback.application");

  @Test
  void validateApplicationModuleArch() {

    final var rule =
        classes()
            .that()
            .areAnnotatedWith(RestController.class)
            .should()
            .haveNameMatching(".*Controller")
            .andShould()
            .resideInAPackage("br.com.gymback.application.rest")
            .andShould()
            .onlyHaveDependentClassesThat()
            .resideInAnyPackage(
                "br.com.gymback.application.rest.mapper", "br.com.gymback.core.usecase");

    rule.check(IMPORTED_CLASSES);
  }

  @Test
  void ensureConfigConventions() {
    var rule =
        classes()
            .that()
            .areAnnotatedWith(Configuration.class)
            .should()
            .haveNameMatching(".*Config")
            .andShould()
            .resideInAPackage("br.com.gymback.application.config.*");

    rule.check(IMPORTED_CLASSES);
  }

  @Test
  void layerArchValidations() {
    final var layers =
        layeredArchitecture()
            .consideringAllDependencies()
            .layer("Controller")
            .definedBy("..rest..")
            .whereLayer("Controller")
            .mayNotBeAccessedByAnyLayer();

    layers.check(IMPORTED_CLASSES);
  }
}
