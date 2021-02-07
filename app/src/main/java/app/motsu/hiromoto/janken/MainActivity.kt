package app.motsu.hiromoto.janken

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gooButton.setOnClickListener {
            janken(0)
        }
        chokiButton.setOnClickListener {
            janken(1)
        }
        parButton.setOnClickListener {
            janken(2)
        }
    }

    fun janken(hand:Int){
        var cpuHand:Int = Random.nextInt(3)
        var printText:String? = null
        when(hand){
            0 ->{
                printText = "あなたの手はグーです"
            }
            1 ->{
                printText = "あなたの手はチョキです"
            }
            2 ->{
                printText = "あなたの手はパーです"
            }
        }
        Player.text = printText
        when(cpuHand){
            0 ->{
                cpu.setImageResource(R.drawable.goo);
            }
            1 ->{
                cpu.setImageResource(R.drawable.choki);
            }
            2 ->{
                cpu.setImageResource(R.drawable.paa);
            }
        }
        if(cpuHand == hand){
            result.text = "引き分けです"
            result.setTextColor(Color.parseColor("#8a000000"))
        }else if(cpuHand == 0){
            if(hand == 1){
                result.text = "あなたの負けです"
                result.setTextColor(Color.parseColor("#f44336"))
            }else{
                result.text = "あなたの勝ちです"
                result.setTextColor(Color.parseColor("#2196f3"))
            }
        }else if(cpuHand == 1){
            if(hand == 2){
                result.text = "あなたの負けです"
                result.setTextColor(Color.parseColor("#f44336"))
            }else{
                result.text = "あなたの勝ちです"
                result.setTextColor(Color.parseColor("#2196f3"))
            }
        }else if(cpuHand == 2){
            if(hand == 0){
                result.text = "あなたの負けです"
                result.setTextColor(Color.parseColor("#f44336"))
            }else{
                result.text = "あなたの勝ちです"
                result.setTextColor(Color.parseColor("#2196f3"))
            }
        }

    }
}