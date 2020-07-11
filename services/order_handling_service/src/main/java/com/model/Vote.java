package com.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    private Double vrednost;
    @Column
    private Long idUsera;
    @Column
    private Boolean approved;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Ad reklamaz;

    public Vote() {
    }

    public Vote(Long id, Long idKola, Long idReklame, Double vrednost) {
        this.id = id;
        this.idKola = idKola;
        this.idReklame = idReklame;
        this.vrednost = vrednost;
    }

    public Vote(Long id, Long idKola, Long idReklame, Double vrednost, Boolean approved) {
        this.id = id;
        this.idKola = idKola;
        this.idReklame = idReklame;
        this.vrednost = vrednost;
        this.approved = approved;
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

    public Double getVrednost() {
        return vrednost;
    }

    public void setVrednost(Double vrednost) {
        this.vrednost = vrednost;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public Ad getReklamaz() {
        return reklamaz;
    }

    public void setReklamaz(Ad reklamaz) {
        this.reklamaz = reklamaz;
    }

    public Long getIdUsera() {
        return idUsera;
    }

    public void setIdUsera(Long idUsera) {
        this.idUsera = idUsera;
    }
}
