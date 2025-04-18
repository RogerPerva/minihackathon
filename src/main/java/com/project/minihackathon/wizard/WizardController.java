package com.project.minihackathon.wizard;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/wizards")
@RequiredArgsConstructor
public class WizardController {
  private final WizardRepository wizardRepository;

  @GetMapping
  public List<WizardEntity> getAllWizards() {
    return wizardRepository.findAll();
  }

  @GetMapping("/{id}")
  public Optional<WizardEntity> getWizardById(@PathVariable Integer id) {
    return wizardRepository.findById(id);
  }

  @PostMapping
  public WizardEntity createWizard(@RequestBody WizardEntity wizard) {
    return wizardRepository.save(wizard);
  }

  @PutMapping("/{id}")
  public WizardEntity updateWizard(@PathVariable Integer id, @RequestBody WizardEntity updatedWizard) {
    WizardEntity wizard = wizardRepository.getReferenceById(id);
    wizard.update(updatedWizard);
    return wizardRepository.save(wizard);
  }

  @DeleteMapping("/{id}")
  public void deleteWizard(@PathVariable Integer id) {
    wizardRepository.deleteById(id);
  }
}
