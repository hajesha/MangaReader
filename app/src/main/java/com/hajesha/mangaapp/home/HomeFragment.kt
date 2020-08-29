package com.hajesha.mangaapp.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.hajesha.mangaapp.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {
        recyclerViewBook.layoutManager = GridLayoutManager(this.context,3)

        recyclerViewBook.addItemDecoration(GridItemDecoration(8, 3))

        val movieListAdapter = UpdateBookListGridRecycleAdapter()
        recyclerViewBook.adapter = movieListAdapter
        movieListAdapter.setUpdateBookList(generateDummyData())
    }

    private fun generateDummyData(): List<UpdateBookModel> {
        val listOfUpdatedBook = mutableListOf<UpdateBookModel>()

        var movieModel = UpdateBookModel(1, "title", "https://mangadex.org/images/manga/47286.jpeg?1594355449", 3)
        listOfUpdatedBook.add(movieModel)

        var movieModel1 = UpdateBookModel(2, "this is a longer title that will not fit", "https://static.zerochan.net/Pandora.Hearts.full.1704822.jpg", 10)
        listOfUpdatedBook.add(movieModel1)

        var movieModel2 = UpdateBookModel(3, "pretty good book", "https://upload.wikimedia.org/wikipedia/en/2/2f/Akatsuki001.jpg", 1)
        listOfUpdatedBook.add(movieModel2)

        var movieModel3 = UpdateBookModel(4, "title", "https://mangadex.org/images/manga/47286.jpeg?1594355449", 3)
        listOfUpdatedBook.add(movieModel3)

        var movieModel4 = UpdateBookModel(2, "this is a longer title that will not fit", "https://static.zerochan.net/Pandora.Hearts.full.1704822.jpg", 10)
        listOfUpdatedBook.add(movieModel4)

        var movieModel5 = UpdateBookModel(4, "pretty good book", "https://upload.wikimedia.org/wikipedia/en/2/2f/Akatsuki001.jpg", 1)
        listOfUpdatedBook.add(movieModel5)

        var movieModel6 = UpdateBookModel(1, "title", "https://mangadex.org/images/manga/47286.jpeg?1594355449", 3)
        listOfUpdatedBook.add(movieModel6)

        var movieModel7 = UpdateBookModel(1, "title", "https://mangadex.org/images/manga/47286.jpeg?1594355449", 3)
        listOfUpdatedBook.add(movieModel7)


        var movieModel8 = UpdateBookModel(1, "title", "https://mangadex.org/images/manga/47286.jpeg?1594355449", 3)
        listOfUpdatedBook.add(movieModel8)

        var movieModel9 = UpdateBookModel(1, "title", "https://mangadex.org/images/manga/47286.jpeg?1594355449", 3)
        listOfUpdatedBook.add(movieModel9)

        var movieModel10 = UpdateBookModel(1, "title", "https://mangadex.org/images/manga/47286.jpeg?1594355449", 3)
        listOfUpdatedBook.add(movieModel10)

        return listOfUpdatedBook
    }
}