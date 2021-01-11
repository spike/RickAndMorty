package io.quickspikes.rickandmorty.data

import androidx.lifecycle.LiveData
import androidx.room.*
import io.quickspikes.rickandmorty.data.entities.CartoonCharacter


@Dao
interface CartoonCharacterDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addCartoonCharacter(cartoonCharacter: CartoonCharacter)

    @Update
    fun updateCartoonCharacter(cartoonCharacter: CartoonCharacter)

    @Delete
    suspend fun deleteCartoonCharacter(cartoonCharacter: CartoonCharacter)

    @Query("DELETE FROM cartoon_character_table")
    suspend fun deleteAllItems()

    @Query( "SELECT * FROM cartoon_character_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<CartoonCharacter>>

}