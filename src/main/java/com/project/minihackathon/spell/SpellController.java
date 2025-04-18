package com.project.minihackathon.spell;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/spells")
@RequiredArgsConstructor
public class SpellController {
  private final SpellRepository spellRepository;

  @GetMapping
  public List<SpellEntity> all() { return spellRepository.findAll(); }

  @GetMapping("/{id}")
  public SpellEntity one(@PathVariable Integer id) {
    return spellRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Spell not found: " + id));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public SpellEntity create(@RequestBody SpellEntity spell) {
    return spellRepository.save(spell);
  }

  @PutMapping("/{id}")
  public SpellEntity update(@PathVariable Integer id,
                            @RequestBody SpellEntity spell) {
    SpellEntity existing = spellRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Spell not found: " + id));
    existing.updateFrom(spell);
    return spellRepository.save(existing);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Integer id) {
    if (!spellRepository.existsById(id)) {
      throw new EntityNotFoundException("Spell not found: " + id);
    }
    spellRepository.deleteById(id);
  }
}
