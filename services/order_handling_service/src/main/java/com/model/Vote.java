package com.model;

import javax.persistence.*;

@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long idKola;
    @Column
    private Long idReklame;
    @Column
    private Long vrednost;

    public Vote() {
    }

    public Vote(Long id, Long idKola, Long idReklame, Long vrednost) {
        this.id = id;
        this.idKola = idKola;
        this.idReklame = idReklame;
        this.vrednost = vrednost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdKola() {
        return idKola;
    }

    public void setIdKola(Long idKola) {
        this.idKola = idKola;
    }

    public Long getIdReklame() {
        return idReklame;
    }

    public void setIdReklame(Long idReklame) {
        this.idReklame = idReklame;
    }

    public Long getVrednost() {
        return vrednost;
    }

    public void setVrednost(Long vrednost) {
        this.vrednost = vrednost;
    }
}