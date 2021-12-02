package advent.y2021

import cats.effect.IO
import cats.implicits._
import weaver._

object Day02Suite extends SimpleIOSuite:
  test("part 1") {
    Day02
      .solve1("AdventOfCode/test/resources/y2021/Day02.txt")
      .flatMap(result => IO(expect.eql(result, 150L)))
  }
  test("part 2") {
    Day02
      .solve2("AdventOfCode/test/resources/y2021/Day02.txt")
      .flatMap(result => IO(expect.eql(result, 900L)))
  }
