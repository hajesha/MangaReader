package com.hajesha.mangaapp.details

public class DescriptionModel(
    var id: Int,
    var artist: String,
    var status: Status,
    var rating: Float,
    var numberOfUsers: Int,
    var url: String,
    var genres: Array<String>,
    var description: String,
    var reads : Int,
    var names : Array<String>
)

enum class Status {
    COMPLETE, INCOMPLETE, HIATUS, DROPPED
}