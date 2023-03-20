package com.example.traningtraking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.example.Personaje
import com.example.example.Results
import com.example.traningtraking.rickAndMorty.ListPersonajeAdapter
import com.example.traningtraking.rickAndMorty.RickAndMortyAPI
import com.squareup.picasso.Picasso
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
 * Use the [PersonajeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PersonajeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_personaje, container, false)
        val imPersonaje = view.findViewById<ImageView>(R.id.im_personajerm)
        val tvPersonaje = view.findViewById<TextView>(R.id.tv_nombre)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var movieAPI = retrofit.create(RickAndMortyAPI::class.java)
        movieAPI.getPersonaje(param1!!).enqueue(object :Callback<Results>{
            override fun onResponse(call: Call<Results>, response: Response<Results>) {

                tvPersonaje.setText(response.body()!!.name)
                Picasso.get().load(response.body()!!.image).into(imPersonaje)
            }
            override fun onFailure(call: Call<Results>, t: Throwable) {
                // Procesar error en la petición
            }

        })
        // Inflate the layout for this fragment
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.

         * @return A new instance of fragment PersonajeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: Int) =
            PersonajeFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, param1!!)

                }
            }
    }
}