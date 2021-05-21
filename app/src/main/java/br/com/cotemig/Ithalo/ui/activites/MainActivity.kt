package br.com.cotemig.Ithalo.ui.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.cotemig.Ithalo.R
import br.com.cotemig.Ithalo.models.Fatura
import br.com.cotemig.Ithalo.services.RetrofitInitializer
import br.com.cotemig.Ithalo.ui.adapters.FaturaAdapter
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getFatura()
    }

    fun getFatura() {
        var s = RetrofitInitializer().serviceFatura()
        var call = s.getFatura()

        call.enqueue(object : retrofit2.Callback<List<Fatura>> {

            override fun onResponse(call: Call<List<Fatura>>, response: Response<List<Fatura>>) {
                if (response.code() == 200) {
                    response.body()?.let {
                        showFatura(it)
                    }
                }
            }

            override fun onFailure(call: Call<List<Fatura>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Algo de errado aconteceu!", Toast.LENGTH_LONG).show()
            }
        })
    }

    fun showFatura(list: List<Fatura>) {
        var recyclerViewFatura = findViewById<RecyclerView>(R.id.recyclerViewFatura)
        recyclerViewFatura.adapter = FaturaAdapter(this, list)
        recyclerViewFatura.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }
}