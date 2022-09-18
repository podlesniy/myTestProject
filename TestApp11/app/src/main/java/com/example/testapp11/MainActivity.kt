package com.example.testapp11

import androidx.appcompat.app.AppCompatActivity
import io.reactivex.disposables.Disposable
import com.example.testapp11.CountryAdapter
import com.example.testapp11.network.model.Country
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testapp11.network.ApiService
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers
import android.widget.Toast
import com.example.testapp11.MainActivity
import android.content.Intent
import com.example.testapp11.MainActivity2
import com.example.testapp11.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity(), OnItemClickListener {
    private var disposable: Disposable? = null
    private var binding: ActivityMainBinding? = null
    private var adapter: CountryAdapter? = null
    var countryFiltered: MutableList<Country> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        adapter = CountryAdapter(this, this)
        binding!!.recyclerList.adapter = adapter
        binding!!.recyclerList.layoutManager = LinearLayoutManager(this@MainActivity) //or set - app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager" in xml
        disposable = ApiService.getAllCocktail()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
//                    countries: List<Country> -> showInfo(countries)
            }) {
                    t: Throwable? -> showError(t)
            }
    }

    fun showInfo(countries: List<Country>) {
        adapter!!.update(countries)
        binding!!.ok.setOnClickListener {
            countryFiltered.clear()
            for (country in countries) {
                if (country.name.lowercase(Locale.getDefault())
                        .contains(binding!!.enterText.text.toString()) || country.name.uppercase(
                        Locale.getDefault()
                    ).contains(
                        binding!!.enterText.text.toString()
                    ) || country.name.contains(
                        binding!!.enterText.text.toString()
                    )
                ) {
                    countryFiltered.add(country)
                } else if (binding!!.enterText.text.toString() == "") {
                    adapter!!.update(countries)
                }
            }
            adapter!!.update(countryFiltered)
        }
    }

    fun showError(t: Throwable?) {
        Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        if (disposable != null) {
            disposable!!.dispose()
        }
    }

    override fun onItemClick(country: Country) {
        countries = country
        startActivity(Intent(this, MainActivity2::class.java))
    }

    companion object {
        @JvmField
        var countries: Country? = null
    }
}