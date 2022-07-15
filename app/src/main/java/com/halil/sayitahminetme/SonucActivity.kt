package com.halil.sayitahminetme

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class SonucActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sonuc)

        val buttonTekrar = findViewById<Button>(R.id.buttonTekrar)

        val textViewSonuc = findViewById<TextView>(R.id.textViewSonuc)

        val textViewBSayi = findViewById<TextView>(R.id.textViewBSayi)

        val imageViewSonuc = findViewById<ImageView>(R.id.imageViewSonuc)


        val sonuc = intent.getBooleanExtra("sonuc",false)

        val bundle = intent.extras
        if (bundle != null){
            textViewBSayi.text = "Sayı  = ${bundle.getString("id")}"
        }

        if(sonuc){

            textViewSonuc.text = "Doğru Bildin"
            imageViewSonuc.setImageResource(R.drawable.mutlu_resim) //resim değiştirme

        }else{

            textViewSonuc.text = "Kaybettin :("
            imageViewSonuc.setImageResource(R.drawable.uzgun_resim) //resim değiştirme

        }

        buttonTekrar.setOnClickListener {
            val intent = Intent(this@SonucActivity,TahminActivity::class.java)
            finish() //backstageden siliyoruz
            startActivity(intent)
        }
    }
}