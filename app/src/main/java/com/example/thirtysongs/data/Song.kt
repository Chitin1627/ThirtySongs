package com.example.thirtysongs.data

import androidx.annotation.StringRes
import com.example.thirtysongs.R

data class Song(
    @StringRes val day: Int,
    @StringRes val description: Int
)

val songs = listOf(
    Song(R.string.day1, R.string.song1),
    Song(R.string.day2, R.string.song2),
    Song(R.string.day3, R.string.song3),
    Song(R.string.day4, R.string.song4),
    Song(R.string.day5, R.string.song5),
    Song(R.string.day6, R.string.song6),
    Song(R.string.day7, R.string.song7),
    Song(R.string.day8, R.string.song8),
    Song(R.string.day9, R.string.song9),
    Song(R.string.day10, R.string.song10),
    Song(R.string.day11, R.string.song11),
    Song(R.string.day12, R.string.song12),
    Song(R.string.day13, R.string.song13),
    Song(R.string.day14, R.string.song14),
    Song(R.string.day15, R.string.song15),
    Song(R.string.day16, R.string.song16),
    Song(R.string.day17, R.string.song17),
    Song(R.string.day18, R.string.song18),
    Song(R.string.day19, R.string.song19),
    Song(R.string.day20, R.string.song20),
    Song(R.string.day21, R.string.song21),
    Song(R.string.day22, R.string.song22),
    Song(R.string.day23, R.string.song23),
    Song(R.string.day24, R.string.song24),
    Song(R.string.day25, R.string.song25),
    Song(R.string.day26, R.string.song26),
    Song(R.string.day27, R.string.song27),
    Song(R.string.day28, R.string.song28),
    Song(R.string.day29, R.string.song29),
    Song(R.string.day30, R.string.song30)
)