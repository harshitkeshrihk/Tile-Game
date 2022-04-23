package com.example.tilegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        bu11.setOnClickListener{
            playAgain()
        }
        bu10.setOnClickListener{
            finish()
        }

    }

    var numbersList = mutableListOf(1,2,3,4,5,6,7,8,9)
    var numbers = mutableListOf<Int>()
    var a: Int = 0
    var score: Int = 0

    fun buClick(view: View){           //called by every buttons which are clicked and give it a unique number from 1 to 9 i.e from number List and make sure not present in numbers.

        var cellId=0
        val btnSelected = view as Button

        when(btnSelected.id){
            R.id.bu1 ->{
                a = numbersList.random()
                while (numbers.contains(a)){
                    a=numbersList.random()
                }
                numbers.add(a)
                cellId=a
            }
            R.id.bu2 -> {
                a = numbersList.random()
                while (numbers.contains(a)){
                    a=numbersList.random()
                }
                numbers.add(a)
                cellId=a
            }
            R.id.bu3 -> {
                a = numbersList.random()
                while (numbers.contains(a)){
                    a=numbersList.random()
                }
                numbers.add(a)
                cellId=a
            }
            R.id.bu4 ->{ a = numbersList.random()
                while (numbers.contains(a)){
                    a=numbersList.random()
                }
                numbers.add(a)
                cellId=a
            }
            R.id.bu5 -> {
                a = numbersList.random()
                while (numbers.contains(a)){
                    a=numbersList.random()
                }
                numbers.add(a)
                cellId=a
            }
            R.id.bu6 -> {
                a = numbersList.random()
                while (numbers.contains(a)){
                    a=numbersList.random()
                }
                numbers.add(a)
                cellId=a
            }
            R.id.bu7 -> {
                a = numbersList.random()
                while (numbers.contains(a)){
                    a=numbersList.random()
                }
                numbers.add(a)
                cellId=a
            }
            R.id.bu8 ->{  a = numbersList.random()
                while (numbers.contains(a)){
                    a=numbersList.random()
                }
                numbers.add(a)
                cellId=a
            }
            R.id.bu9 -> {
                a = numbersList.random()
                while (numbers.contains(a)){
                    a=numbersList.random()
                }
                numbers.add(a)
                cellId=a
            }
        }
//        Log.d("buClick :",btnSelected.id.toString())
//        Log.d("buClick : cellId",cellId.toString())

        playTileGame(cellId,btnSelected)
    }

    fun playTileGame(cellId: Int,btnSelected: Button){

        btnSelected.text = cellId.toString()
        if(cellId == 7 && score<3){
            btnSelected.setBackgroundResource(R.drawable.win)
            btnSelected.isEnabled = false
            // show alert to win and play again
            showWinAlertDialog()

        }else {
            btnSelected.setBackgroundResource(R.drawable.lose)
            btnSelected.isEnabled = false
            score++
            if (score == 3) {
                //show Alert to lose and retry
                showLoseAlertDialog()
            }
        }
    }

    fun playAgain(){
        numbersList = mutableListOf(1,2,3,4,5,6,7,8,9)
        numbers = mutableListOf()
        score = 0

        bu1.apply {
            isEnabled = true
            text = ""
            setBackgroundResource(R.color.background)
        }
        bu2.apply {
            isEnabled = true
            text = ""
            setBackgroundResource(R.color.background)
        }
        bu3.apply {
            isEnabled = true
            text = ""
            setBackgroundResource(R.color.background)
        }
        bu4.apply {
            isEnabled = true
            text = ""
            setBackgroundResource(R.color.background)
        }
        bu5.apply {
            isEnabled = true
            text = ""
            setBackgroundResource(R.color.background)
        }
        bu6.apply {
            isEnabled = true
            text = ""
            setBackgroundResource(R.color.background)
        }
        bu7.apply {
            isEnabled = true
            text = ""
            setBackgroundResource(R.color.background)
        }
        bu8.apply {
            isEnabled = true
            text = ""
            setBackgroundResource(R.color.background)
        }
        bu9.apply {
            isEnabled = true
            text = ""
            setBackgroundResource(R.color.background)
        }
    }

    fun showWinAlertDialog(){
        val winDialog = AlertDialog.Builder(this)
            .setTitle("WIN")
            .setMessage("You have found 7 in three or less than three attempts.")
            .setIcon(R.drawable.ic_win_foreground)
            .setPositiveButton("Play Again"){ _,_ ->
                playAgain()
            }
            .setNegativeButton("Exit"){ _,_ ->
                finish()
            }.create()
        winDialog.show()
    }
    fun showLoseAlertDialog(){
        val winDialog = AlertDialog.Builder(this)
            .setTitle("LOSE")
            .setMessage("Better luck next time!!")
            .setIcon(R.drawable.ic_lose_foreground)
            .setPositiveButton("Retry"){ _,_ ->
                playAgain()
            }
            .setNegativeButton("Exit"){ _,_ ->
                finish()
            }.create()
        winDialog.show()
    }

}