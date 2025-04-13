package com.tbox.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.tbox.app.ui.theme.TBOXTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Surface

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TBOXTheme {
                Surface {
                    Text("ברוך הבא ל-TBOX!")
                }
            }
        }
    }
}
