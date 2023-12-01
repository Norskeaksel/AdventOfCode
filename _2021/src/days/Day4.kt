package days

import java.lang.Math.max

fun _printBoard(board: MutableList<List<Int>>, name: String) {
    println(name)
    board.forEach { println(it) }
    println()
}

fun _boards(input: List<String>): MutableList<MutableList<List<Int>>> {
    val boards = mutableListOf<MutableList<List<Int>>>()
    var c = 0
    var board = mutableListOf<List<Int>>()
    for (line in input) {
        if (c++ < 2) continue

        var bingoRow: List<Int>
        if (line != "") {
            bingoRow = line.trim().split("\\s+".toRegex()).map { it.toInt() }
            board.add(bingoRow)
        } else {
            val boardCopy = mutableListOf<List<Int>>()
            board.forEach { boardCopy.add(it) }
            boards.add(boardCopy)
            //_printBoard(board,"Original")
            //_printBoard(boardCopy,"Copy")
            board.clear()
        }
    }
    return boards
}

fun _placeNumber(boards: MutableList<MutableList<List<Int>>>, number: Int): MutableList<MutableList<List<Int>>> {
    for ((boardNr, board) in boards.withIndex()) {
        for ((rowNr, row) in board.withIndex()) {
            board[rowNr] = row.map { if (it == number) -1 else it }
        }
        boards[boardNr] = board
    }
    return boards
}

fun _gameOver(boards: MutableList<MutableList<List<Int>>>): MutableList<List<Int>>? {
    for (board in boards) {
        for ((idx, row) in board.withIndex()) {
            if (row.sum() == -row.size)
                return board
            val colSize = board.size
            var colsum = 0
            for (i in 0 until colSize) {
                colsum += board[i][idx]
            }
            if (colsum == -colSize)
                return board
        }
    }
    return null
}

fun _finalScore(board: MutableList<List<Int>>, number: Int): Int {
    var score = 0
    for (rowNr in 0 until board[0].size) {
        for (colNr in 0 until board.size) {
            score += max(board[rowNr][colNr], 0)
        }
    }
    return score * number
}

fun part1(input: List<String>): Int {
    //input.forEach{println(it)}
    val draws = input[0].split(",").map { it.toInt() }
    var boards = _boards(input)
    var c = 1
    //boards.forEach{_printBoard(it,"Board Nr${c++}")}
    for (number in draws) {
        boards = _placeNumber(boards, number)
        val winner = _gameOver(boards)
        if (winner != null) {
            //_printBoard(winner,"Winner")
            return _finalScore(winner, number)
        }
    }
    return -1
}


fun part2(input: List<String>): Int {
    //input.forEach{println(it)}
    val draws = input[0].split(",").map { it.toInt() }
    var boards = _boards(input)
    var c = 1
    var winner: MutableList<List<Int>>? = null
    //boards.forEach{_printBoard(it,"Board Nr${c++}")}
    for (number in draws) {
        boards = _placeNumber(boards, number)
        winner = _gameOver(boards)
        while (winner != null) {
            if (boards.size == 1) {
                //_printBoard(winner,"Winner")
                return _finalScore(boards[0], number)
            }
            boards.remove(winner)
            winner = _gameOver(boards)
        }

    }
    return -1

}


fun main(args: Array<String>) {
    val path = "src/inputFiles/day4.txt"
    val input = readLineByLine(path)
    val ans1 = part1(input)
    println("Part 1 = $ans1")
    val ans2 = part2(input)
    println("Part 2 = $ans2")
}
