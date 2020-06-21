package com.model;

public class VoteDTO {
    private Long id;
    private Long idKola;
    private Long idReklame;
    private Long vrednost;

    public VoteDTO() {
    }

    public VoteDTO(Long id, Long idKola, Long idReklame, Long vrednost) {
        this.id = id;
        this.idKola = idKola;
        this.idReklame = idReklame;
        this.vrednost = vrednost;
    }

    public VoteDTO(Vote vote) {
        this.id = vote.getId();
        this.idKola = vote.getIdKola();
        this.idReklame = vote.getIdReklame();
        this.vrednost = vote.getVrednost();
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
