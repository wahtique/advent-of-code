package advent.common

import cats.effect._
import cats.effect.implicits._

import scala.io.BufferedSource
import scala.io.Source.fromFile

/**
 * Utility trait for puzzle solver.
 * 
 * An AoC puzzle always has
 *  - data contained in an input file which can be parsed into type I by a parser function
 * specific to each challenge
 *  - two parts which each necessitate a solution function
 * 
 * A solver to a challenge will extend this trait and only need to implement
 *  - the parser function which takes an open file as a `BufferedSource` and output a challenge 
 * input of type I which can be used as is by the solution functions
 *  - two solution functions which solve the part 1 and part 2 of the challenge
 */
trait PuzzleSolver[I, O]:

  // to define for each puzzle

  val parse: BufferedSource => I
  val solutionPart1: I => O
  val solutionPart2: I => O

  // common to each puzzle

  def input(inputFile: String): Resource[IO, BufferedSource] =
    Resource.fromAutoCloseable(IO(fromFile(inputFile)))

  def parsedInput(inputFile: String): IO[I] = input(inputFile).use(source => IO(parse(source)))

  def solve1(inputFile: String): IO[O] = solve1(parsedInput(inputFile))

  def solve1(input: IO[I]): IO[O] = input.map(solve2)

  def solve1(input: I): O = solutionPart1(input)

  def solve2(inputFile: String): IO[O] = solve2(parsedInput(inputFile))

  def solve2(input: IO[I]): IO[O] = input.map(solve2)

  def solve2(input: I): O = solutionPart2(input)

  def printSolutions(inputFile: String): IO[Unit] =
    for
      parsedInput <- parsedInput(inputFile)
      _ <- IO.println(s"Solution to part 1 : ${solve1(parsedInput)}")
      _ <- IO.println(s"Solution to part 2 : ${solve2(parsedInput)}")
    yield ()
