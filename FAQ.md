# Realm for Android FAQ

This document contains questions an answers to various questions about how Realm works and why it
the design is the way it is.

For a high level view of Realm please start here: http://realm.io/news/introducing-realm/


# Q: Why do I need to extend RealmObject?

A: The reason for this is so we can add Realm specific functionality to your model classes.
Currently only *removeFromRealm()*, but others might show up. It also allow us to use generics
in our API's, making it easier to read and use.


# Q: What is the \*RealmProxy classes about?
A: For every model class in your project, the Realm annotation processor will generate a
corresponding RealmProxy class.

A key design choice for Realm is that you never should operate on copies of data. There is only ever
one copy of it.

When your retrieve or create an an Realm object it doesn't really contain any data, it just contain
references to those data in the database, and the data is only manipulated when needed. This
abstraction is hidden away in the Proxy classes which extend your model class, so from the point of
view of the IDE, you don't notice any difference.

This design allows us not only to gain a large speedup in queries, but also reduce memory
requirements. Conceptually you can view a query result from Realm as a sort of advanced Cursor in
Android.

Essentially, your model class functions as a schema for the database, and the real implementation
is hidden away in the Proxy classes. This is also why you need to either reset or migrate your
database when the model class changes.


# Q: Why do I need to have getters and setters for all my fields?

A: This ties into how the generated RealmProxy classes work plus a limitation of Java in general.

In order for us to rewire all field access to reference the database instead of a local copy
of the data we need to override all access to those fields. This is unfortunately not possible in
Java when directly accessing public fields which is why we require private fields with getters and
setters.

It is not an ideal situation and we would love to get rid of this requirement. Some solutions
like AspectJ and Javassist might make it possible but we are still investigating the possibilities.





