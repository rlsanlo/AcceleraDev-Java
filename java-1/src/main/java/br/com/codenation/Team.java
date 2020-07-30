package br.com.codenation;

import java.time.LocalDate;

public class Team {
    private long id;
    private String name;
    private LocalDate createdAt;
    private String homeKit;
    private String awayKit;
    private Long captain = null;

    public Team(long id, String name, LocalDate createdAt, String homeKit, String awayKit) {
        setId(id);
        setName(name);
        setCreatedAt(createdAt);
        setHomeKit(homeKit);
        setAwayKit(awayKit);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public void setHomeKit(String homeKit) {
        this.homeKit = homeKit;
    }

    public void setAwayKit(String awayKit) {
        this.awayKit = awayKit;
    }

    public void setCaptain(Long playerId) {
        this.captain = playerId;
    }

    public Long getCaptain() {
        return this.captain;
    }
}
