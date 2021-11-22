package com.example.demo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.R
import com.example.demo.adapter.ListMovieAdapter
import com.example.demo.model.ListMovie
import com.example.demo.model.Movie


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MovieFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MovieFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var recycler_movie : RecyclerView
    lateinit var adapter : ListMovieAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_movie, container, false)
        recycler_movie= view.findViewById(R.id.recycler_movie)
        adapter= ListMovieAdapter(requireContext(),getListData())
        recycler_movie.layoutManager=LinearLayoutManager(requireContext())
        recycler_movie.adapter=adapter
        recycler_movie.setHasFixedSize(true)
        return view
    }

    private fun getListData(): ArrayList<ListMovie> {
        val listMovie : ArrayList<ListMovie> = ArrayList()

        val listMovieCat : ArrayList<Movie> = ArrayList()
        listMovieCat.add(Movie(R.drawable.sangchi,"Sang chi 1"))
        listMovieCat.add(Movie(R.drawable.sangchi,"Sang chi 2"))
        listMovieCat.add(Movie(R.drawable.sangchi,"Sang chi 3"))
        listMovieCat.add(Movie(R.drawable.sangchi,"Sang chi 4"))
        listMovieCat.add(Movie(R.drawable.sangchi,"Sang chi 5"))
        listMovieCat.add(Movie(R.drawable.sangchi,"Sang chi 6"))

        val listTopMovie : ArrayList<Movie> = ArrayList()
        listTopMovie.add(Movie(R.drawable.sangchi,"Top movie 1"))
        listTopMovie.add(Movie(R.drawable.sangchi,"Top movie 2"))
        listTopMovie.add(Movie(R.drawable.sangchi,"Top movie 3"))
        listTopMovie.add(Movie(R.drawable.sangchi,"Top movie 4"))
        listTopMovie.add(Movie(R.drawable.sangchi,"Top movie 5"))
        listTopMovie.add(Movie(R.drawable.sangchi,"Top movie 6"))
        listTopMovie.add(Movie(R.drawable.sangchi,"Top movie 7"))
        listTopMovie.add(Movie(R.drawable.sangchi,"Top movie 8"))
        listTopMovie.add(Movie(R.drawable.sangchi,"Top movie 9"))

        val listTopMovie2 : ArrayList<Movie> = ArrayList()
        listTopMovie2.add(Movie(R.drawable.sangchi,"Top movie 1"))
        listTopMovie2.add(Movie(R.drawable.sangchi,"Top movie 1"))
        listTopMovie2.add(Movie(R.drawable.sangchi,"Top movie 1"))
        listTopMovie2.add(Movie(R.drawable.sangchi,"Top movie 1"))
        listTopMovie2.add(Movie(R.drawable.sangchi,"Top movie 1"))
        listTopMovie2.add(Movie(R.drawable.sangchi,"Top movie 1"))
        listTopMovie2.add(Movie(R.drawable.sangchi,"Top movie 1"))
        listTopMovie2.add(Movie(R.drawable.sangchi,"Top movie 1"))
        listTopMovie2.add(Movie(R.drawable.sangchi,"Top movie 1"))
        listTopMovie2.add(Movie(R.drawable.sangchi,"Top movie 1"))
        listTopMovie2.add(Movie(R.drawable.sangchi,"Top movie 1"))
        listTopMovie2.add(Movie(R.drawable.sangchi,"Top movie 1"))
        listTopMovie2.add(Movie(R.drawable.sangchi,"Top movie 1"))



        listMovie.add(ListMovie(ListMovieAdapter.TYPE_CATEGORY,"Movie Category",listMovieCat,null))
        listMovie.add(ListMovie(ListMovieAdapter.TYPE_TOP_MOVIE,"TOP Movie",null,listTopMovie))
        listMovie.add(ListMovie(ListMovieAdapter.TYPE_TOP_MOVIE,"TOP Movie 2",null,listTopMovie2))

        return listMovie
    }

//    private fun getItemsList(): ArrayList<MovieTabModel> {
//        val list = ArrayList<MovieTabModel>()
//
//        list.add(MovieTabModel(R.drawable.sangchi,"Name 1",TabRelaxAdapter.MOVIE_CATEGORY))
//        list.add(MovieTabModel(R.drawable.sangchi,"Name 2",TabRelaxAdapter.MOVIE_CATEGORY))
//        list.add(MovieTabModel(R.drawable.sangchi,"Name 3",TabRelaxAdapter.MOVIE_CATEGORY))
//        list.add(MovieTabModel(R.drawable.sangchi,"Name 4",TabRelaxAdapter.MOVIE_CATEGORY))
//        list.add(MovieTabModel(R.drawable.sangchi,"Name 5",TabRelaxAdapter.MOVIE_CATEGORY))
//
//
//        list.add(MovieTabModel(R.drawable.sangchi,"Name 2",TabRelaxAdapter.TOP_MOVIE))
//        list.add(MovieTabModel(R.drawable.sangchi,"Name 2",TabRelaxAdapter.TOP_MOVIE))
//        list.add(MovieTabModel(R.drawable.sangchi,"Name 2",TabRelaxAdapter.TOP_MOVIE))
//        list.add(MovieTabModel(R.drawable.sangchi,"Name 2",TabRelaxAdapter.TOP_MOVIE))
//        list.add(MovieTabModel(R.drawable.sangchi,"Name 2",TabRelaxAdapter.TOP_MOVIE))
//        list.add(MovieTabModel(R.drawable.sangchi,"Name 2",TabRelaxAdapter.TOP_MOVIE))
//
//        return list
//
//    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MovieFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MovieFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}