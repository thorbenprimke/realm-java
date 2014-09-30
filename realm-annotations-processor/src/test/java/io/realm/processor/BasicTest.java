package io.realm.processor;

import com.google.testing.compile.JavaFileObjects;
import org.junit.Test;

import static com.google.testing.compile.JavaSourceSubjectFactory.javaSource;
import static org.truth0.Truth.ASSERT;

public class BasicTest {

    @Test
    public void basic() {
        ASSERT.about(javaSource())
                .that(JavaFileObjects.forSourceString("HelloWorld", "final class HelloWorld {}"))
                .compilesWithoutError();
    }

}
