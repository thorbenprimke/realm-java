package io.realm.entities;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class AutoincrementInt extends RealmObject {

    @PrimaryKey(autoincrement = true)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
