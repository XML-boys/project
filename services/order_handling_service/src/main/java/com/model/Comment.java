package com.model;

import javax.persistence.*;
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long idKomentatora;
    @Column
    private String sadrzaj;
    @Column
    private Boolean approved;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@JoinColumn(name = "reklamak")
    private Ad reklamak;

    public Comment() {
    }

    public Comment(Long id, Long idKomentatora, String sadrzaj, Ad reklamak) {
        this.id = id;
        this.idKomentatora = idKomentatora;
        this.sadrzaj = sadrzaj;
        this.reklamak = reklamak;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdKomentatora() {
        return idKomentatora;
    }

    public void setIdKomentatora(Long idKomentatora) {
        this.idKomentatora = idKomentatora;
    }

    public String getSadrzaj() {
        return sadrzaj;
    }

    public void setSadrzaj(String sadrzaj) {
        this.sadrzaj = sadrzaj;
    }

    public Ad getReklamak() {
        return reklamak;
    }

    public void setReklamak(Ad reklamak) {
        this.reklamak = reklamak;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }
}
