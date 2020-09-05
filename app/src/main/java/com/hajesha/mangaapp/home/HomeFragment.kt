package com.hajesha.mangaapp.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager.widget.ViewPager
import com.google.android.material.appbar.AppBarLayout
import com.hajesha.mangaapp.R
import com.hajesha.mangaapp.home.header.HeaderImageAdapter
import com.hajesha.mangaapp.search.SearchActivity
import com.viewpagerindicator.CirclePageIndicator
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var hold: Boolean = false

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

    @SuppressLint("ClickableViewAccessibility")
    private fun initView() {

        //toolbar stuff
        val toolbar = view!!.findViewById<AppBarLayout>(R.id.appBarLayout)

        //Pager Stuff
        val viewPage = view!!.findViewById<ViewPager>(R.id.pager)
        val adapter = HeaderImageAdapter(requireContext())
        viewPage.adapter = adapter
        viewPage.autoScroll(3000, toolbar)
        viewPage.setOnTouchListener { v, event ->
            hold = event?.action != MotionEvent.ACTION_UP
            Log.e("hajesha touch", hold.toString())
            v?.onTouchEvent(event) ?: true
        }
        val circlePageIndicator = view!!.findViewById<CirclePageIndicator>(R.id.indicator)
        circlePageIndicator.setViewPager(pager)
        //recycler view stuff
        recyclerViewBook.layoutManager = GridLayoutManager(requireContext(), 3)
        recyclerViewBook.addItemDecoration(GridItemDecoration(8, 3))
        val movieListAdapter = UpdateBookListGridRecycleAdapter()
        recyclerViewBook.adapter = movieListAdapter
        movieListAdapter.setUpdateBookList(generateDummyData())

        val search = view!!.findViewById<ImageView>(R.id.search_icon)
        search.setOnClickListener {
            val intent = Intent(requireContext(), SearchActivity::class.java)
            startActivity(intent)
        }
    }

    private fun ViewPager.autoScroll(interval: Long, toolbar: AppBarLayout) {

        //TODO: handle when the app is on pause and resume
        val handler = Handler()
        var scrollPosition = 0

        val runnable = object : Runnable {
            override fun run() {
                Log.e("hajesha", (toolbar.height - toolbar.bottom).toString())
                if (!hold && toolbar.height - toolbar.bottom == 0) {
                    val count = adapter?.count ?: 0
                    setCurrentItem(scrollPosition++ % count, true)
                    Log.e("hajesha", "scroll")
                }
                handler.postDelayed(this, interval)
            }
        }
        handler.post(runnable)
    }

    private fun generateDummyData(): List<UpdateBookModel> {

        //Todo: place proper information into the view model
        val listOfUpdatedBook = mutableListOf<UpdateBookModel>()

        var movieModel = UpdateBookModel(
            1,
            "title",
            "https://mangadex.org/images/manga/47286.jpeg?1594355449",
            3
        )
        listOfUpdatedBook.add(movieModel)

        var movieModel1 = UpdateBookModel(
            2,
            "this is a longer title that will not fit",
            "https://mangadex.org/images/manga/47275.large.jpg?1586678016",
            10
        )
        listOfUpdatedBook.add(movieModel1)

        var movieModel2 = UpdateBookModel(
            3,
            "pretty good book",
            "https://mangadex.org/images/manga/48167.large.jpg?1589964790",
            1
        )
        listOfUpdatedBook.add(movieModel2)

        var movieModel3 = UpdateBookModel(
            4,
            "title",
            "https://mangadex.org/images/manga/47286.jpeg?1594355449",
            3
        )
        listOfUpdatedBook.add(movieModel3)

        var movieModel4 = UpdateBookModel(
            2,
            "this is a longer title that will not fit",
            "https://mangadex.org/images/manga/45833.large.jpg?1594355230",
            10
        )
        listOfUpdatedBook.add(movieModel4)

        var movieModel5 = UpdateBookModel(
            4,
            "pretty good book",
            "https://mangadex.org/images/manga/3579.large.jpg?1532791283",
            1
        )
        listOfUpdatedBook.add(movieModel5)

        var movieModel6 = UpdateBookModel(
            1,
            "title",
            "https://mangadex.org/images/manga/35866.large.jpg?1554326843",
            3
        )
        listOfUpdatedBook.add(movieModel6)

        var movieModel7 = UpdateBookModel(
            1,
            "title",
            "https://mangadex.org/images/manga/47286.jpeg?1594355449",
            3
        )
        listOfUpdatedBook.add(movieModel7)


        var movieModel8 = UpdateBookModel(
            1,
            "title",
            "https://mangadex.org/images/manga/47286.jpeg?1594355449",
            3
        )
        listOfUpdatedBook.add(movieModel8)

        var movieModel9 = UpdateBookModel(
            1,
            "title",
            "https://mangadex.org/images/manga/20735.jpg?1519175683",
            3
        )
        listOfUpdatedBook.add(movieModel9)

        var movieModel10 = UpdateBookModel(
            1,
            "title",
            "https://mangadex.org/images/manga/47286.jpeg?1594355449",
            3
        )
        listOfUpdatedBook.add(movieModel10)

        return listOfUpdatedBook
    }
}