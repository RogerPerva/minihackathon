package com.project.minihackathon.wizard;

import com.project.minihackathon.enums.House;
import com.project.minihackathon.enums.Level;
import com.project.minihackathon.enums.Speciality;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "wizard")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WizardEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false, nullable = false)
  private Integer id;

  @Column(name = "name", nullable = false)
  private String name;

  @Enumerated(EnumType.STRING)
  @Column(name = "level", nullable = false)
  private Level level;

  @Enumerated(EnumType.STRING)
  @Column(name = "speciality", nullable = false)
  private Speciality speciality;

  @Enumerated(EnumType.STRING)
  @Column(name = "house", nullable = false)
  private House house;

  @Column(name = "active", nullable = false)
  private Boolean active;

  @Column(name = "enroll_date", nullable = false)
  private Date enrollDate;

  public void update(WizardEntity updatedWizard) {
    this.name = updatedWizard.getName();
    this.level = updatedWizard.getLevel();
    this.speciality = updatedWizard.getSpeciality();
    this.house = updatedWizard.getHouse();
    this.active = updatedWizard.getActive();
    this.enrollDate = updatedWizard.getEnrollDate();
  }
}
