package io.realm.entities;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class AutoincrementLong extends RealmObject {

    @PrimaryKey(autoincrement = true)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
