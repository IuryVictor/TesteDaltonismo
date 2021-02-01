package tads.eaj.ufrn.testeishihara

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var teste1: Button
    lateinit var teste2: Button
    lateinit var teste3: Button
    lateinit var verificaButton: Button
    lateinit var respostaTextView1: TextView
    lateinit var respostaTextView2: TextView
    lateinit var respostaTextView3: TextView
    lateinit var resultadoFinal: TextView
    var resposta1:Int? = 0
    var resposta2:Int? = 0
    var resposta3:Int? = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        teste1 = findViewById(R.id.teste1)
        teste2 = findViewById(R.id.teste2)
        teste3 = findViewById(R.id.teste3)
        verificaButton = findViewById(R.id.verificar)
        respostaTextView1 = findViewById(R.id.resposta1)
        respostaTextView2 = findViewById(R.id.resposta2)
        respostaTextView3 = findViewById(R.id.resposta3)
        resultadoFinal = findViewById(R.id.ResultadoFinal)

        respostaTextView1.setText(resposta1.toString())
        respostaTextView2.setText(resposta2.toString())
        respostaTextView3.setText(resposta3.toString())

        teste1.setOnClickListener {
            val intent = Intent(this, TesteActivity::class.java)
            val param = Bundle()
            val REQUESTCODE = 1
            param.putString("IMAGEM", "imgTeste1")
            intent.putExtras(param)
            startActivityForResult(intent, REQUESTCODE)
        }

        teste2.setOnClickListener {
            val intent = Intent(this, TesteActivity::class.java)
            val param = Bundle()
            val REQUESTCODE = 2
            param.putString("IMAGEM", "imgTeste2")
            intent.putExtras(param)
            startActivityForResult(intent, REQUESTCODE)
        }

        teste3.setOnClickListener {
            val intent = Intent(this, TesteActivity::class.java)
            val param = Bundle()
            val REQUESTCODE = 3
            param.putString("IMAGEM", "imgTeste3")
            intent.putExtras(param)
            startActivityForResult(intent, REQUESTCODE)
        }

        verificaButton.setOnClickListener {
            if(resposta1 == 74 && resposta2 == 29 && resposta3 == 2){
                resultadoFinal.setText("Você não é Daltônico")
            }else if(resposta1 == 0 || resposta2 == 0 || resposta3 == 0){
                Toast.makeText(applicationContext, "Todos os campos devem estar preenchidos", Toast.LENGTH_SHORT).show()
            }else {
                resultadoFinal.setText("Você é possivelmente daltônico, procure um médico")
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode){
            1 -> {
                when(resultCode){
                    Activity.RESULT_OK -> {
                        val params:Bundle? = data?.extras
                        resposta1 = params?.getInt("RESULTADO")
                        respostaTextView1.setText(resposta1.toString())
                    }
                }
            }

            2 -> {
                when(resultCode){
                    Activity.RESULT_OK -> {
                        val params:Bundle? = data?.extras
                        resposta2 = params?.getInt("RESULTADO")
                        respostaTextView2.setText(resposta2.toString())
                    }
                }
            }

            3 -> {
                when(resultCode){
                    Activity.RESULT_OK -> {
                        val params:Bundle? = data?.extras
                        resposta3 = params?.getInt("RESULTADO")
                        respostaTextView3.setText(resposta3.toString())
                    }
                }
            }
        }
    }
}