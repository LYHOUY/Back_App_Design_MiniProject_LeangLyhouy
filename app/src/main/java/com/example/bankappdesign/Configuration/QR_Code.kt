package com.example.bankappdesign.Configuration

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.toArgb
import com.google.zxing.MultiFormatWriter
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException


@Composable
fun QRCodeGenerator(link: String) {
    val qrCodeBitmap = remember {
        generateQRCodeBitmap(link, 512, 512)
    }
    qrCodeBitmap?.let {
        Image(
            bitmap = it.asImageBitmap(),
            contentDescription = "QR Code",
            modifier = Modifier.fillMaxSize()
        )
    }
}
fun generateQRCodeBitmap(content: String, width: Int, height: Int): Bitmap? {
    val writer = MultiFormatWriter()
    return try {
        val bitMatrix = writer.encode(content, BarcodeFormat.QR_CODE, width, height)
        val bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)
        for (x in 0 until width) {
            for (y in 0 until height) {
                bmp.setPixel(x, y, if (bitMatrix[x, y]) Color.Black.toArgb() else Color.White.toArgb())
            }
        }
        bmp
    } catch (e: WriterException) {
        e.printStackTrace()
        null
    }
}
