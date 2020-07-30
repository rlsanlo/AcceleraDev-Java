package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Player {
    private long id;
    private long idTeam;
    private String name;
    private LocalDate birthDate;
    private int skillLevel;
    private BigDecimal salary;

    public Player(long id, long idTeam, String name, LocalDate birthDate, int skillLevel, BigDecimal salary) {
        setId(id);
        setIdTeam(idTeam);
        setName(name);
        setBirthDate(birthDate);
        setSkillLevel(skillLevel);
        setSalary(salary);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(long idTeam) {
        this.idTeam = idTeam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(int skillLevel) {
        if (skillLevel > 100)
            this.skillLevel = 100;
        else
            this.skillLevel = skillLevel;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
