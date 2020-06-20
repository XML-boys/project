package com.Tim5.dto;

public class LongBoolDTO {
    private Long id;
    private Boolean blocked;

    public LongBoolDTO() {
    }

    public LongBoolDTO(Long id, Boolean blocked) {
        this.id = id;
        this.blocked = blocked;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }
}
