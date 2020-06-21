package com.model;

public class CommentDTO {
    private Long id;
    private Long idKomentatora;
    private String sadrzaj;
    private Ad reklamak;
    private Boolean approved;

    public CommentDTO() {
    }

    public CommentDTO(Long id, Long idKomentatora, String sadrzaj, Ad reklamak) {
        this.id = id;
        this.idKomentatora = idKomentatora;
        this.sadrzaj = sadrzaj;
        this.reklamak = reklamak;
    }

    public CommentDTO(Comment comment) {
        this.id = comment.getId();
        this.idKomentatora = comment.getIdKomentatora();
        this.sadrzaj = comment.getSadrzaj();
        this.reklamak = comment.getReklamak();
        this.approved = comment.getApproved();
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
