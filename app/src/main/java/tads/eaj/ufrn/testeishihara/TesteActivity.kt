package tads.eaj.ufrn.testeishihara

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class TesteActivity : AppCompatActivity() {

    lateinit var cancelar: Button
    lateinit var ok: Button
    lateinit var resultNumber: EditText
    lateinit var img:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teste)

        cancelar = findViewById(R.id.cancelarButton)
        ok = findViewById(R.id.OKbutton)
        resultNumber = findViewById(R.id.resultNumber)

        val params:Bundle? = intent.extras
        var imagem: String? = params?.getString("IMAGEM")
        img = findViewById(R.id.imagem)

        if(imagem == "imgTeste1"){
            img.setImageResource(R.drawable.teste1)
        }else if(imagem == "imgTeste2"){
            img.setImageResource(R.drawable.teste2)
        }else{
            img.setImageResource(R.drawable.teste3)
        }

        cancelar.setOnClickListener {
            Toast.makeText(applicationContext, "Ação cancelada", Toast.LENGTH_SHORT).show()
            finish()
        }

        ok.setOnClickListener {
            val intent = Intent()
            if(!resultNumber.text.isEmpty()){
                intent.putExtra("RESULTADO", Integer.parseInt(resultNumber.text.toString()))
                setResult(Activity.RESULT_OK, intent)
                finish()
            }else{
                Toast.makeText(applicationContext, "Campo vazio", Toast.LENGTH_SHORT).show()
            }

        }

    }
}