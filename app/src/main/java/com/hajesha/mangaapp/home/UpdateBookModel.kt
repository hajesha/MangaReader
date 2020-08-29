package com.hajesha.mangaapp.home

data class UpdateBookModel(
    var bookId: Int,
    var bookTitle: String,
    var image: String,
    var numberOfUpdatedChapter: Int
) {
    constructor() : this(0, "", "", 0)
}