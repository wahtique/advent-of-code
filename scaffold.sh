#!/usr/bin/env zsh

year=${1}
day=${2}

echo "Scaffolding ${year}/${day}..."

yearsrcdir="AdventOfCode/src/advent/y${year}"
daysrcfile="${yearsrcdir}/Day${day}.scala"

yearresourcedir="AdventOfCode/resources/y${year}"
dayresourcefile="${yearresourcedir}/Day${day}.txt"

yeartestdir="AdventOfCode/test/src/advent/y${year}"
daytestfile="${yeartestdir}/Day${day}Suite.scala"

yeartestresourcedir="AdventOfCode/test/resources/y${year}"
daytestresourcefile="${yeartestresourcedir}/Day${day}.txt"

echo "Generating source..."

mkdir -p ${yearsrcdir}
mkdir -p ${yearresourcedir}
touch ${daysrcfile} ${dayresourcefile}
cat <<EOT > ${daysrcfile}
package advent.y${year}

import advent.common.PuzzleSolver
import cats.effect.IOApp

import scala.io.BufferedSource

object Day${day} extends PuzzleSolver[List[Int], Int]:
  override val parse = (source: BufferedSource) => ???
  override val solutionPart1 = (input: List[Int]) => ???
  override val solutionPart2 = (input: List[Int]) => ???

object Main extends IOApp.Simple:
  val run = Day${day}.printSolutions("${dayresourcefile}")
EOT

echo "Generating tests..."

mkdir -p ${yeartestdir}
mkdir -p ${yeartestresourcedir}
touch ${daytestfile} ${daytestresourcefile}
cat <<EOT > ${daytestfile}
package advent.y${year}

import cats.effect.IO
import munit.CatsEffectSuite

class Day${day}Suite extends CatsEffectSuite:
  test("part 1") {
    Day${day}
      .solve1("${daytestresourcefile}")
      .flatMap(result => IO(assertEquals(result, ???)))
  }
  test("part 2") {
    Day${day}
      .solve2("${daytestresourcefile}")
      .flatMap(result => IO(assertEquals(result, ???)))
  }
EOT