package advent.y2021

import advent.common.Puzzle

import scala.io.BufferedSource

class Day01(inputFile: String) extends Puzzle[List[Int], Int](inputFile):
  override val parse = (source: BufferedSource) =>
    source.getLines().map(_.toInt).toList
  override val solutionPart1 = (input: List[Int]) =>
    input.sliding(2).count(w => w.head < w.last)
  override val solutionPart2 = (input: List[Int]) =>
    input.sliding(3).map(_.sum).sliding(2).count(w => w.head < w.last)

@main def main(): Unit =
  Day01("AdventOfCode/resources/y2021/day01.txt").printSolutions
