package advent.y2021

import advent.common.PuzzleSolver
import cats.*
import cats.implicits.*

import scala.io.BufferedSource

import Direction.*

// We don't really NEED an ADT but...
sealed trait Direction

object Direction:

  object Forward extends Direction
  object Up extends Direction
  object Down extends Direction

  def option(s: String): Option[Direction] =
    s match
      case "forward" => Some(Forward)
      case "up"      => Some(Up)
      case "down"    => Some(Down)
      case _         => None

case class Move(direction: Direction, value: Long)

// x is horizontal, y is vertical
case class Position(x: Long, y: Long):

  def move(move: Move): Position =
    move.direction match
      case Forward => Position(x + move.value, y)
      case Up      => Position(x, y - move.value)
      case Down    => Position(x, y + move.value)

  def dist = x * y

object Position:
  val zero = Position(0, 0)

case class PositionWithAim(position: Position, aim: Long):

  def move(move: Move): PositionWithAim =
    (move.direction, position) match
      case (Forward, Position(x, y)) =>
        PositionWithAim(Position(x + move.value, y + (move.value * aim)), aim)
      case (Up, pos) =>
        PositionWithAim(pos, aim - move.value)
      case (Down, pos) =>
        PositionWithAim(pos, aim + move.value)

  def dist = position.dist

object PositionWithAim:
  val zero = PositionWithAim(Position.zero, 0)

type Input = Seq[Move]
type Output = Long

object Day02 extends PuzzleSolver[Input, Output]:

  override val inputFileName = "AdventOfCode/resources/y2021/Day02.txt"
  override val parse = (source: BufferedSource) =>
    source.getLines.toList
      .map(_.trim.split(" ").toList)
      .collect { case dir :: value :: Nil =>
        (Direction.option(dir), value.toLongOption)
      }
      .collect { case (Some(direction), Some(value)) =>
        Move(direction, value)
      }

  override val solutionPart1 = (input: Input) =>
    input
      .foldLeft(Position.zero) { case (position, move) => position.move(move) }
      .dist

  override val solutionPart2 = (input: Input) =>
    input
      .foldLeft(PositionWithAim.zero) { case (positionWithAim, move) =>
        positionWithAim.move(move)
      }
      .dist
