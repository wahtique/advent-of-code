package advent.y2021

import advent.common.PuzzleSolver

import scala.io.BufferedSource

object Day01 extends PuzzleSolver[List[Int], Int]:
  override val inputFileName: String = "AdventOfCode/resources/y2021/Day01.txt"
  override val parse = (source: BufferedSource) =>
    source.getLines().map(_.toInt).toList
  override val solutionPart1 = (input: List[Int]) =>
    input.sliding(2).count(w => w.head < w.last)
  override val solutionPart2 = (input: List[Int]) =>
    input.sliding(3).map(_.sum).sliding(2).count(w => w.head < w.last)
