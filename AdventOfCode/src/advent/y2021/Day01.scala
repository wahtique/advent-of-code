package advent.y2021

import advent.common.PuzzleSolver
import cats.effect.IOApp

import scala.io.BufferedSource

object Day01 extends PuzzleSolver[List[Int], Int]:
  override val parse = (source: BufferedSource) =>
    source.getLines().map(_.toInt).toList
  override val solutionPart1 = (input: List[Int]) =>
    input.sliding(2).count(w => w.head < w.last)
  override val solutionPart2 = (input: List[Int]) =>
    input.sliding(3).map(_.sum).sliding(2).count(w => w.head < w.last)

object Day01App extends IOApp.Simple:
  val run = Day01.printSolutions("AdventOfCode/resources/y2021/Day01.txt")
