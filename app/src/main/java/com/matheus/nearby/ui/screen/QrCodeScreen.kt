package com.matheus.nearby.ui.screen

import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanOptions
import com.matheus.nearby.MainActivity

@Composable
fun QrCodeScreen(modifier: Modifier = Modifier, onCompletedScan: (String) -> Unit) {
    val context = LocalContext.current

    val scanOptions = ScanOptions().setDesiredBarcodeFormats(ScanOptions.QR_CODE)
        .setPrompt("").setCameraId(0).setBeepEnabled(false).setOrientationLocked(false)
        .setBarcodeImageEnabled(true)

    val barcodeLauncher = rememberLauncherForActivityResult(
        ScanContract()
    ) { result -> onCompletedScan(result.contents.orEmpty()) }

    val cameraPermissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (!isGranted) ActivityResultContracts.RequestPermission()
        else
            barcodeLauncher.launch(scanOptions)
    }

    fun checkCameraPermission() {
        if (ContextCompat.checkSelfPermission(
                context, android.Manifest.permission.CAMERA
            ) == android.content.pm.PackageManager.PERMISSION_GRANTED
        ) {
            barcodeLauncher.launch(scanOptions)
        } else if (ActivityCompat.shouldShowRequestPermissionRationale(
                context as MainActivity, android.Manifest.permission.CAMERA
            )
        ) {
            Toast.makeText(context, "Necessário permitir acesso a camera", Toast.LENGTH_SHORT)
                .show()
        } else {
            cameraPermissionLauncher.launch(android.Manifest.permission.CAMERA)
        }
    }

    LaunchedEffect(true) {
        checkCameraPermission()
    }

    Column(modifier=modifier.fillMaxSize()) {  }
}