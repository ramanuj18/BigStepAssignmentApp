package com.example.bigstepassignmentapp.data.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * created by Ramanuj Kesharawani on 4/6/21
 */
@Entity(tableName = "video")
data class Video (
    @PrimaryKey
    val trackId : Int = 0,
    val wrapperType : String?=null,
    val kind : String?=null,
    val artistId : Int?=null,
    val collectionId : Int?=null,
    val artistName : String?=null,
    val collectionName : String?=null,
    val trackName : String?=null,
    val collectionCensoredName : String?=null,
    val trackCensoredName : String?=null,
    val artistViewUrl : String?=null,
    val collectionViewUrl : String?=null,
    val trackViewUrl : String?=null,
    val previewUrl : String?=null,
    val artworkUrl30 : String?=null,
    val artworkUrl60 : String?=null,
    val artworkUrl100 : String?=null,
    val collectionPrice : Double?=null,
    val trackPrice : Double?=null,
    val releaseDate : String?=null,
    val collectionExplicitness : String?=null,
    val trackExplicitness : String?=null,
    val discCount : Int?=null,
    val discNumber : Int?=null,
    val trackCount : Int?=null,
    val trackNumber : Int?=null,
    val trackTimeMillis : Int?=null,
    val country : String?=null,
    val currency : String?=null,
    val primaryGenreName : String?=null,
    val contentAdvisoryRating : String?=null,
    val isStreamable : Boolean?=null
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(trackId)
        parcel.writeString(wrapperType)
        parcel.writeString(kind)
        parcel.writeValue(artistId)
        parcel.writeValue(collectionId)
        parcel.writeString(artistName)
        parcel.writeString(collectionName)
        parcel.writeString(trackName)
        parcel.writeString(collectionCensoredName)
        parcel.writeString(trackCensoredName)
        parcel.writeString(artistViewUrl)
        parcel.writeString(collectionViewUrl)
        parcel.writeString(trackViewUrl)
        parcel.writeString(previewUrl)
        parcel.writeString(artworkUrl30)
        parcel.writeString(artworkUrl60)
        parcel.writeString(artworkUrl100)
        parcel.writeValue(collectionPrice)
        parcel.writeValue(trackPrice)
        parcel.writeString(releaseDate)
        parcel.writeString(collectionExplicitness)
        parcel.writeString(trackExplicitness)
        parcel.writeValue(discCount)
        parcel.writeValue(discNumber)
        parcel.writeValue(trackCount)
        parcel.writeValue(trackNumber)
        parcel.writeValue(trackTimeMillis)
        parcel.writeString(country)
        parcel.writeString(currency)
        parcel.writeString(primaryGenreName)
        parcel.writeString(contentAdvisoryRating)
        parcel.writeValue(isStreamable)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Video> {
        override fun createFromParcel(parcel: Parcel): Video {
            return Video(parcel)
        }

        override fun newArray(size: Int): Array<Video?> {
            return arrayOfNulls(size)
        }
    }
}