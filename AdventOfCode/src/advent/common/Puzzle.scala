package advent.common

import cats.effect._
import cats.effect.implicits._
import scala.io.Source.fromFile
import scala.io.BufferedSource
import cats.effect.unsafe.implicits._

abstract class Puzzle[I, O](val inputFileName: String):

  // to define for each puzzle
  val parse: BufferedSource => I
  val solutionPart1: I => O
  val solutionPart2: I => O

  // common to each puzzle
  lazy val inputFile: Resource[IO, BufferedSource] =
    Resource.fromAutoCloseable(IO(fromFile(inputFileName)))
  def solve1: O = inputFile
    .use(source => IO(parse(source)))
    .map(solutionPart1)
    .unsafeRunSync()
  def solve2: O = inputFile
    .use(source => IO(parse(source)))
    .map(solutionPart2)
    .unsafeRunSync()
  def printSolutions =
    println(s"Solution part 1: $solve1")
    println(s"Solution part 2: $solve2")
