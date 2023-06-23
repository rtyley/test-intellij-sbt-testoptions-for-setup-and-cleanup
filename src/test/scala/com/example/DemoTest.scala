package com.example

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import java.nio.file.StandardOpenOption.{APPEND, CREATE, WRITE}
import java.nio.file.{Files, Path, Paths}
import scala.util.Properties

class DemoTest extends AnyFunSuite with Matchers {

  def file(name: String): Path = Paths.get(Properties.tmpDir, name)
  val testSetupFile: Path = file("test-setup")
  val testCleanupFile: Path = file("test-cleanup")
  val bytes = new Array[Byte](1024)

  test("check file that should be created by sbt Tests.Setup does exist") {
    Files.exists(testSetupFile) shouldBe true
    Files.delete(testCleanupFile) // it should be created by sbt Tests.Setup
  }

  test("check file that should be cleaned up by sbt Tests.Cleanup does not get bigger") {
    Files.write(testCleanupFile, bytes, CREATE, WRITE, APPEND).toFile.length() shouldEqual bytes.length
  }


}