package com.project.minihackathon.magicalCriature;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/magical-creatures")
@RequiredArgsConstructor
public class MagicalCreatureController {

  private final MagicalCriatureRepository repository;

  @GetMapping
  public List<MagicalCriatureEntity> all() {
    return repository.findAll();
  }

  @GetMapping("/{id}")
  public MagicalCriatureEntity one(@PathVariable Integer id) {
    return repository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Magical creature not found: " + id));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public MagicalCriatureEntity create(@RequestBody MagicalCriatureEntity creature) {
    return repository.save(creature);
  }

  @PutMapping("/{id}")
  public MagicalCriatureEntity update(@PathVariable Integer id,
                                      @RequestBody MagicalCriatureEntity creature) {
    MagicalCriatureEntity existing = repository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Magical creature not found: " + id));
    existing.updateFrom(creature);
    return repository.save(existing);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Integer id) {
    if (!repository.existsById(id)) {
      throw new EntityNotFoundException("Magical creature not found: " + id);
    }
    repository.deleteById(id);
  }
}
