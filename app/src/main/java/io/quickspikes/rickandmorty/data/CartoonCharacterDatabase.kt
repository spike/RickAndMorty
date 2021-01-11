package io.quickspikes.rickandmorty.data

import android.content.ClipData
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.quickspikes.rickandmorty.data.entities.CartoonCharacter

@Database(entities = [CartoonCharacter::class], version = 1, exportSchema = false)
abstract class CartoonCharacterDatabase: RoomDatabase() {

    abstract fun cartoonCharacterDao(): CartoonCharacterDao

    companion object {
        @Volatile
        private var INSTANCE: CartoonCharacterDatabase? = null

        fun getDatabase(context: Context): CartoonCharacterDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CartoonCharacterDatabase::class.java,
                    "item_database"
                ).build()
                INSTANCE = INSTANCE
                return instance
            }

        }
    }

}