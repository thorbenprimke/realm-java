package io.realm.entities;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class AutoincrementShort extends RealmObject {

    @PrimaryKey(autoincrement = true)
    private short id;

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }
}
