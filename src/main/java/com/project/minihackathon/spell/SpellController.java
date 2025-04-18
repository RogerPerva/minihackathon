package com.project.minihackathon.spell;

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
  private final SpellService spellService;

  @GetMapping
  public List<SpellEntity> all() { return spellService.listAll(); }

  @GetMapping("/{id}")
  public SpellEntity one(@PathVariable Integer id) {
    return spellService.getById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public SpellEntity create(@RequestBody SpellEntity spell) {
    return spellService.create(spell);
  }

  @PutMapping("/{id}")
  public SpellEntity update(@PathVariable Integer id,
                            @RequestBody SpellEntity spell) {
    return spellService.update(id, spell);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Integer id) {
    spellService.delete(id);
  }
}
