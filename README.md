Workaround for Gradle issue https://github.com/gradle/gradle/issues/2657

(SLF4J ClassCastException when testing with custom system ClassLoader or Java 9 modules)

        java.lang.ClassCastException: org.slf4j.simple/org.slf4j.simple.SimpleLoggerFactory cannot be cast to org.gradle.internal.logging.slf4j.OutputEventListenerBackedLoggerContext
                at org.gradle.internal.logging.slf4j.Slf4jLoggingConfigurer.configure(Slf4jLoggingConfigurer.java:42)
                at org.gradle.internal.logging.config.LoggingSystemAdapter.startCapture(LoggingSystemAdapter.java:54)
                at org.gradle.internal.logging.services.DefaultLoggingManager$StartableLoggingSystem.start(DefaultLoggingManager.java:297)
                at org.gradle.internal.logging.services.DefaultLoggingManager.start(DefaultLoggingManager.java:73)
                at org.gradle.internal.logging.services.DefaultLoggingManager.start(DefaultLoggingManager.java:37)
                at org.gradle.process.internal.worker.child.SystemApplicationClassLoaderWorker.call(SystemApplicationClassLoaderWorker.java:83)
                at org.gradle.process.internal.worker.child.SystemApplicationClassLoaderWorker.call(SystemApplicationClassLoaderWorker.java:64)
                at worker.org.gradle.process.internal.worker.GradleWorkerMain.run(GradleWorkerMain.java:62)
                at worker.org.gradle.process.internal.worker.GradleWorkerMain.main(GradleWorkerMain.java:67)

This error is a masked ClassNotFoundException.
				
The ida was that may adding the right dependencies to the test classpath will solve the problem.

One problem is with this solution is that gradle internals are not available in maven repos (or I have not found them), so I decided to put them as local jar to the classpath.

Second problem is that this solution utilizes Gradle 4.10.2 jars and it is not 100% that will work with other versions.

Third problem is that the modification of the test classpath may cause other side effects.

I tested this workaround with Oracle JDK 9 and JDK 10 64 bit (Windows 10 64 bit OS)