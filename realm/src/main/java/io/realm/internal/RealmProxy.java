package io.realm.internal;

import android.util.JsonReader;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;

import io.realm.Realm;

/**
 * Interface that all model proxy classes must implement.
 */
public interface RealmProxy {
    public Realm getRealm();
    public void setRealm(Realm realm);
    public Row getRow();
    public void setRow(Row row);
    public void populateUsingJsonObject(JSONObject json) throws JSONException;
    public void populateUsingJsonStream(JsonReader reader) throws java.io.IOException;
}
