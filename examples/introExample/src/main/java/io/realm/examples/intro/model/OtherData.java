package io.realm.examples.intro.model;

import io.realm.RealmObject;

/**
 * Created by thorben on 2/17/15.
 */
public class OtherData extends RealmObject {

  private Person person;

  private String info;

  public OtherData() {
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }
}
