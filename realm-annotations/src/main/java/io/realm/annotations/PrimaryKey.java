/*
 * Copyright 2014 Realm Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.realm.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The @PrimaryKey annotation will mark a field as a primary key inside Realm. The field
 * should uniquely identify the object. Trying to insert an object with an existing primary key
 * will result in an {@link io.realm.exceptions.RealmException}.
 *
 * Primary keys on Strings also counts as having the {@link io.realm.annotations.Index} annotation.
 *
 * Only one field pr. model class can have this annotation and it is only allowed on the following
 * types: String, short, int, long
 *
 * Setting autoincrement only works for short, int and long fields and means that Realm automatically
 * sets the value to max() + 1 for all objects of that type. The first object gets a primary key
 * value of 1. If a autoincremented value hits the maximum value for the datatype a RealmException
 * will be thrown, and no futher elements can be inserted. Trying to set the value manually will
 * also result in a RealmException.
 *
 * Autoincremented keys are usually not needed, and adding them has a negative impact on
 * disc space and creating and copying objects into Realm.
 *
 * Some rough estimates for creating new objects are (Nexus 5 w/ Lollipop 5.0.1):
 *
 * - Object with no primary key defined (baseline): 100%
 * - Object with a long primary key: ???
 * - Object with a string primary key: ???
 * - Object with a autoincremented long primary key: ???
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.FIELD)
public @interface PrimaryKey {
    boolean autoincrement() default false;
}
