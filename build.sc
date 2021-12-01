import mill._, scalalib._

trait Day extends ScalaModule {
  def scalaVersion = "3.1.0"
  def ivyDeps = Agg(ivy"org.typelevel::cats-core:2.6.1")
  object test extends Tests {
    def ivyDeps = Agg(ivy"org.scalameta::munit:1.0.0-M1")
    def testFrameworks = Seq("munit.Framework")
  }
}

object AdventOfCode2021 extends Module {
  object Day1 extends Day
  object Day2 extends Day
  object Day3 extends Day
  object Day4 extends Day
  object Day5 extends Day
  object Day6 extends Day
  object Day7 extends Day
  object Day8 extends Day
  object Day9 extends Day
  object Day10 extends Day
  object Day11 extends Day
  object Day12 extends Day
  object Day13 extends Day
  object Day14 extends Day
  object Day15 extends Day
  object Day16 extends Day
  object Day17 extends Day
  object Day18 extends Day
  object Day19 extends Day
  object Day20 extends Day
  object Day21 extends Day
  object Day22 extends Day
  object Day23 extends Day
  object Day24 extends Day
  object Day25 extends Day
}