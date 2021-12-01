package advent.y2021

class Day01Suite extends munit.FunSuite:
  val puzzle = Day01("AdventOfCode/test/resources/y2021/day01.txt")
  test("part1")(assertEquals(puzzle.solve1, 7))
  test("part2")(assertEquals(puzzle.solve2, 5))
  
