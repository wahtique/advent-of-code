package advent.y2021

import advent.common.PuzzleSolver

import scala.io.BufferedSource
import cats.effect.IOApp

class Day01(val inputFileName: String) extends PuzzleSolver[List[Int], Int]:
  override val parse = (source: BufferedSource) =>
    source.getLines().map(_.toInt).toList
  override val solutionPart1 = (input: List[Int]) =>
    input.sliding(2).count(w => w.head < w.last)
  override val solutionPart2 = (input: List[Int]) =>
    input.sliding(3).map(_.sum).sliding(2).count(w => w.head < w.last)

object Main extends IOApp.Simple:
  val run = Day01("AdventOfCode/resources/y2021/day01.txt").printSolutions