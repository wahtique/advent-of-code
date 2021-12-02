package advent.common

import cats.effect._
import cats.effect.implicits._

import scala.io.BufferedSource
import scala.io.Source.fromFile

trait PuzzleSolver[I, O]:
  // to define for each puzzle

  val parse: BufferedSource => I
  val solutionPart1: I => O
  val solutionPart2: I => O

  // common to each puzzle

  def input(inputFile: String): Resource[IO, BufferedSource] =
    Resource.fromAutoCloseable(IO(fromFile(inputFile)))

  def solve1(inputFile: String): IO[O] =
    input(inputFile)
      .use(source => IO(parse(source)))
      .map(solutionPart1)

  def solve2(inputFile: String): IO[O] =
    input(inputFile)
      .use(source => IO(parse(source)))
      .map(solutionPart2)

  def printSolutions(inputFile: String) =
    for
      solution1 <- solve1(inputFile)
      _ <- IO(println(solution1))
      solution2 <- solve2(inputFile)
      _ <- IO(println(solution2))
    yield ()
