package io.realm.examples.intro.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by thorben on 2/17/15.
 */
public class Town extends RealmObject {

  @PrimaryKey
  private String townId;

  private String name;

  private Person townOwner;

  private OtherData otherData;

  public Town() {
  }

  public Town(String id, String sf) {
    townId = id;

  }

  public String getTownId() {
    return townId;
  }

  public void setTownId(String townId) {
    this.townId = townId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Person getTownOwner() {
    return townOwner;
  }

  public void setTownOwner(Person townOwner) {
    this.townOwner = townOwner;
  }

  public OtherData getOtherData() {
    return otherData;
  }

  public void setOtherData(OtherData otherData) {
    this.otherData = otherData;
  }
}
