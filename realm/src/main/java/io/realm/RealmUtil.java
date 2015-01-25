package io.realm;

import io.realm.internal.RealmProxy;

/**
 * Created by cm on 24/01/15.
 */
public class RealmUtil {
    public static RealmProxy getProxy(Object object) {
        if (object instanceof RealmProxy) {
            return (RealmProxy) object;
        }

        throw new IllegalArgumentException("Class is either not a Realm class or isn't in this Realms Schema");
    }
}
