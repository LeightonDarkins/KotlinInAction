package chapterFour.ObjectDeclaration;

import java.io.File;

// Using a Kotlin singleton in JAVA

public class KotlinSingleton {
    public static void main(String[] args) {
        System.out.println("Equal? " + CaseInsensitiveFileComparator.INSTANCE.compare(new File("/test"), new File("/test")));
    }
}

