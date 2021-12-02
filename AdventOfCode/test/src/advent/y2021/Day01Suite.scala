package advent.y2021

import cats.effect.IO
import weaver._

object Day01Suite extends SimpleIOSuite:
  test("part 1") {
    Day01
      .solve1("AdventOfCode/test/resources/y2021/Day01.txt")
      .flatMap(result => IO(expect.eql(result, 7)))
  }
  test("part2") {
    Day01
      .solve2("AdventOfCode/test/resources/y2021/Day01.txt")
      .flatMap(result => IO(expect.eql(result, 5)))
  }
