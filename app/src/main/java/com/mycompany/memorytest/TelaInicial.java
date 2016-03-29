package com.mycompany.memorytest;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.mycompany.memorytest.R.id.opcao8;


public class TelaInicial extends Activity  {

    private Button btn_novo , btn_ponto , btn_8 , btn_12 , btn_16;
    private Intent it;
    private int esconde = 1;
    MediaPlayer player;
    MediaPlayer click = null;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.tela_inicial );

        btn_novo = ( Button )findViewById( R.id.novo );
        btn_8 = ( Button )findViewById( opcao8 );
        btn_12 = ( Button )findViewById( R.id.opcao12 );
        btn_16 = ( Button )findViewById( R.id.opcao16 );


        btn_novo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(esconde==1) {
                    btn_8.setVisibility( View.VISIBLE );
                    btn_12.setVisibility( View.VISIBLE );
                    btn_16.setVisibility( View.VISIBLE );
                    esconde=2;
                }else{
                    btn_8.setVisibility( View.GONE );
                    btn_12.setVisibility( View.GONE );
                    btn_16.setVisibility( View.GONE );
                    esconde=1;
                }
                playMusic();
            }
        });


        btn_8.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                it = new Intent( TelaInicial.this , NivelFacil.class );
                player.stop();
                player.release();
                playMusic();
                startActivity(it);
            }
        });
        btn_12.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                it = new Intent( TelaInicial.this , NivelMedio.class );
                player.stop();
                player.release();
                playMusic();
                startActivity( it );
            }
        });

        btn_16.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                it = new Intent ( TelaInicial.this , NivelDificil.class);
                player.stop();
                player.release();
                playMusic();
                startActivity(it);
            }
        });

    }

    public void playMusic(){
        click = MediaPlayer.create(TelaInicial.this,R.raw.click);
        click.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer click) {
                click.stop();
                click.release();
                click = null;
            }
        });
        click.start();
    }

    @Override
    protected void onStart() {
        super.onStart();
        player = MediaPlayer.create(this , R.raw.pokemon_center);
        player.start();
        player.setLooping(true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.stop();
        player.release();
    }

}



