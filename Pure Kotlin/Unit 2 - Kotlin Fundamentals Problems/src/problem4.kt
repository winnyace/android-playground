class Song {
    public var title: String = ""
    public var artist: String = ""
    public var yearPublish: String = ""
    public var playCount: Int = 0

    public fun SongPopularity(): Boolean {
        if (playCount > 1000) {
            return true
        } else {
            return false
        }
    }

    public fun SongDescription(): String {
        return "${this.title}, performed by ${this.artist}, was released in ${this.yearPublish}"
    }

    constructor(title: String, artist: String, yearPublished: String, playCount: Int) {
        this.title = title
        this.artist = artist
        this.yearPublish = yearPublished
        this.playCount = playCount

    }
}

fun main() {
    val song: Song = Song(
        title = "A",
        artist = "B",
        yearPublished = "2025-6-9",
        playCount = 999
    )
    println(song.SongDescription())
    if (song.SongPopularity()) println("Song is popular") else println("Song is unpopular")
}