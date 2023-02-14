package com.example.ticketbooking.dataRepository.roomDatabase.daos

import android.database.Cursor
import androidx.room.*
import com.example.ticketbooking.dataRepository.roomDatabase.entities.*


@Dao
interface MovieDao{

    @Query("SELECT * FROM MOVIE_TABLE WHERE id=:movieId")
    suspend fun getMovie(movieId:Int):Movie

    @Query("SELECT * FROM MOVIE_TABLE")
    suspend fun getAllMovies(): List<Movie>


    @Insert( onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: Movie):Long

    @Delete
    suspend fun deleteMovie(user: User)

    @Update
    suspend fun updateMovie(user: User)

}