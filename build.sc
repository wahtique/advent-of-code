import mill._, scalalib._

object AdventOfCode extends ScalaModule {
  def scalaVersion = "3.1.0"
  def ivyDeps = Agg(
    ivy"org.typelevel::cats-core:2.6.1",
    ivy"org.typelevel::cats-effect:3.3.0"
  )
  object test extends Tests {
    def ivyDeps = Agg(
      ivy"org.scalameta::munit:1.0.0-M1",
      ivy"org.typelevel::munit-cats-effect-3:1.0.6"
    )
    def testFrameworks = Seq("munit.Framework")
  }
}