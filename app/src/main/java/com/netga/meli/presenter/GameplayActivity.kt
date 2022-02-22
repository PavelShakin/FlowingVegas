package com.netga.meli.presenter

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.netga.meli.R
import com.netga.meli.databinding.ActivityGameplayBinding

class GameplayActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameplayBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameplayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            back.setOnClickListener {
                startActivity(Intent(this@GameplayActivity, StartActivity::class.java))
            }

            spinBtn.setOnClickListener {
                val angle = (Math.random() * 360f).toFloat()

                spinner.spin(
                    2000,
                    0f,
                    720 + angle,
                    Easing.EaseOutCirc
                )

                result.visibility = View.INVISIBLE
                result.text =
                    "You won " + spinner.data.dataSet
                        .getEntryForIndex(spinner.getIndexForAngle(270f - angle))
                        .value.toInt() + "$"

                Handler(Looper.getMainLooper()).postDelayed({
                    result.visibility = View.VISIBLE
                }, 2000)
            }

            val item1 = (Math.random() * 100f).toFloat()
            val item2 = (Math.random() * 100f).toFloat()
            val item3 = (Math.random() * 100f).toFloat()
            val item4 = (Math.random() * 100f).toFloat()
            val item5 = (Math.random() * 100f).toFloat()

            val entries = listOf(
                PieEntry(item1, ResourcesCompat.getDrawable(resources, R.drawable.first, null)),
                PieEntry(item2, ResourcesCompat.getDrawable(resources, R.drawable.second, null)),
                PieEntry(item3, ResourcesCompat.getDrawable(resources, R.drawable.third, null)),
                PieEntry(item4, ResourcesCompat.getDrawable(resources, R.drawable.fourth, null)),
                PieEntry(item5, ResourcesCompat.getDrawable(resources, R.drawable.fifth, null))
            )
            val dataSet = PieDataSet(entries, "")

            val colors = ArrayList<Int>()
            spinner.isDrawHoleEnabled = true
            spinner.isRotationEnabled = false
            spinner.legend.isEnabled = false
            dataSet.setDrawValues(false)
            colors.add(Color.CYAN)
            colors.add(Color.GRAY)
            colors.add(Color.BLACK)
            colors.add(Color.RED)
            colors.add(Color.BLUE)
            colors.add(Color.GREEN)

            dataSet.colors = colors
            val data = PieData(dataSet)

            data.setValueFormatter(PercentFormatter())
            data.setValueTextSize(30f)
            data.setValueTextColor(Color.BLACK)
            spinner.data = data
        }
    }
}