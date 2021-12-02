package advent.y2021

import munit.CatsEffectSuite
import cats.effect.IO

class Day01Suite extends CatsEffectSuite:
  val solver = Day01("AdventOfCode/test/resources/y2021/day01.txt")
  test("part1")(solver.solve1.flatMap(result => IO(assertEquals(result, 7))))
  test("part2")(solver.solve2.flatMap(result => IO(assertEquals(result, 5))))
  
