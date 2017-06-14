package gift.witch.android.ae.kotlin

import android.os.Bundle
import android.widget.TextView
import gift.witch.android.ae.R
import gift.witch.android.ae.base.BaseCompatActivity

/**
 *
 */
class KotlinActivity : BaseCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
        val textTV  = findViewById(R.id.text) as TextView
        val btnBTN = findViewById(R.id.btn)

        btnBTN.setOnClickListener {
            textTV.setText("已经点击我了")
        }

    }

}
