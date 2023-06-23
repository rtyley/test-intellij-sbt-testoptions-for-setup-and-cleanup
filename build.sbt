import scala.util.Properties
import java.nio.file.{Files, Path, Paths}

scalaVersion := "2.13.11"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.16" % Test

Test/testOptions += Tests.Argument(
  TestFrameworks.ScalaTest,
  "-u", s"test-results/scala-${scalaVersion.value}", "-o"
)

def file(name: String): Path = Paths.get(Properties.tmpDir, name)
val testSetupFile = file("test-setup")
val testCleanupFile = file("test-cleanup")

Test / testOptions += Tests.Setup(() => testSetupFile.toFile.createNewFile())
Test / testOptions += Tests.Cleanup(() => Files.delete(testCleanupFile))
