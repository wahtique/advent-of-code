package advent.y2021

import cats.effect.IO
import munit.CatsEffectSuite

class Day01Suite extends CatsEffectSuite:
  test("part 1") {
    Day01
      .solve1("AdventOfCode/test/resources/y2021/Day01.txt")
      .flatMap(result => IO(assertEquals(result, 7)))
  }
  test("part2") {
    Day01
      .solve2("AdventOfCode/test/resources/y2021/Day01.txt")
      .flatMap(result => IO(assertEquals(result, 5)))
  }
