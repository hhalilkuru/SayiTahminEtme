package com.halil.sayitahminetme

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.google.android.material.snackbar.Snackbar
import kotlin.random.Random

class TahminActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tahmin)

        val buttonTahmin = findViewById<Button>(R.id.buttonTahmin)
        val editTextGirdi = findViewById<EditText>(R.id.editTextGirdi)
        val textViewYardim = findViewById<TextView>(R.id.textViewYardim)
        val textViewKalanHak = findViewById<TextView>(R.id.textViewKalanHak)


        var tahmin = 0


        val rastgeleSayi: Int = Random.nextInt(0,100) //0 ile 100 arasında rastgele sayı üretecek.
        Log.e("Rastgele Sayi",rastgeleSayi.toString())


        var sayac = 5
        textViewKalanHak.text = "Kalan Hak: $sayac"

        buttonTahmin.setOnClickListener{

            try{
                tahmin = editTextGirdi.text.toString().toInt()
            }
            catch (e: Exception){
                tahmin = 2147483647
            }finally {
                if (tahmin == 2147483647){
                    Snackbar.make(it, "Lütfen tahmininizi giriniz!",1000).show()
                }else{
                    if(tahmin > rastgeleSayi && tahmin <=100){
                        sayac--
                        textViewYardim.text = "Azalt"
                        textViewKalanHak.text = "Kalan Hak: $sayac"
                    }
                    if(tahmin < rastgeleSayi && tahmin >=0) {
                        sayac--
                        textViewYardim.text = "Arttır"
                        textViewKalanHak.text = "Kalan Hak: $sayac"
                    }
                    if (tahmin > 100){
                        Snackbar.make(it, "Lütfen tahmininizi 0 ile 100 arasında giriniz!",1000).show()
                    }
                }
            }


            if(tahmin == rastgeleSayi){

                val intent = Intent(this@TahminActivity,SonucActivity::class.java)

                intent.putExtra("sonuc",true)
                //finish() //tahmin ekranından sonuç ekranına geçerken backstage den siliyoruz. böylece tahmin et kısmına değil ana ekrana geçiyor
                startActivity(intent)

                return@setOnClickListener //son 1 hakkımız kaldığı zaman kaybettiniz yazısının çıkması engellendi.
            }



            if(sayac == 0) {
                val intent = Intent(this@TahminActivity,SonucActivity::class.java)
                intent.putExtra("sonuc",false)
                finish()
                startActivity(intent)

            }

            editTextGirdi.setText("") // tahmin edilen sayı her defasında siliniyor

        }
    }
}