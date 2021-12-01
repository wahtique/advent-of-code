import mill._, scalalib._

object AdventOfCode2021 extends ScalaModule {
  def scalaVersion = "3.1.0"

  object test extends Tests {
    def ivyDeps = Agg(ivy"org.scalameta::munit:0.7.29")
    def testFrameworks = Seq("munit.Framework")
  }
}