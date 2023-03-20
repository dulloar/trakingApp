package com.example.traningtraking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.example.Personaje
import com.example.traningtraking.rickAndMorty.ListPersonajeAdapter
import com.example.traningtraking.rickAndMorty.RickAndMortyAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListRMFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListRMFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        val view = inflater.inflate(R.layout.fragment_list_r_m, container, false)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var movieAPI = retrofit.create(RickAndMortyAPI::class.java)
        movieAPI.getPersonajes().enqueue(object : Callback<Personaje> {
            override fun onResponse(call: Call<Personaje>, response: Response<Personaje>) {
                // Procesar respuesta exitosa
                var users = response.body()!!.results
                var rvUser =  view.findViewById<RecyclerView>(R.id.rv_user)
                rvUser.setHasFixedSize(true)
                rvUser.layoutManager = LinearLayoutManager(context)

                var adapter = ListPersonajeAdapter(users)

                rvUser.adapter= adapter
                rvUser.visibility = View.VISIBLE

            }
            override fun onFailure(call: Call<Personaje>, t: Throwable) {
                // Procesar error en la petición
            }
        })

        // Inflate the layout for this fragment
        return view;
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ListRMFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ListRMFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}