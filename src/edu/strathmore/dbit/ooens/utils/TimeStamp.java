package edu.strathmore.dbit.ooens.utils;

import java.time.LocalDateTime;

/**
 *
 * @author strategide
 */
public class TimeStamp {
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    public TimeStamp() {
        final LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
    }
    
    public TimeStamp(LocalDateTime dateTime) {
        this.createdAt = dateTime;
        this.updatedAt = dateTime;
    }

    public TimeStamp(LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
