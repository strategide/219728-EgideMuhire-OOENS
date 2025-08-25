package edu.strathmore.dbit.ooens.entity;

import edu.strathmore.dbit.ooens.utils.TimeStamp;

/**
 *
 * @author strategide
 */
public abstract class BaseEntity {
    private String id;
    private TimeStamp timeStamp;
    
    public BaseEntity(String id, TimeStamp timeStamp) {
        this.id = id;
        this.timeStamp = timeStamp;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public TimeStamp getTimeStamp() {
        return timeStamp;
    }
    
    public void setTimeStamp(TimeStamp timeStamp) {
        this.timeStamp = timeStamp;
    }
}
