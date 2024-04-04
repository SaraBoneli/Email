package sara.dayse.email;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnEnviar = (Button) findViewById(R.id.btnEnviar);// Definicao da acao do click do botao
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtendo dados digitados pelo usuario
                EditText etEmail = (EditText) findViewById(R.id.etEmail);
                String email = etEmail.getText().toString();
                EditText etAssunto = (EditText) findViewById(R.id.etAssunto);
                String assunto = etAssunto.getText().toString();
                EditText etTexto = (EditText) findViewById(R.id.etTexto);
                String texto = etTexto.getText().toString();
                Intent i = new Intent(Intent.ACTION_SENDTO);//criar intent
                i.setData(Uri.parse("mailto:"));//indicar apps que trabalham com envio e recebimento de e-mail
                String[] emails = new String[] {email};//cria lista de String
                i.putExtra(Intent.EXTRA_EMAIL, emails);//lista de Strings onde cada String é um e-mail de destinatário
                i.putExtra(Intent.EXTRA_SUBJECT, assunto);//referente ao campo de assunto
                i.putExtra(Intent.EXTRA_TEXT, texto);// referente ao corpo de texto do e-mail.

                try {
                    startActivity(Intent.createChooser(i, "Escolha o APP"));//tenta executar o intent e faz com que apareça
                    // um menu onde o usuário pode escolher
                    // entre várias apps que são capazes de enviar uma mensagem de e-mail

                }
                catch (ActivityNotFoundException e) {
                    Toast.makeText(MainActivity.this, "Não há nenhum app que posso realizar essa operação", Toast.LENGTH_LONG).show();
                    // mensagem de
                    //erro exibida para o usuário com o motivo pelo qual a ação não pode ser concluída

                }




            }
        });


    }
}