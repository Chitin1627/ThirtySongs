package com.example.thirtysongs.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.thirtysongs.R

data class Song(
    @StringRes val day: Int,
    @StringRes val description: Int,
    @DrawableRes val image: Int
)

val songs = listOf(
    Song(R.string.day1, R.string.song1, R.drawable.image1),
    Song(R.string.day2, R.string.song2,R.drawable.image2),
    Song(R.string.day3, R.string.song3,R.drawable.image3),
    Song(R.string.day4, R.string.song4,R.drawable.image4),
    Song(R.string.day5, R.string.song5,R.drawable.image5),
    Song(R.string.day6, R.string.song6,R.drawable.image6),
    Song(R.string.day7, R.string.song7,R.drawable.image7),
    Song(R.string.day8, R.string.song8,R.drawable.image8),
    Song(R.string.day9, R.string.song9,R.drawable.image9),
    Song(R.string.day10, R.string.song10,R.drawable.image10),
    Song(R.string.day11, R.string.song11,R.drawable.image1),
    Song(R.string.day12, R.string.song12,R.drawable.image2),
    Song(R.string.day13, R.string.song13,R.drawable.image3),
    Song(R.string.day14, R.string.song14,R.drawable.image4),
    Song(R.string.day15, R.string.song15,R.drawable.image5),
    Song(R.string.day16, R.string.song16,R.drawable.image6),
    Song(R.string.day17, R.string.song17,R.drawable.image7),
    Song(R.string.day18, R.string.song18,R.drawable.image8),
    Song(R.string.day19, R.string.song19,R.drawable.image9),
    Song(R.string.day20, R.string.song20,R.drawable.image10),
    Song(R.string.day21, R.string.song21,R.drawable.image1),
    Song(R.string.day22, R.string.song22,R.drawable.image2),
    Song(R.string.day23, R.string.song23,R.drawable.image3),
    Song(R.string.day24, R.string.song24,R.drawable.image4),
    Song(R.string.day25, R.string.song25,R.drawable.image5),
    Song(R.string.day26, R.string.song26,R.drawable.image6),
    Song(R.string.day27, R.string.song27,R.drawable.image7),
    Song(R.string.day28, R.string.song28,R.drawable.image8),
    Song(R.string.day29, R.string.song29,R.drawable.image9),
    Song(R.string.day30, R.string.song30,R.drawable.image10)
)