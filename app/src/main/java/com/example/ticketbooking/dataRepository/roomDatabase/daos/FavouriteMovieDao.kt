package com.example.ticketbooking.dataRepository.roomDatabase.daos

import androidx.room.*
import com.example.ticketbooking.dataRepository.roomDatabase.entities.FavouriteMovie

@Dao
interface  FavouriteMovieDao {

    @Query("SELECT * FROM favourite_movies_table WHERE userId=:userId" )
    fun getFavouriteMovies(userId:Long):List<FavouriteMovie>

    @Insert
    fun insertFavouriteMovie(movie: FavouriteMovie):Long

    @Update
    fun updateFavouriteMovie(movie: FavouriteMovie)

    @Delete
    fun deleteFavouriteMovie(movie: FavouriteMovie)
}