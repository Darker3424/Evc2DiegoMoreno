package pe.company.dmEvc2

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.renderscript.ScriptGroup.Binding
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import pe.company.dmEvc2.databinding.ActivityAddProductBinding

class AddProduct : AppCompatActivity() {
    private lateinit var binding: ActivityAddProductBinding
    private lateinit var openCameraLauncher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTakePhoto.setOnClickListener {
            if (permissionValidated()) {
                takePhoto()
            }
        }
        openCameraLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if(result.resultCode == RESULT_OK){
                val photoBitmap = result.data?.extras?.get("data") as Bitmap
                binding.imgProductPhoto.setImageBitmap(photoBitmap)
            }
        }

        binding.btnAddAddress.setOnClickListener {
            val intent = Intent(this, AddAddressActivity::class.java)
            startActivity(intent)
        }

    }

    private fun permissionValidated(): Boolean {
        val cameraPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
        val permissionList: MutableList<String> = mutableListOf()
        if (cameraPermission != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.CAMERA)
        }
        if (permissionList.isNotEmpty()) {
            ActivityCompat.requestPermissions(this, permissionList.toTypedArray(), 1000)
            return false
        }

        return true
    }

    private fun takePhoto() {
        val cameraIntent = Intent()
        cameraIntent.setAction(MediaStore.ACTION_IMAGE_CAPTURE)
        openCameraLauncher.launch(cameraIntent)


    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode) {
            1000->{
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    takePhoto()
                }
            }
        }
    }
}