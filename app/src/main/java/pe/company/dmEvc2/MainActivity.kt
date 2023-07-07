package pe.company.dmEvc2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import pe.company.dmEvc2.databinding.ActivityInitialBinding
import pe.company.dmEvc2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fabAddProduct.setOnClickListener {
            val intent = Intent(this, AddProduct::class.java)
            startActivity(intent)
        }

    }
}