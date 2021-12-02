import mill._, scalalib._

object AdventOfCode extends ScalaModule {
  def scalaVersion = "3.1.0"
  def ivyDeps = Agg(
    ivy"org.typelevel::cats-core:2.6.1",
    ivy"org.typelevel::cats-effect:3.3.0"
  )
  object test extends Tests {
    def ivyDeps = Agg(
      ivy"com.disneystreaming::weaver-cats:0.7.6"
    )
    def testFramework = "weaver.framework.CatsEffect"
  }
}