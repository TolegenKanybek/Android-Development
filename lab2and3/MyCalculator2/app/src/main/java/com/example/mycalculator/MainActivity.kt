package com.example.mycalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var calculations = Calculations(this)
    private val ANGLES = arrayOf("rad", "deg", "grad")
    private val angle_index = 0
    private val HYP = false
    lateinit private var sub: TextView
    lateinit private var main: TextView
    lateinit private var sin: Button
    lateinit private var cos: Button
    lateinit private var tan: Button
    lateinit private var parent_open: Button
    lateinit private var parent_close: Button
    lateinit private var ce: Button
    lateinit private var c: Button
    lateinit private var bs: Button
    lateinit private var div: Button
    lateinit private var pi: Button
    lateinit private var seven: Button
    lateinit private var eight: Button
    lateinit private var nine: Button
    lateinit private var mul: Button
    lateinit private var indice: Button
    lateinit private var fact: Button
    lateinit private var four: Button
    lateinit private var five: Button
    lateinit private var six: Button
    lateinit private var plus: Button
    lateinit private var sqrt: Button
    lateinit private var ln: Button
    lateinit private var one: Button
    lateinit private var two: Button
    lateinit private var three: Button
    lateinit private var minus: Button
    lateinit private var log: Button
    lateinit private var zero: Button
    lateinit private var decimal: Button
    lateinit private var equal: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sub = findViewById(R.id.scientific_tv_sub)
        main = findViewById(R.id.scientific_tv_main)
        sin = findViewById(R.id.scientific_btn_sin)
        sin.setOnClickListener(View.OnClickListener {
            if (HYP) {
                calculations.operatorClicked("sinh")
            } else {
                calculations.operatorClicked("sin")
            }
            main.setText(calculations.currentNumber)
            sub.setText(calculations.calc(calculations.numbers))
        })
        cos = findViewById(R.id.scientific_btn_cos)
        cos.setOnClickListener(View.OnClickListener {
            if (HYP) {
                calculations.operatorClicked("cosh")
            } else {
                calculations.operatorClicked("cos")
            }
            main.setText(calculations.currentNumber)
            sub.setText(calculations.calc(calculations.numbers))
        })
        tan = findViewById(R.id.scientific_btn_tan)
        tan.setOnClickListener(View.OnClickListener {
            if (HYP) {
                calculations.operatorClicked("tanh")
            } else {
                calculations.operatorClicked("tan")
            }
            main.setText(calculations.currentNumber)
            sub.setText(calculations.calc(calculations.numbers))
        })
        parent_open = findViewById(R.id.scientific_btn_parent_open)
        parent_open.setOnClickListener(View.OnClickListener {
            calculations.parent_openClicked()
            main.setText(calculations.currentNumber)
            sub.setText(calculations.calc(calculations.numbers))
        })
        parent_close = findViewById(R.id.scientific_btn_parent_close)
        parent_close.setOnClickListener(View.OnClickListener {
            calculations.parent_closeClicked()
            main.setText(calculations.currentNumber)
            sub.setText(calculations.calc(calculations.numbers))
        })
        ce = findViewById(R.id.scientific_btn_ce)
        ce.setOnClickListener(View.OnClickListener {
            calculations.ce()
            main.setText("0")
            sub.setText(calculations.calc(calculations.numbers))
        })
        c = findViewById(R.id.scientific_btn_c)
        c.setOnClickListener(View.OnClickListener {
            calculations.clear()
            main.setText("0")
            sub.setText(calculations.calc(calculations.numbers))
        })
        bs = findViewById(R.id.scientific_btn_bs)
        bs.setOnClickListener(View.OnClickListener {
            calculations.bs()
            main.setText(calculations.currentNumber)
            sub.setText(calculations.calc(calculations.numbers))
        })
        div = findViewById(R.id.scientific_btn_div)
        div.setOnClickListener(View.OnClickListener {
            calculations.operatorClicked("/")
            main.setText(calculations.currentNumber)
            sub.setText(calculations.calc(calculations.numbers))
        })
        pi = findViewById(R.id.scientific_btn_pi)
        pi.setOnClickListener(View.OnClickListener {
            calculations.operatorClicked("pi")
            main.setText(calculations.currentNumber)
            sub.setText(calculations.calc(calculations.numbers))
        })
        seven = findViewById(R.id.scientific_btn_7)
        seven.setOnClickListener(View.OnClickListener {
            calculations.numberClicked("7")
            main.setText(calculations.currentNumber)
            sub.setText(calculations.calc(calculations.numbers))
        })
        eight = findViewById(R.id.scientific_btn_8)
        eight.setOnClickListener(View.OnClickListener {
            calculations.numberClicked("8")
            main.setText(calculations.currentNumber)
            sub.setText(calculations.calc(calculations.numbers))
        })
        nine = findViewById(R.id.scientific_btn_9)
        nine.setOnClickListener(View.OnClickListener {
            calculations.numberClicked("9")
            main.setText(calculations.currentNumber)
            sub.setText(calculations.calc(calculations.numbers))
        })
        mul = findViewById(R.id.scientific_btn_mul)
        mul.setOnClickListener(View.OnClickListener {
            calculations.operatorClicked("*")
            main.setText(calculations.currentNumber)
            sub.setText(calculations.calc(calculations.numbers))
        })
        indice = findViewById(R.id.scientific_btn_indice)
        indice.setOnClickListener(View.OnClickListener {
            calculations.operatorClicked("^")
            main.setText(calculations.currentNumber)
            sub.setText(calculations.calc(calculations.numbers))
        })
        fact = findViewById(R.id.scientific_btn_fact)
        fact.setOnClickListener(View.OnClickListener {
            calculations.operatorClicked("!")
            main.setText(calculations.currentNumber)
            sub.setText(calculations.calc(calculations.numbers))
        })
        four = findViewById(R.id.scientific_btn_4)
        four.setOnClickListener(View.OnClickListener {
            calculations.numberClicked("4")
            main.setText(calculations.currentNumber)
            sub.setText(calculations.calc(calculations.numbers))
        })
        five = findViewById(R.id.scientific_btn_5)
        five.setOnClickListener(View.OnClickListener {
            calculations.numberClicked("5")
            main.setText(calculations.currentNumber)
            sub.setText(calculations.calc(calculations.numbers))
        })
        six = findViewById(R.id.scientific_btn_6)
        six.setOnClickListener(View.OnClickListener {
            calculations.numberClicked("6")
            main.setText(calculations.currentNumber)
            sub.setText(calculations.calc(calculations.numbers))
        })
        plus = findViewById(R.id.scientific_btn_add)
        plus.setOnClickListener(View.OnClickListener {
            calculations.operatorClicked("+")
            main.setText(calculations.currentNumber)
            sub.setText(calculations.calc(calculations.numbers))
        })
        sqrt = findViewById(R.id.scientific_btn_sqrt)
        sqrt.setOnClickListener(View.OnClickListener {
            calculations.operatorClicked("sqrt")
            main.setText(calculations.currentNumber)
            sub.setText(calculations.calc(calculations.numbers))
        })
        ln = findViewById(R.id.scientific_btn_ln)
        ln.setOnClickListener(View.OnClickListener {
            calculations.operatorClicked("ln")
            main.setText(calculations.currentNumber)
            sub.setText(calculations.calc(calculations.numbers))
        })
        one = findViewById(R.id.scientific_btn_1)
        one.setOnClickListener(View.OnClickListener {
            calculations.numberClicked("1")
            main.setText(calculations.currentNumber)
            sub.setText(calculations.calc(calculations.numbers))
        })
        two = findViewById(R.id.scientific_btn_2)
        two.setOnClickListener(View.OnClickListener {
            calculations.numberClicked("2")
            main.setText(calculations.currentNumber)
            sub.setText(calculations.calc(calculations.numbers))
        })
        three = findViewById(R.id.scientific_btn_3)
        three.setOnClickListener(View.OnClickListener {
            calculations.numberClicked("3")
            main.setText(calculations.currentNumber)
            sub.setText(calculations.calc(calculations.numbers))
        })
        minus = findViewById(R.id.scientific_btn_sub)
        minus.setOnClickListener(View.OnClickListener {
            calculations.operatorClicked("-")
            main.setText(calculations.currentNumber)
            sub.setText(calculations.calc(calculations.numbers))
        })
        log = findViewById(R.id.scientific_btn_log)
        log.setOnClickListener(View.OnClickListener {
            calculations.operatorClicked("log")
            main.setText(calculations.currentNumber)
            sub.setText(calculations.calc(calculations.numbers))
        })
        zero = findViewById(R.id.scientific_btn_0)
        zero.setOnClickListener(View.OnClickListener {
            calculations.numberClicked("0")
            main.setText(calculations.currentNumber)
            sub.setText(calculations.calc(calculations.numbers))
        })
        decimal = findViewById(R.id.scientific_btn_decimal)
        decimal.setOnClickListener(View.OnClickListener {
            calculations.decimalClicked()
            main.setText(calculations.currentNumber)
            sub.setText(calculations.calc(calculations.numbers))
        })
        equal = findViewById(R.id.scientific_btn_equal)
        equal.setOnClickListener(View.OnClickListener {
            val expression = calculations.numbers
            calculations.evaluateAnswer()
            main.setText(calculations.answer)
            sub.setText("")
        })
    }
}