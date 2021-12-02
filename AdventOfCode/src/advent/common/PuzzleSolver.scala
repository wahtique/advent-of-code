package advent.common

import cats.effect._
import cats.effect.implicits._
import scala.io.Source.fromFile
import scala.io.BufferedSource


trait PuzzleSolver[I, O]:

  val inputFileName: String

  // to define for each puzzle

  val parse: BufferedSource => I
  val solutionPart1: I => O
  val solutionPart2: I => O

  // common to each puzzle

  lazy val inputFile: Resource[IO, BufferedSource] =
    Resource.fromAutoCloseable(IO(fromFile(inputFileName)))

  def solve1: IO[O] = inputFile
    .use(source => IO(parse(source)))
    .map(solutionPart1)

  def solve2: IO[O] = inputFile
    .use(source => IO(parse(source)))
    .map(solutionPart2)

  def printSolutions =
    for 
      solution1 <- solve1
      _ <- IO(println(solution1))
      solution2 <- solve2
      _ <- IO(println(solution2))
    yield ()
