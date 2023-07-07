package pe.company.dmEvc2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pe.company.dmEvc2.databinding.ActivityInitialBinding

class InitialActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInitialBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInitialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGoLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}